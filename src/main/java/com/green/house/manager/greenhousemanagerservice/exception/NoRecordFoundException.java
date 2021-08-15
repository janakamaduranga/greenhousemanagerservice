package com.green.house.manager.greenhousemanagerservice.exception;

public class NoRecordFoundException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "No record found";
    public NoRecordFoundException(){
        super(DEFAULT_MESSAGE);
    }
}
