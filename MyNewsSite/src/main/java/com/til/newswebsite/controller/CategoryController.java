package com.til.newswebsite.controller;

import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.CategoryResponseDto;
import com.til.newswebsite.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping("/addCategory")
    public CategoryResponseDto addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryServiceImpl.addCategory(categoryDto);
    }

    @GetMapping("/allCategory")
    public List<CategoryResponseDto> getAllCategory(){
        return categoryServiceImpl.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Integer id){
        return categoryServiceImpl.getCategoryById(id);
    }

    @GetMapping("/allArticles/{categoryId}")
    public List<ArticleListResponseDto> getAllArticlesFromCategory(@PathVariable Integer categoryId){
        return categoryServiceImpl.getAllArticlesFromCategory(categoryId);
    }

}
