package com.nabiki.hope.common.provider.conn;

import java.io.Writer;
import java.net.InetSocketAddress;

public interface Session {
	Writer out();
	
	Boolean isClosed();
	
	void terminate();
	
	InetSocketAddress peerAddress();
}
