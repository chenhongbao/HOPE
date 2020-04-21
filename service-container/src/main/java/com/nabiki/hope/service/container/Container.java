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
		this.connProfile = connProfile();
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
		this.connection.connect(this.connProfile);
	}

	private ConnectionProfile connProfile() {
		// Manually checked, it won't throw exception.
		return JAXB.unmarshal(new File(env.parentDirectory(), PreDefine.coreConnProfile), XmlConnProfile.class);
	}
}
