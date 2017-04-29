
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 19.04.2017
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>List</title>
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
        <th>firstName</th>
        <th>secondName</th>
        <th>lastName</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.usersInformations}" var="usersInformation">
    <tr>
        <td><c:out value="${usersInformation.id}"></c:out></td>
        <td><c:out value="${usersInformation.firstName}"></c:out></td>
        <td><c:out value="${usersInformation.secondName}"></c:out></td>
        <td><c:out value="${usersInformation.lastName}"></c:out></td>
    </tr>
    </c:forEach>
    <tbody/>
</table>
</body>
</html>

