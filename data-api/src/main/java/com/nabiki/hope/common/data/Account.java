package com.nabiki.hope.common.data;

import java.util.Date;

/**
 * Client's account.
 * 
 * @author Hongbao Chen
 *
 */
public interface Account {
	String accountId();
	
	Double preMortgage();
	
	Double preCredit();
	
	Double preDeposit();
	
	Double preBalance();
	
	Double preMargin();
	
	Double interestBase();
	
	Double interest();
	
	Double deposit();
	
	Double withdraw();
	
	Double frozenMargin();
	
	Double frozenCash();
	
	Double frozenCommission();
	
	Double currentMargin();
	
	Double cashIn();
	
	Double commission();
	
	Double closeProfit();
	
	Double positionProfit();
	
	Double balance();
	
	Double available();
	
	Double withdrawQuota();
	
	Double reserve();
	
	Date tradingDay();
	
	String settlementId();
	
	Double credit();
	
	Double mortgage();
	
	Double exchangeMargin();
	
	Double deliveryMargin();
	
	Double exchangeDeliveryMargin();
	
	Double reserveBalance();
	
	String currencyId();
	
	Double preFundMortgageIn();
	
	Double preFundMortgageOut();
	
	Double fundMortgageIn();
	
	Double fundMortgageOut();
	
	Double fundMortgageAvailable();
	
	Double mortgageableFund();
	
	Double specProductMagin();
	
	Double specProductFrozenMargin();
	
	Double specProductCommission();
	
	Double specProductFrozenCommission();
	
	Double specProductPositionProfit();
	
	Double specProductCloseProfit();
	
	Double specProductPositionProfitByAlg();
	
	Double specProductExchangeMargin();
	
	TokenByte bizType();
	
	Double frozenSwap();
	
	Double remainSwap();
}
