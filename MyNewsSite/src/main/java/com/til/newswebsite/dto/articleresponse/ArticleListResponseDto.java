package com.til.newswebsite.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ArticleListResponseDto {
    String title;
    String description;
    String AuthorName;
    String CategoryName;
    String imageUrl;
    Date createdAt;
}
