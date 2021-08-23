package com.til.newswebsite.service;

import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.AuthorResponseDto;
import com.til.newswebsite.entity.Author;

import java.util.List;

public interface AuthorService {
    public Author addAuthor(AuthorDto authorDto);
    public List<AuthorResponseDto> getAllAuthors();
    public Author getAuthorById(Integer id);
    public Author getAuthorByName(String authorName);
}
