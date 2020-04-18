package com.nabiki.hope.client.user;

public enum Reasons {
	/**
	 * Client starts as normal.
	 */
	NORMAL_INIT,
	
	/**
	 * Client is started by outside demand.
	 */
	DEMAND_INIT,
	
	/**
	 * Client exits as normal.
	 */
	NORMAL_EXIT,
	
	/**
	 * Client is terminated by outside demand.
	 */
	DEMAND_EXIT,
	
	/**
	 * Client terminates due to fatal error.
	 */
	FATAL_ERROR_TERMINATED
}
