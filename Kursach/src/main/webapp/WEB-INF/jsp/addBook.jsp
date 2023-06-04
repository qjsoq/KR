<%--
  Created by IntelliJ IDEA.
  User: асус
  Date: 5/12/2023
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="text-danger">Add new book</h1>

    <form action="add" method="post">
        <div class="form-group">
            <label class="form-label">Title</label>
            <input type="text" class="form-control" name="title">
        </div>

        <div class="form-group">
            <label class="form-label">Author</label>
            <input type="text" class="form-control" name="author">
        </div>

        <div class="form-group">
            <label class="form-label">Key Word</label>
            <input type="text" class="form-control" name="keyword">
        </div>
        <div class="form-group">
            <label class="form-label">Description</label>
            <input type="text" class="form-control" name="description">
        </div>

        <div class="form-group">
            <label class="form-label">Genre</label>
            <input type="text" class="form-control" name="genre">
        </div>
        <div class="form-group">
            <label class="form-label">Image path from internet</label>
            <input type="text" class="form-control" name="imgPath">
        </div>

        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</div>
</body>
</html>
