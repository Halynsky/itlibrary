package com.itstep.itlibrary.repository;

import com.itstep.itlibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);

    List<Author> findAllByEmailAndFirstNameAndLastName(String email, String firstName, String lastName);

    Optional<Author> findByFirstNameOrLastName(String firstName, String lastName);

    Optional<Author> findByFirstNameStartingWithOrLastNameStartingWith(String firstName, String lastName);
}
