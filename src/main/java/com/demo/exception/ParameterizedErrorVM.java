package com.demo.exception;

import java.io.Serializable;
import java.util.List;

/**
 * View Model for sending a parameterized error message.
 * 
 * @author Mehraj Malik
 */
public class ParameterizedErrorVM implements Serializable {

	private static final long serialVersionUID = 1L;

	private final boolean success;
	private final String exception;
	private final List<String> errorCodeList;
	

	public ParameterizedErrorVM(String exception, List<String> errorCodeList) {
		this.success = false;
		this.exception = exception;
		this.errorCodeList = errorCodeList;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getException() {
		return exception;
	}

	public List<String> getErrorCodeList() {
		return errorCodeList;
	}

}

