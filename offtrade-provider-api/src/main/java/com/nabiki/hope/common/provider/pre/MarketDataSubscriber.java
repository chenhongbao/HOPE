package com.nabiki.hope.common.provider.pre;

/**
 * @author Hongbao Chen
 *
 */
public interface MarketDataSubscriber {
	void subscribe(String symbol, TickListener listener, MarketDataSubscriptionMode mode)
			throws MarketDataSubscriptionException;
	
	void subscribe(String symbol, CandleListener listener, Integer minutePeriod, MarketDataSubscriptionMode mode)
			throws MarketDataSubscriptionException;
	
	void unsubscribe(String symbol) throws MarketDataSubscriptionException;
	
	void recall(String symbol, TickListener listener) throws MarketDataSubscriptionException;
	
	void recall(String symbol, CandleListener listener, Integer minutePeriod) throws MarketDataSubscriptionException;
}
