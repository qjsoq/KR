package com.example.kursach.repository;

import com.example.kursach.model.User;
import com.example.kursach.model.Book;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Saeco";
        String username = "root";
        String password = "12345Joj@";

        return DriverManager.getConnection(url,username,password);
    }

    public static ResultSet executeUsers() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT login, password FROM users";
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public static User findByLogin(String login) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = executeUsers();
        User user = null;
        while (resultSet.next()){
            if(resultSet.getString("login").equals(login)){
                User u = new User(resultSet.getString("login"),resultSet.getString("password"));
                user = u;
            }
        }
        return user;
    }

    public static ResultSet executeBooks() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT id, title, author, keyword, genre, imgPath, description FROM books";
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public static List<Book> findBooks() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = executeBooks();
        List<Book> books = new ArrayList<>();
        while (resultSet.next()){
            Book book = new Book(resultSet.getString("id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("keyword"),
                    resultSet.getString("genre"),
                    resultSet.getString("imgPath"),
                    resultSet.getString("description"));
            books.add(book);
        }
        return books;
    }

}
