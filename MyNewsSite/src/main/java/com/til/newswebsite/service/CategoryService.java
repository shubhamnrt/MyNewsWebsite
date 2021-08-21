package com.til.newswebsite.service;


import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public Category addCategory(CategoryDto categoryDto){
        Category category = new Category();

        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);
    }


    public List<Category> getAllCategory(){
        return  categoryRepository.findAll();
    }


    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    public List<ArticleListResponseDto> getAllArticlesFromCategory(Integer categoryId){
        List<ArticleListResponseDto> articleListDtoListResponse = new ArrayList<>();

        articleRepository.findAllByCategory(categoryRepository.getById(categoryId)).forEach(article -> {
            ArticleListResponseDto articleListResponseDto = new ArticleListResponseDto();

            articleListResponseDto.setArticleId(article.getArticleId());
            articleListResponseDto.setTitle(article.getTitle());
            articleListResponseDto.setDescription(article.getDescription());
            articleListResponseDto.setImageUrl(article.getImageUrl());
            articleListResponseDto.setCreatedAt(article.getCreatedAt());
            articleListResponseDto.setCategoryName(article.getCategory().getCategoryName());
            articleListResponseDto.setAuthorName(article.getAuthor().getFullName());

            articleListDtoListResponse.add(articleListResponseDto);
        });

        return articleListDtoListResponse;
    }

}
