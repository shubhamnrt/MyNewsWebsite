package com.til.newswebsite.controller;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/signup")
    public Author createAuthor(AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
    }

    @GetMapping("/allAuthors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("/{fullName")
    public Author getAuthorByName(@PathVariable String fullName){
        return authorService.getAuthorByName(fullName);
    }
}