package com.til.newswebsite.service;

import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    public CategoryResponseDto addCategory(CategoryDto categoryDto);
    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto getCategoryById(Integer id);
    public List<ArticleListResponseDto> getAllArticlesFromCategory(Integer categoryId);
}
