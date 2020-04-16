package com.nabiki.hope.common.data2;

import java.util.Date;

import com.nabiki.hope.common.data.Account;
import com.nabiki.hope.common.data.TokenByte;

/**
 * Internally used account with full getters.
 * 
 * @author Hongbao Chen
 *
 */
public interface InternalAccount extends Account {
	String brokerId();
	
	void brokerId(String s);
	
	void accountId(String s);
	
	void preMortgage(Double d);
	
	void preCredit(Double d);
	
	void preDeposit(Double d);
	
	void preBalance(Double d);
	
	void preMargin(Double d);
	
	void interestBase(Double d);
	
	void interest(Double d);
	
	void deposit(Double d);
	
	void withdraw(Double d);
	
	void frozenMargin(Double d);
	
	void frozenCash(Double d);
	
	void frozenCommission(Double d);
	
	void currentMargin(Double d);
	
	void cashIn(Double d);
	
	void commission(Double d);
	
	void closeProfit(Double d);
	
	void positionProfit(Double d);
	
	void balance(Double d);
	
	void available(Double d);
	
	void withdrawQuota(Double d);
	
	void reserve(Double d);
	
	void tradingDay(Date d);
	
	void settlementId(String s);
	
	void credit(Double d);
	
	void mortgage(Double d);
	
	void exchangeMargin(Double d);
	
	void deliveryMargin(Double d);
	
	void exchangeDeliveryMargin(Double d);
	
	void reserveBalanec(Double d);
	
	void currencyId(Double d);
	
	void preFundMortgageIn(Double d);
	
	void preFundMortgageOut(Double d);
	
	void fundMortgageIn(Double d);
	
	void fundMortgageOut(Double d);
	
	void fundMortgageAvailable(Double d);
	
	void mortgageableFund(Double d);
	
	void specProductMargin(Double d);
	
	void specProductFrozenMargin(Double d);
	
	void specProductCommission(Double d);
	
	void specProductFrozenCommission(Double d);
	
	void specProductPositionProfit(Double d);
	
	void specProductCloseProfit(Double d);
	
	void specProductPositionProfitByAlg(Double d);
	
	void specProductExchangeMargin(Double d);
	
	void bizType(TokenByte t);
	
	void frozenSwap(Double d);
	
	void remainSwap(Double d);
}
