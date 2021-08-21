package com.til.newswebsite.service;

import com.til.newswebsite.dto.ArticleDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.dto.articleresponse.ArticleCreateResponseDto;
import com.til.newswebsite.dto.articleresponse.ArticleResponseDto;
import com.til.newswebsite.dto.articleupdate.ContentDto;
import com.til.newswebsite.dto.articleupdate.DescriptionDto;
import com.til.newswebsite.dto.articleupdate.ImageUrlDto;
import com.til.newswebsite.dto.articleupdate.TitleDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.AuthorRepository;
import com.til.newswebsite.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public ArticleCreateResponseDto createArticle(ArticleDto articleDto) {

        Article article = new Article();
        ArticleCreateResponseDto articleCreateResponseDto = new ArticleCreateResponseDto();

        article.setCategory(categoryRepository.getById(articleDto.getCategoryId()));
        article.setAuthor(authorRepository.getById(articleDto.getAuthorId()));
        article.setContent(articleDto.getContent());
        article.setDescription(articleDto.getDescription());
        article.setImageUrl(articleDto.getImageUrl());
        article.setTitle(articleDto.getTitle());
        //categoryRepository.getById(articleDto.getCategoryId()).addArticle(article);

        return new ArticleCreateResponseDto("success",articleRepository.save(article).getArticleId());
    }


    public List<ArticleListResponseDto> getArticles(){
        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

         articleRepository.findAll().forEach(article -> {

             articleListResponseDtoList.add(new ArticleListResponseDto(
                     article.getArticleId(),article.getTitle(),article.getDescription(),
                     article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                     article.getImageUrl(),article.getCreatedAt()));
         });
         return articleListResponseDtoList;
    }


    public ArticleResponseDto getArticleById(int id){

        Article article = articleRepository.findById(id).orElse(null);

        return new ArticleResponseDto(
                article.getArticleId(),article.getTitle(),article.getDescription(),article.getContent(),
                article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                article.getImageUrl(),article.getCreatedAt());
    }


    public ArticleResponseDto getArticleByTitle(String title){

        Article article = articleRepository.findByTitle(title);

        return new ArticleResponseDto(article.getArticleId(),article.getTitle(),
                article.getDescription(),article.getContent(),
                article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                article.getImageUrl(),article.getCreatedAt());
    }


    public String deleteArticle(int id) {
        articleRepository.deleteById(id);
        return "Article removed !! " + id;
    }


    public String updateArticleDescription(DescriptionDto descriptionDto){
        Article article = articleRepository.getById(descriptionDto.getArticleId());
        article.setDescription(descriptionDto.getDescription());
        articleRepository.save(article);
        return "Updated Description!";
    }


    public String updateArticleTitle(TitleDto titleDto){
        Article article = articleRepository.getById(titleDto.getArticleId());
        article.setTitle(titleDto.getTitle());
        articleRepository.save(article);
        return "Updated Title";
    }


    public String updateArticleContent(ContentDto contentDto){
        Article article = articleRepository.getById(contentDto.getArticleId());
        article.setContent(contentDto.getContent());
        articleRepository.save(article);
        return "Updated Content";
    }


    public String updateArticleImageURl(ImageUrlDto imageUrlDto){
        Article article = articleRepository.getById(imageUrlDto.getArticleId());
        article.setImageUrl(imageUrlDto.getImageUrl());
        articleRepository.save(article);
        return "Updated ImageUrl";
    }

}

