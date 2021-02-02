package com.tp.library.services;

import com.tp.library.models.Book;
import com.tp.library.persistence.LibraryDao;
import com.tp.library.persistence.LibraryInMemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    LibraryDao dao;
    public Book createBook(Book toCreate) {

        return dao.addBook(toCreate);
    }

    public List<Book> getAllBooks() {

        return dao.grabBookList();
    }

    public List<Book> getBooksByTitle(String title) {
        // Create the logic for users in here
        return dao.returnATitle(title);
    }

    public List<Book> getBooksByAuthor(String author) {
       return dao.returnAnAuthor(author);
    }

    public List<Book> getBooksByYear(int year) {
        return dao.returnAYear(year);
    }

    public Book getBookByID(int bookID) {
       return dao.returnBookID(bookID);
    }

    public void deleteBookByID(int bookID) {
        dao.deleteBook(bookID);
    }

    public Book updateBook(Integer bookID) {
        return dao.returnedUpdatedBook(bookID);
    }
    // AML
    // all @Services are @Components
}
