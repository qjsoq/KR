package com.example.kursach.repository;

import com.example.kursach.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryFindById {
    public static Book findById(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = Repository.executeBooks();
        Book book = null;
        while (resultSet.next()){
            if(resultSet.getString("id").equals(id)){
               book = new Book(resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("keyword"),
                        resultSet.getString("genre"),
                        resultSet.getString("imgPath"),
                       resultSet.getString("description"));

            }
        }
        return book;
    }
}
