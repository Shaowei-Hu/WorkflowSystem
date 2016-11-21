package com.shaowei.workflow.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.shaowei.workflow.dto.KeyValue;

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
	
	
	public static List<KeyValue> getAllProperties(String fileName){
		InputStream is = null;
		Properties prop = new Properties();
		List<KeyValue> result = new ArrayList<>();
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			prop.load(is);
			
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				KeyValue keyValue = new KeyValue(key, value);
				result.add(keyValue);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public static List<KeyValue> getAllPropertiesOrdered(String fileName){
		InputStream is = null;
		OrderedProperties prop = new OrderedProperties();
		List<KeyValue> result = new ArrayList<>();
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			prop.load(is);
			
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				KeyValue keyValue = new KeyValue(key, value);
				result.add(keyValue);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	


}
