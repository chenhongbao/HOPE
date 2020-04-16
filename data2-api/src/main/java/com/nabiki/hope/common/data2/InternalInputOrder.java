package com.nabiki.hope.common.data2;

import java.util.Date;

import com.nabiki.hope.common.data.InputOrder;
import com.nabiki.hope.common.data.TokenByte;

/**
 * Internally used order with full attributes.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalInputOrder extends InputOrder {
	String brokerId();
	
	void brokerId(String s);
	
	String investorId();
	
	void investorId(String s);
	
	String orderReference();
	
	void orderReference(String s);
	
	String userId();
	
	void userId(String s);
	
	Date gtdDate();
	
	void gtdDate(Date d);
	
	TokenByte forceCloseReason();
	
	void forceCloseReason(TokenByte t);
	
	Boolean isAutoSuspend();
	
	void isAutoSuspend(Boolean b);
	
	String businessUnit();
	
	void businessUnit(String s);
	
	Integer requestId();
	
	void requestId(Integer i);
	
	Boolean userForceClose();
	
	void userForceClose(Boolean b);
	
	Boolean isSwapOrder();
	
	void isSwapOrder(Boolean b);
	
	String exchangeId();
	
	void exchangeId(String s);
	
	String investUnitId();
	
	void investUnitId(String s);
	
	String currencyId();
	
	void currencyId(String s);
	
	String clientId();
	
	void clientId(String s);
	
	String ipAddress();
	
	void ipAddress(String s);
	
	String macAddress();
	
	void macAddress(String s);
}
