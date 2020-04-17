package com.nabiki.hope.common.data;

import java.time.Instant;
import java.util.Date;

/**
 * Trade report to client.
 * 
 * @author Hongbao Chen
 *
 */
public interface TradeReport {
	String orderId();
	
	String tradeId();
	
	TokenByte direction();
	
	TokenByte offsetFlag();
	
	TokenByte hedgeFlag();
	
	Double price();
	
	Integer volume();
	
	Instant tradeTime();
	
	Date tradingDay();
	
	Integer sequenceNo();
	
	Integer brokerOrderSequence();
}
