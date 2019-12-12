<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 11/11/2019
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 2</title>
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.userSession != null}">
            <c:out value="${sessionScope.userSession.firstName}"/>
            <c:out value="${pageContext.session.id}"/>
        </c:when>
        <c:otherwise>
            <%--<c:out value="${'Please go to the first page.'}"/>--%>
            <c:redirect url="index.jsp"/>
        </c:otherwise>
    </c:choose>

    <p>${Message}</p>

    <form action="doSomething" method="post">
        <input type="hidden" name="fromPage" value="page2">
        <input type="submit" value="Blahblah">
    </form>
</body>
</html>
