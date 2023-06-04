package com.example.kursach.controller;

import com.example.kursach.model.Book;
import com.example.kursach.model.User;
import com.example.kursach.services.BookService;
import com.example.kursach.services.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FrontController", value = "/do/*")
public class FrontController extends HttpServlet {

    protected void proccess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/home":
                home(request, response);
                break;
            case "/Onlogin":
                Onlogin(request, response);
                break;
            case "/login":
                login(request, response);
                break;
            case "/logout":
                logout(request, response);
                break;
            case "/Onedit":
                Onedit(request, response);
                break;
            case "/edit":
                edit(request, response);
                break;
            case "/Onadd":
                Onadd(request, response);
                break;
            case "/add":
                add(request, response);
                break;
            case "/search":
                search(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/Ondetail":
                Ondetail(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            BookService.deleteBook(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("home");
    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuerry = request.getParameter("text");
        List<Book> foundBooks = null;
        try {
            foundBooks = BookService.searchBook(searchQuerry.toLowerCase());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("books", foundBooks);
        request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String keyword = request.getParameter("keyword");
        String genre = request.getParameter("genre");
        String imgPath = request.getParameter("imgPath");
        String description = request.getParameter("description");

        try {
            BookService.addBook(title, author, keyword, genre, imgPath, description);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("home");
    }
    protected void Ondetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/detailed.jsp").forward(request, response);
    }

    protected void Onadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null){
            request.getRequestDispatcher("/WEB-INF/jsp/login-page.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/addBook.jsp").forward(request, response);

        }
    }

    protected void Onlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login-page.jsp").forward(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("Username");
        String passwrod = request.getParameter("Password");
        try {
            if (UserService.checkPassword(login, passwrod)) {
                User user = UserService.login(login);
                request.getSession().setAttribute("user", user);
                response.sendRedirect("home");
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/login-page.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("home");
    }

    protected void Onedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null){
            request.getRequestDispatcher("/WEB-INF/jsp/login-page.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request, response);
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String keyword = request.getParameter("keyword");
        String genre = request.getParameter("genre");
        String imgPath = request.getParameter("imgPath");
        String description = request.getParameter("description");

        try {
            BookService.updateInfo(id, title, author, keyword, genre, imgPath, description);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("home");
    }

    protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Book> bookList = BookService.getAll();
            request.getSession().setAttribute("books", bookList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proccess(request, response);
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        proccess(request, response);
    }
}
