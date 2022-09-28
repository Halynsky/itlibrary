package com.itstep.itlibrary.dto;

import com.itstep.itlibrary.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SecurityUserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private User.Role role;

    public static SecurityUserDto of(User user) {
        return new SecurityUserDto()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRole(user.getRole());
    }
}
