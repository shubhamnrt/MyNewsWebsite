package com.til.newswebsite.service.impl;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.AuthorResponseDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.exception.InvalidRequestException;
import com.til.newswebsite.repository.AuthorRepository;
import com.til.newswebsite.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

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

    public List<AuthorResponseDto> getAllAuthors(){
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();
        authorRepository.findAll().forEach(author -> {
            authorResponseDtoList.add(new AuthorResponseDto(author.getAuthorId(),author.getFullName()));
        });
        return authorResponseDtoList;
    }

    public Author getAuthorById(Integer id){
        Optional<Author>authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            Author author = authorOptional.get();
            return author;
        }
        else{
            throw new InvalidRequestException("Author don't exist with given id :- " +id);
        }
    }

    public Author getAuthorByName(String authorName){
        return authorRepository.findByFullName(authorName);
    }
}
