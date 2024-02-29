package com.samdev.books.microservice.Repository;

import com.samdev.books.microservice.Entity.BookBorrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksBorrowedRepository extends JpaRepository<BookBorrowed, Long> {
}
