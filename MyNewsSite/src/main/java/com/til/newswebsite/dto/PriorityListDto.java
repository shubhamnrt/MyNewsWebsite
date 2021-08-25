package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class PriorityListDto {
    private String description;

    @NotNull(message = "PList Name can't be empty")
    private String name;
}
