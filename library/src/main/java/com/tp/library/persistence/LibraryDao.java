package com.tp.library.persistence;

import com.tp.library.models.Book;

import java.util.List;
import java.util.Map;

public interface LibraryDao {
    //Book copyOfBook;
    Book addBook(Book toCreate);

    Map<Integer, Book> grabBookList();

    List<Book> returnATitle(String title);

    List<Book> returnAnAuthor(String author);

    List<Book> returnAYear(int year);

    Book returnBookID(int bookID);

    void deleteBook(Integer bookID);

    Book returnedUpdatedBook(Integer bookID);

    void clearDAO();
}
