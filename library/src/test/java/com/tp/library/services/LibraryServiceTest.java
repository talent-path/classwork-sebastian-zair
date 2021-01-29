package com.tp.library.services;

import com.tp.library.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceTest {

    //create a service to run tests for the Service layer
    @Autowired
    LibraryService service;


    @BeforeEach
    void setup(){
        List<String> authors = new ArrayList<>();
        Book bookToCreate = new Book(1, "Harry Potter and the Deadly Coding",authors, "Penguin Publishing" );
        service.createBook(bookToCreate);
        int three = 3;

        List<String> authors1 = new ArrayList<>();
        Book bookToCreate1 = new Book(2, "Harry Potter and the Deadly Coding pt2",authors1, "Penguin Publishing2" );
        service.createBook(bookToCreate1);

        List<String> authors2 = new ArrayList<>();
        Book bookToCreate2 = new Book(3, "Harry Potter and the Deadly Coding pt3",authors2, "Penguin Publishing" );
        service.createBook(bookToCreate2);

    }

    @Test
    void createBook() {
        List<String> authors = new ArrayList<>();
        Book bookToCreate = new Book(1, "Harry Potter and the Deadly Coding",authors, "Penguin Publishing" );
        service.createBook(bookToCreate);
        int three = 3;

        List<String> authors1 = new ArrayList<>();
        Book bookToCreate1 = new Book(2, "Harry Potter and the Deadly Coding pt2",authors1, "Penguin Publishing2" );
        service.createBook(bookToCreate1);

        List<String> authors2 = new ArrayList<>();
        Book bookToCreate2 = new Book(3, "Harry Potter and the Deadly Coding pt3",authors2, "Penguin Publishing" );
        service.createBook(bookToCreate2);

        assertEquals(service.getAllBooks().size(), 12);
    }

    @Test
    void getAllBooks() {
        List<Book> allBooks = service.getAllBooks();
        assertEquals(allBooks.size(), 3);
    }

    @Test
    void getBooksByTitleGoldenPath() { // does it wor correctly if everything is right?
       List<Book> title = service.getBooksByTitle("Harry Potter and the Deadly Coding pt2");
        assertEquals(title.get(0).getTitle(), "Harry Potter and the Deadly Coding pt2");
    }

    @Test
    void  getBookByID(){
        Book bID = service.getBookByID(1);
        assertEquals(bID.getBookID(),1);
        //int five = 5;
    }
}