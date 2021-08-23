package com.til.newswebsite.exception;

public class AuthorAlreadyExistException extends RuntimeException {
    public AuthorAlreadyExistException(String message){
        super(message);
    }
}
