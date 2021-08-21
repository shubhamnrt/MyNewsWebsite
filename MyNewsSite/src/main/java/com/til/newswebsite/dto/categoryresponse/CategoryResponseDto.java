package com.til.newswebsite.dto.categoryresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {
    Integer categoryId;
    String categoryName;
    String Description;
}
