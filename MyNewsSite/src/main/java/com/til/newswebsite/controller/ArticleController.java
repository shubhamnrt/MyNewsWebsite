package com.til.newswebsite.controller;

import com.til.newswebsite.dto.ArticleDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.ArticleCreateResponseDto;
import com.til.newswebsite.dto.ArticleResponseDto;
import com.til.newswebsite.dto.ArticleContentUpdateDto;
import com.til.newswebsite.dto.ArticleDescriptionUpdateDto;
import com.til.newswebsite.dto.ArticleImageUrlUpdateDto;
import com.til.newswebsite.dto.ArticleTitleUpdateDto;
import com.til.newswebsite.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    @PostMapping("/createArticle")
    public ArticleCreateResponseDto createArticle(@RequestBody ArticleDto articleDto) {
        return articleServiceImpl.createArticle(articleDto);
    }

    @GetMapping("/allArticles")
    public List<ArticleListResponseDto> findAllArticles(){
        return articleServiceImpl.getArticles();
    }

    @GetMapping("/{articleId}")
    public ArticleResponseDto findArticleById(@PathVariable int articleId){
        return articleServiceImpl.getArticleById(articleId);
    }

    @GetMapping("/articleTitle/{title}")
    public ArticleResponseDto findArticleByTitle(@PathVariable String title){
        return articleServiceImpl.getArticleByTitle(title);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
        return articleServiceImpl.deleteArticle(id);
    }

    @PutMapping("/updateDescription")
    public String updateArticleDescription(ArticleDescriptionUpdateDto articleDescriptionUpdateDto){
        return articleServiceImpl.updateArticleDescription(articleDescriptionUpdateDto);
    }

    @PutMapping("/updateTitle")
    public String updateArticleTitle(ArticleTitleUpdateDto articleTitleUpdateDto){
        return articleServiceImpl.updateArticleTitle(articleTitleUpdateDto);
    }

    @PutMapping("/updateContent")
    public String updateArticleContent(ArticleContentUpdateDto articleContentUpdateDto){
        return articleServiceImpl.updateArticleContent(articleContentUpdateDto);
    }

    @PutMapping("/updateImageUrl")
    public String updateArticleImageUrl(ArticleImageUrlUpdateDto articleImageUrlUpdateDto){
        return articleServiceImpl.updateArticleImageURl(articleImageUrlUpdateDto);
    }

}

