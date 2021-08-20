package com.til.newswebsite.controller;

import com.til.newswebsite.dto.CategoryDto;
import com.til.newswebsite.dto.articleresponse.ArticleListDto;
import com.til.newswebsite.entity.Article;
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
    public Category addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/allCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/allArticles/{categoryId}")
    public List<ArticleListDto> getAllArticlesFromCategory(@PathVariable Integer id){
        return categoryService.getAllArticlesFromCategory(id);
    }
}
