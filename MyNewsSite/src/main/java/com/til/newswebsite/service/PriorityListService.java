package com.til.newswebsite.service;

import com.til.newswebsite.dto.*;

import java.util.List;

public interface PriorityListService {
    public PListResponseDto addPriorityList(PriorityListDto priorityListDto);
    public AddArticleResponseDto addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto);
    public List<PListsResponseDto> getAllPriorityLists();
    public List<ArticleListResponseDto> getAllArticles(Integer priorityListId);
    public String deleteArticleFromPriorityList(String id);
}
