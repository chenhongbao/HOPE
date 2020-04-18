package com.nabiki.hope.common.provider.off;

import com.nabiki.hope.common.data.Tick;

/**
 * @author Hongbao Chen
 *
 */
public interface TickListener {
	void onTick(Tick tick);
}
