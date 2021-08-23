package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDescriptionUpdateDto {
    Integer articleId;
    String description;
}
