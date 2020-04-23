package com.nabiki.hope.service.container;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.factory.data.DataFactory;
import com.nabiki.hope.common.provider.conn.Listener;
import com.nabiki.hope.common.provider.conn.Session;
import com.nabiki.hope.service.api.MessageHandler;
import com.nabiki.hope.service.api.PreDefine;

public class ConnectionListener implements Listener {

	private Session session;
	private DataFactory dataFactory;
	private MessageHandler messageHandler;

	public ConnectionListener(DataFactory d, MessageHandler m) {
		this.dataFactory = d;
		this.messageHandler = m;
	}

	@Override
	public void onClose() {
		if (this.messageHandler == null)
			return;
		
		try {
			this.messageHandler.onStop();
		} catch (Exception e) {
			System.err.println("Unhandled unknown error. " + e.getMessage());
		}
	}

	@Override
	public void onError(Exception e) {
		if (this.messageHandler == null)
			return;
		
		try {
			this.messageHandler.onError(new CommonException(e));
		} catch (Exception ex) {
			System.err.println("Unhandled unknown error. " + ex.getMessage());
		}
	}

	@Override
	public void onInputData(byte[] bytes) {
		if (bytes == null || bytes.length == 0)
			return;

		var msg = this.dataFactory.message(bytes);
		if (msg == null || this.messageHandler == null)
			return;

		try {
			switch (msg.ackType()) {
			case PreDefine.ACK_MSG:
				var rsp = this.messageHandler.onRpcRequest(msg);
				if (this.session != null) {
					this.session.put(this.dataFactory.message(rsp));
				}
				break;
			case PreDefine.ACK_RECV:
				this.messageHandler.onMessage(msg);
				if (this.session != null) {
					var recv = this.dataFactory.message();
					recv.messageType(PreDefine.MSG_ACK_RECV);
					recv.ackType(PreDefine.ACK_NO);
					recv.errorCode(0);
					this.session.put(this.dataFactory.message(recv));
				}
				break;
			case PreDefine.ACK_NO:
				this.messageHandler.onMessage(msg);
				break;
			default:
				this.messageHandler.onError(new CommonException("Unknown message ack type."), msg);
				break;
			}
		} catch (Exception e) {
			System.err.println("Unhandled unknown error. " + e.getMessage());
		}
	}

	@Override
	public void onOpen(Session s) {
		this.session = s;
		
		if (this.messageHandler == null)
			return;
		
		try {
			this.messageHandler.onStart();
		} catch (Exception e) {
			System.err.println("Unhandled unknown error. " + e.getMessage());
		}
	}

}
