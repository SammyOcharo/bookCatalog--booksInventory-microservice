package com.samdev.books.microservice.Controller;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apps/api/v1/books/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    //create book record
    @PostMapping("create/")
    public ResponseEntity<ReqResponse> createBook(@RequestBody BookDTO bookDTO){

        return new ResponseEntity<>(bookService.createBook(bookDTO), HttpStatus.CREATED);
    }
    //get one book
    //get all books
    //delete book
    //update book records
    //filter books according to pages
    //filter books according to cost
    //filter books according to tags
    //filter books that are available
    //filter books that are already borrowed.
    //filter books that the borrowing time has passed.

}
