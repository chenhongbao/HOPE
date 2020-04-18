package com.nabiki.hope.common.provider.off;

import java.util.Collection;

import com.nabiki.hope.common.data.Account;
import com.nabiki.hope.common.data.PositionDetail;

/**
 * Operations exposed to clients to get pre-trade data.
 * 
 * @author Hongbao Chen
 *
 */
public interface OffTradeProvider {
	String accountId();
	
	Account account();
	
	Collection<PositionDetail> positions();
	
	Collection<PositionDetail> positions(String symbol);
	
	MarketDataSubscriber marketDataSubscriber();

}
