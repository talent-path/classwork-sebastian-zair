package com.tp.library.persistence;

import com.tp.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LibraryInMemDao implements LibraryDao {

    Map<Integer, Book> allBooks = new HashMap<>();

    public LibraryInMemDao(){

    }
    //Book copyOfBook;
    @Override
    public Book addBook(Book toCreate) {
        int nextId = 0;
        for(Integer id: allBooks.keySet()){
            if(id > nextId) nextId = id;
        }
        nextId++;

        Book copy = new Book(toCreate);
        copy.setBookID(nextId);

        allBooks.put(nextId, copy);

        return new Book(copy);

    }

    @Override
    public Map<Integer, Book> grabBookList() {
        // return every book that has been created

        //List<Book> copyOfAllBooks = new ArrayList<Book>();
        Map<Integer, Book> copyOfAllBooks = new HashMap<>();
//        for(Integer id: allBooks){
//            // Currently you're iterating through all current books that exist
//            // You need to get a copy of all current books that exist
//            // --- create a new objec- WAIT Perhaps I should create that copy Object OUTSIDE of the method like alBooks..
//            Book copyOfOriginal = new Book(original);
//            copyOfAllBooks.add(copyOfOriginal);
//        }
        //copyOfAllBooks

        throw new UnsupportedOperationException();
        //return copyOfAllBooks;
    }

    @Override
    public List<Book> returnATitle(String title) {
        // have list that contains all books -- yes
        // if list contains 'title' add that book to a new list
        // return that new list to represent books with that title
        List<Book> toReturn = new ArrayList<>();
//        for (Book toCheck : allBooks) {
//            if (toCheck.getTitle().equals(title)) {
//                // return the list of books that contain that title..
//                Book copy = new Book(toCheck);
//                toReturn.add(copy);
//            }
//        }
        throw new UnsupportedOperationException();
      //  return toReturn;
    }
    @Override
    public List<Book> returnAnAuthor(String author) {
        // have a list that contains all books
        // if list contains 'author' add that book to a new list
        // return that new list to represent books with that author
//        List<Book> authors = new ArrayList<>();
//        for(Book toCheck: allBooks){
//            if(toCheck.getAuthors().equals(author)){
//                    Book copy = new Book(toCheck);
//                //String copiedAuthors = toCheck.toString();
//                authors.add(copy);
//            }
//        }
        throw new UnsupportedOperationException();
        //return authors;

       // throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> returnAYear(int year) {
        // have a list that contains all books
        // if list contains the 'year' inputted, then add a book made that year to a new list
        // return that new list that has all of the books made in that year
        List<Book> booksByYear = new ArrayList<>();

//        for(Book bookYear: allBooks){
//            if(bookYear.getYear().equals(year)){
//                Book copy = new Book(bookYear);
//                booksByYear.add(copy);
//            }
//        }
        throw new UnsupportedOperationException();
       // return booksByYear;

    }

    @Override
    public Book returnBookID(int bookID) {
        //have a list that contains all books
        // if that list contains the bookID (all IDs SHOULD be unique..?)
        // return the book with that ID
       // return allBooks.stream().filter( g -> g.getBookID().equals(bookID) ).findFirst().orElse(null);
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteBook(Integer bookID) {
        // have a list that contains all books
        // if that list contains the bookID (Unique)
        // remove that bookID from the list
        // return the book that has now been deleted
        int index = -1;
        for(int i = 0; i < allBooks.size(); i++ ){
            if(allBooks.get(i).getBookID().equals(bookID)){
                allBooks.remove(i);
            }
        }
    }

    @Override
    public Book returnedUpdatedBook(Integer bookID) {
        // have find the 'Book' in a list
        // if it is valid(not null)
        // set the book with the new data to be changed
        // return the updated book

//        Book updatedCopy;
//        for(Book toCheck: allBooks){
//            if(toCheck.getBookID().equals(bookID)){
//                updatedCopy = new Book(toCheck);
//                return updatedCopy;
//                break;
//            }
//        }
//        //return updatedCopy;
//        //throw new UnsupportedOperationException();
//        return toCheck;
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearDAO(){
       allBooks.clear();
    }
    // add methods later

    // 11L38 AM, filled Controller and Service class
    // 11:38 AM, alogorithm design created for each method in the DAO
    //
}
