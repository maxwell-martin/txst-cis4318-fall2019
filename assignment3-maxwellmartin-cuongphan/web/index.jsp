<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
    <%--Table to display products--%>
    <table>
        <tr>
            <td>
                <img src="pics/lebron-james.png">
                <%--Form to add Lebron James jersey to cart--%>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="addToCart">
                    <input type="hidden" name="productCode" value="1">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
            <td>
                <img src="pics/giannis-antetokounmpo.png">
                <%--Form to add Giannis Antetokounmpo jersey to cart--%>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="addToCart">
                    <input type="hidden" name="productCode" value="2">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <img src="pics/jayson-tatum.png">
                <%--Form to add Jayson Tatum jersey to cart--%>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="addToCart">
                    <input type="hidden" name="productCode" value="3">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
            <td>
                <img src="pics/stephen-curry.png">
                <%--Form to add Stephen Curry jersey to cart--%>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="addToCart">
                    <input type="hidden" name="productCode" value="4">
                    <input type="submit" value="Add to Cart">
                </form>
            </td>
        </tr>
    </table>
    <%--Form to checkout and view cart--%>
    <form action="cart" method="post">
        <input type="hidden" name="action" value="checkout">
        <input type="submit" value="Checkout">
    </form>
</div>
</body>
</html>
