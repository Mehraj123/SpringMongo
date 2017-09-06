package com.demo.util;

import java.util.List;
import java.util.function.BiFunction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.entity.Person;

/**
 * 
 * @author Mehraj Malik
 *
 */
public class FunctionFactory <T>{
	
	T type;

	public static BiFunction<String,List<Person>, ResponseEntity<CustomeResponse>> biFunction = (successCode, list)->
	   new ResponseEntity<CustomeResponse>(new CustomeResponse(successCode,list), HttpStatus.OK);
	   
	   public static BiFunction<String,Boolean, ResponseEntity<CustomeResponse>> boolBiFunction = (successCode,status)->
	   new ResponseEntity<CustomeResponse>(new CustomeResponse(successCode,status), HttpStatus.OK);
}
