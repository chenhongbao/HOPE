package com.nabiki.hope.service.udp;

public class UdpDefine {
	/**
	 * The maximum safe UDP payload is 508 bytes. This is a packet size of 576, minus the maximum 60-byte IP header
	 * and the 8-byte UDP header. Any UDP payload this size or smaller is guaranteed to be deliverable over IP 
	 * (though not guaranteed to be delivered). Anything larger is allowed to be outright dropped by any router for
	 * any reason.
	 */
	public final static int MAX_BODY_SIZE = 508;
}
