package com.til.newswebsite.controller;

import com.til.newswebsite.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionHandlerController {

<<<<<<< HEAD
    @ExceptionHandler(value ={InvalidRequestBodyException.class, AuthorAlreadyExistException.class,
            NotFoundException.class, UnauthorizedException.class, InvalidRequestException.class,ArticleAlreadyExistException.class})
=======
    @ExceptionHandler(value ={InvalidRequestBodyException.class, AuthorAlreadyExistException.class, 
        ArticleAlreadyExistException.class,
            NotFoundException.class, UnauthorizedException.class, InvalidRequestException.class})
>>>>>>> 22bbefa1821f939cd69ea7611e56e10ed75bf1a1
    public ResponseEntity<HashMap<String,String>> runTimeExceptionHandler(RuntimeException runtimeException){

        return ResponseEntity.badRequest().body(new HashMap<String, String>(){{put("message",runtimeException.getMessage());}});
    }
}
