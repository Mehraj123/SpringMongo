package com.demo.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom, parameterized exception, which can be translated on the client side. 
 * 
 * @author Mehraj Malik
 *
 */
public class CustomParameterizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final boolean success;
    private final String message;
    private final List<String> paramList = new ArrayList<>();
    
    
    

    public CustomParameterizedException(String message, String... params) {
        super(message);
        this.message = message;
        this.success=false;
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                paramList.add(params[i]);
            }
        }
    }

    public CustomParameterizedException(String message,  List<String>  paramList) {
        super(message);
        this.success=false;
        this.message = message;
        this.paramList.addAll(paramList);
    }

    public ParameterizedErrorVM getParameterizedErrorVM() {
        return new ParameterizedErrorVM(message, paramList);
    }
}
