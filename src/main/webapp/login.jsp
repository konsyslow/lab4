<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.04.2017
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Literary portal</title>
</head>
<body>
<form method="post">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Yet Not Registered!! <a href="reg.jsp">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
