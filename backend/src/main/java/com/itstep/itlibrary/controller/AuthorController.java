package com.itstep.itlibrary.controller;

import com.itstep.itlibrary.dto.AuthorDto;
import com.itstep.itlibrary.entity.Author;
import com.itstep.itlibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired private AuthorService authorService;

    @GetMapping("/{id}")
    public Author get(@PathVariable Long id) {
        return authorService.get(id);
    }

    @GetMapping()
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @PostMapping()
    public void create(@RequestBody AuthorDto authorDto) {
        authorService.create(authorDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        authorService.update(id, authorDto);
    }

    @Deprecated
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

}


