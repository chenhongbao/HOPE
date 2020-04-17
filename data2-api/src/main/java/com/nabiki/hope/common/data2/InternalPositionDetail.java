package com.nabiki.hope.common.data2;

import java.util.Date;

import com.nabiki.hope.common.data.PositionDetail;
import com.nabiki.hope.common.data.TokenByte;

/**
 * Position detail with full attributes and getters.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalPositionDetail extends PositionDetail {
	void symbol(String s);
	
	String brokerId();
	
	void brokerId(String s);
	
	String investorId();
	
	void investorId(String s);
	
	void hedgeFlag(TokenByte t);
	
	void direction(TokenByte t);
	
	void openDate(Date d);
	
	void tradeId(String s);
	
	void volume(Integer i);
	
	void openPrice(Double d);
	
	void tradingDay(Date d);
	
	void settlementId(String s);
	
	void tradeType(TokenByte t);
	
	String combSymbol();
	
	void combSymbol(String s);
	
	String exchangeId();
	
	void exchangeId(String s);
	
	void closeProfitByDate(Double d);
	
	void closeProfitByTrade(Double d);
	
	void positionProfitByDate(Double d);
	
	void positionProfitByTrade(Double d);
	
	void margin(Double d);
	
	void exchangeMargin(Double d);
	
	void marginRateByMoney(Double d);
	
	void maringRateByVolume(Double d);
	
	void lastSettlementPrice(Double d);
	
	void settlementPrice(Double d);
	
	void closeVolume(Integer i);
	
	void closeAmount(Double d);
	
	Integer timeFirstVolume();
	
	void timeFirstVolume(Integer i);
	
	String investUnitId();
	
	void investUnitId(String s);
}
