package com.til.newswebsite.service.impl;

import com.til.newswebsite.exception.InvalidRequestBodyException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class BindingResultService {

    public void validate(BindingResult bindingResult){
        List<String> errorMessages = new ArrayList<>();

        if (bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(objectError -> errorMessages.add(objectError.getDefaultMessage()));
            throw new InvalidRequestBodyException(errorMessages.toString());
        }

    }

//    public void validate2(BindingResult bindingResult){
//        List<String> errorMessages = new ArrayList<>();
//        bindingResult.getAllErrors().forEach( objectError -> errorMessages.add(objectError.getDefaultMessage()) );
//        throw new RuntimeException(errorMessages.toString());
//    }

}
