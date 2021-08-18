package com.til.newswebsite.service;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author addAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setEmail(authorDto.getEmail());
        author.setFullName(authorDto.getFullName());
        author.setUserName(authorDto.getUserName());
        author.setPassword(authorDto.getPassword());
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Integer id){
        return authorRepository.getById(id);
    }

    public Author getAuthorByName(String fullName){
        return authorRepository.findByFullName(fullName);
    }
}
