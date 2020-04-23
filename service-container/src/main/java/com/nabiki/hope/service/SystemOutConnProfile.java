package com.nabiki.hope.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SystemOutConnProfile {
	@XmlElement(type = SocketAddressProfile.class)
	public SocketAddressProfile outProfile;
	
	@XmlElement(type = SocketAddressProfile.class)
	public SocketAddressProfile errProfile;

	public SystemOutConnProfile() {
		this.outProfile = new SocketAddressProfile();
		this.errProfile = new SocketAddressProfile();
	}

	public SocketAddressProfile outProfile() {
		return this.outProfile;
	}
	
	public SocketAddressProfile errProfile() {
		return this.errProfile;
	}
}
