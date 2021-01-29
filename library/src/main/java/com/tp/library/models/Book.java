package com.tp.library.models;

import java.util.ArrayList;
import java.util.List;

public class Book {

    String title;
    // multiple authors
    List<String> authors;
    String publisher;
    Integer bookID;

    public Book(Integer bookID, String title, List<String> authors, String publisher){
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;

        // must needs for  the book

    }



    // represent the information in a book we WANT to copy..
    public Book(Book toCopy){

        this.bookID = toCopy.getBookID();
        this.authors = new ArrayList<>();
        this.authors.addAll(toCopy.getAuthors());
        this.title = toCopy.getTitle();
        this.publisher = toCopy.getPublisher();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String>  author) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    // A book

}
