package com.til.newswebsite.service.impl;

import com.til.newswebsite.dto.*;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.Author;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.exception.ArticleAlreadyExistException;
import com.til.newswebsite.exception.InvalidRequestException;
import com.til.newswebsite.exception.NotFoundException;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.AuthorRepository;
import com.til.newswebsite.repository.CategoryRepository;
import com.til.newswebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        Optional<Category> categoryOptional=categoryRepository.findById(articleDto.getCategoryId());
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            article.setCategory(category);
        }
        else{
            throw new InvalidRequestException("Category don't exist with given id :- "+ articleDto.getCategoryId());
        }

        Optional<Author> authorOptional = authorRepository.findById(articleDto.getAuthorId());
        if(authorOptional.isPresent()){
            Author author = authorOptional.get();
            article.setAuthor(author);
        }
        else{
            throw new InvalidRequestException("Author don't exist with given id :- "+articleDto.getAuthorId());
        }

        article.setContent(articleDto.getContent());
        article.setDescription(articleDto.getDescription());
        article.setImageUrl(articleDto.getImageUrl());
        article.setTitle(articleDto.getTitle());

        try
        {
            return new ArticleCreateResponseDto("success",articleRepository.save(article).getArticleId());
        }
        catch (DataIntegrityViolationException dataIntegrityViolationException)
        {
            throw new ArticleAlreadyExistException("Article Already Exist with given Title :- " + articleDto.getTitle());
        }
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

        Optional<Article > articleOptional=articleRepository.findById(id);

        if(articleOptional.isPresent()){
            Article article = articleOptional.get();
            return new ArticleResponseDto(
                    article.getArticleId(),article.getTitle(),article.getDescription(),article.getContent(),
                    article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                    article.getImageUrl(),article.getCreatedAt());
        }
        else{
            throw new NotFoundException("Article don't exist with given Id :- " + id);
        }
    }


    public ArticleResponseDto getArticleByTitle(String title){

        Article article = articleRepository.findByTitle(title);
        if(article==null) throw new NotFoundException("Article don't exist with given Title :- " + title);

        return new ArticleResponseDto(article.getArticleId(),article.getTitle(),
                article.getDescription(),article.getContent(),
                article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                article.getImageUrl(),article.getCreatedAt());
    }


    public String deleteArticle(int id) {
        try{
            articleRepository.deleteById(id);
            return "Article removed !! " + id;
        }
        catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new InvalidRequestException("Article is not found with given id :- " + id);
        }

    }


    public String updateArticleDescription(ArticleDescriptionUpdateDto articleDescriptionUpdateDto){

        Optional<Article > articleOptional=articleRepository.findById(articleDescriptionUpdateDto.getArticleId());
        if(articleOptional.isPresent()){
            Article article = articleOptional.get();
            article.setDescription(articleDescriptionUpdateDto.getDescription());
            articleRepository.save(article);
            return "Updated Description!";
        }
        else{
            throw new InvalidRequestException("Article is not found with given Id :- " + articleDescriptionUpdateDto.getArticleId());
        }
    }


    public String updateArticleTitle(ArticleTitleUpdateDto articleTitleUpdateDto){

        Optional<Article > articleOptional=articleRepository.findById(articleTitleUpdateDto.getArticleId());
        if(articleOptional.isPresent()){
            Article article = articleOptional.get();
            article.setTitle(articleTitleUpdateDto.getTitle());
            articleRepository.save(article);
            return "Updated Title!";
        }
        else{
            throw new InvalidRequestException("Article is not found with given Id :- " + articleTitleUpdateDto.getArticleId());
        }
    }


    public String updateArticleContent(ArticleContentUpdateDto articleContentUpdateDto){

        Optional<Article > articleOptional=articleRepository.findById(articleContentUpdateDto.getArticleId());
        if(articleOptional.isPresent()){
            Article article = articleOptional.get();
            article.setTitle(articleContentUpdateDto.getContent());
            articleRepository.save(article);
            return "Updated Content!";
        }
        else{
            throw new InvalidRequestException("Article is not found with given Id :- " + articleContentUpdateDto.getArticleId());
        }
    }


    public String updateArticleImageURl(ArticleImageUrlUpdateDto articleImageUrlUpdateDto){

        Optional<Article > articleOptional=articleRepository.findById(articleImageUrlUpdateDto.getArticleId());

        if(articleOptional.isPresent()){
            Article article = articleOptional.get();
            article.setImageUrl(articleImageUrlUpdateDto.getImageUrl());
            articleRepository.save(article);
            return "Updated Image Url!";
        }
        else{
            throw new InvalidRequestException("Article is not found with given Id :- " + articleImageUrlUpdateDto.getArticleId());
        }
    }

}

