<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 11/4/2019
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage joining list</title>
    <link rel="stylesheet" href="css/management.css">
</head>
<body>
<div class="modify-div">
    <table border="1">
        <tr>
            <th>Userid</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p>Modify data</p>
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="modify">
        <table border="1">
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="firstName">
                </td>
                <td>
                    <input type="text" name="lastName">
                </td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <input type="submit" name="update" value="Update">
                    <input type="submit" name="delete" value="Delete">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
