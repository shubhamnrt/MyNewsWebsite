package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArticleTitleUpdateDto {
    @NotNull(message = "Article Id can't be empty")
    Integer articleId;
    @NotNull(message = "Title can't be empty")
    String title;
}
