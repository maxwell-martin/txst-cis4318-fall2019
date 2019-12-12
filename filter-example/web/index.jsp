<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 11/18/2019
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="doSomething" method="post">
    <input type="hidden" value="page1">
    <label>Name:</label><input type="text" name="userName" required><br>
    <label>Email:</label><input type="text" name="userEmail" required><br>
    <input type="submit" value="Send">
</form>
</body>
</html>
