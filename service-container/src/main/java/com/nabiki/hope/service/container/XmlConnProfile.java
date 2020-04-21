package com.nabiki.hope.service.container;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.nabiki.hope.common.provider.conn.ConnectionProfile;

@XmlRootElement
public class XmlConnProfile implements ConnectionProfile {
	@XmlElement
	String url;
	
	@XmlElement
	String user;
	
	@XmlElement
	String domain;
	
	@XmlElement
	String password;
	
	@XmlElement
	Integer port;

	public XmlConnProfile() {
	}
	
	@Override
	public String url() {
		return this.url;
	}
	
	@Override
	public void url(String s) {
		this.url = s;
	}
	
	@Override
	public Integer port() {
		return this.port;
	}
	
	@Override
	public void port(Integer i) {
		this.port = i;
	}
	
	@Override
	public String user() {
		return this.user;
	}
	
	@Override
	public void user(String s) {
		this.user = s;
	}
	
	@Override
	public String password() {
		return this.password;
	}
	
	@Override
	public void password(String s) {
		this.password = s;
	}
	
	@Override
	public String domain() {
		return this.domain;
	}
	
	@Override
	public void domain(String s) {
		this.domain = s;
	}
}
