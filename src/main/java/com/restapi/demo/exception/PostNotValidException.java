package com.restapi.demo.exception;

public class PostNotValidException extends  RuntimeException{

    public PostNotValidException(String message) {
        super(message);
    }
}
