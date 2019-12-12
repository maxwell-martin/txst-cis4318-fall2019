<%--
  Created by IntelliJ IDEA.
  com.mydomain.max.User: mhm85
  Date: 10/28/2019
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="doSomething" method="post" enctype="multipart/form-data">
    <input type="hidden" name="fromPage" value="page1">
    <label>Firstname:</label><input type="text" name="firstName" required><br>
    <label>Lastname:</label><input type="text" name="lastName" required><br>
    <label>Picture:</label><input type="file" name="fileUp"><br>
    <input type="submit" value="Get in">
</form>
</body>
</html>
