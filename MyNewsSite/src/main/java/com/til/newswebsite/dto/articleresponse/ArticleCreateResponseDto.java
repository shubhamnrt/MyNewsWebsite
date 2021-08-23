package com.til.newswebsite.dto.articleresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateResponseDto {
    String message;
    Integer articleId;
}
