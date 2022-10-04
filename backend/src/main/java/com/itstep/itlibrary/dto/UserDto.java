package com.itstep.itlibrary.dto;

import com.itstep.itlibrary.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private User.Role role = User.Role.USER;
    private Boolean isActivated = false;
    private Boolean isDisabled = false;
}
