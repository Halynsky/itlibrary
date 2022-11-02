package com.itstep.itlibrary.service;

import com.itstep.itlibrary.dto.AuthorDto;
import com.itstep.itlibrary.dto.BookDto;
import com.itstep.itlibrary.entity.Author;
import com.itstep.itlibrary.entity.Book;
import com.itstep.itlibrary.entity.Publisher;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import com.itstep.itlibrary.mapper.Mapper;
import com.itstep.itlibrary.repository.AuthorRepository;
import com.itstep.itlibrary.repository.BookRepository;
import com.itstep.itlibrary.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final Mapper mapper;

    public BookDto get(Long id) {
        return mapper.toBookDto(retrieve(id));
    }

    public void update(Long id, BookDto bookDto) {
        Book book = retrieve(id);
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher().getId())
                .orElseThrow(() -> new ItemNotFoundException("Publisher not found id = " + bookDto.getPublisher().getId()));
        List<Author> authors = authorRepository.findAllById(bookDto.getAuthors().stream().map(AuthorDto::getId).toList());
        mapper.mergeBook(bookDto, book);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookRepository.save(book);
    }

    public void create(BookDto bookDto) {
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher().getId())
                .orElseThrow(() -> new ItemNotFoundException("Publisher not found id = " + bookDto.getPublisher().getId()));
        List<Author> authors = authorRepository.findAllById(bookDto.getAuthors().stream().map(AuthorDto::getId).toList());
        Book book = mapper.toBook(bookDto);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Page<BookDto> getAll(String searchTerm, Pageable pageable) {
        return bookRepository.findAll(searchTerm, pageable).map(mapper::toBookDto);
    }

    private Book retrieve(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Book not found id = " + id));
    }
}
