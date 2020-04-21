package com.nabiki.hope.service.api;

import com.nabiki.hope.service.container.ServiceState;

public interface ServiceStateListener {
	void onState(ServiceState s);
}
