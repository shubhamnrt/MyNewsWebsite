package com.til.newswebsite.service;

import com.til.newswebsite.dto.ArticleDto;
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

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Article createArticle(ArticleDto articleDto) {

        Article article = new Article();

        article.setCategory(categoryRepository.getById(articleDto.getCategoryId()));

        article.setAuthor(authorRepository.getById(articleDto.getAuthorId()));
        article.setContent(articleDto.getContent());
        article.setDescription(articleDto.getDescription());
        article.setImageUrl(articleDto.getImageUrl());
        article.setTitle(articleDto.getTitle());
        categoryRepository.getById(articleDto.getCategoryId()).addArticle(article);
        return articleRepository.save(article);
    }
//
//    public List<Article> createArticles(List<ArticleDto> articlesDto)
//    {
//        List<Article> articles = new ArrayList<>();
//        articlesDto.forEach((articleDto) -> {
//            Article article = new Article();
//
//            article.setCategory(categoryRepository.getById(articleDto.getCategoryId()));
//            article.setAuthor(authorRepository.getById(articleDto.getAuthorId()));
//            article.setContent(articleDto.getContent());
//            article.setDescription(articleDto.getDescription());
//            article.setImageUrl(articleDto.getImageUrl());
//            article.setTitle(articleDto.getTitle());
//            articles.add(article);
//        });
//
//        return articleRepository.saveAll(articles);
//    }

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    public Article getArticleById(int id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article getArticleByTitle(String title){
        return articleRepository.findByTitle(title);
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

