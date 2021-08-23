package com.til.newswebsite.controller;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.til.newswebsite.dto.authorresponse.AuthorResponseDto;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/demo")
    public String welcome() {
        return "Welcome to MyNewsWebsite !!";
    }

    @PostMapping("/signup")
    public Author createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
    }

    @GetMapping("/allAuthors")
    public List<AuthorResponseDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("/{fullName}")
    public Author getAuthorByName(@PathVariable String fullName){
        return authorService.getAuthorByName(fullName);
    }
}
