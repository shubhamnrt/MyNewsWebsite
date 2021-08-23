package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleContentUpdateDto {
    Integer articleId;
    String content;
}
