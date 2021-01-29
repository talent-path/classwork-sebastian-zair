package com.tp.library.services;

import com.tp.library.models.Book;
import com.tp.library.persistence.LibraryInMemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    LibraryInMemDao dao;
    public Book createBook(Book toCreate) {

        return dao.addBook(toCreate);
    }
    // AML
    // all @Services are @Components
}
