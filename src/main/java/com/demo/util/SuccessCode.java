package com.demo.util;


/**
 * 
 * @author Mehraj Malik
 *
 */
public enum SuccessCode {
	
	SAVED_SUCCESSFULLY("SCS0001","Person save successfully"),
	FETCHED_SUCCESSFULLY("SCS0002","Person fetch successfully"),
	CREATED_SUCCESSFULLY("SCS0003","Person create successfully"),
	DELETED_SUCCESSFULLY("SCS0004","Person delete successfully");
	
	private final String code;
	private final String msg;

	private SuccessCode(String code, String msg) {
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
