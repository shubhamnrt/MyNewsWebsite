package com.til.newswebsite.controller;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.AddArticleResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.PListResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.PListsResponseDto;
import com.til.newswebsite.entity.PriorityArticles;
import com.til.newswebsite.entity.PriorityList;
import com.til.newswebsite.service.PriorityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pList")
public class PriorityListController {

    @Autowired
    PriorityListService priorityListService;

    @PostMapping("/createPList")
    public PListResponseDto createPList(PriorityListDto priorityListDto){
        return priorityListService.addPriorityList(priorityListDto);
    }

    @PostMapping("/addArticles")
    public AddArticleResponseDto addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        return priorityListService.addArticleToPriorityList(priorityArticlesDto);
    }

    @GetMapping("/allPList")
    public List<PListsResponseDto> getAllPriorityLists(){
        return priorityListService.getAllPriorityLists();
    }

    @GetMapping("/{priorityListId}/allArticles")
    public List<ArticleListResponseDto> getAllArticles(@PathVariable Integer priorityListId){
        return priorityListService.getAllArticles(priorityListId);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteArticleFromPriorityList(@PathVariable String id){
        return priorityListService.deleteArticleFromPriorityList(id);
    }
}
