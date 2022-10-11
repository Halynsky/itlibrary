package com.itstep.itlibrary.controller;

import com.itstep.itlibrary.dto.UserDto;
import com.itstep.itlibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public Page<UserDto> getAll(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Boolean isActivated,
            @RequestParam(required = false) Boolean isDisabled,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.getAll(id, email, isActivated, isDisabled, pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public void create(@RequestBody UserDto user) {
        userService.create(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto user) {
        userService.update(id, user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Deprecated
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}


