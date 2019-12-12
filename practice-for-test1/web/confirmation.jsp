<%--
  Created by IntelliJ IDEA.
  beans.User: maxma
  Date: 9/29/2019
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
    <h1>Thank you for placing an order.</h1>
    <p>Below are your order details.</p>
    <hr>
    <table border="2">
        <tr>
            <th>First Name</th>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <th>LastName</th>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${user.email}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${user.address}</td>
        </tr>
        <tr>
            <th>City</th>
            <td>${user.city}</td>
        </tr>
        <tr>
            <th>State</th>
            <td>${user.state}</td>
        </tr>
        <tr>
            <th>Zip Code</th>
            <td>${user.zipCode}</td>
        </tr>
        <tr>
            <th>Shipping</th>
            <td>${order.shipping}</td>
        </tr>
        <tr>
            <th>Cards:</th>
            <td>
                <%@ page import="beans.Order" %>
                <%
                    Order order = (Order) request.getAttribute("order");
                    String results = "";

                    for (String card: order.getCards()) {
                        results += card + " | ";
                    }
                %>
                <%= results %>
            </td>
        </tr>
        <tr>
            <th>Mailing List:</th>
            <td>${user.mailingList}</td>
        </tr>
        <tr>
            <th>Recommendation:</th>
            <td>${user.recommendToFriend}</td>
        </tr>
    </table>
</body>
</html>
