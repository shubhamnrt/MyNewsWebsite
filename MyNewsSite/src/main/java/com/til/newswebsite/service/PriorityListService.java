package com.til.newswebsite.service;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.PriorityArticles;
import com.til.newswebsite.entity.PriorityList;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.PriorityArticlesRepository;
import com.til.newswebsite.repository.PriorityListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriorityListService {
    @Autowired
    PriorityListRepository priorityListRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PriorityArticlesRepository priorityArticlesRepository;

    public PriorityList addPriorityList(PriorityListDto priorityListDto){
        PriorityList priorityList = new PriorityList();
        priorityList.setDescription(priorityListDto.getDescription());
        priorityList.setName(priorityListDto.getName());
        return priorityListRepository.save(priorityList);
    }

    public PriorityList getPriorityListById(Integer id){
        return priorityListRepository.getById(id);
    }

    public PriorityArticles addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        PriorityArticles priorityArticles = new PriorityArticles();

        priorityArticles.setPriorityList(priorityListRepository.getById(priorityArticlesDto.getPriorityListId()));
        priorityArticles.setArticle(articleRepository.getById(priorityArticlesDto.getArticleId()));

        priorityListRepository.getById(priorityArticlesDto.getPriorityListId()).addPriorityArticles(priorityArticles);
        articleRepository.getById(priorityArticlesDto.getArticleId()).addPriorityArticles(priorityArticles);
        return priorityArticles;
    }

    public List<PriorityList> getAllPriorityLists(){
        return priorityListRepository.findAll();
    }

    public List<Article> getAllArticles(Integer id){

        // title, description, imageUrl, CategoryId, AuthorId, PriorityArticleId
        List<Article> articleList = new ArrayList<>();

        priorityListRepository.getById(id).getPriorityArticlesList().
                forEach(priorityArticles -> articleList.add(priorityArticles.getArticle()));
        return articleList;
    }

//    public String deleteArticleFromPriorityList(Integer PLid, Integer Aid){
//
//        priorityArticlesRepository.deletePriorityArticlesByArticleArticleIdAndPriorityListPriorityListId(Aid,PLid);
//        return "Deleted Successfully!";
//    }
}
