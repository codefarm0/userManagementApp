package com.gl.userManagementApp.expection;

public class MandataoryParamNotPresentException extends RuntimeException{

    public MandataoryParamNotPresentException(String message){
        super(message);
    }
}
