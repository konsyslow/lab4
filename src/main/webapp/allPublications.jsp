<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29.04.2017
  Time: 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page errorPage="error.jsp" %>--%>
<html>
<head>
    <title>allPublications</title>
</head>
<body>
<% String message = (String) request.getAttribute("value");%> <a href='logout.jsp'>Log out</a>
<h1>
    <%=message%> <%=session.getAttribute("login")%>
</h1>
<h2>
    <a href = '<%= request.getContextPath() %>/welcome'> Welcome</a>
    <a href = '<%= request.getContextPath() %>/listPublications'> My publications</a>
</h2>

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
    <c:forEach items="${requestScope.allPublications}" var="allPublications">
    <tr>
        <td><c:out value="${allPublications.id}"></c:out></td>
        <td><c:out value="${allPublications.user_id}"></c:out></td>
        <td><c:out value="${allPublications.name}"></c:out></td>
        <td><c:out value="${allPublications.genre}"></c:out></td>
        <td><input type="button" value="read" onclick="location.href = '<%= request.getContextPath() %>/reading?id=<c:out value="${allPublications.id}" />'"></td>

    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
