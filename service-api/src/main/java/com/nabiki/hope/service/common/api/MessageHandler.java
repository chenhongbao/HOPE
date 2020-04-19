package com.nabiki.hope.service.common.api;

import com.nabiki.hope.common.data.CommonException;

public interface MessageHandler {
	void onMessage(Message m);
	
	Message onRpcRequest(Message m);
	
	void onError(CommonException e);
	
	void onError(CommonException e, Message m);
}
