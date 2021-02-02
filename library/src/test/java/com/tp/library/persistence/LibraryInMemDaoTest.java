package com.tp.library.persistence;

import com.tp.library.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LibraryInMemDaoTest {

    @Autowired
    LibraryInMemDao dao;

    @BeforeEach
    public void reset(){
        // this is for having fresh and new tests!
      dao = new LibraryInMemDao();
    }

    @Test
    void testAddBookGoldenPath(){
        // 1.) Arrange
        // we'll need a book object to create and test to see if functionality works as it should
        // if David or Eliot stop's by..ask if the point of our empty constructor is simply for tests such as this..
        Book bookTest1 = new Book();
        bookTest1.setTitle("Book1");
        bookTest1.setYear(2020);
        List<String> authors = new ArrayList<>();
        authors.add("Author1");
        authors.add("Author2");

        bookTest1.setAuthors(authors);

        // 2.) Act
       Book returnedBook =  dao.addBook(bookTest1);
        // 3.) Assert
        assertEquals(1, returnedBook.getBookID());
        
    }
}
