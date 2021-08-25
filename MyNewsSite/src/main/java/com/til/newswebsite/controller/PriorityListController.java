package com.til.newswebsite.controller;

import com.til.newswebsite.dto.PriorityArticlesDto;
import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.dto.ArticleListResponseDto;
import com.til.newswebsite.dto.AddArticleResponseDto;
import com.til.newswebsite.dto.PListResponseDto;
import com.til.newswebsite.dto.PListsResponseDto;
import com.til.newswebsite.service.impl.BindingResultService;
import com.til.newswebsite.service.impl.PriorityListServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/pList")
public class PriorityListController {

    @Autowired
    PriorityListServiceImpl priorityListServiceImpl;

    @Autowired
    BindingResultService bindingResultService;

    @PostMapping("/createPList")
    public PListResponseDto createPList(@RequestBody @Valid PriorityListDto priorityListDto, BindingResult bindingResult){
        bindingResultService.validate(bindingResult);
        return priorityListServiceImpl.addPriorityList(priorityListDto);
    }

    @PostMapping("/addArticles")
    public AddArticleResponseDto addArticleToPriorityList(@RequestBody @Valid PriorityArticlesDto priorityArticlesDto, BindingResult bindingResult) {
        bindingResultService.validate(bindingResult);
        return priorityListServiceImpl.addArticleToPriorityList(priorityArticlesDto);
    }

    @GetMapping("/allPList")
    public List<PListsResponseDto> getAllPriorityLists(){
        return priorityListServiceImpl.getAllPriorityLists();
    }

    @GetMapping("/{priorityListId}/allArticles")
    public List<ArticleListResponseDto> getAllArticles(@PathVariable Integer priorityListId, @RequestParam String limit){
        return priorityListServiceImpl.getAllArticles(priorityListId, limit);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticleFromPriorityList(@PathVariable String id){
        return priorityListServiceImpl.deleteArticleFromPriorityList(id);
    }
}
