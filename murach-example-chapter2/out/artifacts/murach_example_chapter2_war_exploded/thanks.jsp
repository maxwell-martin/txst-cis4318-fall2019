<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 9/16/2019
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanks!</title>
</head>
<body>
    <h1>Thanks for joining our email list!</h1>

    <p>Here is the information that you entered:</p>

    <table border="2" cellpadding="5px">
        <tr>
            <th>Email:</th>
            <th>First Name:</th>
            <th>Last Name:</th>
        </tr>
        <tr>
            <td>${myUser.email}</td>
            <td>${myUser.firstName}</td>
            <td>${myUser.lastName}</td>
        </tr>
    </table>

    <br>

    <label>Email:</label><span> ${myUser.email}</span><br>
    <label>First Name:</label><span> ${myUser.firstName}</span><br>
    <label>Last Name:</label><span> ${myUser.lastName}</span><br>

    <p>To enter another email address, click on the back button in your browser or the 'Return' button shown below.</p>

    <form action="emailList" method="post">
        <input type="hidden" name="fromPage" value="thk">
        <input type="submit" value="Return">
    </form>
</body>
</html>
