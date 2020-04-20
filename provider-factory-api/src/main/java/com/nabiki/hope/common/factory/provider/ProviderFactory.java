package com.nabiki.hope.common.factory.provider;

import com.nabiki.hope.common.provider.conn.Connection;
import com.nabiki.hope.common.provider.off2.InternalOffTradeProvider;
import com.nabiki.hope.common.provider.trade2.InternalTradeProvider;

public interface ProviderFactory {
	Connection connection();
	
	InternalOffTradeProvider internalOffTradeProvider();
	
	InternalTradeProvider internalTradeProvider();
}
