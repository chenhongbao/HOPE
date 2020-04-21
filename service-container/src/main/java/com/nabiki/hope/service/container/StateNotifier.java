package com.nabiki.hope.service.container;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.service.api.ServiceStateListener;

public class StateNotifier implements ServiceStateListener {

	public StateNotifier() {
		// TODO constructor
	}

	@Override
	public void onState(ServiceState s) {
		// TODO process state change

	}
	
	public void waitState(ServiceState s) throws CommonException {
		// TODO wait state and return
	}

}
