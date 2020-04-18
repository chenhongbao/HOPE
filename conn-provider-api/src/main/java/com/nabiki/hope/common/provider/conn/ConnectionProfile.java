package com.nabiki.hope.common.provider.conn;

public interface ConnectionProfile {
	String url();
	
	void url(String s);
	
	Integer port();
	
	void port(Integer i);
	
	String user();
	
	void user(String s);
	
	String password();
	
	void password(String s);
	
	String domain();
	
	void domain(String s);
}
