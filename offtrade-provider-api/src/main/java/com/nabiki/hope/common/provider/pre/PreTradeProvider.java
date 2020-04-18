package com.nabiki.hope.common.provider.pre;

import java.util.Collection;

import com.nabiki.hope.common.data.Account;
import com.nabiki.hope.common.data.PositionDetail;

/**
 * Operations exposed to clients to get pre-trade data.
 * 
 * @author Hongbao Chen
 *
 */
public interface PreTradeProvider {
	String accountId();
	
	Account account();
	
	Collection<PositionDetail> positions();
	
	Collection<PositionDetail> positions(String symbol);
	
	MarketDataSubscriber marketDataSubscriber();

}
