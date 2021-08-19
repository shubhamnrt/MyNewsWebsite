package com.til.newswebsite.controller;

import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.entity.PriorityList;
import com.til.newswebsite.service.PriorityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pList")
public class PriorityListController {

    @Autowired
    PriorityListService priorityListService;

    public PriorityList createPList(PriorityListDto priorityListDto){
        return priorityListService.addPriorityList(priorityListDto);
    }
}
