package com.samdev.books.microservice.Entity;

import com.samdev.books.microservice.DTO.ReqResponse;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "BOOKS_BORROWED")
public class BookBorrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String userId;
    private Date borrowDate;
    private Date returnDate;
    private boolean isReturned;
    private double fineAmount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public BookBorrowed() {
    }

    public BookBorrowed(Long id,
                        String userId,
                        Date borrowDate,
                        Date returnDate,
                        boolean isReturned,
                        double fineAmount,
                        Book book) {
        this.id = id;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.fineAmount = fineAmount;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
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

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate) {
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
