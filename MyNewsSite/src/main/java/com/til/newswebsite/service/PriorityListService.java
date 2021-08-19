package com.til.newswebsite.service;

import com.til.newswebsite.dto.PriorityListDto;
import com.til.newswebsite.entity.PriorityList;
import com.til.newswebsite.repository.PriorityListRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriorityListService {
    @Autowired
    PriorityListRepository priorityListRepository;

    public PriorityList addPriorityList(PriorityListDto priorityListDto){
        PriorityList priorityList = new PriorityList();
        priorityList.setDescription(priorityListDto.getDescription());
        priorityList.setName(priorityListDto.getName());

        return priorityListRepository.save(priorityList);
    }


}
