package com.til.newswebsite.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    @NotNull(message = "Email can't be null")
    @Email(message = "Invalid email")
    private String email;

    @NotNull(message = "userName can't be null")
    private String userName;

    @NotNull(message = "Author name can't be null")
    private String fullName;

    @NotNull(message = "Password can't be null")
    private String password;

}
