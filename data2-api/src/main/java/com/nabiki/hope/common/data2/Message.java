package com.nabiki.hope.common.data2;

import java.util.Collection;

public interface Message {
	String messageType();
	
	void messageType(String s);
	
	byte[] element(Integer i);
	
	Integer bodySize();
	
	void addElement(byte[] b);
	
	Collection<byte[]> body();
}
