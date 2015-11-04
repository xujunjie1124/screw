package com.wj2304.screw.exception;

public class ScrewException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ScrewException() {
        super();
    }
    
    public ScrewException(String message) {
        super(message);
    }
}
