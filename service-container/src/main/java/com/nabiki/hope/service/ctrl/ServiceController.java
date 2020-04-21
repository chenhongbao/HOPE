package com.nabiki.hope.service.ctrl;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.ServiceStateListener;

/**
 * Controller for start, stop and restart of the container object. It watches file on disk for command.
 * @author Hongbao Chen
 *
 */
public class ServiceController extends FileWatcher {
	
	public ServiceController() throws CommonException {
		super(null);
	}

	public ServiceController(ServiceStateListener listener) throws CommonException {
		super(null);
	}

	private void startContainer() {
		
	}
	
	private void stopContainer() {
		
	}
	
	private void restartContainer() {
		
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
