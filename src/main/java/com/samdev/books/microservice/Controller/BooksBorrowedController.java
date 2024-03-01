package com.samdev.books.microservice.Controller;

import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Entity.BookBorrowed;
import com.samdev.books.microservice.Service.BooksBorrowedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("return-book/")
    public ResponseEntity<ReqResponse> returnBook(@RequestBody ReqResponse reqResponse){

        return new ResponseEntity<>(booksBorrowedService.returnBook(reqResponse), HttpStatus.OK);
    }
    //List of overdue books
    @GetMapping("overdue-books/")
    public ResponseEntity<ReqResponse> overdueBooks(){

        return new ResponseEntity<>(booksBorrowedService.overdueBooks(), HttpStatus.OK);
    }

    //extend time for borrowed
    @PostMapping("extend-borrow-time/")
    public ResponseEntity<ReqResponse> extendBookBorrowTime(@RequestBody ReqResponse reqResponse){

        return new ResponseEntity<>(booksBorrowedService.extendBookBorrowTime(reqResponse), HttpStatus.OK);
    }
    // history for a user's borrowing


}
