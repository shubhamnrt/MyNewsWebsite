package com.til.newswebsite.controller;

import com.til.newswebsite.dto.AuthorDto;
<<<<<<< HEAD
import com.til.newswebsite.dto.AuthorResponseDto;
=======
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.service.impl.AuthorServiceImpl;
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
    AuthorServiceImpl authorServiceImpl;

    @GetMapping("/demo")
    public String welcome() {
        return "Welcome to MyNewsWebsite !!";
    }

    @PostMapping("/signup")
<<<<<<< HEAD
    public Author createAuthor(AuthorDto authorDto){
        return authorServiceImpl.addAuthor(authorDto);
=======
    public Author createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
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
