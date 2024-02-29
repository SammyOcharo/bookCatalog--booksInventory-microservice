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

    public ReqResponse() {
    }

    public ReqResponse(BookDTO bookDetails,
                       List<BookDTO> bookDetailsList,
                       Integer statusCode,
                       String responseMessage,
                       String userId) {
        this.bookDetails = bookDetails;
        this.bookDetailsList = bookDetailsList;
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.userId = userId;
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
}
