package com.til.newswebsite.dto.articleresponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
