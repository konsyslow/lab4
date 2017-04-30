<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.04.2017
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page errorPage="error.jsp" %>--%>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<% String message = (String) request.getAttribute("value");%> <a href='logout.jsp'>Log out</a>
<h1>
    <%=message%> <%=session.getAttribute("login")%>
</h1>
<table border="1">
    <thead>
    <tr>
        <th> <a href = '<%= request.getContextPath() %>/listPublications'> My publications</a> </th>
        <th> <a href = '<%= request.getContextPath() %>/allPublications'> All Publications</a> </th>
    </tr>
    </thead>
</table>


</body>
</html>
