

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Catalog</title>
    <style>
        h1, h3, p {
            font-family: 'Montserrat', sans-serif;
        }
        .container {
            background-image: url("Images/style.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
        }
        ul {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin: 0;
            padding: 0;
        }
        li {
            margin: 10px;
            padding: 20px;
            font-size: 18px;
            line-height: 1.5;
            background-color: #fff;
            border-radius: 4px;
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
            width: calc(100%/3 - 30px); /* зміна ширини елементів */
            max-width: 550px;
            box-sizing: border-box;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
        }
        .book-img {
            width: 250px;
            height: 350px;
            margin-bottom: 30px;
        }
        input[type="submit"] {
            font-size: 16px;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #3F51B5;
            color: #fff;
            border: none;
            cursor: pointer;
        }

    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <h1>Book Collection</h1>
    <p>Welcome ${Username}</p>
    <ul>
        <c:forEach var="book" items="${books}">
            <li>
                <img src="${book.getImgPath()}" class="book-img"> <!-- зображення книги -->
                <h3>${book.getTitle()}</h3>
                <p>by ${book.getAuthor()}</p>
                <form action="Ondetail" method="post">
                    <input type="hidden" value="${book.getId()}" name="id">
                    <input type="submit" value="View detailed info" />
                </form>
                <c:if test="${!empty user}">
                    <form action="delete" method="post">
                        <input type="hidden" value="${book.getId()}" name="id">
                        <input type="submit" value="Delete" />
                    </form>
                    <form action="Onedit" method="post">
                        <input type="hidden" value="${book.getId()}" name="id">
                        <input type="submit" value="Edit" />
                    </form>
                </c:if>
            </li>
        </c:forEach>
    </ul>

</div>

</body>
</html>