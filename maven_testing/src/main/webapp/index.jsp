<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 10/14/2019
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="doSomething" method="post">
    <input type="hidden" name="fromPage" value="page1">
    <label>First name:</label>
    <input type="text" name="fn" required><br>
    <label>Last name:</label>
    <input type="text" name="ln" required><br>
    <label>Username:</label>
    <input type="text" name="un" required><br>
    <label>Password:</label>
    <input type="password" name="pw" required><br>
    <input type="submit" value="Sign Up">
</form>
</body>
</html>
