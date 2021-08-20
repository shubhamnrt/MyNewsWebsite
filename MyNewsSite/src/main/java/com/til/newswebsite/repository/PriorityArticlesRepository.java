package com.til.newswebsite.repository;

import com.til.newswebsite.entity.PriorityArticles;
import com.til.newswebsite.entity.PriorityList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriorityArticlesRepository extends JpaRepository<PriorityArticles,Integer> {
    public List<PriorityArticles> findAllByPriorityList(PriorityList priorityList);
}
