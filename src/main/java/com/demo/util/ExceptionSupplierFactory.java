package com.demo.util;

import java.util.function.Supplier;

import com.demo.exception.CustomExceptionCode;
import com.demo.exception.CustomParameterizedException;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class ExceptionSupplierFactory {

	public static Supplier<CustomParameterizedException> dbFetchError(){
		return ()-> new CustomParameterizedException(CustomExceptionCode.DB_FETCH_ERROR.getErrMsg(),
				CustomExceptionCode.DB_FETCH_ERROR.getErrCode());
	}
}
