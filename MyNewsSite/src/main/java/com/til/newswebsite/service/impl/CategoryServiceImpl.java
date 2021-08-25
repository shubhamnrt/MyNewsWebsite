package com.til.newswebsite.service.impl;


import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.CategoryResponseDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.exception.InvalidRequestException;
import com.til.newswebsite.exception.NotFoundException;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.CategoryRepository;
import com.til.newswebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;


    public CategoryResponseDto addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        try{
            category = categoryRepository.save(category);
            return new CategoryResponseDto(category.getId(),category.getCategoryName(),category.getDescription());
        }
        catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new InvalidRequestException("Category already exist with given name");
        }

    }


    public List<CategoryResponseDto> getAllCategory(){
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> {
            categoryResponseDtoList.add(new CategoryResponseDto(category.getId(),
                    category.getCategoryName(),category.getDescription()));
        });

        return categoryResponseDtoList;
    }


    public CategoryResponseDto getCategoryById(Integer id)
    {
        Optional<Category> categoryOptional=categoryRepository.findById(id);

        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            return new CategoryResponseDto(category.getId(),category.getCategoryName(),category.getDescription());
        }
        else{
            throw new NotFoundException("Category don't exist with given id :- "+ id);
        }

    }

    public List<ArticleListResponseDto> getAllArticlesFromCategory(String categoryName,String limit){
        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();
        Category category = categoryRepository.findByCategoryName(categoryName);
        if(category ==null){
            throw new NotFoundException("Category Not found with given :- " + categoryName);
        }

        articleRepository.findAllByCategory(category).forEach(article -> {

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
