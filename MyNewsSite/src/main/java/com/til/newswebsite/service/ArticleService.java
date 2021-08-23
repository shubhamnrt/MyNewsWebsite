package com.til.newswebsite.service;

import com.til.newswebsite.dto.*;

import java.util.List;

public interface ArticleService {
    public ArticleCreateResponseDto createArticle(ArticleDto articleDto);
    public List<ArticleListResponseDto> getArticles(String limit);
    public ArticleResponseDto getArticleById(int id);
    public ArticleResponseDto getArticleByTitle(String title);
    public String deleteArticle(int id);
    public String updateArticleDescription(ArticleDescriptionUpdateDto articleDescriptionUpdateDto);
    public String updateArticleTitle(ArticleTitleUpdateDto articleTitleUpdateDto);
    public String updateArticleContent(ArticleContentUpdateDto articleContentUpdateDto);
    public String updateArticleImageURl(ArticleImageUrlUpdateDto articleImageUrlUpdateDto);
}