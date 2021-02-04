package com.tp.library.controllers;

import com.tp.library.models.Book;
import com.tp.library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    // 1:00 PM Jan 30 = test last 2 methods and map last 2 methods :)

    @Autowired // This acts as auto instantiation
    LibraryService service;

    @GetMapping("/createbook/")
    public ResponseEntity createBook(@RequestBody Book toCreate){
        // verify why we use ResponseEntity over the 'Book' object
        // if there is an exception there will be no Book to return
       Book toReturn = service.createBook(toCreate);

       // also check for unsuccessful


       return ResponseEntity.ok(toReturn);

    }
    @GetMapping("/allbooks/")
    public ResponseEntity getAllBooks(){

        List<Book> listOfBooks = service.getAllBooks();

        return ResponseEntity.ok(listOfBooks);

       // return listOfBooks;

    }
    @GetMapping("books/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title){

        List<Book> returnedTitle = service.getBooksByTitle(title);
        //throw new UnsupportedOperationException();
        return returnedTitle;
    }
    @GetMapping("books/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){

        List<Book> returnedAuthor = service.getBooksByAuthor(author);
        //throw new UnsupportedOperationException();
        return returnedAuthor;
    }
    @GetMapping("books/year/{year}")
    public List<Book> getBooksByYear(@PathVariable int year){

       List<Book> returnedYear = service.getBooksByYear(year);
       // throw new UnsupportedOperationException();
        return returnedYear;
    }
    @GetMapping("book/bookid/{bookID}")
    public Book getBookByID(@PathVariable int bookID){

        Book bID = service.getBookByID(bookID);
        //throw new UnsupportedOperationException();
        return bID;
    }
    @DeleteMapping("book/bookid/delete/{bookID}")
    public void deleteBookByID(@PathVariable int bookID){

        service.deleteBookByID(bookID);
       // throw new UnsupportedOperationException();

    }
    @PutMapping("book/update/{bookID}")
    public Book updateBook(@PathVariable Integer bookID){

        Book updatedBook = service.updateBook(bookID);
        //throw new UnsupportedOperationException();
        return updatedBook;
    }

    //
}
