<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 10/16/2019
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${aDude.fnUser} ${aDude.lnUser} <br>
<table border="1">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Password</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.idUser}"/></td>
            <td><c:out value="${user.fnUser}"/></td>
            <td><c:out value="${user.lnUser}"/></td>
            <td><c:out value="${user.unUser}"/></td>
            <td><c:out value="${user.pwUser}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
