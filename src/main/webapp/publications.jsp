<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.04.2017
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Publications</title>
</head>
<body>
<% String message = (String) request.getAttribute("value");%>
<h1>
    <%=message%>
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

</body>
</html>
