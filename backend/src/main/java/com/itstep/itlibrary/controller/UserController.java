package com.itstep.itlibrary.controller;

import com.itstep.itlibrary.dto.UserDto;
import com.itstep.itlibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping()
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping()
    public void create(@RequestBody UserDto user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserDto user) {
        userService.update(id, user);
    }

    @Deprecated
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}


