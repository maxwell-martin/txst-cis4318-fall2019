<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxma
  Date: 10/24/2019
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="results-box">
    <form action="process" method="post">
        <input type="hidden" name="action" value="modify">
        <table class="results-container-table">
            <tr>
                <td>
                    <table class="results-table">
                    <tr>
                        <th>iduser</th>
                        <th>fnuser</th>
                        <th>lnuser</th>
                        <th>unuser</th>
                        <th>pwuser</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td class="td-right"><c:out value="${user.user_id}"/></td>
                            <td class="td-padleft"><c:out value="${user.user_fn}"/></td>
                            <td class="td-padleft"><c:out value="${user.user_ln}"/></td>
                            <td class="td-padleft"><c:out value="${user.user_un}"/></td>
                            <td class="td-right"><c:out value="${user.user_pw}"/></td>
                        </tr>
                    </c:forEach>
                    </table>
                </td>
                <td>
                    <table class="results-submitbtns-table">
                        <tr><td><input type="submit" class="results-submit" name="delete" value="Delete"></td></tr>
                        <tr><td><input type="submit" class="results-submit" name="update" value="Update"></td></tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="firstTxt" type="text" class="results-textboxes" placeholder="X" name="idText">
                    <input type="text" class="results-textboxes" placeholder="X" name="fnText">
                    <input type="text" class="results-textboxes" placeholder="X" name="lnText">
                    <input type="text" class="results-textboxes" placeholder="X" name="unText">
                    <input type="password" class="results-textboxes" placeholder="X" name="pwText">
                    <p>${message}</p>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
