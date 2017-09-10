package com.demo.exception;

/**
 * The enum which contains all the registered excpetions 
 * 
 * @author Mehraj Malik
 *
 */
public enum RegisteredException {
	
	PERSON_EXCEPTION("PersonException"),
	CONSTRAINT_VIOLATION_EXCEPTION("ConstraintViolationException"),
	METHOD_NOT_ALLOWED("HttpRequestMethodNotSupportedException"),
	UNKNOWN_EXCEPTION("Unknown Exception"),
	ACCESS_DENIED_EXCEPTION("AccessDeniedException"),
	HOTEL_EXCEPTION("Hotel Exception");

	private final String exception;
	
	private RegisteredException(final String exception) {
		this.exception=exception;
	}
		

	public String getException() {
		return exception;
	}
	
}
