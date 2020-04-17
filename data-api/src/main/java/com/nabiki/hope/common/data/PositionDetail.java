package com.nabiki.hope.common.data;

import java.util.Date;

/**
 * Position detail per trade.
 * 
 * @author Hongbao Chen
 *
 */
public interface PositionDetail {
	String symbol();
	
	TokenByte hedgeFlag();
	
	TokenByte direction();
	
	Date openDate();
	
	String tradeId();
	
	Integer volume();
	
	Double openPrice();
	
	Date tradingDay();
	
	String settlementId();
	
	TokenByte tradeType();
	
	Double closeProfitByDate();
	
	Double closeProfitByTrade();
	
	Double positionProfitByDate();
	
	Double positionProfitByTrade();
	
	Double margin();
	
	Double exchangeMargin();
	
	Double marginRateByMoney();
	
	Double maringRateByVolume();
	
	Double lastSettlementPrice();
	
	Double settlementPrice();
	
	Integer closeVolume();
	
	Double closeAmount();
}
