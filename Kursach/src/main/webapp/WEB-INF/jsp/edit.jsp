<%@ page import="com.example.kursach.model.Book" %>
<%@ page import="com.example.kursach.services.BookService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% String id = request.getParameter("id");%>
<%
  Book book = BookService.findBook(id);
  request.getSession().setAttribute("selectedBook", book);
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>User Apartments</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .edit-form {
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .form-row {
      margin-bottom: 20px;
    }

    .form-row label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .form-row input[type="text"],
    .form-row input[type="number"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .form-row input[type="submit"] {
      background-color: #4CAF50;
      color: #ffffff;
      border: none;
      border-radius: 5px;
      padding: 10px 20px;
      cursor: pointer;
    }
  </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
  <div class="edit-form">
    <h2>Edit Book</h2>
    <form action="edit" method="post">
      <input type="hidden" name="id" value="${selectedBook.getId()}">
      <div class="form-row">
        <label>Title:</label>
        <input type="text" name="title" value="${selectedBook.getTitle()}" required>
      </div>
      <div class="form-row">
        <label>Author:</label>
        <input type="text" name="author" value="${selectedBook.getAuthor()}" required>
      </div>
      <div class="form-row">
        <label>Description:</label>
        <input type="text" name="description" value="${selectedBook.getDescription()}" required>
      </div>
      <div class="form-row">
        <label>Keyword:</label>
        <input type="text" name="keyword" value="${selectedBook.getKeyWords()}" required>
      </div>
      <div class="form-row">
        <label>Genre:</label>
        <input type="text" name="genre" value="${selectedBook.getGenre()}" required>
      </div>
      <div class="form-row">
        <label>Image path from internet:</label>
        <input type="text" name="imgPath" value="${selectedBook.getImgPath()}" required>
      </div>

      <div class="form-row">
        <input type="submit" value="Update">
      </div>
    </form>
  </div>
</div>
</body>
</html>