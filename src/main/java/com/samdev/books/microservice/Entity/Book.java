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
    private String isbn;
    private String publisher;
    private Date publicationDate;
    private String category;
    private String lcc;
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

    public Book(Long id,
                String title,
                String authors,
                String isbn,
                String publisher,
                Date publicationDate,
                String category,
                String lcc,
                String language,
                String format,
                String edition,
                String pages,
                String condition,
                String shelfLocation,
                Boolean availability,
                Double cost,
                List<String> tags,
                String summary,
                String seriesInformation) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.category = category;
        this.lcc = lcc;
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

    public String getAuthors() {
        return authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getCategory() {
        return category;
    }

    public String getLcc() {
        return lcc;
    }

    public String getLanguage() {
        return language;
    }

    public String getFormat() {
        return format;
    }

    public String getEdition() {
        return edition;
    }

    public String getPages() {
        return pages;
    }

    public String getCondition() {
        return condition;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public Double getCost() {
        return cost;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getSummary() {
        return summary;
    }

    public String getSeriesInformation() {
        return seriesInformation;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLcc(String lcc) {
        this.lcc = lcc;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSeriesInformation(String seriesInformation) {
        this.seriesInformation = seriesInformation;
    }
}
