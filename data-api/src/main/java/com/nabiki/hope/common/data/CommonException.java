package com.nabiki.hope.common.data;

/**
 * @author Hongbao Chen
 *
 */
public class CommonException extends Exception {
	private static final long serialVersionUID = -1015646585496180515L;
	
	private Integer code;
	
	public CommonException() {
	}
	
	public CommonException(Integer code) {
		this.code = code;
	}

	public CommonException(String message) {
		super(message);
	}
	
	public CommonException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public CommonException(Throwable cause) {
		super(cause);
	}
	
	public CommonException(Integer code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CommonException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommonException(Integer code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}
	
	public Integer code() {
		return this.code;
	}
	
	public String message() {
		return this.getMessage();
	}
	
	public Throwable cause() {
		return this.getCause();
	}
}
