package com.nabiki.hope.common.data;

/**
 * Level 2 tick has five ask/bid quotes.
 * 
 * @author Hongbao Chen
 *
 */
public interface TickLevel2 extends Tick {
	Integer askVolume2();

	Double askPrice2();

	Integer bidVolume2();

	Double bidPrice2();

	Integer askVolume3();

	Double askPrice3();

	Integer bidVolume3();

	Double bidPrice3();

	Integer askVolume4();

	Double askPrice4();

	Integer bidVolume4();

	Double bidPrice4();

	Integer askVolume5();

	Double askPrice5();

	Integer bidVolume5();

	Double bidPrice5();
}
