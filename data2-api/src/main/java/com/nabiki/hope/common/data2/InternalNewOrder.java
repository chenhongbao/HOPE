package com.nabiki.hope.common.data2;

import java.util.Date;

import com.nabiki.hope.common.data.NewOrder;
import com.nabiki.hope.common.data.TokenByte;

/**
 * Internally used order with full attributes.
 * 
 * @author Hongbao Chen
 *
 */
public abstract class InternalNewOrder extends NewOrder {
	public abstract String brokerId();
	
	public abstract void brokerId(String s);
	
	public abstract String investorId();
	
	public abstract void investorId(String s);
	
	public abstract String orderId();
	
	public abstract void orderId(String s);
	
	public abstract String userId();
	
	public abstract void userId(String s);
	
	public abstract Date gtdDate();
	
	public abstract void gtdDate(Date d);
	
	public abstract TokenByte forceCloseReason();
	
	public abstract void forceCloseReason(TokenByte t);
	
	public abstract Boolean isAutoSuspend();
	
	public abstract void isAutoSuspend(Boolean b);
	
	public abstract String businessUnit();
	
	public abstract void businessUnit(String s);
	
	public abstract Integer requestId();
	
	public abstract void requestId(Integer i);
	
	public abstract Boolean userForceClose();
	
	public abstract void userForceClose(Boolean b);
	
	public abstract Boolean isSwapOrder();
	
	public abstract void isSwapOrder(Boolean b);
	
	public abstract String exchangeId();
	
	public abstract void exchangeId(String s);
	
	public abstract String investUnitId();
	
	public abstract void investUnitId(String s);
	
	public abstract String currencyId();
	
	public abstract void currencyId(String s);
	
	public abstract String clientId();
	
	public abstract void clientId(String s);
	
	public abstract String ipAddress();
	
	public abstract void ipAddress(String s);
	
	public abstract String macAddress();
	
	public abstract void macAddress(String s);
}
