<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 9/9/2019
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Data 2</title>
</head>
<body>
    <%!
        int a=10;
        int b=5;
        int aSum;
    %>

    <%
        aSum = a + b;
    %>

    The sum is <%=aSum%>

    <br>

    <%
        for(int i=0; i<=10; i++)
        {
    %>
        <h2>hello, hello, hello, is there anybody out there?</h2>
    <%
        }
    %>
</body>
</html>
