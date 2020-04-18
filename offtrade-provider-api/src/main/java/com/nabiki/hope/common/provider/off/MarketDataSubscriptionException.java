package com.nabiki.hope.common.provider.off;

import com.nabiki.hope.common.data.CommonException;

public class MarketDataSubscriptionException extends CommonException {
	private static final long serialVersionUID = -5558482392288213255L;

	public MarketDataSubscriptionException() {
	}

	public MarketDataSubscriptionException(Integer code) {
		super(code);
	}

	public MarketDataSubscriptionException(String message) {
		super(message);
	}

	public MarketDataSubscriptionException(Throwable cause) {
		super(cause);
	}

	public MarketDataSubscriptionException(Integer code, String message) {
		super(code, message);
	}

	public MarketDataSubscriptionException(Integer code, Throwable cause) {
		super(code, cause);
	}

	public MarketDataSubscriptionException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarketDataSubscriptionException(Integer code, String message, Throwable cause) {
		super(code, message, cause);
	}

	public MarketDataSubscriptionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MarketDataSubscriptionException(Integer code, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(code, message, cause, enableSuppression, writableStackTrace);
	}

}
