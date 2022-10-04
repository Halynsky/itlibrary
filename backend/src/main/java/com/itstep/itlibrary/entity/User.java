package com.itstep.itlibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.itstep.itlibrary.entity.User.Role.USER;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = USER;
    @JsonIgnore
    private String password;
    @Column(columnDefinition="boolean default false")
    private Boolean isActivated = false;
    @Column(columnDefinition="boolean default false")
    private Boolean isDisabled = false;

    @Schema(description = "Synthetic field. Read only.")
    public String getFullName() {
        return firstName + " " +lastName;
    }

    public enum Role {
        USER, ADMIN, SUPPORT
    }
}
