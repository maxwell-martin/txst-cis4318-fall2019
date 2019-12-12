<%--
  Created by IntelliJ IDEA.
  User: maxma
  Date: 9/16/2019
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Homepage</title>
    <link rel="stylesheet" href="css/main.css">
  </head>
  <body>
  <form class="box" action="employeeInformation" method="post">
    <input type="hidden" name="fromPage" value="index">
    <label for="fnText">First name:</label>
    <input type="text" id="fnText" name="fnText" required><br>
    <label for="lnText">Last name:</label>
    <input type="text" id="lnText" name="lnText" required><br>
    <label for="msText">Monthly salary:</label>
    <input type="text" id="msText" name="msText" required><br>
    <label for="mpText">Months of payments:</label>
    <input type="text" id="mpText" name="mpText" required><br>
    <input class="submit-index" type="submit" value="Calculate">
  </form>
  </body>
</html>
