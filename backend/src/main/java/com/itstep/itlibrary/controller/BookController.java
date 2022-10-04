package com.itstep.itlibrary.controller;

import com.itstep.itlibrary.dto.BookDto;

import com.itstep.itlibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public BookDto get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @GetMapping()
    public Page<BookDto> getAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return bookService.getAll(pageable);
    }

    @PostMapping()
    public void create(@RequestBody BookDto book) {
        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody BookDto book) {
        bookService.update(id, book);
    }

    @Deprecated
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

}


