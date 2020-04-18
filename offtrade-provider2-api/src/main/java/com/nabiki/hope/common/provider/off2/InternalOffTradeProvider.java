package com.nabiki.hope.common.provider.off2;

import java.util.Collection;

import com.nabiki.hope.common.data2.InternalAccount;
import com.nabiki.hope.common.data2.InternalPositionDetail;
import com.nabiki.hope.common.provider.off.OffTradeProvider;

/**
 * Internal operations to get full attributes data.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalOffTradeProvider extends OffTradeProvider {
	InternalAccount internalAccount();
	
	Collection<InternalPositionDetail> internalPositions();
	
	Collection<InternalPositionDetail> internalPositions(String symbol);
}
