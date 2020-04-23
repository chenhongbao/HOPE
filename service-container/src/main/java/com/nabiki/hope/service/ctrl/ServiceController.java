package com.nabiki.hope.service.ctrl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.UUID;

import javax.xml.bind.JAXB;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.service.Environment;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.PreDefine;
import com.nabiki.hope.service.api.ServiceStateListener;
import com.nabiki.hope.service.container.Container;
import com.nabiki.hope.service.container.ServiceState;

/**
 * Controller for start, stop and restart of the container object. It watches
 * file on disk for command.
 * 
 * @author Hongbao Chen
 *
 */
public class ServiceController extends FileWatcher {
	private ComponentSettingProfile compoProfile;
	private Environment env;
	private ServiceStateListener listener;
	private Container container;

	// Close the loader and set null before each loading.
	// So that it is possible to load a modified jar class.
	private URLClassLoader clzLoader;

	public ServiceController(Environment e) throws CommonException {
		super(Paths.get(e.parentDirectory().getAbsolutePath(), PreDefine.WATCHED_CTRL_FILE));
		this.env = e;
		this.prepare();
	}

	public ServiceController(ServiceStateListener l, Environment e) throws CommonException {
		super(Paths.get(e.parentDirectory().getAbsolutePath(), PreDefine.WATCHED_CTRL_FILE));
		this.env = e;
		this.listener = l;
		this.prepare();
	}

	private void prepare() throws CommonException {
		this.compoProfile = JAXB.unmarshal(new File(this.env.parentDirectory(), PreDefine.COMPO_PATH_XML),
				ComponentSettingProfile.class);
		if (this.compoProfile == null) {
			throw new CommonException("Fail loading component setting profile.");
		}
		// Watching file.
		super.watch();
	}

	private void callStateListener(ServiceState s) throws CommonException {
		if (this.listener != null) {
			try {
				this.listener.onState(s);
			} catch (Exception e) {
				throw new CommonException("Service state listener throws exception." + e.getMessage(), e);
			}
		}
	}

	private void startContainer() throws CommonException {
		callStateListener(ServiceState.STARTING);
		setupContainer();
		callStateListener(ServiceState.STARTED);
	}

	private void stopContainer() throws CommonException {
		callStateListener(ServiceState.STOPPING);
		if (this.container != null) {
			this.container.stop();
			this.container = null;
		}
		callStateListener(ServiceState.STOPPED);
	}

	private void restartContainer() throws CommonException {
		callStateListener(ServiceState.RESTART_STOPPING);
		this.container.stop();

		// Destroy old object
		this.container = null;
		System.gc();

		callStateListener(ServiceState.RESTARTING);
		setupContainer();
		callStateListener(ServiceState.RESTARTED);
	}

	private void exitProgram() throws CommonException {
		stopContainer();
		callStateListener(ServiceState.EXIT);
	}

	private void setupContainer() throws CommonException {
		setupClassLoader();
		this.container = new Container(dataFactory(), providerFactory(), messageHandler(), this.env);
		this.container.run();
	}

	private void setupClassLoader() throws CommonException {
		if (this.clzLoader != null) {
			try {
				// Assume it closes all closable object in class loader, then clears internal
				// buffer.
				this.clzLoader.close();
				this.clzLoader = null;
			} catch (IOException | SecurityException e) {
				throw new CommonException("Fail closing class loader. " + e.getMessage());
			}
		}

		// Construct URL from setting.
		var data = getUrl(this.env.parentDirectory().getAbsolutePath(), this.compoProfile.dataFactory().jar());
		var prov = getUrl(this.env.parentDirectory().getAbsolutePath(), this.compoProfile.providerFactory().jar());
		var msg = getUrl(this.env.parentDirectory().getAbsolutePath(), this.compoProfile.messageHandler().jar());
		// Use system's class loader as parent class loader.
		this.clzLoader = new URLClassLoader(UUID.randomUUID().toString(), new URL[] { data, prov, msg },
				System.class.getClassLoader());
	}

	private URL getUrl(String root, String path) throws CommonException {
		String s = null;
		if (path.startsWith("http:") || path.startsWith("file:")) {
			s = "jar:" + path;
		} else if (new File(path).isAbsolute()) {
			s = "jar:file:" + path;
		} else {
			if (!root.endsWith("/") && !root.endsWith("\\") && !path.startsWith("/") && !path.startsWith("\\")) {
				s = root + "\\" + path;
			} else {
				s = root + path;
			}
		}

		if (!s.endsWith("!/")) {
			s += "!/";
		}

		try {
			return new URL(s);
		} catch (MalformedURLException e) {
			throw new CommonException("Fail getting valid URL for jar.");
		}
	}

	private Class<?> getClass(String name) throws CommonException {
		try {
			return Class.forName(name, false, this.clzLoader);
		} catch (ClassNotFoundException e) {
			throw new CommonException("Can't find class within loader. " + e.getMessage());
		}
	}

	private DataFactory dataFactory() throws CommonException {
		var clz = getClass(this.compoProfile.dataFactory().classPath());
		try {
			return (DataFactory) clz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new CommonException("Fail getting instance of class. " + e.getMessage());
		}
	}

	private ProviderFactory providerFactory() throws CommonException {
		var clz = getClass(this.compoProfile.providerFactory().classPath());
		try {
			return (ProviderFactory) clz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new CommonException("Fail getting instance of class. " + e.getMessage());
		}
	}

	private MessageHandler messageHandler() throws CommonException {
		var clz = getClass(this.compoProfile.messageHandler().classPath());
		try {
			return (MessageHandler) clz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new CommonException("Fail getting instance of class. " + e.getMessage());
		}
	}

	@Override
	public void onTextContentChange(String from, String to) {
		try {
			switch (to) {
			case PreDefine.CTRL_CMD_START:
				startContainer();
				break;
			case PreDefine.CTRL_CMD_STOP:
				stopContainer();
				break;
			case PreDefine.CTRL_CMD_RESTART:
				restartContainer();
				break;
			case PreDefine.CTRL_CMD_EXIT:
				exitProgram();
				break;
			default:
				System.err.println("Unkown command for service controller: " + to);
				break;
			}
		} catch (CommonException e) {
			System.err.println("Service controller encounters error when executing command. " + e.getMessage());
		}
	}
}
