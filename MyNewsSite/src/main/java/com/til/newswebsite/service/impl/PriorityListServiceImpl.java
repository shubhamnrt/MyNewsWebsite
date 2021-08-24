package com.til.newswebsite.service.impl;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.AddArticleResponseDto;
import com.til.newswebsite.dto.PListResponseDto;
import com.til.newswebsite.dto.PListsResponseDto;
import com.til.newswebsite.entity.Article;
import com.til.newswebsite.entity.PriorityArticles;
import com.til.newswebsite.entity.PriorityList;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.PriorityArticlesRepository;
import com.til.newswebsite.repository.PriorityListRepository;
import com.til.newswebsite.service.PriorityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

@Service
public class PriorityListServiceImpl implements PriorityListService {
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


    public AddArticleResponseDto addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        PriorityArticles priorityArticles = new PriorityArticles();

        String id = String.valueOf(priorityArticlesDto.getPriorityListId()) + "_" +
                String.valueOf(priorityArticlesDto.getArticleId());
        priorityArticles.setPriorityArticlesId(id);
        priorityArticles.setPriorityList(priorityListRepository.getById(priorityArticlesDto.getPriorityListId()));
        priorityArticles.setArticle(articleRepository.getById(priorityArticlesDto.getArticleId()));
        priorityArticlesRepository.save(priorityArticles);
        return new AddArticleResponseDto("success",id);
    }


    public List<PListsResponseDto> getAllPriorityLists()
    {
        List<PListsResponseDto> pListsResponseDto = new ArrayList<>();
        priorityListRepository.findAll().forEach(priorityList -> {
            pListsResponseDto.add(new PListsResponseDto(priorityList.getPriorityListId(),priorityList.getName()));
        });
        return pListsResponseDto;
    }


    public List<ArticleListResponseDto> getAllArticles(Integer priorityListId,String limit){

        List<ArticleListResponseDto> articleListResponseDtoList = new ArrayList<>();

        priorityArticlesRepository.findAllByPriorityList(priorityListRepository.getById(priorityListId)).
                forEach(priorityArticles -> {
                    Article article = articleRepository.getById(priorityArticles.getArticle().getArticleId());

                    articleListResponseDtoList.add(new ArticleListResponseDto(
                            article.getArticleId(),article.getTitle(),article.getDescription(),
                            article.getCategory().getCategoryName(),article.getAuthor().getFullName(),
                            article.getImageUrl(),article.getCreatedAt()));
                });

        articleListResponseDtoList.sort(Comparator.comparing(ArticleListResponseDto::getCreatedAt).reversed());

        int limitInt = Integer.parseInt(limit);

        if(limitInt==-1){
            return articleListResponseDtoList;
        }
        else{
            Stream<ArticleListResponseDto> stream = articleListResponseDtoList.stream();
            return stream.limit(limitInt).collect(Collectors.toList());
        }

    }
    public String deleteArticleFromPriorityList(String id){
        priorityArticlesRepository.deleteById(id);
        return "Deleted Successfully!";
    }

}
