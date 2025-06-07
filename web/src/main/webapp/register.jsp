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
    <title>Register</title>
</head>
<body>

<%--user registration form--%>
<form action="./register" method="POST">
    <h2>Create Account</h2>
    <input type="text" name="name" placeholder="Full Name" required><br>
    <input type="email" name="email" placeholder="Email Address" required><br>
    <input type="text" name="phone" placeholder="Phone" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <input type="password" name="confirm_password" placeholder="Confirm Password" required><br><br>
    <button type="submit">Register</button>
</form>
<%--user navigates to login page--%>
<a href="login.jsp">Login</a>
</body>
</html>
