package com.nabiki.hope.common.data2;

import java.time.Instant;
import java.util.Date;

import com.nabiki.hope.common.data.Order;
import com.nabiki.hope.common.data.TokenByte;

/**
 * Internal used order report with full attributes.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalOrder extends Order {
	void symbol(String s);
	
	String brokerId();
	
	void brokerId(String s);
	
	String investorId();
	
	void investorId(String s);
	
	String orderReference();
	
	void orderReference(String s);
	
	String userId();
	
	void userId(String s);
	
	void priceType(TokenByte t);
	
	void direction(TokenByte t);
	
	void offsetFlag(TokenByte t);
	
	void hedgeFlag(TokenByte t);
	
	void price(Double d);
	
	void orginalVolume(Integer i);
	
	void timeCondition(TokenByte t);
	
	void gtdDate(Date d);
	
	void volumeCondition(TokenByte t);
	
	void minVolume(Integer i);
	
	void contigentCondition(TokenByte t);
	
	void stopPrice(Double d);
	
	TokenByte forceCloseReason();
	
	void forceCloseReason(TokenByte t);
	
	Boolean isAutoSuspend();
	
	void isAutoSuspend(Boolean b);
	
	String businessUnit();
	
	void businessUnit(String s);
	
	Integer requestId();
	
	void requestId(Integer i);
	
	String orderLocalId();
	
	void orderLocalId(String s);
	
	String exchangeId();
	
	void exchangeId(String s);
	
	String participantId();
	
	void participantId(String s);
	
	String clientId();
	
	void clientId(String s);
	
	String exchangeInstId();
	
	void exchangeInstId(String s);
	
	String traderId();
	
	void traderId(String s);
	
	Integer installId();
	
	void installId(Integer i);
	
	void orderSubmitStatus(TokenByte t);
	
	Integer notifySequence();
	
	void notifySequence(Integer i);
	
	void tradingDay(Date d);
	
	Integer settlementId();
	
	void settlementId(Integer i);
	
	String orderSysId();
	
	void orderSysId(String s);
	
	TokenByte orderSource();
	
	void orderSource(TokenByte t);
	
	void orderStatus(TokenByte t);
	
	TokenByte orderType();
	
	void orderType(TokenByte t);
	
	void tradedVolume(Integer i);
	
	void waitingVolume(Integer i);
	
	void insertTime(Instant i);
	
	void activeTime(Instant i);
	
	void suspendTime(Instant i);
	
	void updateTime(Instant i);
	
	void cancelTime(Instant i);
	
	String activeTraderId();
	
	void activeTraderId(String s);
	
	String clearingPartId();
	
	void clearingPartId(String s);
	
	void sequenceNo(Integer i);
	
	Integer frontId();
	
	void frontId(Integer i);
	
	Integer sessionId();
	
	void sessionId(Integer i);
	
	String userProductInfo();
	
	void userProductInfo(String s);
	
	String statusMessage();
	
	void statusMessage(String s);
	
	Boolean userForceClose();
	
	void userForceClose(Boolean b);
	
	String activeUserId();
	
	void activeUserId(String s);
	
	void brokerOrderSequence(Integer i);
	
	String relativeOrderSysId();
	
	void relativeOrderSysId(String s);
	
	void zceTradedVolume(Integer i);
	
	Boolean isSwapOrder();
	
	void isSwapOrder(Boolean b);
	
	String branchId();
	
	void branchId(String s);
	
	String investUnitId();
	
	void investUnitId(String s);
	
	void accountId(String s);
	
	String currencyId();
	
	void currencyId(String s);
	
	String ipAddress();
	
	void ipAddress(String s);
	
	String macAddress();
	
	void macAddress(String s);
}
