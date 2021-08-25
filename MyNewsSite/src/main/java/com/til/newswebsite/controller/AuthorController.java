package com.til.newswebsite.controller;

import com.til.newswebsite.dto.AuthorCreateResponseDto;
import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.AuthorListResponseDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.service.impl.AuthorServiceImpl;
import com.til.newswebsite.service.impl.BindingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.til.newswebsite.dto.AuthorResponseDto;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @Autowired
    private BindingResultService bindingResultService;

    @GetMapping("/demo")
    public String welcome() {
        return "Welcome to MyNewsWebsite !!";
    }

    @PostMapping("/signup")
    public AuthorCreateResponseDto createAuthor(@RequestBody @Valid AuthorDto authorDto, BindingResult bindingResult) {
        bindingResultService.validate(bindingResult);
        return authorServiceImpl.addAuthor(authorDto);
    }

    @GetMapping("/allAuthors")
    public List<AuthorListResponseDto> getAllAuthors(){
        return authorServiceImpl.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getAuthorById(@PathVariable Integer id){
        return authorServiceImpl.getAuthorById(id);
    }

    @GetMapping("/{fullName}")
    public AuthorResponseDto getAuthorByName(@PathVariable String fullName){
        return authorServiceImpl.getAuthorByName(fullName);
    }
}
