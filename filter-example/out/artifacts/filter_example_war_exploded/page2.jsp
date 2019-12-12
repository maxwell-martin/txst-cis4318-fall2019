<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 11/18/2019
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page2</title>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String userEmail = request.getParameter("userEmail");

    out.println(userName);
    out.println(userEmail);
%>
</body>
</html>
