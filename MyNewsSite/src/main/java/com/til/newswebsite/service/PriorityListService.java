package com.til.newswebsite.service;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.PriorityArticles;
import com.til.newswebsite.entity.PriorityList;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.PriorityArticlesRepository;
import com.til.newswebsite.repository.PriorityListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Integer id = Integer.valueOf(String.valueOf(priorityArticlesDto.getPriorityListId())
                + String.valueOf(priorityArticlesDto.getArticleId()));
        priorityArticles.setPriorityArticlesId(id);
        priorityArticles.setPriorityList(priorityListRepository.getById(priorityArticlesDto.getPriorityListId()));
        priorityArticles.setArticle(articleRepository.getById(priorityArticlesDto.getArticleId()));

        priorityListRepository.getById(priorityArticlesDto.getPriorityListId()).addPriorityArticles(priorityArticles);
        articleRepository.getById(priorityArticlesDto.getArticleId()).addPriorityArticles(priorityArticles);

        return priorityArticles;
    }

    public List<PriorityList> getAllPriorityLists(){
        return priorityListRepository.findAll();
    }

    public List<ArticleListResponseDto> getAllArticles(Integer priorityListId){

        // title, description, imageUrl, CategoryId, AuthorId, PriorityArticleId
        List<ArticleListResponseDto> articleListDtoListResponse = new ArrayList<>();

        priorityArticlesRepository.findAllByPriorityList(priorityListRepository.getById(priorityListId)).
                forEach(priorityArticles -> {
                    ArticleListResponseDto articleListResponseDto = new ArticleListResponseDto();
                    Article article = articleRepository.getById(priorityArticles.getArticle().getArticleId());
                    articleListResponseDto.setTitle(article.getTitle());
                    articleListResponseDto.setDescription(article.getDescription());
                    articleListResponseDto.setAuthorName(article.getAuthor().getFullName());
                    articleListResponseDto.setImageUrl(article.getImageUrl());
                    articleListResponseDto.setCreatedAt(article.getCreatedAt());
                    articleListResponseDto.setCategoryName(article.getCategory().getCategoryName());

                    articleListDtoListResponse.add(articleListResponseDto);
                });

//
//        priorityListRepository.getById(id).getPriorityArticlesList().
//                forEach(priorityArticles -> articleList.add(priorityArticles.getArticle()));
        return articleListDtoListResponse;
    }

    public String deleteArticleFromPriorityList(Integer PLid, Integer Aid){

        Integer id = Integer.valueOf(String.valueOf(PLid) + String.valueOf(Aid));
        priorityArticlesRepository.deleteById(id);
        return "Deleted Successfully!";
    }
}
