package com.shaowei.workflow.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MavenProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6127188526845184037L;
	
	Logger loger = Logger.getLogger(this.getClass());
	
	
	public String javaVersion;
	public String hibernateVersion;
	public String springVersion;
	public String applicationVersion;

	public MavenProperties() {
		
		loger.info("Application Maven properties init");
		javaVersion = getProperty("java.version");
		hibernateVersion = getProperty("hibernate.version");
		springVersion = getProperty("spring.version");
		applicationVersion = getProperty("application.version");
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getHibernateVersion() {
		return hibernateVersion;
	}

	public void setHibernateVersion(String hibernateVersion) {
		this.hibernateVersion = hibernateVersion;
	}

	public String getSpringVersion() {
		return springVersion;
	}

	public void setSpringVersion(String springVersion) {
		this.springVersion = springVersion;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public String getProperty(String propertyName) {
		InputStream is = null;
		Properties p = new Properties();
		try {
			is = this.getClass().getClassLoader().getResourceAsStream("maven.properties");
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return p.getProperty(propertyName);

	}

}
