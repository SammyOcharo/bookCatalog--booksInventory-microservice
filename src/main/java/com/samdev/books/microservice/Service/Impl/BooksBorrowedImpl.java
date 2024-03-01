package com.samdev.books.microservice.Service.Impl;

import com.samdev.books.microservice.DTO.BookBorrowedDTO;
import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Entity.Book;
import com.samdev.books.microservice.Entity.BookBorrowed;
import com.samdev.books.microservice.Exceptions.BookNotFoundException;
import com.samdev.books.microservice.Repository.BookRepository;
import com.samdev.books.microservice.Repository.BooksBorrowedRepository;
import com.samdev.books.microservice.Service.BooksBorrowedService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BooksBorrowedImpl implements BooksBorrowedService {

    private final BooksBorrowedRepository booksBorrowedRepository;

    private final BookRepository bookRepository;


    public BooksBorrowedImpl(BooksBorrowedRepository booksBorrowedRepository, BookRepository bookRepository ) {
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
            requestedBook = bookRepository.findByTitleAndIsbn(reqResponse.getBookDetails().getTitle(), reqResponse.getBookDetails().getIsbn())
                    .orElseThrow(() -> new NoSuchElementException("The book requested does not exist"));
            if (requestedBook.getAvailability() == Boolean.FALSE) {
                response.setResponseMessage("Book is currently not available");
                response.setBookDetails(null);
                response.setStatusCode(404);

                return response;
            }
        } catch (NoSuchElementException e) {
            response.setResponseMessage(e.getMessage());
            response.setBookDetails(null);
            response.setStatusCode(404);

            return response;
        }

        if ((!bookRepository.existsByIsbn(reqResponse.getBookDetails().getIsbn()) &&
                (requestedBook.getTitle().equals(reqResponse.getBookDetails().getTitle())))) {
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
            bookBorrowed.setBorrowDate(LocalDate.now());

            bookBorrowed.setReturnDate(bookBorrowed.getBorrowDate().plusDays(30));
            bookBorrowed.setReturned(Boolean.FALSE);
            bookBorrowed.setFineAmount(0);
            bookBorrowed.setBook(requestedBook);
            bookBorrowed.setIsbn(reqResponse.getBookDetails().getIsbn());
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

    @Override
    public ReqResponse returnBook(ReqResponse reqResponse) {
        ReqResponse response = new ReqResponse();

        try{
            Book requestedBook = bookRepository
                    .findByTitleAndIsbn(reqResponse.getBookDetails().getTitle(), reqResponse.getBookDetails().getIsbn())
                    .orElseThrow(() -> new NoSuchElementException("Book  does not exist"));

            if(requestedBook.getAvailability() == Boolean.TRUE){
                response.setResponseMessage("Book has already been returned");
                response.setBookDetails(null);
                response.setStatusCode(400);
                return response;
            }


            BookBorrowed bookBorrowed = booksBorrowedRepository.findByIsbnAndIsReturned(requestedBook.getIsbn(), false)
                    .orElseThrow(()-> new BookNotFoundException("Book not found in borrowed catalog"));


            requestedBook.setAvailability(Boolean.TRUE);
            bookBorrowed.setReturned(Boolean.TRUE);

            long daysDifference = ChronoUnit.DAYS.between(bookBorrowed.getBorrowDate(), bookBorrowed.getReturnDate());
            int fineAmount = (daysDifference > 40) ? 50 : 0;

            bookBorrowed.setFineAmount(fineAmount);

            bookRepository.save(requestedBook);
            booksBorrowedRepository.save(bookBorrowed);
            response.setResponseMessage("Book "+ reqResponse.getBookDetails().getTitle() +" and isbn number " + reqResponse.getBookDetails().getIsbn() + " returned successfully");
            response.setStatusCode(200);
            return response;

        } catch (NoSuchElementException | BookNotFoundException e){
            response.setResponseMessage(e.getMessage());
            response.setBookDetails(null);
            response.setStatusCode(404);
            return response;
        }
    }

    @Override
    public ReqResponse overdueBooks() {
        ReqResponse response = new ReqResponse();
        BookBorrowedDTO bookBorrowedDTO = new BookBorrowedDTO();

        System.out.println(LocalDate.now());

        try{
            List<BookBorrowedDTO> bookBorrowed1 = booksBorrowedRepository.findAll()
                    .stream()
                    .filter(bookBorrowed -> LocalDate.now().isAfter(bookBorrowed.getBorrowDate().plusDays(10)))
                    .map(bookBorrowed -> mapBookBorrowEntityToBookDTO(bookBorrowed, bookBorrowedDTO))
                    .toList();

            System.out.println(bookBorrowed1);

            response.setBookBorrowedDTOList(bookBorrowed1);
            response.setResponseMessage("All overdue books");
            response.setStatusCode(200);
            return response;
        } catch (Exception e){
            response.setResponseMessage("An error occurred");
            response.setBookDetails(null);
            response.setStatusCode(500);
            return response;
        }
    }

    @Override
    public ReqResponse extendBookBorrowTime(ReqResponse reqResponse) {

        ReqResponse response = new ReqResponse();

        try {

            Book requestedBook = bookRepository.findByTitleAndIsbn(reqResponse.getBookDetails().getTitle(), reqResponse.getBookDetails().getIsbn())
                    .orElseThrow(() -> new NoSuchElementException("Book  does not exist"));

            if(requestedBook.getAvailability() == Boolean.TRUE){
                response.setResponseMessage("Book has already been returned");
                response.setBookDetails(null);
                response.setStatusCode(400);
                return response;
            }

            BookBorrowed bookBorrowed = booksBorrowedRepository.findByIsbnAndIsReturned(requestedBook.getIsbn(), false)
                    .orElseThrow(()-> new BookNotFoundException("Book not found in borrowed catalog"));

            bookBorrowed.setReturnDate(bookBorrowed.getReturnDate().plusDays(10));
            booksBorrowedRepository.save(bookBorrowed);


            response.setResponseMessage("Book "+ bookBorrowed.getBook().getTitle() + " return date has been extended by "+ 10 + " days.");
            response.setStatusCode(200);
            return response;

        } catch (BookNotFoundException e){
            response.setResponseMessage(e.getMessage());
            response.setBookDetails(null);
            response.setStatusCode(404);
            return response;
        }
    }

    @Override
    public ReqResponse userBorrowHistory(String userId) {
        ReqResponse response = new ReqResponse();
        if (userId.isEmpty()){
            response.setResponseMessage("null user ID passed");
            response.setBookDetails(null);
            response.setStatusCode(400);
            return response;
        }
        try {
            BookBorrowedDTO bookBorrowedDTO = new BookBorrowedDTO();
            List<BookBorrowedDTO> bookBorrowedDTO1 = booksBorrowedRepository
                    .findByUserId(userId)
                    .stream()
                    .map(bookBorrowed1 -> mapBookBorrowEntityToBookDTO( bookBorrowed1, bookBorrowedDTO))
                    .toList();

            response.setBookBorrowedDTOList(bookBorrowedDTO1);
            response.setStatusCode(200);
            response.setResponseMessage("User borrowing history");

            return  response;
        } catch (Exception e){
            response.setResponseMessage("An error has occurred" + e.getMessage());
            response.setStatusCode(200);
            return response;
        }

    }

    public BookBorrowedDTO mapBookBorrowEntityToBookDTO(BookBorrowed bookBorrowed, BookBorrowedDTO bookBorrowedDTO) {
        bookBorrowedDTO.setBorrowDate(bookBorrowed.getBorrowDate());
        bookBorrowedDTO.setBook(bookBorrowed.getBook());
        bookBorrowedDTO.setReturnDate(bookBorrowed.getReturnDate());
        bookBorrowedDTO.setFineAmount(bookBorrowed.getFineAmount());
        bookBorrowedDTO.setUserId(bookBorrowed.getUserId());
        bookBorrowedDTO.setReturned(bookBorrowed.isReturned());

        return bookBorrowedDTO;
    }
}
