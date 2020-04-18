package com.nabiki.hope.common.provider.pre;

import com.nabiki.hope.common.data.Tick;

/**
 * @author Hongbao Chen
 *
 */
public interface TickListener {
	void onTick(Tick tick);
}
