package com.til.newswebsite.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryDto {

    @NotNull(message = "Category Name can't be empty")
    private String categoryName;

    private String description;

}
