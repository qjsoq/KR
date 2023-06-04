<%@ page import="com.example.kursach.services.BookService" %>
<%@ page import="com.example.kursach.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    Book book = BookService.findBook(id);
    request.getSession().setAttribute("detailedBook", book);
%>
<html>
<head>
    <title>Info</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333333;
            margin-top: 0;
        }

        img {
            max-width: 300px;
            height: auto;
            margin-bottom: 10px;
        }

        .genre {
            font-style: italic;
            color: #666666;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>

<h1>${detailedBook.getTitle()}</h1>
<form action="home" method="get">
    <button type="submit">Back</button>
</form>
<img src="${detailedBook.getImgPath()}">
<p class="genre">${detailedBook.getGenre()}</p>
${detailedBook.getDescription()}
</body>
</html>
