package com.nabiki.hope.service.ctrl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComponentSettingProfile {
	@XmlElement(type = JarPathProfile.class)
	public JarPathProfile messageHandler;
	
	@XmlElement(type = JarPathProfile.class)
	public JarPathProfile dataFactory;
	
	@XmlElement(type = JarPathProfile.class)
	public JarPathProfile providerFactory;

	public ComponentSettingProfile() {
	}

	public JarPathProfile messageHandler() {
		return this.messageHandler;
	}
	
	public JarPathProfile dataFactory() {
		return this.dataFactory;
	}
	
	public JarPathProfile providerFactory() {
		return this.providerFactory;
	}
}
