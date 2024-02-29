package com.samdev.books.microservice.Repository;

import com.samdev.books.microservice.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleAndIsbn(String title, String isbn);
    boolean existsByIsbn(String isbn);
}
