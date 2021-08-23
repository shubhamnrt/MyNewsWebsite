package com.til.newswebsite.repository;

import com.til.newswebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.til.newswebsite.entity.Article;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article,Integer> {

    Article findByTitle(String Title);
    List<Article> findAllByCategory(Category category);

}
