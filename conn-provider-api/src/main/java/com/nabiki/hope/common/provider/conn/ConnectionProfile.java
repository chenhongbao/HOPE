package com.nabiki.hope.common.provider.conn;

public class ConnectionProfile {
	String url;
	String user;
	String domain;
	String password;
	Integer port;
	
	public String url() {
		return this.url;
	}
	
	public void url(String s) {
		this.url = s;
	}
	
	public Integer port() {
		return this.port;
	}
	
	public void port(Integer i) {
		this.port = i;
	}
	
	public String user() {
		return this.user;
	}
	
	public void user(String s) {
		this.user = s;
	}
	
	public String password() {
		return this.password;
	}
	
	public void password(String s) {
		this.password = s;
	}
	
	public String domain() {
		return this.domain;
	}
	
	public void domain(String s) {
		this.domain = s;
	}
}
