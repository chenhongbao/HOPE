package com.nabiki.hope.service;

import com.nabiki.hope.common.data2.CommonException;
import com.nabiki.hope.service.container.ServiceState;
import com.nabiki.hope.service.container.StateNotifier;
import com.nabiki.hope.service.ctrl.ServiceController;

public class Main {
	private StateNotifier notifier;
	private ServiceController serviceController;

	public Main() {
		try {
			// listen container state change
			this.notifier = new StateNotifier();
			this.serviceController = new ServiceController(this.notifier);

			// wait for container stopped
			this.notifier.waitState(ServiceState.STOPPED);
		} catch (CommonException c) {
			// TODO common exception
		} catch (Exception e) {
			// TODO generic exception
		} finally {
			// TODO exit ops
		}
	}
}
