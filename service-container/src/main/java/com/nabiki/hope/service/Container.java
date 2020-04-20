package com.nabiki.hope.service;

import java.io.File;
import java.io.IOException;

import com.nabiki.hope.common.data2.MessageHandler;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.factory.provider.ProviderFactory;
import com.nabiki.hope.common.provider.conn.ConnectionProfile;
import com.nabiki.hope.service.api.ContainerStateListener;
import com.nabiki.hope.service.api.Predefine;

public class Container implements AutoCloseable {

	public Container(DataFactory datafac, ProviderFactory provfac, MessageHandler msghnd) {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		// TODO async run
	}
	
	public void listener(ContainerStateListener lis) {
		// TODO set listener
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	private ConnectionProfile connProfile() {
		// TODO load conn profile
		return null;
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
