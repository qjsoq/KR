package com.example.kursach.services;

import com.example.kursach.repository.*;
import com.example.kursach.model.Book;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class BookService {
    public static void addBook(String title, String author, String keyword, String genre, String imgPath, String description)
            throws SQLException, FileNotFoundException, ClassNotFoundException {
        RepositoryAdd.addToTable(title,author, keyword, genre, imgPath, description);
    }
    public static List<Book> getAll() throws SQLException, ClassNotFoundException {
        return Repository.findBooks();
    }

    public static void deleteBook(String id) throws SQLException, ClassNotFoundException {
        RepositoryDeleteInfo.DeleteBook(id);
    }

    public static void updateInfo(String id, String title, String author, String keyword, String genre, String imgPath, String description)
            throws SQLException, ClassNotFoundException {
        RepositoryEdit.editInfo(id, title, author, keyword, genre, imgPath, description);
    }

    public static Book findBook(String id) throws SQLException, ClassNotFoundException {
        return RepositoryFindById.findById(id);
    }

    public static List<Book> searchBook(String text) throws SQLException, ClassNotFoundException {
        List<Book> allBooks = BookService.getAll();
        if(text.isEmpty()){
            return allBooks;
        }
        return allBooks.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(text)
                        || book.getAuthor().toLowerCase().contains(text)
                        || book.getKeyWords().toLowerCase().contains(text))
                .toList();
    }
}
