<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 9/30/2019
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <h1>Sign Up providing the following information</h1>
    <br>
    <br>
    <form action="enter" method="post">
        <input type="hidden" name="fromPage" value="signUp">
        <label>Username </label><input type="text" name="username" required><br>
        <label>Password </label><input type="password" name="password" required><br>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
