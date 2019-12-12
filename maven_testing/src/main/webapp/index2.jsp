<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 11/20/2019
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index 2</title>
</head>
<body>
<table border="1">
    <c:forEach items="${users}" var="user" varStatus="loopCounter">
        <tr>
            <td>
                <form action="doSomething" method="post">
                    <input type="hidden" name="fromPage" value='<c:out value="${user.idUser}"/>'>
                    <label>First name:</label><c:out value="${user.fnUser}"/><br>
                    <label>Last name:</label><c:out value="${user.lnUser}"/><br>
                    <label>Username:</label><c:out value="${user.unUser}"/><br>
                    <label>Password:</label><c:out value="${user.pwUser}"/><br>
                    <input type="submit" value="Send">
                </form>
            </td>
            <c:if test="${loopCounter.count % 2 == 0}">
                <tr></tr>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
