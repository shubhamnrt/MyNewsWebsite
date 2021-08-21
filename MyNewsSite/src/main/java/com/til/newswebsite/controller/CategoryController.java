package com.til.newswebsite.controller;

import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.dto.categoryresponse.CategoryResponseDto;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public CategoryResponseDto addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/allCategory")
    public List<CategoryResponseDto> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/allArticles/{categoryId}")
    public List<ArticleListResponseDto> getAllArticlesFromCategory(@PathVariable Integer categoryId){
        return categoryService.getAllArticlesFromCategory(categoryId);
    }

}
