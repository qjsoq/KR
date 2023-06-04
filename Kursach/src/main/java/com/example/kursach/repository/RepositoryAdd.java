package com.example.kursach.repository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryAdd {
    public static void addToTable(String title, String author, String keyword, String genre, String imgPath, String description) throws SQLException, ClassNotFoundException, FileNotFoundException {
        Connection connection = Repository.getConnection();
        String sql = "INSERT INTO books (title,author,keyword, genre, imgPath, description) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,author);
        statement.setString(3,keyword);
        statement.setString(4,genre);
        statement.setString(5,imgPath);
        statement.setString(6,description);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
