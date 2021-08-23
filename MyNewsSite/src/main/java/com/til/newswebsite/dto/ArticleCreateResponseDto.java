package com.til.newswebsite.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateResponseDto {
    String message;
    Integer articleId;
}
