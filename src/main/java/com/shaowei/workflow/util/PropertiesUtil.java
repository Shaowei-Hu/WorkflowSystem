package com.shaowei.workflow.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String getProperties(String fileName, String propertyName){
		InputStream is = null;
		Properties p = new Properties();
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return p.getProperty(propertyName);
	}
	
	
	public static boolean setProperties(String fileName, String propertyName, String value){
		InputStream is = null;
		Properties p = new Properties();
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			p.load(is);
			p.setProperty(propertyName, value);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

}
