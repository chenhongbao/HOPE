package com.nabiki.hope.common.provider.trade;

import java.util.Collection;

import com.nabiki.hope.common.data.NewOrder;
import com.nabiki.hope.common.data.OrderStatus;
import com.nabiki.hope.common.data.TradeReport;

public interface Trade {
	/**
	 * Identifier for this trade across system.
	 * @return trade id
	 */
	String id();
	
	/**
	 * Send order and wait for complete or cancel.
	 * 
	 * @param order new order
	 * @return order status
	 * @throws TradeException order execution error
	 */
	OrderStatus sendAndWait(NewOrder order) throws TradeException;
	
	OrderStatus send(NewOrder order) throws TradeException;
	
	OrderStatus lastStatus() throws TradeException;
	
	Collection<OrderStatus> statuses() throws TradeException;
	
	TradeReport lastTrade() throws TradeException;
	
	Collection<TradeReport> trades() throws TradeException;
	
	OrderStatus cancel() throws TradeException;
}
