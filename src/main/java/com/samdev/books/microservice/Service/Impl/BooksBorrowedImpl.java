package com.samdev.books.microservice.Service.Impl;

import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Entity.Book;
import com.samdev.books.microservice.Entity.BookBorrowed;
import com.samdev.books.microservice.Repository.BookRepository;
import com.samdev.books.microservice.Repository.BooksBorrowedRepository;
import com.samdev.books.microservice.Service.BooksBorrowedService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class BooksBorrowedImpl implements BooksBorrowedService {

    private final BooksBorrowedRepository booksBorrowedRepository;

    private final BookRepository bookRepository;

    public BooksBorrowedImpl(BooksBorrowedRepository booksBorrowedRepository, BookRepository bookRepository) {
        this.booksBorrowedRepository = booksBorrowedRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public ReqResponse borrowBook(ReqResponse reqResponse) {

        ReqResponse response = new ReqResponse();
        if (reqResponse.getUserId() == null) {

            response.setResponseMessage("No User ID passed");
            response.setBookDetails(null);
            response.setStatusCode(400);

            return response;
        }
        Book requestedBook = null;
        try {
            requestedBook = bookRepository.findByIsbn(reqResponse.getBookDetails().getIsbn())
                    .orElseThrow(() -> new NoSuchElementException("The book requested does not exist"));
            if (requestedBook.getAvailability() == Boolean.FALSE) {
                response.setResponseMessage("Book is currently not available");
                response.setBookDetails(null);
                response.setStatusCode(404);

                return response;
            }
        } catch (NoSuchElementException e) {
            response.setResponseMessage("No such book exists in the catalog");
            response.setBookDetails(null);
            response.setStatusCode(404);

            return response;
        }

        if ((!bookRepository.existsByIsbn(reqResponse.getBookDetails().getIsbn()) &&
                !Objects.equals(requestedBook.getTitle(), reqResponse.getBookDetails().getTitle()))) {
            response.setResponseMessage("Book does not exist in catalog");
            response.setBookDetails(null);
            response.setStatusCode(400);

            return response;
        }

        try {
            String bookName = reqResponse.getBookDetails().getTitle();
            if (bookName == null) {
                response.setResponseMessage("No book name passed");
                response.setBookDetails(null);
                response.setStatusCode(400);

                return response;
            }

            BookBorrowed bookBorrowed = new BookBorrowed();
            bookBorrowed.setUserId(reqResponse.getUserId());
            bookBorrowed.setBorrowDate(new Date());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(bookBorrowed.getBorrowDate());
            calendar.add(Calendar.DAY_OF_MONTH, 30);
            Date returnDate = calendar.getTime();

            bookBorrowed.setReturnDate(returnDate);
            bookBorrowed.setReturned(Boolean.FALSE);
            bookBorrowed.setFineAmount(0);
            bookBorrowed.setBook(requestedBook);
            requestedBook.setAvailability(Boolean.FALSE);
            bookRepository.save(requestedBook);

            booksBorrowedRepository.save(bookBorrowed);

            response.setStatusCode(200);
            response.setResponseMessage("Book " + requestedBook.getTitle() + " successfully borrowed");

            return response;
        }  catch (Exception e) {
            response.setResponseMessage("An error has occurred. Failed to borrow book");
            response.setBookDetails(null);
            response.setStatusCode(500);

            return response;
        }
    }
}
