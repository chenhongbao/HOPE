/**
 * 
 */
package com.nabiki.hope.common.data;

/**
 * Order input to market.
 * 
 * @author Hongbao Chen
 *
 */
public interface NewOrder {
	void symbol(String s);
	
	String symbol();
	
	void accountId(String s);
	
	String accountId();
	
	void price(Double d);
	
	Double price();
	
	void stopPrice(Double d);
	
	Double stopPrice();
	
	void volume(Integer i);
	
	Integer volume();
	
	void minVolume(Integer i);
	
	Integer minVolume();
	
	void direction(TokenByte t);
	
	TokenByte direction();
	
	void priceType(TokenByte t);
	
	TokenByte priceType();
	
	void offsetFlag(TokenByte t);
	
	TokenByte offsetFlag();
	
	void hedgeFlag(TokenByte t);
	
	TokenByte hedgeFlag();
	
	void timeCondition(TokenByte t);
	
	TokenByte timeCondition();
	
	void volumeCondition(TokenByte t);
	
	TokenByte volumeCondition();
	
	void contigentConditon(TokenByte t);
	
	TokenByte contigentConditon();
	
	/**
	 * Note on the input order such as reason for the trade.
	 * 
	 * @param n
	 */
	void note(String n);
	
	String note();
}
