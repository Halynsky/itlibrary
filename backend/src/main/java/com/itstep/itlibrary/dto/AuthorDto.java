package com.itstep.itlibrary.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
}
