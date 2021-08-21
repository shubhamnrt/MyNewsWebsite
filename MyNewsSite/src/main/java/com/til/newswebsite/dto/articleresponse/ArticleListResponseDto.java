package com.til.newswebsite.dto.articleresponse;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ArticleListResponseDto {
    Integer articleId;
    String title;
    String description;
    String AuthorName;
    String CategoryName;
    String imageUrl;
    Date createdAt;
}
