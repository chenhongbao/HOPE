package com.nabiki.hope.service.ctrl;

import java.io.File;
import java.nio.file.Paths;

import javax.xml.bind.JAXB;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.service.Environment;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.PreDefine;
import com.nabiki.hope.service.api.ServiceStateListener;
import com.nabiki.hope.service.container.ComponentSettingProfile;
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
		this.container = new Container(dataFactory(), providerFactory(), messageHandler(), this.env);
		this.container.run();
		callStateListener(ServiceState.STARTED);
	}

	private void stopContainer() throws CommonException {
		callStateListener(ServiceState.STOPPING);
		this.container.stop();
		callStateListener(ServiceState.STOPPED);
	}

	private void restartContainer() throws CommonException {
		callStateListener(ServiceState.RESTART_STOPPING);
		this.container.stop();

		// Destroy old object
		this.container = null;
		System.gc();

		callStateListener(ServiceState.RESTARTING);
		this.container = new Container(dataFactory(), providerFactory(), messageHandler(), this.env);
		this.container.run();
		callStateListener(ServiceState.RESTARTED);
	}

	private DataFactory dataFactory() {
		// TODO load data factory from jar file
		return null;

	}

	private ProviderFactory providerFactory() {
		// TODO load provider factory from jar file
		return null;
	}

	private MessageHandler messageHandler() {
		// TODO load message handler from jar file
		return null;
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
			default:
				System.err.println("Unkown command for service controller: " + to);
				break;
			}
		} catch (CommonException e) {
			System.err.println("Service controller encounters error when executing command. " + e.getMessage());
		}
	}
}
