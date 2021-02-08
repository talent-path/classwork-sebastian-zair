package com.tp.library.persistence;

import com.tp.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PostgresLibraryDao implements LibraryDao{

    // how we do JDBC connnections
    @Autowired
    JdbcTemplate template;

    @Override
    public Book addBook(Book toCreate) {


        return null;
    }

    public Book addAuthors(String[] bookAuthors){

        List<Integer> authorList = new ArrayList<>();
        for(String author: bookAuthors){
            Integer authorID = addOrRetrieve(author);
            authorList.add(authorID);
        }
    }

    private Integer addOrRetrieve(String author) {
        Integer authorID = getAuthorID(author);
        if(authorID == null){
            authorID = addAuthor(author);
        }
        return authorID;
    }

    private Integer getAuthorID(String author) {
        List<Integer> id = template.query("SELECT * \n" +
                "FROM \"Authors\" ath\n" +
                "WHERE ath.\"authorName\" = 'J.K. Rowling'");
    }

    @Override
    public Map<Integer, Book> grabBookList() {
        return null;
    }

    @Override
    public List<Book> returnATitle(String title) {
        return null;
    }

    @Override
    public List<Book> returnAnAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> returnAYear(int year) {
        return null;
    }

    @Override
    public Book returnBookID(int bookID) {
        return null;
    }

    @Override
    public void deleteBook(Integer bookID) {

    }

    @Override
    public Book returnedUpdatedBook(Integer bookID) {
        return null;
    }

    @Override
    public void clearDAO() {

    }

    private Integer addAuthor(String author){
        // not visible to service layer because of its DAO
        // called a private helper method
        // set up to add 1 author to our DB
        // these methods are great for adding specific things

      return  template.query("INSERT into \"Authors\" (\"authorName\")\n" +
                "VALUES('"+ author +"')\n" +
                "RETURNING \"authorID\";\n", new IdMapper()).get(0);
    }

    private class IdMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
           // return null;
            // always use columnLABEL version..
            // This is so that nothing get reordered later if someone comes from behind you and works on it
            // This will be a part of every DB DAO

           return  resultSet.getInt("authorID");
        }
    }
}
