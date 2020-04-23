package com.nabiki.hope.service.container;

import java.io.File;

import javax.xml.bind.JAXB;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.common.provider.conn.Connection;
import com.nabiki.hope.common.provider.conn.ConnectionProfile;
import com.nabiki.hope.service.Environment;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.PreDefine;

public class Container {

	private Connection connection;
	private ConnectionProfile connProfile;
	private DataFactory dataFactory;
	private ProviderFactory provFactory;
	private MessageHandler msgHandler;
	private Environment env;
	
	public Container(DataFactory d, ProviderFactory p, MessageHandler m, Environment e) throws CommonException {
		var f = new File(env.parentDirectory(), PreDefine.CORE_CONN_XML);
		this.connProfile = JAXB.unmarshal(f, CoreConnProfile.class);
		if (this.connProfile == null) {
			// Write a sample XML.
			JAXB.marshal(new CoreConnProfile(), f);
			throw new CommonException("Fail loading core connection profile.");
		}
		
		this.dataFactory = d;
		this.provFactory = p;
		this.msgHandler = m;
	}
	
	public void run() throws CommonException {
		this.connection = this.provFactory.connection();
		if (this.connection == null) {
			throw new CommonException("Fail obtaining connection from factory.");
		}
		
		this.connection.listener(new ConnectionListener(this.dataFactory, this.msgHandler));
		this.connection.open(this.connProfile);
	}
	
	public void stop() throws CommonException {
		if (this.connection != null && !this.connection.isClosed()) {
			this.connection.close();
		}
		// Reset fields
		this.connection = null;
		this.connProfile = null;
		this.dataFactory = null;
		this.provFactory = null;
		this.msgHandler = null;
		this.msgHandler = null;
	}
}
