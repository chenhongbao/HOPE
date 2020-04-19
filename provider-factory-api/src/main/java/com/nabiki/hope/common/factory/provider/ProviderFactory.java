package com.nabiki.hope.common.factory.provider;

import com.nabiki.hope.common.provider.conn.Connection;
import com.nabiki.hope.common.provider.datarw.CandleRw;
import com.nabiki.hope.common.provider.datarw.InternalAccountRw;
import com.nabiki.hope.common.provider.datarw.InternalNewOrderRw;
import com.nabiki.hope.common.provider.datarw.InternalOrderStatusRw;
import com.nabiki.hope.common.provider.datarw.InternalPositionDetailRw;
import com.nabiki.hope.common.provider.datarw.InternalTradeReportRw;
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
