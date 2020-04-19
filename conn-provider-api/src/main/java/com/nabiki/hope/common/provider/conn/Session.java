package com.nabiki.hope.common.provider.conn;

import java.io.OutputStream;
import java.net.InetSocketAddress;

public interface Session {
	OutputStream out();
	
	Boolean isClosed();
	
	void terminate();
	
	InetSocketAddress peerAddress();
}
