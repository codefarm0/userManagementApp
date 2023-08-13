package com.gl.userManagementApp.expection;

public class ResourceAlreadyExistsIntheSystem extends RuntimeException{

    public ResourceAlreadyExistsIntheSystem(String message){
        super(message);
    }
}
