package com.nabiki.hope.common.provider.conn;

import com.nabiki.hope.common.data2.CommonException;

public interface Connection {
	/**
	 * Connect peer with previous profile.
	 */
	void connect() throws CommonException;
	
	void connect(ConnectionProfile profile) throws CommonException;
	
	void disconnect() throws CommonException;
	
	void listener(Listener listener);

}
