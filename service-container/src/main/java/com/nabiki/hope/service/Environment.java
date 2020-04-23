package com.nabiki.hope.service;

import java.io.File;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.xml.bind.JAXB;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.service.api.PreDefine;
import com.nabiki.hope.service.udp.UdpOutputStream;

public class Environment {
	private File parentDirectory;
	
	private void initParentDirectory() throws CommonException {
		try {
			var jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
			this.parentDirectory = jarFile.getParentFile();
			
			if (!this.parentDirectory.isDirectory()) {
				throw new CommonException("Parent folder of application is not a folder.");
			}
		} catch (SecurityException e) {
			throw new CommonException("Fail getting parent folder of application due to security issue.");
		}
	}
	
	private void initOut() throws CommonException {
		InetAddress outAddress = null, errAddress = null;
		int outPort = 0, errPort = 0;
		
		try {
			var profile = JAXB.unmarshal(
					new File(this.parentDirectory(), PreDefine.SYS_STDOS_CONN_XML), SystemOutConnProfile.class);
			if (profile == null) {
				throw new CommonException("Fail loading system standard output profile.");
			}
			
			outAddress = InetAddress.getByName(profile.outProfile.ip());
			outPort = profile.outProfile().port();
			errAddress = InetAddress.getByName(profile.errProfile().ip());
			errPort = profile.errProfile().port();
			
			// Replace default system output stream with UDP enabled output stream.
			System.setOut(new PrintStream(new UdpOutputStream(outPort, outAddress), true));
			System.setOut(new PrintStream(new UdpOutputStream(errPort, errAddress), true));
		} catch (SocketException e) {
			throw new CommonException("Fail creating UDP socket to remote system output host.");
		} catch (UnknownHostException e) {
			throw new CommonException("Unknown remote system output host.");
		}
	}
	
	private void init() throws CommonException {
		this.initOut();
		this.initParentDirectory();
	}

	public Environment() throws CommonException {
		init();
	}

	public File parentDirectory() {
		return this.parentDirectory;
	}
}
