<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.04.2017
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Publications</title>
</head>
<body>
<% String message = (String) request.getAttribute("value");%> <a href='logout.jsp'>Log out</a>
<h1>
    <%=message%> <%=session.getAttribute("userLogin")%>
</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>user_id</th>
        <th>name</th>
        <th>genre</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.publications}" var="publications">
    <tr>
        <td><c:out value="${publications.id}"></c:out></td>
        <td><c:out value="${publications.user_id}"></c:out></td>
        <td><c:out value="${publications.name}"></c:out></td>
        <td><c:out value="${publications.genre}"></c:out></td>
    </tr>
    </c:forEach>
</table>
<h2>My publications</h2>
<form action="${pageContext.request.contextPath}/publications" method="post">
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>user_id</th>
        <th>name</th>
        <th>genre</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.usersPublications}" var="usersPublications">
    <tr>
        <td><c:out value="${usersPublications.id}"></c:out></td>
        <td><c:out value="${usersPublications.user_id}"></c:out></td>
        <td><c:out value="${usersPublications.name}"></c:out></td>
        <td><c:out value="${usersPublications.genre}"></c:out></td>
        <td><button type="submit" name="button" value="update">update</button></td>
        <td><button type="submit" name="button" value="delete">delete</button></td>
    </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
