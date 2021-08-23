package com.til.newswebsite.exception;

public class InvalidRequestBodyException extends RuntimeException{
    public InvalidRequestBodyException(String message){
        super(message);
    }
}
