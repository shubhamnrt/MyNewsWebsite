package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
public class ArticleDto {

    private String title;

    @Lob
    private String description;

    @Lob
    private String content;

    private String imageUrl;

    private Integer categoryId;

    private Integer authorId;

}
