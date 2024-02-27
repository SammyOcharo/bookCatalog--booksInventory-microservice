package com.samdev.books.microservice.Service;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;

public interface BookService {
    ReqResponse createBook(BookDTO bookDTO);
}
