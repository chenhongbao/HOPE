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

	Integer openInterest();

	Integer preOpenInterest();

	Integer volume();

	Double lowestPrice();

	Double highestPrice();

	Double upperLimitPrice();

	Double lowerLimitPrice();

	Double averagePrice();

	Double lastPrice();
	
	Double openPrice();

	Double closePrice();

	Double preClosePrice();

	Double settlementPrice();

	Double preSettlementPrice();
	
	Boolean isEndOfDay();
	
	Boolean isRealTime();

	Instant updateTime();

	Date tradingDay();

	Date actionDay();
}
