package com.nabiki.hope.service.ctrl;

import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.ServiceStateListener;

/**
 * Controller for start, stop and restart of the container object. It watches file on disk for command.
 * @author Hongbao Chen
 *
 */
public class ServiceController {
	
	public ServiceController() {
	}

	public ServiceController(ServiceStateListener listener) {
	}

	public void start() {
		
	}
	
	public void stop() {
		
	}
	
	public void restart() {
		
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
}
