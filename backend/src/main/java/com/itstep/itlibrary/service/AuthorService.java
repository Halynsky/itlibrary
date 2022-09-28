package com.itstep.itlibrary.service;

import com.itstep.itlibrary.dto.AuthorDto;
import com.itstep.itlibrary.entity.Author;
import com.itstep.itlibrary.exception.ItemNotFoundException;
import com.itstep.itlibrary.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author get(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Author not found id=" + id));
    }

    public List<Author> getAll() {
        return  authorRepository.findAll();
    }

    public void create(AuthorDto authorDto) {
        save(new Author(), authorDto);
    }

    public void update(Long id, AuthorDto authorDto) {
        save(get(id), authorDto);
    }

    public void save(Author author, AuthorDto authorDto) {
        author.setEmail(authorDto.getEmail());
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        authorRepository.save(author);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }


}
