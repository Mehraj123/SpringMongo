package com.demo.util;

import java.util.Collections;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class SupplierFactory {

	
	public static Supplier<ResponseEntity<CustomeResponse>> emptyRespone() {
		return  () -> new ResponseEntity<CustomeResponse>(
				new CustomeResponse(FailedCode.FETCHED_FAILED.getCode(), Collections.emptyList()), HttpStatus.OK);
		
	}
}
