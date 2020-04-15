/**
 * 
 */
package com.nabiki.hope.common.data;

/**
 * Order input to market. The interface has only setters.
 * 
 * @author Hongbao Chen
 *
 */
public interface InputOrder {
	void symbol(String s);
	
	void accountId(String s);
	
	void price(Double d);
	
	void stopPrice(Double d);
	
	void volume(Integer i);
	
	void minVolume(Integer i);
	
	void direction(TokenByte t);
	
	void priceType(TokenByte t);
	
	void offsetFlag(TokenByte t);
	
	void hedgeFlag(TokenByte t);
	
	void timeCondition(TokenByte t);
	
	void volumeCondition(TokenByte t);
	
	void contigentConditon(TokenByte t);
	
	/**
	 * Note on the input order such as reason for the trade.
	 * 
	 * @param n
	 */
	void note(String n);
}
