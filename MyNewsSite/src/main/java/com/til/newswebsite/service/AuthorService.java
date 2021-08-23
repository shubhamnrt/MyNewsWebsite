package com.til.newswebsite.service;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.authorresponse.AuthorResponseDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<AuthorResponseDto> getAllAuthors(){
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();
        authorRepository.findAll().forEach(author -> {
            authorResponseDtoList.add(new AuthorResponseDto(author.getAuthorId(),author.getFullName()));
        });
        return authorResponseDtoList;
    }

    public Author getAuthorById(Integer id){
        return authorRepository.getById(id);
    }

    public Author getAuthorByName(String fullName){
        return authorRepository.findByFullName(fullName);
    }
}
