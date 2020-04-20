package com.nabiki.hope.service;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXB;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.common.provider.conn.Connection;
import com.nabiki.hope.common.provider.conn.ConnectionProfile;
import com.nabiki.hope.service.api.ContainerStateListener;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.Predefine;

public class Container implements AutoCloseable {

	private Connection connection;
	private ConnectionProfile connProfile;
	private DataFactory dataFactory;
	private ProviderFactory provFactory;
	private MessageHandler msgHandler;
	
	public Container(DataFactory d, ProviderFactory p, MessageHandler m) throws CommonException {
		try {
			this.connProfile = connProfile();
		} catch (NullPointerException | SecurityException | IOException e) {
			throw new CommonException("Fail loading connection profile.", e);
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
		this.connection.connect(this.connProfile);
	}
	
	public void listener(ContainerStateListener lis) {
		// TODO set listener
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	private ConnectionProfile connProfile() throws NullPointerException, SecurityException, IOException {
		return JAXB.unmarshal(profileFile(), XmlConnProfile.class);
	}
	
	private File profileFile() throws NullPointerException, SecurityException, IOException {
		var jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		var dir = jarFile.getParentFile();
		
		if (!dir.isDirectory()) {
			throw new IOException("Parent of connection profile file is not a directory.");
		}
		
		return new File(dir, Predefine.profileFileName);
	}
}
