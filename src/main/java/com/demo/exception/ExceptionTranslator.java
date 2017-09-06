package com.demo.exception;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Controller advice to translate the server side exceptions to client-friendly json structures.
 */
@ControllerAdvice
public class ExceptionTranslator {

	private final Logger log = LoggerFactory.getLogger(ExceptionTranslator.class);

 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ParameterizedErrorVM processValidationError(MethodArgumentNotValidException ex) {
    	log.error("-- MethodArgumentNotValidException --- ");
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errorCodeList=new ArrayList<>();
        for(FieldError fieldError : fieldErrors) {
            errorCodeList.add(fieldError.getDefaultMessage());
        }
        return new ParameterizedErrorVM(RegisteredException.CONSTRAINT_VIOLATION_EXCEPTION.getException(), errorCodeList);
    }

    @ExceptionHandler(CustomParameterizedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ParameterizedErrorVM processParameterizedValidationError(CustomParameterizedException ex) {
    	log.error("-- CustomParameterizedException --- ");
        return ex.getParameterizedErrorVM();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ParameterizedErrorVM processAccessDeniedException(AccessDeniedException e) {
    	log.error("-- AccessDeniedException --- ");

    	return new ParameterizedErrorVM(RegisteredException.ACCESS_DENIED_EXCEPTION.getException(),Arrays.asList(e.getMessage()));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ParameterizedErrorVM processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
    	log.error("-- HttpRequestMethodNotSupportedException --- ");
    	 return new ParameterizedErrorVM(RegisteredException.METHOD_NOT_ALLOWED.getException(),Collections.emptyList());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ParameterizedErrorVM processException(Exception ex) {
    	log.error("----Unknown Exception---");
    	 return new ParameterizedErrorVM(RegisteredException.UNKNOWN_EXCEPTION.getException(),Collections.emptyList());
    }
}
