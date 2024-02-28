package com.samdev.books.microservice.Service;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;

import java.util.List;

public interface BookService {
    ReqResponse createBook(BookDTO bookDTO);

    ReqResponse getOneBook(Long id);

    ReqResponse getAllBook();

    String deleteBook(Long id);

    ReqResponse updateBook(Long id, BookDTO bookDTO);

    ReqResponse filterByPagesBook(String pages);

    ReqResponse filterByCostBook(int cost);

    ReqResponse filterByTagsBook(ReqResponse reqResponse);

    ReqResponse filterByAvailableBook(ReqResponse reqResponse);

    ReqResponse filterByLanguage(ReqResponse reqResponse);
}
