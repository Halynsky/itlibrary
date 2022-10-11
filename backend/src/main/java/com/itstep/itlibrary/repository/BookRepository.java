package com.itstep.itlibrary.repository;

import com.itstep.itlibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
        SELECT b FROM Book b
        WHERE (:searchTerm IS NULL OR lower(b.title) LIKE concat('%', lower(:searchTerm), '%'))
    """)
    Page<Book> findAll(String searchTerm, Pageable pageable);

}
