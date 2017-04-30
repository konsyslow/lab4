<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.04.2017
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page errorPage="error.jsp" %>--%>
<html>
<head>
    <title>Publications</title>
</head>
<h2><a href='logout.jsp'>Log out</a></h2>
<body>
<form method="post">
    <input type="text" name="id" value="<%= request.getAttribute("id")%>" >id</input>
    <input type="text" name="name" value="<%= request.getAttribute("name")%>">name</input>
    <input type="text" name="genre" value="<%= request.getAttribute("genre") %>">genre</input>
    <input type="text" name="text" value="<%= request.getAttribute("text") %>">text</input>
    <input type="submit" value="Save" />
</form>

</body>
</html>
