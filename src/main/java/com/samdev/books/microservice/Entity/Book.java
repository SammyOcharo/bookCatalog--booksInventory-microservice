package com.samdev.books.microservice.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String authors;
    private String ISBN;
    private String publisher;
    private Date publicationDate;
    private String category;
    private String LCCNumber;
    private String language;
    private String format;
    private String edition;
    private String pages;

    @Column(name = "book_condition")
    private String condition;

    private String shelfLocation;

    private Boolean availability;

    private Double cost;

    private List<String> tags;

    private String summary;
    private String seriesInformation;

    public Book() {
    }

    public Book(Long id, String title, String authors, String ISBN, String publisher, Date publicationDate, String category, String LCCNumber, String language, String format, String edition, String pages, String condition, String shelfLocation, Boolean availability, Double cost, List<String> tags, String summary, String seriesInformation) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.category = category;
        this.LCCNumber = LCCNumber;
        this.language = language;
        this.format = format;
        this.edition = edition;
        this.pages = pages;
        this.condition = condition;
        this.shelfLocation = shelfLocation;
        this.availability = availability;
        this.cost = cost;
        this.tags = tags;
        this.summary = summary;
        this.seriesInformation = seriesInformation;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLCCNumber() {
        return LCCNumber;
    }

    public void setLCCNumber(String LCCNumber) {
        this.LCCNumber = LCCNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSeriesInformation() {
        return seriesInformation;
    }

    public void setSeriesInformation(String seriesInformation) {
        this.seriesInformation = seriesInformation;
    }
}
