package com.til.newswebsite.service.impl;

import com.til.newswebsite.dto.AuthorCreateResponseDto;
import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.AuthorListResponseDto;
import com.til.newswebsite.dto.AuthorResponseDto;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.exception.InvalidRequestException;
import com.til.newswebsite.repository.AuthorRepository;
import com.til.newswebsite.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public AuthorCreateResponseDto addAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setEmail(authorDto.getEmail());
        author.setFullName(authorDto.getFullName());
        author.setUserName(authorDto.getUserName());
        author.setPassword(authorDto.getPassword());

        try{
            return new AuthorCreateResponseDto("Author Created",authorRepository.save(author).getAuthorId());
        }
        catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new InvalidRequestException("Author already exist!");
        }
    }

    public List<AuthorListResponseDto> getAllAuthors(){
        List<AuthorListResponseDto> authorListResponseDtoList = new ArrayList<>();
        authorRepository.findAll().forEach(author -> {
            authorListResponseDtoList.add(new AuthorListResponseDto(author.getAuthorId(),author.getFullName()));
        });
        return authorListResponseDtoList;
    }

    public AuthorResponseDto getAuthorById(Integer id){
        Optional<Author>authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            Author author = authorOptional.get();
            return new AuthorResponseDto(author.getAuthorId(),author.getUserName(),author.getFullName(),author.getEmail());
        }
        else{
            throw new InvalidRequestException("Author don't exist with given id :- " +id);
        }
    }

    public AuthorResponseDto getAuthorByName(String authorName){
        Author author = authorRepository.findByFullName(authorName);
        if(author==null){
            throw new InvalidRequestException("Author don't exist with given Name :- "+ authorName);
        }
        else{
            return new AuthorResponseDto(author.getAuthorId(),author.getUserName(),author.getFullName(),author.getEmail());
        }
    }
}
