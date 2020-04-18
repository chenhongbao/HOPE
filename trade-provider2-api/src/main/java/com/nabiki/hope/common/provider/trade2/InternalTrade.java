package com.nabiki.hope.common.provider.trade2;

import java.util.Collection;

import com.nabiki.hope.common.data.NewOrder;
import com.nabiki.hope.common.data2.InternalOrderStatus;
import com.nabiki.hope.common.data2.InternalTradeReport;
import com.nabiki.hope.common.provider.trade.Trade;
import com.nabiki.hope.common.provider.trade.TradeException;

public interface InternalTrade extends Trade {
	InternalOrderStatus internalSendAndWait(NewOrder order) throws TradeException;
	
	InternalOrderStatus internalSend(NewOrder order) throws TradeException;
	
	InternalOrderStatus lastStatus() throws TradeException;
	
	Collection<InternalOrderStatus> internalStatuses() throws TradeException;
	
	InternalTradeReport internalLastTrade() throws TradeException;
	
	Collection<InternalTradeReport> internalTrades() throws TradeException;
	
	InternalOrderStatus internalCancel() throws TradeException;
}
