package com.nabiki.hope.service.ctrl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JarPathProfile {
	@XmlElement
	public String jar;
	
	@XmlElement
	public String classPath;

	public JarPathProfile() {
	}

	public String jar() {
		return this.jar;
	}
	
	public String classPath() {
		return this.classPath;
	}
}
