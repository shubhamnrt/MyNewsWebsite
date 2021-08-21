package com.til.newswebsite.dto.authorresponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponseDto {
    Integer authorId;
    String authorName;
}
