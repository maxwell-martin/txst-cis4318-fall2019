<%--
  Created by IntelliJ IDEA.
  beans.User: maxma
  Date: 9/29/2019
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Test Website</title>
      <link rel="stylesheet" href="css/main.css">
  </head>
  <body>
  <h1>Welcome to Baseball Cards R' Us!</h1>
  <h2>Please fill out the form to order your free items.</h2>
  <hr>
  <form action="order" method="post">
    <input type="hidden" name="fromPage" value="index">
    <label>First Name: </label><input type="text" name="firstName" required><br>
    <label>Last Name: </label><input type="text" name="lastName" required><br>
    <label>Email: </label><input type="email" name="email" required><br>
    <label>Address: </label><input type="text" name="address" required><br>
    <label>City: </label><input type="text" name="city" required><br>
    <label>State: </label><input type="text" name="state" required><br>
    <label>Zip Code: </label><input type="text" name="zipCode" required><br>
    Shipping:
    <select name="shipping">
      <option value="ground">Ground (3-5 business days)</option>
      <option value="air">Air (1-2 business days)</option>
      <option value="drone">Drone (30 minutes)</option>
    </select><br>

    <div id="cards">
        <label>Cards:</label>
        <select name="cards" size="5" multiple required>
            <option value="barryBonds">Barry Bonds</option>
            <option value="kenGriffeyJr">Ken Griffey Jr.</option>
            <option value="hankAaron">Hank Aaron</option>
            <option value="jackieRobinson">Jackie Robinson</option>
            <option value="randyJohnson">Randy Johnson</option>
        </select>
    </div>

    <label>Join mailing list? </label><input type="checkbox" name="mailingList"><br>
    <label>Would you recommend this site to a friend?</label>
    <label>Yes: </label><input type="radio" name="recommend" value="Yes" checked><label>No: </label><input type="radio" name="recommend" value="No"><br>
    <input type="submit" value="Order">
  </form>
  </body>
</html>
