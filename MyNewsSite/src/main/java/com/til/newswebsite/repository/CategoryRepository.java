package com.til.newswebsite.repository;


import com.til.newswebsite.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String CategoryName);
}
