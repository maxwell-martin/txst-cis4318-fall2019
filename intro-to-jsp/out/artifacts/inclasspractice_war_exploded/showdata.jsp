<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 9/9/2019
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Data</title>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>
    <%
        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String gender = request.getParameter("gender");

        out.println(fn);
        out.println(ln);
        out.println(gender);
    %>
</body>
</html>
