package com.demo.exception;

/**
 * 	This class contains enum of exception code and message
 * @author Mehraj Malik
 *
 */
public enum CustomExceptionCode {
	
	DB_FETCH_ERROR("ERR0001","Exception occured while fetching data from DB"),
	DB_CREATE_ERROR("ERR0002","Exception occured while creating data into DB"),
	DB_UPDATE_ERROR("ERR0003","Exception occured while updating data into DB"),
	DB_DELETE_ERROR("ERR0004","Exception occured while deleting data from DB"),
	DATE_PARSE_EXCEPTION("ERR0005","Exception occured while parsing date");
	

	private final String errCode;
	private final String errMsg;
	
	private CustomExceptionCode(final String errCode,final String errMsg) {
	        this.errCode = errCode;
	        this.errMsg = errMsg;
	    }

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	@Override
	public String toString() {
		return errCode + " : " + errMsg;
	}
	
}