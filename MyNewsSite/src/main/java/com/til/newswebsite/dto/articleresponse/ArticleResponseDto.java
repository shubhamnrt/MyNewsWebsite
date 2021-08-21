package com.til.newswebsite.dto.articleresponse;

import lombok.Setter;

import java.util.Date;

@Setter
public class ArticleResponseDto {
    Integer articleId;
    String title;
    String description;
    String content;
    String categoryName;
    String authorName;
    String imageUrl;
    Date createdAt;
}
