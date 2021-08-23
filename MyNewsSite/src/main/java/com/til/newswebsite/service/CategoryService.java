package com.til.newswebsite.service;


import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.dto.categoryresponse.CategoryResponseDto;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public CategoryResponseDto addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category = categoryRepository.save(category);
        return new CategoryResponseDto(category.getId(),category.getCategoryName(),category.getDescription());
    }


    public List<CategoryResponseDto> getAllCategory(){
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> {
            categoryResponseDtoList.add(new CategoryResponseDto(category.getId(),
                    category.getCategoryName(),category.getDescription()));
        });

        return categoryResponseDtoList;
    }


    public CategoryResponseDto getCategoryById(Integer id){
        Category category = categoryRepository.findById(id).orElse(null);
        return new CategoryResponseDto(category.getId(),category.getCategoryName(),category.getDescription());
    }


    public List<ArticleListResponseDto> getAllArticlesFromCategory(String categoryName, String limit){
        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

        articleRepository.findAllByCategory(categoryRepository.findByCategoryName(categoryName)).forEach(article -> {

            articleListResponseDtoList.add(new ArticleListResponseDto(
                    article.getArticleId(),article.getTitle(),article.getDescription(),
                    article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                    article.getImageUrl(),article.getCreatedAt()));

        });

        articleListResponseDtoList.sort(Comparator.comparing(ArticleListResponseDto::getCreatedAt).reversed());
        
        int limitInt = Integer.parseInt(limit);
        
        if(limitInt==-1){
            return articleListResponseDtoList;
        }
        else{
            Stream<ArticleListResponseDto> stream = articleListResponseDtoList.stream();
            return stream.limit(limitInt).collect(Collectors.toList());
        }
        

    }
}
