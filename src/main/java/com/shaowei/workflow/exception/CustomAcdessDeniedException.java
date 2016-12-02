package com.shaowei.workflow.exception;

public class CustomAcdessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CustomAcdessDeniedException(String errMsg) {
		this.errCode = "3000";
		this.errMsg = "AOP access controll : Access Denied " + errMsg;
	}

}
