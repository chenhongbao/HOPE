package com.nabiki.hope.common.data;

import java.util.Date;
import java.time.Instant;

/**
 * Candle generated from ticks.
 * 
 * @author Hongbao Chen
 *
 */
public interface Candle {
	String symbol();
	
	Double openPrice();
	
	Double highPrice();
	
	Double lowPrice();
	
	Double closePrice();
	
	Integer openInterest();
	
	Integer volume();
	
	Integer minutePeriod();
	
	Boolean isDay();
	
	Boolean isEndOfDay();
	
	Boolean isRealTime();
	
	Instant updateTime();

	Date tradingDay();
	
	Date actionDay();
}
