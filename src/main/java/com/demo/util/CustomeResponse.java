package com.demo.util;

/**
 * A custome response class to render the respone on the client side
 * 
 * @author Mehraj Malik
 * @version 1.0
 */
public class CustomeResponse {

	private final boolean status;
	private final Object errCode;
	private final Object data;
	
	public CustomeResponse(Object errCode, Object data) {
		this.status = true;
		this.errCode = errCode;
		this.data = data;
	}
	
	public CustomeResponse(Object statusCode) {
		this(statusCode,null);
	}

	public boolean isStatus() {
		return status;
	}

	public Object getErrCode() {
		return errCode;
	}

	public Object getData() {
		return data;
	}

}
