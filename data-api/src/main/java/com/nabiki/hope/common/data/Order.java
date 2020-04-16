package com.nabiki.hope.common.data;

import java.time.Instant;
import java.util.Date;

/**
 * Order report to client.
 * 
 * @author Hongbao Chen
 *
 */
public interface Order {
	String symbol();
	
	TokenByte priceType();
	
	TokenByte direction();
	
	TokenByte offsetFlag();
	
	TokenByte hedgeFlag();
	
	Double price();
	
	Integer originalVolume();
	
	TokenByte timeCondition();
	
	Date gtdDate();
	
	TokenByte volumeCondition();
	
	Integer minVolume();
	
	TokenByte contigentCondition();
	
	Double stopPrice();
	
	TokenByte orderSubmitStatus();
	
	Date tradingDay();
	
	TokenByte orderStatus();
	
	Integer tradedVolume();
	
	Integer waitingVolume();
	
	Instant insertTime();
	
	Instant activeTime();
	
	Instant suspendTime();
	
	Instant updateTime();
	
	Instant cancelTime();
	
	Integer zceTradedVolume();
	
	String accountId();
	
	Integer sequenceNo();
	
	Integer brokerOrderSequence();
}
