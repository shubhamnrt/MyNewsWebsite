package com.til.newswebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.til.newswebsite.entity.Article;
import com.til.newswebsite.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	public Article saveArticle(Article Article) {
		return repository.save(Article);
	}
	
	public List<Article> saveArticles(List<Article> Articles) {
		return repository.saveAll(Articles);
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
		repository.deleteById(id);
		return "Article removed !! " + id;
	}
	
	
}
