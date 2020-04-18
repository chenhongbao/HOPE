package com.nabiki.hope.client.user;

import com.nabiki.hope.common.data.CommonException;
import com.nabiki.hope.common.provider.off.OffTradeProvider;
import com.nabiki.hope.common.provider.trade.TradeProvider;

public interface ClientHandler {
	void onInit(OffTradeProvider off, TradeProvider trade, Reasons reason);
	
	void onExit(Reasons reason);
	
	void onException(CommonException e);

}
