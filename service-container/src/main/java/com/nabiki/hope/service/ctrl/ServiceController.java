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

/**
 * Controller for start, stop and restart of the container object. It watches file on disk for command.
 * @author Hongbao Chen
 *
 */
public class ServiceController extends FileWatcher {
	private ComponentSettingProfile compoProfile;
	private Environment env;
	private ServiceStateListener listener;
	
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
	
	private void prepare() {
		this.compoProfile = JAXB.unmarshal(new File(this.env.parentDirectory(), PreDefine.COMPO_PATH_XML), 
				ComponentSettingProfile.class);
		super.watch();
	}

	private void startContainer() {
		// TODO start container
	}
	
	private void stopContainer() {
		// TODO stop container
	}
	
	private void restartContainer() {
		// TODO restart container
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
		// TODO implement change process
		
	}
}
