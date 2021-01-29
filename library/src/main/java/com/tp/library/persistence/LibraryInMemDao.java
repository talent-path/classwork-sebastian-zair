package com.tp.library.persistence;

import com.tp.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryInMemDao {

    List<Book> allBooks;
    public Book addBook(Book toCreate) {
        Book toAdd = new Book(toCreate);
        allBooks.add(toAdd);

        return toCreate;
    }

    // add methods later
}
