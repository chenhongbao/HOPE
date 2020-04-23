package com.nabiki.hope.common.provider.conn;

import com.nabiki.hope.common.data2.CommonException;

public interface Connection {
	/**
	 * Connect peer with previous profile.
	 */
	void open() throws CommonException;
	
	void open(ConnectionProfile profile) throws CommonException;
	
	void close() throws CommonException;
	
	void listener(Listener listener);
	
	Boolean isClosed();

}
