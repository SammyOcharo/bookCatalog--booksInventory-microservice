package com.samdev.books.microservice.Service.Impl;

import com.samdev.books.microservice.DTO.BookDTO;
import com.samdev.books.microservice.DTO.ReqResponse;
import com.samdev.books.microservice.Entity.Book;
import com.samdev.books.microservice.Exceptions.BookNotFoundException;
import com.samdev.books.microservice.Exceptions.InvalidIDException;
import com.samdev.books.microservice.Repository.BookRepository;
import com.samdev.books.microservice.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ReqResponse createBook(BookDTO bookDTO) {

        ReqResponse reqResponse1 = new ReqResponse();
        try{
            Book book = new Book();
            Book mappedbook = mapBookDtoToEntity(book, bookDTO);
            bookRepository.save(mappedbook);

            reqResponse1.setBookDetails(bookDTO);
            reqResponse1.setStatusCode(200);
            reqResponse1.setResponseMessage("Book created successfully");

            return reqResponse1;

        }catch (Exception e){
            return reqResponse1;
        }
    }


    private Book mapBookDtoToEntity(Book book, BookDTO bookDTO) {

        book.setTitle(bookDTO.getTitle());
        book.setAuthors(bookDTO.getAuthors());
        book.setISBN(bookDTO.getISBN());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublicationDate(bookDTO.getPublicationDate());
        book.setCategory(bookDTO.getCategory());
        book.setLCCNumber(bookDTO.getLCCNumber());
        book.setLanguage(bookDTO.getLanguage());
        book.setFormat(bookDTO.getFormat());
        book.setEdition(bookDTO.getEdition());
        book.setPages(bookDTO.getPages());
        book.setCondition(bookDTO.getCondition());
        book.setShelfLocation(bookDTO.getShelfLocation());
        book.setAvailability(bookDTO.isAvailability());
        book.setCost(bookDTO.getCost());
        book.setTags(bookDTO.getTags());
        book.setSummary(bookDTO.getSummary());
        book.setSeriesInformation(bookDTO.getSeriesInformation());
        return book;
    }

    private BookDTO mapBookEntitytoBookDTO(Book book, BookDTO bookDTO) {

        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthors(book.getAuthors());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setPublicationDate(book.getPublicationDate());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setLCCNumber(book.getLCCNumber());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setFormat(book.getFormat());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setPages(book.getPages());
        bookDTO.setCondition(book.getCondition());
        bookDTO.setShelfLocation(book.getShelfLocation());
        bookDTO.setAvailability(book.getAvailability());
        bookDTO.setCost(book.getCost());
        bookDTO.setTags(book.getTags());
        bookDTO.setSummary(book.getSummary());
        bookDTO.setSeriesInformation(book.getSeriesInformation());
        return bookDTO;
    }

    @Override
    public ReqResponse getOneBook(Long id) {
        ReqResponse reqResponse = new ReqResponse();
        BookDTO bookDTO = new BookDTO();
        if(id==null || id <= 0){
            reqResponse.setBookDetails(null);
            reqResponse.setResponseMessage("Invalid id value!");
            reqResponse.setStatusCode(400);
            return reqResponse;
        }
        try {
            Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found!"));

            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthors(book.getAuthors());
            bookDTO.setISBN(book.getISBN());
            bookDTO.setPublisher(book.getPublisher());
            bookDTO.setPublicationDate(book.getPublicationDate());
            bookDTO.setCategory(book.getCategory());
            bookDTO.setLCCNumber(book.getLCCNumber());
            bookDTO.setLanguage(book.getLanguage());
            bookDTO.setFormat(book.getFormat());
            bookDTO.setEdition(book.getEdition());
            bookDTO.setPages(book.getPages());
            bookDTO.setCondition(book.getCondition());
            bookDTO.setShelfLocation(book.getShelfLocation());
            bookDTO.setAvailability(book.getAvailability());
            bookDTO.setCost(book.getCost());
            bookDTO.setTags(book.getTags());
            bookDTO.setSummary(book.getSummary());
            bookDTO.setSeriesInformation(book.getSeriesInformation());

            reqResponse.setBookDetails(bookDTO);
            reqResponse.setResponseMessage("Book details of (" + book.getTitle() + ") retrieved successfully");
            reqResponse.setStatusCode(200);
            return reqResponse;
        }catch (BookNotFoundException e){
            reqResponse.setStatusCode(404);
            reqResponse.setResponseMessage("Book not found");
            reqResponse.setBookDetails(null);
            return reqResponse;
        }
    }

    @Override
    public ReqResponse getAllBook() {

        try {
            ReqResponse reqResponse = new ReqResponse();
            List<Book> allBooks = bookRepository.findAll();
            List<BookDTO> allBooksDTO = allBooks
                    .stream()
                    .map(book -> {
                        BookDTO bookDTO = new BookDTO();
                        bookDTO.setTitle(book.getTitle());
                        bookDTO.setAuthors(book.getAuthors());
                        bookDTO.setISBN(book.getISBN());
                        bookDTO.setPublisher(book.getPublisher());
                        bookDTO.setPublicationDate(book.getPublicationDate());
                        bookDTO.setCategory(book.getCategory());
                        bookDTO.setLCCNumber(book.getLCCNumber());
                        bookDTO.setLanguage(book.getLanguage());
                        bookDTO.setFormat(book.getFormat());
                        bookDTO.setEdition(book.getEdition());
                        bookDTO.setPages(book.getPages());
                        bookDTO.setCondition(book.getCondition());
                        bookDTO.setShelfLocation(book.getShelfLocation());
                        bookDTO.setAvailability(book.getAvailability());
                        bookDTO.setCost(book.getCost());
                        bookDTO.setTags(book.getTags());
                        bookDTO.setSummary(book.getSummary());
                        bookDTO.setSeriesInformation(book.getSeriesInformation());

                        return bookDTO;
                    })
                    .collect(Collectors.toList());
            reqResponse.setBookDetailsList(allBooksDTO);
            reqResponse.setResponseMessage("All books current in the catalog");
            reqResponse.setStatusCode(200);

            return reqResponse;
        } catch (Exception e) {
           throw e;
        }
    }

    @Override
    public String deleteBook(Long id) {
        try {
            if(id==null || id <= 0){
                throw new InvalidIDException("Invalid ID!");
            }
            Book book = bookRepository.findById(id).orElseThrow();
            bookRepository.deleteById(id);
            return "The book " + book.getTitle() + " deleted successfully!";

        }catch (InvalidIDException e){
            return "Invalid ID";
        } catch (Exception e){
            return "An error occurred";
        }
    }

    @Override
    public ReqResponse updateBook(Long id, BookDTO bookDTO) {
        ReqResponse reqResponse = new ReqResponse();
        if(id==null || id <= 0){
            reqResponse.setBookDetails(null);
            reqResponse.setResponseMessage("Invalid id value!");
            reqResponse.setStatusCode(400);
            return reqResponse;
        }
        try {
            Book book = bookRepository.findById(id).orElseThrow();
            Book mappedBook = mapBookDtoToEntity(book, bookDTO);
            bookRepository.save(mappedBook);

            reqResponse.setBookDetails(bookDTO);
            reqResponse.setResponseMessage("Book details of (" + book.getTitle() + ") updated successfully");
            reqResponse.setStatusCode(200);
            return reqResponse;
        } catch (Exception e){
            reqResponse.setBookDetails(null);
            reqResponse.setStatusCode(500);
            reqResponse.setResponseMessage("An error occurred ");

            return  reqResponse;
        }
    }

    @Override
    public ReqResponse filterByPagesBook(String pages) {
        ReqResponse reqResponse = new ReqResponse();
        if(pages==null || pages.trim().isEmpty() || Integer.parseInt(pages) <= 0 ){
            reqResponse.setBookDetails(null);
            reqResponse.setResponseMessage("Invalid page value passed!");
            reqResponse.setStatusCode(400);
            return reqResponse;
        }
        try{
            List<BookDTO> mappedBook = bookRepository.findAll()
                    .stream()
                    .map(book -> {
                        BookDTO bookDTO = new BookDTO();

                        return mapBookEntitytoBookDTO(book, bookDTO);
                    })
                    .filter(bookDTO1 -> {
                        int bookPages = Integer.parseInt(pages);
                        int savedBookPages = Integer.parseInt(bookDTO1.getPages());
                        return savedBookPages < bookPages;
                    }).collect(Collectors.toList());

            reqResponse.setBookDetailsList(mappedBook);
            reqResponse.setResponseMessage("All books with paged below " + pages + " in the catalog");
            reqResponse.setStatusCode(200);

            return  reqResponse;
        }catch (Exception e) {
            reqResponse.setBookDetails(null);
            reqResponse.setStatusCode(500);
            reqResponse.setResponseMessage("An error occurred ");

            return reqResponse;
        }
    }

    @Override
    public ReqResponse filterByCostBook(int cost) {
        return null;
    }
}
