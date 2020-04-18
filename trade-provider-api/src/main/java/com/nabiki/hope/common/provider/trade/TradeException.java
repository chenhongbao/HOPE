package com.nabiki.hope.common.provider.trade;

import com.nabiki.hope.common.data.CommonException;

public class TradeException extends CommonException {
	private static final long serialVersionUID = 4477747369912474506L;

	public TradeException() {
	}

	public TradeException(Integer arg0) {
		super(arg0);
	}

	public TradeException(String arg0) {
		super(arg0);
	}

	public TradeException(Throwable arg0) {
		super(arg0);
	}

	public TradeException(Integer arg0, String arg1) {
		super(arg0, arg1);
	}

	public TradeException(Integer arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TradeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TradeException(Integer arg0, String arg1, Throwable arg2) {
		super(arg0, arg1, arg2);
	}

	public TradeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public TradeException(Integer arg0, String arg1, Throwable arg2, boolean arg3, boolean arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
	}

}
