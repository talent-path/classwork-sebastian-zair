package com.tp.library.controllers;

import com.tp.library.models.Book;
import com.tp.library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    // CONTROL
    // The only way the user can INTERACT with your applciation are through the CONTROLLER
    // s = lists
    // get requests from the Internet is the controller layer

    // Auto-generating methods all the way down from the top down level (controller to dao)
    // is a main cycle to pay attention to for the project

    // @RequestBody takes in Objects from the HTTP request -
    //      -

    // 5:34 PM TO:DO = test last 4 methods, and map last 4 methods :)

    @Autowired // This acts as auto instantiation
    LibraryService service;

    @GetMapping("/createbook/")
    public Book createBook(@RequestBody Book toCreate){

       Book toReturn = service.createBook(toCreate);

       return toReturn;

    }
    @GetMapping("/allbooks/")
    public List<Book> getAllBooks(){

        List<Book> listOfBooks = service.getAllBooks();

        return listOfBooks;

    }
    @GetMapping("books/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title){

        List<Book> returnedTitle = service.getBooksByTitle(title);
        //throw new UnsupportedOperationException();
        return returnedTitle;
    }
    //@GetMapping
    public List<Book> getBooksByAuthor(List<String> author){

        List<Book> returnedAuthor = service.getBooksByAuthor(author);
        //throw new UnsupportedOperationException();
        return returnedAuthor;
    }
    @GetMapping("books/year")
    public List<Book> getBooksByYear(int year){

       List<Book> returnedYear = service.getBooksByYear(year);
       // throw new UnsupportedOperationException();
        return returnedYear;
    }
    @GetMapping("book/bookid")
    public Book getBookByID(int bookID){

        Book bID = service.getBookByID(bookID);
        //throw new UnsupportedOperationException();
        return bID;
    }
    //@DeleteMapping
    public void deleteBookByID(int bookID){

        service.deleteBookByID(bookID);
       // throw new UnsupportedOperationException();

    }
    //@PutMapping
    public Book updateBook(Book book){

        Book updatedBook = service.updateBook(book);
        //throw new UnsupportedOperationException();
        return updatedBook;
    }

    //
}
