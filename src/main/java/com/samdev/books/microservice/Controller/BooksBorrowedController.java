package com.samdev.books.microservice.Controller;

import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Entity.BookBorrowed;
import com.samdev.books.microservice.Service.BooksBorrowedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apps/api/v1/books-borrowed/")
public class BooksBorrowedController {

    private final BooksBorrowedService booksBorrowedService;

    public BooksBorrowedController(BooksBorrowedService booksBorrowedService){
        this.booksBorrowedService = booksBorrowedService;
    }

    //borrow book
    @PostMapping("borrow/")
    public ResponseEntity<ReqResponse> borrowBook(@RequestBody ReqResponse reqResponse){

        return new ResponseEntity<>(booksBorrowedService.borrowBook(reqResponse), HttpStatus.OK);
    }
    //return borrowed book
    //List of overdue books
    //extend time for borrowed
    // history for a user's borrowing


}
