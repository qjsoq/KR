package com.example.kursach.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryEdit {
    public static void editInfo(String id, String title, String author, String keyword, String genre, String imgPath, String description) throws SQLException, ClassNotFoundException {
        Connection connection = Repository.getConnection();
        String sql = "UPDATE books SET title = ?, author = ?, keyword = ?, genre = ?, imgPath = ?, description = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setString(3, keyword);
        preparedStatement.setString(4, genre);
        preparedStatement.setString(5, imgPath);
        preparedStatement.setString(6, description);
        preparedStatement.setString(7, id);
        preparedStatement.executeUpdate();
    }
}
