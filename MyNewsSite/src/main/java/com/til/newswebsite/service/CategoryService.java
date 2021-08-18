package com.til.newswebsite.service;


import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


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


}
