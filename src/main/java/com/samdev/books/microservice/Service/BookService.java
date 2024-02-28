package com.samdev.books.microservice.Service;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;

public interface BookService {
    ReqResponse createBook(BookDTO bookDTO);

    ReqResponse getOneBook(Long id);

    ReqResponse getAllBook();

    String deleteBook(Long id);

    ReqResponse updateBook(Long id, BookDTO bookDTO);

    ReqResponse filterByPagesBook(String pages);

    ReqResponse filterByCostBook(int cost);
}
