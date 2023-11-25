package com.ren0five.springbootblogrestapi.exceptions;

public class NoBlogDataFoundException extends RuntimeException {
    public NoBlogDataFoundException(String str){
        super(str);
    }
}
