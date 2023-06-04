<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" %>
<header style="display: flex; justify-content: space-between; align-items: center; background-color: #eee; padding: 10px;">
  <h1 class="project-title" style="margin: 0;">*** The Best Library EVER! ***</h1>
  <form class="search-form" action="search" style="display: flex; margin: 0;">
    <input class="search-text" type="text" name="text" value="${text}" style="padding: 5px; font-size: 16px; border: 1px solid #ccc; border-radius: 3px; margin-right: 10px;" />
    <input class="search-button" type="submit" value="Search" style="padding: 5px 10px; background-color: #008cba; color: #fff; border: none; border-radius: 3px; cursor: pointer;" />
  </form>
  <a href="home">Catalog</a>
  <div style="display: flex; align-items: center;">
    <c:if test="${!empty user}">
      <form class="login-form" action="logout" method="get" style="display: flex; align-items: center; margin: 0 10px;">
        <c:out value="${user.getLogin()}"/><br>
        <input type="submit" value="Log Out" style="padding: 5px 10px; background-color: #008cba; color: #fff; border: none; border-radius: 3px; cursor: pointer;" />
      </form>
      <a href="Onadd" style="padding: 5px 10px; background-color: #008cba; color: #fff; border: none; border-radius: 3px; cursor: pointer; text-decoration: none;">Add book</a>
    </c:if>
    <c:if test="${empty user}">
      <a href="Onlogin" style="padding: 5px 10px; background-color: #008cba; color: #fff; border: none; border-radius: 3px; cursor: pointer; text-decoration: none;">Login</a>
    </c:if>
  </div>
</header>
