package com.samdev.books.microservice.Service.Impl;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Entity.Book;
import com.samdev.books.microservice.Repository.BookRepository;
import com.samdev.books.microservice.Service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ReqResponse createBook(BookDTO bookDTO) {

        ReqResponse reqResponse1 = new ReqResponse();
        Book book = new Book();
        try{
            book.setTitle(bookDTO.getTitle());
            book.setAuthors(bookDTO.getAuthors());
            book.setISBN(bookDTO.getISBN());
            book.setPublisher(bookDTO.getPublisher());
            book.setPublicationDate(bookDTO.getPublicationDate());
            book.setCategory(bookDTO.getCategory());
            book.setLCCNumber(bookDTO.getLCCNumber());
            book.setLanguage(bookDTO.getLanguage());
            book.setFormat(bookDTO.getFormat());
            book.setEdition(bookDTO.getEdition());
            book.setPages(bookDTO.getPages());
            book.setCondition(bookDTO.getCondition());
            book.setShelfLocation(bookDTO.getShelfLocation());
            book.setAvailability(bookDTO.isAvailability());
            book.setCost(bookDTO.getCost());
            book.setTags(bookDTO.getTags());
            book.setSummary(bookDTO.getSummary());
            book.setSeriesInformation(bookDTO.getSeriesInformation());

            bookRepository.save(book);

            reqResponse1.setBookDetails(bookDTO);
            reqResponse1.setStatusCode(200);
            reqResponse1.setResponseMessage("Book created successfully");

            return reqResponse1;

        }catch (Exception e){
            return reqResponse1;
        }
    }
}
