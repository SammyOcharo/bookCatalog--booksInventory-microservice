package com.samdev.books.microservice.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
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

    private String condition;

    private String shelfLocation;

    private boolean availability;

    private double cost;

    private List<String> tags;

    private String summary;
    private String seriesInformation;

    public BookDTO() {
    }

    public BookDTO(String title,
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
                   boolean availability,
                   double cost,
                   List<String> tags,
                   String summary,
                   String seriesInformation) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getLcc() {
        return lcc;
    }

    public void setLcc(String lcc) {
        this.lcc = lcc;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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
