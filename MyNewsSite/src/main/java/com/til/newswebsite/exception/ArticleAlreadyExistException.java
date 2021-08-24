package com.til.newswebsite.exception;


public class ArticleAlreadyExistException extends RuntimeException{
    public ArticleAlreadyExistException(String message){
        super(message);
    }
}
