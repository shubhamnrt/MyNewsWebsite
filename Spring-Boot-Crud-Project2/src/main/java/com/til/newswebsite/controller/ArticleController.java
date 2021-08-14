package com.til.newswebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.til.newswebsite.entity.Article;
import com.til.newswebsite.service.ArticleService;


@RestController
public class ArticleController {

	@Autowired
	private ArticleService service;
	
	@PostMapping("/addArticle")
	public Article addArticle(@RequestBody Article article) {
		return service.saveArticle(article);
	}
	
	@PostMapping("/addArticles")
	public List<Article> addArticle(@RequestBody List<Article> articles){
		return service.saveArticles(articles);
	}
	
	@GetMapping("/articles")
	public List<Article> findAllArticles(){
		return service.getArticles();
	}
	
	@GetMapping("/article/{id}")
	public Article findArticleById(@PathVariable int id){
		return service.getArticleById(id);
	}
	
	@GetMapping("/article/{name}")
	public Article findArticleByName(@PathVariable String name){
		return service.getArticleByName(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteArticle(@PathVariable int id) {
		return service.deleteArticle(id);
	}
	
}
