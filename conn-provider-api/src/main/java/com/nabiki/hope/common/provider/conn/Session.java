package com.nabiki.hope.common.provider.conn;

import java.net.InetSocketAddress;

public interface Session {
	void put(byte[] b);
	
	Boolean isClosed();
	
	void terminate();
	
	InetSocketAddress peerAddress();
}
