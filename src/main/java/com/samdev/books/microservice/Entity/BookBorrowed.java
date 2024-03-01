package com.samdev.books.microservice.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "BOOKS_BORROWED")
public class BookBorrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;

    private String isbn;
    private double fineAmount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public BookBorrowed() {
    }


    public BookBorrowed(Long id, String userId, LocalDate borrowDate, LocalDate returnDate, boolean isReturned, String isbn, double fineAmount, Book book) {
        this.id = id;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.isbn = isbn;
        this.fineAmount = fineAmount;
        this.book = book;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public Book getBook() {
        return book;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
