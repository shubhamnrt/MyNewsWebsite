package com.til.newswebsite.controller;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
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
    public PriorityList createPList(PriorityListDto priorityListDto){
        return priorityListService.addPriorityList(priorityListDto);
    }

    @PostMapping("/addArticles")
    public PriorityArticles addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        return priorityListService.addArticleToPriorityList(priorityArticlesDto);
    }

    @GetMapping("/allPList")
    public List<PriorityList> getAllPriorityLists(){
        return priorityListService.getAllPriorityLists();
    }

    @GetMapping("/{id}/allArticles")
    public List<ArticleListResponseDto> getAllArticles(@PathVariable Integer priorityListId){
        return priorityListService.getAllArticles(priorityListId);
    }

    @DeleteMapping("/delete/{PLid}/{Aid}")
    public String deleteArticleFromPriorityList(@PathVariable Integer PLid, @PathVariable Integer Aid){
        return priorityListService.deleteArticleFromPriorityList(PLid,Aid);
    }
}
