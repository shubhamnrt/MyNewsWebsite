package com.til.newswebsite.controller;

import com.til.newswebsite.dto.ArticleDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/createArticle")
    public Article createArticle(@RequestBody ArticleDto articleDto) {

        return articleService.createArticle(articleDto);
    }

//    @PostMapping("/addArticles")
//    public List<Article> addArticle(@RequestBody List<ArticleDto> articlesDto){
//        return articleService.createArticles(articlesDto);
//    }

    @GetMapping("/allArticles")
    public List<Article> findAllArticles(){
        return articleService.getArticles();
    }

    @GetMapping("/{id}")
    public Article findArticleById(@PathVariable int id){
        return articleService.getArticleById(id);
    }

    @GetMapping("/articleTitle/{title}")
    public Article findArticleByTitle(@PathVariable String title){
        return articleService.getArticleByTitle(title);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
        return articleService.deleteArticle(id);
    }

}

