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
import com.til.newswebsite.service.impl.BindingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    @Autowired
    private BindingResultService bindingResultService;

    @PostMapping("/createArticle")
    public ArticleCreateResponseDto createArticle(@RequestBody @Valid ArticleDto articleDto, BindingResult bindingResult) {
        bindingResultService.validate(bindingResult);
        return articleServiceImpl.createArticle(articleDto);
    }

    @GetMapping("/allArticles")
    public List<ArticleListResponseDto> findAllArticles(@RequestParam String limit){
        return articleServiceImpl.getArticles(limit);
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
    public String updateArticleDescription(@RequestBody @Valid ArticleDescriptionUpdateDto articleDescriptionUpdateDto, BindingResult bindingResult){
        bindingResultService.validate(bindingResult);
        return articleServiceImpl.updateArticleDescription(articleDescriptionUpdateDto);
    }

    @PutMapping("/updateTitle")
    public String updateArticleTitle(@RequestBody @Valid ArticleTitleUpdateDto articleTitleUpdateDto,BindingResult bindingResult){
        bindingResultService.validate(bindingResult);
        return articleServiceImpl.updateArticleTitle(articleTitleUpdateDto);
    }

    @PutMapping("/updateContent")
    public String updateArticleContent(@RequestBody @Valid ArticleContentUpdateDto articleContentUpdateDto,BindingResult bindingResult){
        bindingResultService.validate(bindingResult);
        return articleServiceImpl.updateArticleContent(articleContentUpdateDto);
    }

    @PutMapping("/updateImageUrl")
    public String updateArticleImageUrl(@RequestBody @Valid ArticleImageUrlUpdateDto articleImageUrlUpdateDto, BindingResult bindingResult){
        bindingResultService.validate(bindingResult);
        return articleServiceImpl.updateArticleImageURl(articleImageUrlUpdateDto);
    }

}

