package com.nabiki.hope.service;

import java.io.IOException;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.service.api.MessageHandler;

public class SvcMain {
	
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

	public SvcMain() {
		try(var container = new Container(dataFactory(), providerFactory(), messageHandler())) {
			var notifier = new StateNotifier();
			container.listener(notifier);
			
			// async run
			container.run();
			
			// wait for container stopped
			notifier.waitState(ContainerState.STOPPED);
		} catch (CommonException c) {
			// TODO common exception
		} catch (IOException io) {
			// TODO io exception
		} catch (Exception e) {
			// TODO generic exception
		} finally {
			// TODO exit ops
		}
	}
}
