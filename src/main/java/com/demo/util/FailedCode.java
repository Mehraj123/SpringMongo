package com.demo.util;

public enum FailedCode {
	
	SAVED_FAILED("ERR0001","Person save failed"),
	FETCHED_FAILED("ERR0002","Person fetch failed"),
	CREATED_FAILED("ERR0003","Person create failed"),
	DELETED_FAILED("ERR0004","Person delete failed");
	
	private final String code;
	private final String msg;

	private FailedCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
