package com.nabiki.hope.common.provider.conn;

public interface Connection {
	/**
	 * Connect peer with previous profile.
	 */
	void connect();
	
	void connect(ConnectionProfile profile);
	
	void disconnect();
	
	void listener(Listener listener);

}
