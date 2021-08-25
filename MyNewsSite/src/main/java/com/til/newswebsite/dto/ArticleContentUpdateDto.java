package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArticleContentUpdateDto {
    @NotNull(message = "Article Id can't be empty")
    Integer articleId;

    @NotNull(message = "content is empty")
    @Lob
    String content;
}
