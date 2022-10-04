package com.itstep.itlibrary.service;

import com.itstep.itlibrary.dto.BookDto;
import com.itstep.itlibrary.entity.Book;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import com.itstep.itlibrary.mapper.Mapper;
import com.itstep.itlibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final Mapper mapper;

    public BookDto get(Long id) {
        return mapper.toBookDto(retrieve(id));
    }

    public void update(Long id, BookDto bookDto) {
        Book book = retrieve(id);
        // TODO: save relations
        mapper.mergeBook(bookDto, book);
        bookRepository.save(book);
    }

    public void create(BookDto bookDto) {
        // TODO: save relations
        Book book = mapper.toBook(bookDto);
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Page<BookDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).map(mapper::toBookDto);
    }

    private Book retrieve(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Book not found id = " + id));
    }
}
