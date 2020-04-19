package com.nabiki.hope.common.provider.conn;

public interface Listener {
	void onOpen(Session w);
	
	void onInputData(byte[] b);
	
	void onError(Exception e);
	
	void onClose();
}
