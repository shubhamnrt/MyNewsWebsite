package com.til.newswebsite.controller;

import com.til.newswebsite.dto.CategoryDto;
<<<<<<< HEAD
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.CategoryResponseDto;
import com.til.newswebsite.service.impl.CategoryServiceImpl;
=======
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.service.CategoryService;
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.til.newswebsite.dto.categoryresponse.CategoryResponseDto;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
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

<<<<<<< HEAD
    @GetMapping("/allArticles/{categoryId}")
    public List<ArticleListResponseDto> getAllArticlesFromCategory(@PathVariable Integer categoryId){
        return categoryServiceImpl.getAllArticlesFromCategory(categoryId);
    }
=======
    // @GetMapping("/allArticles/{categoryId}")
    // public List<ArticleListResponseDto> getAllArticlesFromCategory(@PathVariable Integer categoryId){
    //     return categoryService.getAllArticlesFromCategory(categoryId);
    // }
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde

    @GetMapping("/allArticles/{categoryName}")
    public List<ArticleListResponseDto> getAllArticlesFromCategory(@PathVariable String categoryName, @RequestParam String limit){
        return categoryService.getAllArticlesFromCategory(categoryName, limit);
    }
}
