package com.til.newswebsite.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.til.newswebsite.entity.Article;


public interface ArticleRepository extends JpaRepository<Article,Integer> {
	
	Article findByName(String Name);

}
