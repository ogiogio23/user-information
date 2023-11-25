package com.ogiogio.api.exceptions;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
    private String code;

    public UserNotFoundException(String code, String message){
        super(message);
        this.code = code;
    }
}
