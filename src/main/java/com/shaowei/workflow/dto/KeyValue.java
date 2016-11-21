package com.shaowei.workflow.dto;

public class KeyValue {
	
	private String keyy;
	private String value;
	
	
	
	public KeyValue() {
	}
	
	public KeyValue(String keyy, String value) {
		super();
		this.keyy = keyy;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKeyy() {
		return keyy;
	}
	public void setKeyy(String keyy) {
		this.keyy = keyy;
	}
	
	
	
	

}
