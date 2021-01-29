package com.tp.library.persistence;

import com.tp.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDao {

    List<Book> allBooks;
    //Book copyOfBook;
    public Book addBook(Book toCreate) {
        Book toAdd = new Book(toCreate);
        allBooks.add(toAdd);

        return toCreate;
    }

    public List<Book> grabBookList() {
        // return every book that has been created

        List<Book> copyOfAllBooks = new ArrayList<Book>();
        for(Book original: allBooks){
            // Currently you're iterating through all current books that exist
            // You need to get a copy of all current books that exist
            // --- create a new objec- WAIT Perhaps I should create that copy Object OUTSIDE of the method like alBooks..
            Book copyOfOriginal = new Book(original);
            copyOfAllBooks.add(copyOfOriginal);
        }
        //copyOfAllBooks

        return copyOfAllBooks;
    }

    public List<Book> returnATitle(String title) {
        // have list that contains all books
        // if list contains 'title' add that book to a new list
        // return that new list to represent books with that title

    }

    public List<Book> returnAnAuthor(List<String> author) {
        // have a list that contains all books
        // if list contains 'author' add that book to a new list
        // return that new list to represent books with that author

    }

    public List<Book> returnAYear(int year) {
        // have a list that contains all books
        // if list contains the 'year' inputted, then add a book made that year to a new list
        // return that new list that has all of the books made in that year

    }

    public Book returnBookID(int bookID) {
        //have a list that contains all books
        // if that list contains the bookID (all IDs SHOULD be unique..?)
        // return the book with that ID
    }

    public Book returnDeletedBook(int bookID) {
        // have a list that contains all books
        // if that list contains the bookID (Unique)
        // remove that bookID from the list
        // return the book that has now been deleted
    }

    public Book returnedUpdatedBook(Book book) {
        // have find the 'Book' in a list
        // if it is valid(not null)
        // set the book with the new data to be changed
        // return the updated book
    }

    // add methods later

    // 11L38 AM, filled Controller and Service class
    // 11:38 AM, alogorithm design created for each method in the DAO
    //
}
