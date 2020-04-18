package com.nabiki.hope.common.provider.pre2;

import java.util.Collection;

import com.nabiki.hope.common.data2.InternalAccount;
import com.nabiki.hope.common.data2.InternalPositionDetail;
import com.nabiki.hope.common.provider.pre.PreTradeProvider;

/**
 * Internal operations to get full attributes data.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalPreTradeProvider extends PreTradeProvider {
	InternalAccount internalAccount();
	
	Collection<InternalPositionDetail> internalPositions();
	
	Collection<InternalPositionDetail> internalPositions(String symbol);
}
