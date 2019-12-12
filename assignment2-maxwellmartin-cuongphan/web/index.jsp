<%--
  Created by IntelliJ IDEA.
  User: maxma
  Date: 10/24/2019
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<form class="index-box" action="process" method="post">
    <input type="hidden" name="action" value="insert">
    <label>First name:</label><input type="text" class="index-textboxes" name="fnText" required><br>
    <label>Last name:</label><input type="text" class="index-textboxes" name="lnText" required><br>
    <label>Username:</label><input type="text" class="index-textboxes" name="unText" required><br>
    <label>Password:</label><input type="password" class="index-textboxes" name="pwText" required><br>
    <input class="index-submit" type="submit" value="SignUp">
</form>
</body>
</html>
