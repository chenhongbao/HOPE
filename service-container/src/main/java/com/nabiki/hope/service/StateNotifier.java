package com.nabiki.hope.service;

import com.nabiki.hope.service.api.ContainerStateListener;

public class StateNotifier implements ContainerStateListener {

	public StateNotifier() {
		// TODO constructor
	}

	@Override
	public void onState(ContainerState s) {
		// TODO process state change

	}
	
	public void waitState(ContainerState s) {
		// TODO wait state and return
	}

}
