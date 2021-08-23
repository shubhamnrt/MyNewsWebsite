package com.til.newswebsite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListResponseDto {
    Integer articleId;
    String title;
    String description;
    String categoryName;
    String authorName;
    String imageUrl;
    Date createdAt;
}
