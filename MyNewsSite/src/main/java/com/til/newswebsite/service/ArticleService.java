package com.til.newswebsite.service;

import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.Category;
import com.til.newswebsite.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public Article saveArticle(Article article) {
        Category category = article.getCategory();
        category.addArticle(article);
        return repository.save(article);
    }

    public List<Article> saveArticles(List<Article> articles) {
        articles.forEach(article -> article.getCategory().addArticle(article));
        return repository.saveAll(articles);
    }

    public List<Article> getArticles(){
        return repository.findAll();
    }

    public Article getArticleById(int id){
        return repository.findById(id).orElse(null);
    }

    public Article getArticleByTitle(String title){
        return repository.findByTitle(title);
    }

    public String deleteArticle(int id) {
        //Article article = repository.getById(id);
        repository.deleteById(id);
        return "Article removed !! " + id;
    }


}

