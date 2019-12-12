<%--
  Created by IntelliJ IDEA.
  User: maxma
  Date: 9/16/2019
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <div class="box">
        <p>${employee.firstName} ${employee.lastName}, your yearly salary is ${employee.yearlySalary}</p>
        <form action="welcome" method="post">
            <input type="hidden" name="fromPage" value="results">
            <input class="submit-results" type="submit" value="Go to last page">
        </form>
    </div>
</body>
</html>
