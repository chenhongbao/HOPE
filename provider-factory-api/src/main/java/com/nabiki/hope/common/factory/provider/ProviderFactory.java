package com.nabiki.hope.common.factory.provider;

import com.nabiki.hope.common.provider.conn.Connection;
import com.nabiki.hope.common.provider.csv.CandleRw;
import com.nabiki.hope.common.provider.csv.InternalAccountRw;
import com.nabiki.hope.common.provider.csv.InternalNewOrderRw;
import com.nabiki.hope.common.provider.csv.InternalOrderStatusRw;
import com.nabiki.hope.common.provider.csv.InternalPositionDetailRw;
import com.nabiki.hope.common.provider.csv.InternalTradeReportRw;
import com.nabiki.hope.common.provider.off2.InternalOffTradeProvider;
import com.nabiki.hope.common.provider.trade2.InternalTradeProvider;

public interface ProviderFactory {
	Connection connection();
	
	InternalOffTradeProvider internalOffTradeProvider();
	
	InternalTradeProvider internalTradeProvider();
	
	CandleRw candleRw();
	
	InternalAccountRw internalAccountRw();
	
	InternalNewOrderRw internalNewOrderRw();
	
	InternalOrderStatusRw internalOrderStatusRw();
	
	InternalPositionDetailRw internalPositionDetailRw();
	
	InternalTradeReportRw internalTradeReportRw();
}
