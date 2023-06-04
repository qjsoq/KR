package com.example.kursach.services;

import com.example.kursach.repository.Repository;
import com.example.kursach.model.User;

import java.sql.SQLException;

public class UserService {
    public static boolean checkPassword(String login, String password) throws SQLException, ClassNotFoundException {
        User user = Repository.findByLogin(login);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    public static User login(String login) throws SQLException, ClassNotFoundException {
        User user = Repository.findByLogin(login);
        return user;
    }
}
