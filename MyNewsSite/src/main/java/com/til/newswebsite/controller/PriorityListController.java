package com.til.newswebsite.controller;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
<<<<<<< HEAD
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.AddArticleResponseDto;
import com.til.newswebsite.dto.PListResponseDto;
import com.til.newswebsite.dto.PListsResponseDto;
import com.til.newswebsite.service.impl.PriorityListServiceImpl;
=======
import com.til.newswebsite.dto.articleresponse.ArticleListResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.PListResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.PListsResponseDto;
import com.til.newswebsite.dto.prioritylistresponse.AddArticleResponseDto;
import com.til.newswebsite.service.PriorityListService;
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/pList")
public class PriorityListController {

    @Autowired
    PriorityListServiceImpl priorityListServiceImpl;

    @PostMapping("/createPList")
<<<<<<< HEAD
    public PListResponseDto createPList(PriorityListDto priorityListDto){
        return priorityListServiceImpl.addPriorityList(priorityListDto);
    }

    @PostMapping("/addArticles")
    public AddArticleResponseDto addArticleToPriorityList(PriorityArticlesDto priorityArticlesDto){
        return priorityListServiceImpl.addArticleToPriorityList(priorityArticlesDto);
=======
    public PListResponseDto createPList(@RequestBody PriorityListDto priorityListDto){
        return priorityListService.addPriorityList(priorityListDto);
    }

    @PostMapping("/addArticles")
    public AddArticleResponseDto addArticleToPriorityList(@RequestBody PriorityArticlesDto priorityArticlesDto){
        return priorityListService.addArticleToPriorityList(priorityArticlesDto);
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
    }

    @GetMapping("/allPList")
    public List<PListsResponseDto> getAllPriorityLists(){
        return priorityListServiceImpl.getAllPriorityLists();
    }

    @GetMapping("/{priorityListId}/allArticles")
<<<<<<< HEAD
    public List<ArticleListResponseDto> getAllArticles(@PathVariable Integer priorityListId){
        return priorityListServiceImpl.getAllArticles(priorityListId);
=======
    public List<ArticleListResponseDto> getAllArticles(@PathVariable Integer priorityListId, @RequestParam String limit){
        return priorityListService.getAllArticles(priorityListId, limit);
>>>>>>> 09abe1a959f68e11dde68ec1830c3416eafa8dde
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticleFromPriorityList(@PathVariable String id){
        return priorityListServiceImpl.deleteArticleFromPriorityList(id);
    }
}
