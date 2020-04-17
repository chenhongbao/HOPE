package com.nabiki.hope.common.data2;

import java.time.Instant;
import java.util.Date;

import com.nabiki.hope.common.data.TokenByte;
import com.nabiki.hope.common.data.TradeReport;

/**
 * Internally used trade report with full attributes.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalTradeReport extends TradeReport {
	String brokerId();
	
	void brokerId(String s);
	
	String investorId();
	
	void investorId(String s);
	
	String symbol();
	
	void symbol(String s);
	
	void orderId(String s);
	
	String userId();
	
	void userId(String s);
	
	String exchangeId();
	
	void exchangeId(String s);
	
	void tradeId(String s);
	
	void direction(TokenByte t);
	
	String orderSysId();
	
	void orderSysId(String s);
	
	String participantId();
	
	void participantId(String s);
	
	String clientId();
	
	void clientId(String s);
	
	TokenByte tradingRole();
	
	void tradingRole(TokenByte t);
	
	String exchangeInstId();
	
	void exchangeInstId(String s);
	
	void offsetFlag(TokenByte t);
	
	void hedgeFlag(TokenByte t);
	
	void price(Double d);
	
	void volume(Integer i);
	
	void tradeTime(Instant t);
	
	TokenByte tradeType();
	
	void tradeType(TokenByte t);
	
	TokenByte priceSource();
	
	void priceSource(TokenByte t);
	
	String traderId();
	
	void traderId(String s);
	
	String orderLocalId();
	
	void orderLocalId(String s);
	
	String clearingPartId();
	
	void clearingPartId(String s);
	
	String businessUnit();
	
	void businessUnit(String s);
	
	void sequenceNo(Integer i);
	
	void tradingDay(Date d);
	
	String settlementId();
	
	void settlementId(String s);
	
	void brokerOrderSequence(Integer i);
	
	TokenByte tradeSource();
	
	void tradeSource(TokenByte t);
	
	String investUnitId();
	
	void investUnitId(String s);
}
