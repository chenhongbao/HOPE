package com.nabiki.hope.common.provider.off2;

import java.util.Collection;

import com.nabiki.hope.common.provider.conn.Connection;
import com.nabiki.hope.common.provider.off.MarketDataSubscriber;

/**
 * @author Hongbao Chen
 *
 */
public interface InternalMarketDataSubscriber extends MarketDataSubscriber {
	Boolean isRunning();
	
	Collection<String> subscribedSymbols();
	
	void underlyingConnection(Connection c);
	
	void asyncRun();
	
	void run();
	
	void stop();
}
