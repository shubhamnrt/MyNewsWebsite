package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArticleDescriptionUpdateDto {
    @NotNull(message = "Article Id can't be empty")
    Integer articleId;
    @NotNull(message = "Description is empty")
    String description;
}
