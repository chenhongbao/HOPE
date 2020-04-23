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
		this.messageHandler = new JarPathProfile();
		this.dataFactory = new JarPathProfile();
		this.providerFactory = new JarPathProfile();
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
