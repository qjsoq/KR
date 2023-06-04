package com.example.kursach.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositoryDeleteInfo {
    public static void DeleteBook(String id) throws SQLException, ClassNotFoundException {
        Connection connection = Repository.getConnection();
        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
    }
}
