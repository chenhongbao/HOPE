package com.nabiki.hope.common.factory.data;

import com.nabiki.hope.common.data2.InternalAccount;
import com.nabiki.hope.common.data2.InternalNewOrder;
import com.nabiki.hope.common.data2.InternalOrderStatus;
import com.nabiki.hope.common.data2.InternalPositionDetail;
import com.nabiki.hope.common.data2.InternalTradeReport;
import com.nabiki.hope.common.data2.Message;

public interface DataFactory {
	InternalAccount internalAccount();
	
	InternalAccount internalAccountFromBytes(byte[] b);
	
	byte[] internalAccountToBytes(InternalAccount i);
	
	InternalNewOrder internalNewOrder();
	
	InternalNewOrder internalNewOrderFromBytes(byte[] b);
	
	byte[] internalNewOrderToBytes(InternalNewOrder i);
	
	InternalOrderStatus internalOrderStatus();
	
	InternalOrderStatus internalOrderStatusFromBytes(byte[] b);
	
	byte[] internalOrderStatusToBytes(InternalOrderStatus i);
	
	InternalPositionDetail internalPositionDetail();
	
	InternalPositionDetail internalPositionDetailFromBytes(byte[] b);
	
	byte[] internalPositionDetailToBytes(InternalPositionDetail i);
	
	InternalTradeReport internalTradeReport();
	
	InternalTradeReport internalTradeReportFromBytes(byte[] b);
	
	byte[] internalTradeReportToBytes(InternalTradeReport i);
	
	Message message();
	
	Message message(byte[] b);
	
	byte[] message(Message m);
}
