package com.nabiki.hope.common.data;

import java.util.Date;
import java.time.Instant;

/**
 * Any object implementing this interface provides concrete data access to the
 * tick flow from market.
 * 
 * @author Hongbao Chen
 *
 */
public interface Tick {
	String symbol();

	Integer askVolume();

	Double askPrice();

	Integer bidVolume();

	Double bidPrice();

	Integer openInterest();

	Integer preOpenInterest();

	Integer volume();

	Double lowestPrice();

	Double highestPrice();

	Double upperLimitPrice();

	Double lowerLimitPrice();

	Double averagePrice();

	Double lastPrice();

	Double closePrice();

	Double preClosePrice();

	Double settlementPrice();

	Double preSettlementPrice();

	Instant updateTime();

	Date tradingDay();

	Date actionDay();
}
