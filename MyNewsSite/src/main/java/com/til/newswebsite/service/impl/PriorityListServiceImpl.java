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
import com.til.newswebsite.exception.InvalidRequestException;
import com.til.newswebsite.exception.NotFoundException;
import com.til.newswebsite.repository.ArticleRepository;
import com.til.newswebsite.repository.PriorityArticlesRepository;
import com.til.newswebsite.repository.PriorityListRepository;
import com.til.newswebsite.service.PriorityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        try{
            return new PListResponseDto("success",priorityListRepository.save(priorityList).getPriorityListId());
        }
        catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new InvalidRequestException("Priority List already exist with given name :- "+ priorityListDto.getName());
        }

    }


    public AddArticleResponseDto addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        PriorityArticles priorityArticles = new PriorityArticles();

        String id = String.valueOf(priorityArticlesDto.getPriorityListId()) + "_" +
                String.valueOf(priorityArticlesDto.getArticleId());

        Optional<PriorityList> priorityListOptional = priorityListRepository.findById(priorityArticlesDto.getPriorityListId());
        if(priorityListOptional.isEmpty()){
            throw new InvalidRequestException("PList don't exist with given PList Id :- "+priorityArticlesDto.getPriorityListId());
        }
        else{
            priorityArticles.setPriorityList(priorityListOptional.get());
        }


        Optional<Article> articleOptional = articleRepository.findById(priorityArticlesDto.getArticleId());
        if(articleOptional.isEmpty()){
            throw new InvalidRequestException("Article don't exist given Id :- "+priorityArticlesDto.getArticleId());
        }
        else{
            priorityArticles.setArticle(articleOptional.get());
        }
        priorityArticles.setPriorityArticlesId(id);
        try{
            priorityArticlesRepository.save(priorityArticles);
            return new AddArticleResponseDto("success",id);
        }
        catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new InvalidRequestException("Article already Exist in given Priority List :- "+ id);
        }
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

        Optional<PriorityList> priorityListOptional = priorityListRepository.findById(priorityListId);
        if(priorityListOptional.isPresent()){
            PriorityList priorityList = priorityListOptional.get();
            priorityArticlesRepository.findAllByPriorityList(priorityList).
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
        else{
            throw new NotFoundException("Priority List don't exist with given id :- "+ priorityListId);
        }

    }
    public String deleteArticleFromPriorityList(String id){
        try{
            priorityArticlesRepository.deleteById(id);
            return "Deleted Successfully!";
        }
        catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new InvalidRequestException("Article with given id don't exist in PList");
        }

    }

}
