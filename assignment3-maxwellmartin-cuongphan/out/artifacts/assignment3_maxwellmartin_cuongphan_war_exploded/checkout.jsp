<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div id="checkoutContainer">
        <p>Your cart:</p>
        <%--Check if Cart object in session has line items--%>
        <c:choose>
            <%--Display message when Cart has no line items--%>
            <c:when test="${empty cart.lineItems}">
                <p>There are no items in your cart.</p>
            </c:when>
            <%--Create table to display cart--%>
            <c:otherwise>
                <table id="checkoutTable">
                    <tr>
                        <th>Product</th>
                        <th class="align-right">Price</th>
                        <th class="align-right">Quantity</th>
                        <th class="align-right">Subtotal</th>
                    </tr>
                    <%--Loop through all line items and add to table--%>
                    <c:forEach items="${cart.lineItems}" var="li">
                        <tr>
                            <td>${li.product.productDescription}</td>
                            <td class="align-right">${li.product.productPrice}</td>
                            <td class="align-right">${li.quantity}</td>
                            <td class="align-right">${li.subTotal}</td>
                        </tr>
                    </c:forEach>
                </table>
                <p>Total: ${cart.total}</p>
            </c:otherwise>
        </c:choose>
        <div id="checkoutButtons">
            <table id="checkoutButtonsTable">
                <tr>
                    <td>
                        <%--Form to continue shopping--%>
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="home">
                            <input type="submit" value="Continue Shopping">
                        </form>
                    </td>
                    <td>
                        <%--Form to clear cart--%>
                        <form action="cart" method="post">
                            <input type="hidden" name="action" value="clearCart">
                            <input type="submit" value="Clear Cart">
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
