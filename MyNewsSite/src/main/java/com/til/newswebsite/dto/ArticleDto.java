package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

    private String title;

    private String description;

    private String content;

    private String imageUrl;

    private Integer categoryId;

    private Integer authorId;


}
