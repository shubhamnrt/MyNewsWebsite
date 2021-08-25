package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArticleDto {

    @NotNull(message = "Title can't be empty")
    private String title;

    @Lob
    private String description;

    @Lob
    private String content;

    private String imageUrl;

    @NotNull(message = "Category Id can't be empty")
    private Integer categoryId;

    @NotNull(message = "Author Id can't be empty")
    private Integer authorId;

}
