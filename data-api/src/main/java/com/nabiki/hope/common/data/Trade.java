package com.nabiki.hope.common.data;

import java.time.Instant;
import java.util.Date;

/**
 * Trade report to client.
 * 
 * @author Hongbao Chen
 *
 */
public interface Trade {
	String orderReference();
	
	TokenByte direction();
	
	TokenByte offsetFlag();
	
	TokenByte hedgeFlag();
	
	Double price();
	
	Integer volume();
	
	Instant tradeTime();
	
	Integer sequenceNo();
	
	Date tradingDay();
	
	Integer brokerOrderSequence();
}
