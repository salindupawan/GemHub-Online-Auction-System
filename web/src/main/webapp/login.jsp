<%--
  Created by IntelliJ IDEA.
  User: Mr. SP
  Date: 6/4/2025
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<%--user login form--%>
<form action="./login" method="POST">
    <h2>Create Account</h2>
    <input type="email" name="email" placeholder="Email Address" required><br>
    <input type="password" name="password" placeholder="Password" required><br><br>
    <button type="submit">Login</button>
</form>
<%--user navigates to registration page--%>
<a href="register.jsp">Register</a>
</body>
</html>
