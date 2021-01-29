package com.tp.library.controllers;

import com.tp.library.models.Book;
import com.tp.library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    // CONTROL
    // The only way the user can INTERACT with your applciation are through the CONTROLLER
    // s = lists
    // get requests from the Internet is the controller layer

    // Auto-generating methods all the way down from the top down level (controller to dao)
    // is a main cycle to pay attention to for the project

    @Autowired // This acts as auto instantiation
    LibraryService service;

    @GetMapping("/createbook/")
    public Book createBook(@RequestBody Book toCreate){

       Book toReturn = service.createBook(toCreate);

       return toReturn;

    }

    public List<Book> getAllBooks(){
        throw new UnsupportedOperationException();
    }

    public List<Book> getBooksByTitle(String title){
        throw new UnsupportedOperationException();
    }

    public List<Book> getBooksByAuthor(String author){
        throw new UnsupportedOperationException();
    }

    public List<Book> getBooksByYear(int year){
        throw new UnsupportedOperationException();
    }

    public Book getBookByID(int bookID){
        throw new UnsupportedOperationException();
    }

    public Book deleteBookByID(int bookID){
        throw new UnsupportedOperationException();
    }

    public Book updateBook(Book book){
        throw new UnsupportedOperationException();
    }

    //
}
