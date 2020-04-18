package com.nabiki.hope.common.provider.pre;

import com.nabiki.hope.common.data.Candle;

/**
 * @author Hongbao Chen
 *
 */
public interface CandleListener {
	void onCandle(Candle candle);
}
