package com.til.newswebsite.service.impl;

import com.til.newswebsite.dto.ArticleDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.ArticleCreateResponseDto;
import com.til.newswebsite.dto.ArticleResponseDto;
import com.til.newswebsite.dto.ArticleContentUpdateDto;
import com.til.newswebsite.dto.ArticleDescriptionUpdateDto;
import com.til.newswebsite.dto.ArticleImageUrlUpdateDto;
import com.til.newswebsite.dto.ArticleTitleUpdateDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.AuthorRepository;
import com.til.newswebsite.repository.CategoryRepository;
import com.til.newswebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public ArticleCreateResponseDto createArticle(ArticleDto articleDto) {

        Article article = new Article();

        article.setCategory(categoryRepository.getById(articleDto.getCategoryId()));
        article.setAuthor(authorRepository.getById(articleDto.getAuthorId()));
        article.setContent(articleDto.getContent());
        article.setDescription(articleDto.getDescription());
        article.setImageUrl(articleDto.getImageUrl());
        article.setTitle(articleDto.getTitle());
        //categoryRepository.getById(articleDto.getCategoryId()).addArticle(article);

        return new ArticleCreateResponseDto("success",articleRepository.save(article).getArticleId());
    }


    public List<ArticleListResponseDto> getArticles(String limit){
        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

        articleRepository.findAll().forEach(article -> {

            articleListResponseDtoList.add(new ArticleListResponseDto(
                    article.getArticleId(),article.getTitle(),article.getDescription(),
                    article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                    article.getImageUrl(),article.getCreatedAt()));
        });

         
        articleListResponseDtoList.sort(Comparator.comparing(ArticleListResponseDto::getCreatedAt).reversed());
        
        int limitInt = Integer.parseInt(limit);
        
        if(limitInt==-1){
            return articleListResponseDtoList;
        }
        else{
            Stream<ArticleListResponseDto> stream = articleListResponseDtoList.stream();
            return stream.limit(limitInt).collect(Collectors.toList());
        }
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


    public String updateArticleDescription(ArticleDescriptionUpdateDto articleDescriptionUpdateDto){
        Article article = articleRepository.getById(articleDescriptionUpdateDto.getArticleId());
        article.setDescription(articleDescriptionUpdateDto.getDescription());
        articleRepository.save(article);
        return "Updated Description!";
    }


    public String updateArticleTitle(ArticleTitleUpdateDto articleTitleUpdateDto){
        Article article = articleRepository.getById(articleTitleUpdateDto.getArticleId());
        article.setTitle(articleTitleUpdateDto.getTitle());
        articleRepository.save(article);
        return "Updated Title";
    }


    public String updateArticleContent(ArticleContentUpdateDto articleContentUpdateDto){
        Article article = articleRepository.getById(articleContentUpdateDto.getArticleId());
        article.setContent(articleContentUpdateDto.getContent());
        articleRepository.save(article);
        return "Updated Content";
    }


    public String updateArticleImageURl(ArticleImageUrlUpdateDto articleImageUrlUpdateDto){
        Article article = articleRepository.getById(articleImageUrlUpdateDto.getArticleId());
        article.setImageUrl(articleImageUrlUpdateDto.getImageUrl());
        articleRepository.save(article);
        return "Updated ImageUrl";
    }

}

