package com.til.newswebsite.controller;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.AuthorResponseDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @GetMapping("/demo")
    public String welcome() {
        return "Welcome to MyNewsWebsite !!";
    }

    @PostMapping("/signup")
    public Author createAuthor(AuthorDto authorDto){
        return authorServiceImpl.addAuthor(authorDto);
    }

    @GetMapping("/allAuthors")
    public List<AuthorResponseDto> getAllAuthors(){
        return authorServiceImpl.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id){
        return authorServiceImpl.getAuthorById(id);
    }

    @GetMapping("/{fullName}")
    public Author getAuthorByName(@PathVariable String fullName){
        return authorServiceImpl.getAuthorByName(fullName);
    }
}
