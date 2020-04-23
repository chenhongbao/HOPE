package com.nabiki.hope.service.container;

public enum ServiceState {
	/**
	 * Service controller is initializing container for a fresh start.
	 */
	STARTING,
	
	/**
	 * Container is started by service controller.
	 */
	STARTED,
	
	/**
	 * Service controller is stopping container.
	 */
	STOPPING,
	
	/**
	 * Service is stopped and about to exit the program.
	 */
	STOPPED,
	
	/**
	 * Service controller is restarting the container.
	 */
	RESTARTING,
	
	/**
	 * Container is restarted by service controller.
	 */
	RESTARTED,
	
	/**
	 * Service controller is stopping container for upcoming restart.
	 */
	RESTART_STOPPING
}
