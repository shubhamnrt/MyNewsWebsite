package com.til.newswebsite.repository;

import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByFullName(String FullName);
}
