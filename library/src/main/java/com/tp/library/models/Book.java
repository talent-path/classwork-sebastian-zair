package com.tp.library.models;

import java.util.ArrayList;
import java.util.List;

public class Book {

    String title;
    // multiple authors
    List<String> authors;
    //String publisher;
    Integer bookID;
    Integer year;

    public Book(Integer bookID, String title, List<String> authors, Integer year){
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
       // this.publisher = publisher;
        this.year = year;

        // must needs for  the book

    }

    public Book(String title, List<String> authors, Integer year){
        this.bookID = bookID;
        this.title = title;
        this.authors = authors;
        // this.publisher = publisher;
        this.year = year;

        // must needs for  the book

    }


    // represent the information in a book we WANT to copy..
    public Book(Book toCopy){

        this.bookID = toCopy.getBookID();
        this.authors = new ArrayList<>();
        this.authors.addAll(toCopy.getAuthors());
        //this.authors = new ArrayList<>();
        //this.authors.add(authors);
        this.title = toCopy.getTitle();
        //this.publisher = toCopy.getPublisher();
        this.year = toCopy.getYear();

    }

    public Book(){
    // use default constructors for when you need data types to be represents as their default values (0, false, null)
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

    public void setAuthors(List<String>  authors) {

        this.authors = authors;
    }



    //public void setPublisher(String publisher) {

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    // A book

}
