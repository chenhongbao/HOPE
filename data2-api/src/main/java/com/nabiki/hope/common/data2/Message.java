package com.nabiki.hope.common.data2;

import java.util.Collection;

public interface Message {
	String messageType();
	
	void messageType(String s);
	
	String ackType();
	
	void ackType(String s);
	
	byte[] element(Integer i);
	
	Integer bodySize();
	
	void addElement(byte[] b);
	
	Collection<byte[]> body();
}
