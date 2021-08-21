package com.til.newswebsite.service;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.PListResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.PListsResponseDto;
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

    public PListResponseDto addPriorityList(PriorityListDto priorityListDto){
        PriorityList priorityList = new PriorityList();
        priorityList.setDescription(priorityListDto.getDescription());
        priorityList.setName(priorityListDto.getName());

        return new PListResponseDto("success",priorityListRepository.save(priorityList).getPriorityListId());
    }


    public PriorityArticles addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        PriorityArticles priorityArticles = new PriorityArticles();

        String id = String.valueOf(priorityArticlesDto.getPriorityListId()) + "_" +
                String.valueOf(priorityArticlesDto.getArticleId());
        priorityArticles.setPriorityArticlesId(id);
        priorityArticles.setPriorityList(priorityListRepository.getById(priorityArticlesDto.getPriorityListId()));
        priorityArticles.setArticle(articleRepository.getById(priorityArticlesDto.getArticleId()));
        priorityArticlesRepository.save(priorityArticles);

        return priorityArticles;
    }


    public List<PListsResponseDto> getAllPriorityLists()
    {
        List<PListsResponseDto> pListsResponseDto = new ArrayList<>();
        priorityListRepository.findAll().forEach(priorityList -> {
            pListsResponseDto.add(new PListsResponseDto(priorityList.getPriorityListId(),priorityList.getName()));
        });
        return pListsResponseDto;
    }


    public List<ArticleListResponseDto> getAllArticles(Integer priorityListId){

        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

        priorityArticlesRepository.findAllByPriorityList(priorityListRepository.getById(priorityListId)).
                forEach(priorityArticles -> {
                    Article article = articleRepository.getById(priorityArticles.getArticle().getArticleId());

                    articleListResponseDtoList.add(new ArticleListResponseDto(
                            article.getArticleId(),article.getTitle(),article.getDescription(),
                            article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                            article.getImageUrl(),article.getCreatedAt()));
                });

        return articleListResponseDtoList;
    }


    public String deleteArticleFromPriorityList(String id){
        priorityArticlesRepository.deleteById(id);
        return "Deleted Successfully!";
    }
}
