package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PriorityArticlesDto {
    @NotNull(message = "Article Id can't be empty")
    private Integer articleId;

    @NotNull(message = "Priority List Id can't be empty")
    private Integer priorityListId;
}
