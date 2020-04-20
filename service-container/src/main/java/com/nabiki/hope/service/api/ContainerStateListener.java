package com.nabiki.hope.service.api;

import com.nabiki.hope.service.ContainerState;

public interface ContainerStateListener {
	void onState(ContainerState s);
}
