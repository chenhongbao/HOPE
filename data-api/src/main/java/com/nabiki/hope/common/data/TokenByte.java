/**
 * 
 */
package com.nabiki.hope.common.data;

import java.nio.charset.Charset;

/**
 * Command or status encoded in byte.
 * 
 * @author Hongbao Chen
 *
 */
public final class TokenByte {

	final public static TokenByte ORDER_CANCELED = convertChar2Token('5');
	
	private Byte token;
	
	public TokenByte() {
	}
	
	public TokenByte(Byte b) {
		this.token = b;
	}
	
	public Byte value() {
		return this.token;
	}
	
	private static TokenByte convertChar2Token(char c) {
		return new TokenByte(String.valueOf('a').getBytes(Charset.forName("US-ASCII"))[0]);
	}
}
