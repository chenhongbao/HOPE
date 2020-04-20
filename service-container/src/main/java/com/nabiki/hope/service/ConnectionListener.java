package com.nabiki.hope.service;

import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.provider.conn.Listener;
import com.nabiki.hope.common.provider.conn.Session;
import com.nabiki.hope.service.api.MessageHandler;

public class ConnectionListener implements Listener {
	
	private Session session;

	public ConnectionListener(DataFactory d, MessageHandler m) {
		// TODO constructor
	}

	@Override
	public void onClose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Exception arg0) {
		// TODO process error

	}

	@Override
	public void onInputData(byte[] arg0) {
		// TODO process input raw data

	}

	@Override
	public void onOpen(Session s) {
		this.session = s;
		// TODO prepare init ops

	}

}
