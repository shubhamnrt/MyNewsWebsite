package com.til.newswebsite.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class AuthorDto {

    private String email;

    private String userName;

    private String fullName;

    private String password;


}
