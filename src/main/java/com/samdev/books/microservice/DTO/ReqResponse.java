package com.samdev.books.microservice.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqResponse {

    private BookDTO bookDetails;
    private List<BookDTO> bookDetailsList;  // For a list of BookDTO

    private Integer statusCode;

    private String responseMessage;
    private String userId;

    private BookBorrowedDTO BookBorrowedDTO;

    private List<BookBorrowedDTO> BookBorrowedDTOList;

    public ReqResponse() {
    }

    public ReqResponse(List<BookDTO> bookDetailsList,
                       Integer statusCode,
                       String responseMessage,
                       String userId,
                       BookBorrowedDTO bookBorrowedDTO,
                       List<BookBorrowedDTO> bookBorrowedDTOList) {
        this.bookDetailsList = bookDetailsList;
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.userId = userId;
        BookBorrowedDTO = bookBorrowedDTO;
        BookBorrowedDTOList = bookBorrowedDTOList;
    }

    public BookDTO getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDTO bookDetails) {
        this.bookDetails = bookDetails;
    }

    public List<BookDTO> getBookDetailsList() {
        return bookDetailsList;
    }

    public void setBookDetailsList(List<BookDTO> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public com.samdev.books.microservice.DTO.BookBorrowedDTO getBookBorrowedDTO() {
        return BookBorrowedDTO;
    }

    public void setBookBorrowedDTO(com.samdev.books.microservice.DTO.BookBorrowedDTO bookBorrowedDTO) {
        BookBorrowedDTO = bookBorrowedDTO;
    }

    public List<com.samdev.books.microservice.DTO.BookBorrowedDTO> getBookBorrowedDTOList() {
        return BookBorrowedDTOList;
    }

    public void setBookBorrowedDTOList(List<com.samdev.books.microservice.DTO.BookBorrowedDTO> bookBorrowedDTOList) {
        BookBorrowedDTOList = bookBorrowedDTOList;
    }
}
