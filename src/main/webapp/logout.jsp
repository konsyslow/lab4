<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.04.2017
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.setAttribute("login", null);
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/");
%>
