package com.nabiki.hope.service.api;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.common.data2.Message;

public interface MessageHandler {
	void onMessage(Message m);
	
	Message onRpcRequest(Message m);
	
	void onError(CommonException e);
	
	void onError(CommonException e, Message m);
}
