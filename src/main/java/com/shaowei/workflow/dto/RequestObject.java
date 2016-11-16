package com.shaowei.workflow.dto;

import java.util.HashMap;
import java.util.Map;

public class RequestObject {
	
	Map<String, Object> requestObject;

	public RequestObject() {
		requestObject = new HashMap<String, Object>();
	}

	public Map<String, Object> getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(Map<String, Object> requestObject) {
		this.requestObject = requestObject;
	}
	

}
