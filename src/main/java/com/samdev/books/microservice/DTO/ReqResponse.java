package com.samdev.books.microservice.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqResponse {

    private BookDTO bookDetails;
    private Integer statusCode;

    private String responseMessage;

    public ReqResponse() {
    }

    public BookDTO getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDTO bookDetails) {
        this.bookDetails = bookDetails;
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
}
