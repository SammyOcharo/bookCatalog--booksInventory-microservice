package com.samdev.books.microservice.Controller;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("{id}/")
    public ResponseEntity<ReqResponse> getOneBook(@PathVariable Long id){
       return new ResponseEntity<>(bookService.getOneBook(id), HttpStatus.OK);
    }
    //get all books
    @GetMapping("all/")
    public ResponseEntity<ReqResponse> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(), HttpStatus.OK);
    }
    //delete book
    @DeleteMapping("{id}/")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){

        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }
    //update book records
    @PutMapping("{id}/")
    public ResponseEntity<ReqResponse> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){

        return new ResponseEntity<>(bookService.updateBook(id, bookDTO), HttpStatus.CREATED);
    }
    //filter books according to pages
    @GetMapping("filter-by-pages/{pages}/")
    public ResponseEntity<ReqResponse> filterByPagesBook(@PathVariable String pages){

        return new ResponseEntity<>(bookService.filterByPagesBook(pages), HttpStatus.CREATED);
    }
    //filter books according to cost
    @GetMapping("filter-by-cost/{cost}/")
    public ResponseEntity<ReqResponse> filterByCostBook(@PathVariable int cost){

        return new ResponseEntity<>(bookService.filterByCostBook(cost), HttpStatus.CREATED);
    }
    //filter books according to tags
    @PostMapping("filter-by-tags/")
    public ResponseEntity<ReqResponse> filterByTagsBook(@RequestBody ReqResponse reqResponse){

        return new ResponseEntity<>(bookService.filterByTagsBook(reqResponse), HttpStatus.CREATED);
    }
    //filter books that are available
    @PostMapping("filter-by-availability/")
    public ResponseEntity<ReqResponse> filterByAvailableBook(@RequestBody ReqResponse reqResponse){

        return new ResponseEntity<>(bookService.filterByAvailableBook(reqResponse), HttpStatus.CREATED);
    }

    //filter books by language
    @PostMapping("filter-by-language/")
    public ResponseEntity<ReqResponse> filterByLanguage(@RequestBody ReqResponse reqResponse){

        return new ResponseEntity<>(bookService.filterByLanguage(reqResponse), HttpStatus.CREATED);
    }


}
