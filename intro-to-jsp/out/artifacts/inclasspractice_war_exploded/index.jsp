<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 9/9/2019
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Index Form</title>
      <link rel="stylesheet" href="css/mystyle.css">
  </head>
  <body>
    <div id="formDiv">
        <form action="showdata.jsp" method="post">
            <label for="firstName">First name:</label>
            <input id="firstName" type="text" name="firstName" required><br>
            <label for="lastName">Last name:</label>
            <input id="lastName" type="text" name="lastName" required><br>
            <fieldset>
                <legend>What is your gender?</legend>
                <input type="radio" name="gender" value="male" checked>Male<br>
                <input type="radio" name="gender" value="female">Female<br>
            </fieldset>
            <input type="submit" value="Submit now">
        </form>
    </div>
  </body>
</html>
