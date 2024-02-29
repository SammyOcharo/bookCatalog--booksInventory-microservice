package com.samdev.books.microservice.Service;

import com.samdev.books.microservice.DTO.ReqResponse;

public interface BooksBorrowedService {
    ReqResponse borrowBook(ReqResponse reqResponse);
}
