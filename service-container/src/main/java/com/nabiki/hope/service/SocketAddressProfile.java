package com.nabiki.hope.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SocketAddressProfile {
	@XmlElement
	public String ip;
	
	@XmlElement
	public Integer port;

	public SocketAddressProfile() {
	}
	
	public String ip() {
		return this.ip;
	}
	
	public void ip(String s) {
		this.ip = s;
	}
	
	public Integer port() {
		return this.port;
	}
	
	public void port(Integer i) {
		this.port = i;
	}

}
