package com.nabiki.hope.common.data;

public class NewOrder {
	String symbol;
	String accountId;
	Double price;
	Double stopPrice;
	Integer volume;
	Integer minVolume;
	TokenByte direction;
	TokenByte priceType;
	TokenByte offsetFlag;
	TokenByte hedgeFlag;
	TokenByte timeCondition;
	TokenByte volumeCondition;
	TokenByte contigentCondition;
	String note;

	public NewOrder() {
	}

	public void symbol(String s) {
		this.symbol = s;
	}

	public String symbol() {
		return this.symbol;
	}

	public void accountId(String s) {
		this.accountId = s;
	}

	public String accountId() {
		return this.accountId;
	}

	public void price(Double d) {
		this.price = d;
	}

	public Double price() {
		return this.price;
	}

	public void stopPrice(Double d) {
		this.stopPrice = d;
	}

	public Double stopPrice() {
		return this.stopPrice;
	}

	public void volume(Integer i) {
		this.volume = i;
	}

	public Integer volume() {
		return this.volume;
	}

	public void minVolume(Integer i) {
		this.minVolume = i;
	}

	public Integer minVolume() {
		return this.minVolume;
	}

	public void direction(TokenByte t) {
		this.direction = t;
	}

	public TokenByte direction() {
		return this.direction;
	}

	public void priceType(TokenByte t) {
		this.priceType = t;
	}

	public TokenByte priceType() {
		return this.priceType;
	}

	public void offsetFlag(TokenByte t) {
		this.offsetFlag = t;
	}

	public TokenByte offsetFlag() {
		return this.offsetFlag;
	}

	public void hedgeFlag(TokenByte t) {
		this.hedgeFlag = t;
	}

	public TokenByte hedgeFlag() {
		return this.hedgeFlag;
	}

	public void timeCondition(TokenByte t) {
		this.timeCondition = t;
	}

	public TokenByte timeCondition() {
		return this.timeCondition;
	}

	public void volumeCondition(TokenByte t) {
		this.volumeCondition = t;
	}

	public TokenByte volumeCondition() {
		return this.volumeCondition;
	}

	public void contigentConditon(TokenByte t) {
		this.contigentCondition = t;
	}

	public TokenByte contigentConditon() {
		return this.contigentCondition;
	}

	public void note(String n) {
		this.note = n;
	}

	public String note() {
		return this.note;
	}

}
