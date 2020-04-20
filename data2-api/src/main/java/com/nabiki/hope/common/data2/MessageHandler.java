package com.nabiki.hope.common.data2;

public interface MessageHandler {
	void onMessage(Message m);
	
	Message onRpcRequest(Message m);
	
	void onError(CommonException e);
	
	void onError(CommonException e, Message m);
}
