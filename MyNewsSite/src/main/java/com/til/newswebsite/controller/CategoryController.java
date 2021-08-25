package com.til.newswebsite.controller;

import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.CategoryResponseDto;
import com.til.newswebsite.service.impl.BindingResultService;
import com.til.newswebsite.service.impl.CategoryServiceImpl;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.til.newswebsite.dto.CategoryResponseDto;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private BindingResultService bindingResultService;

    @PostMapping("/addCategory")
    public CategoryResponseDto addCategory(@RequestBody @Valid CategoryDto categoryDto, BindingResult bindingResult) {
        bindingResultService.validate(bindingResult);
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


    @GetMapping("/allArticles/{categoryName}")
    public List<ArticleListResponseDto> getAllArticlesFromCategory(@PathVariable String categoryName, @RequestParam String limit){
        return categoryServiceImpl.getAllArticlesFromCategory(categoryName, limit);
    }
}
