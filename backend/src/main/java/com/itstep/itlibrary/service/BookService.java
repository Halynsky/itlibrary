package com.itstep.itlibrary.service;

import com.itstep.itlibrary.entity.Book;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import com.itstep.itlibrary.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {
    @Autowired private BookRepository bookRepository;

    public Book get(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Book not found id=" + id));
    }

    public void update(Long id, Book bookUpdate) {
        Book book = get(id);
        book.setTitle(bookUpdate.getTitle());
        bookRepository.save(book);
    }

    public void create(Book book) {
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAll() {
        return  bookRepository.findAll();
    }
}
