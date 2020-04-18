package com.nabiki.hope.common.provider.trade;

public interface TradeProvider {
	String accountId();
	
	Trade newTrade();
	
	Trade recallTrade(String id);
}
