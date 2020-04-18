package com.nabiki.hope.common.provider.trade2;

import com.nabiki.hope.common.provider.trade.TradeException;
import com.nabiki.hope.common.provider.trade.TradeProvider;

public interface InternalTradeProvider extends TradeProvider {
	InternalTrade newInternalTrade();
	
	InternalTrade recallInternalTrade(String id) throws TradeException;
}
