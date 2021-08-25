package com.til.newswebsite.service;

import com.til.newswebsite.dto.AuthorCreateResponseDto;
import com.til.newswebsite.dto.AuthorDto;
import com.til.newswebsite.dto.AuthorListResponseDto;
import com.til.newswebsite.dto.AuthorResponseDto;
import com.til.newswebsite.entity.Author;

import java.util.List;

public interface AuthorService {
    public AuthorCreateResponseDto addAuthor(AuthorDto authorDto);
    public List<AuthorListResponseDto> getAllAuthors();
    public AuthorResponseDto getAuthorById(Integer id);
    public AuthorResponseDto getAuthorByName(String authorName);
}
