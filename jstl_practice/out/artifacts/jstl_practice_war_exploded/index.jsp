<%--
  Created by IntelliJ IDEA.
  User: mhm85
  Date: 10/7/2019
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="myclasses.Person" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <c:out value="${ 'Hello World!' }"/><br>

    <c:out value="${ 200/2 }"/><br>

    <c:set var="salary" value="${2000*2}"/>
    <c:out value="${'Your salary is: '} ${salary}"/><br>

    <br>
    <hr>

    <%
        ArrayList myList = new ArrayList();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        request.setAttribute("numbers", myList);
    %>

    <c:forEach items="${numbers}" var="aValue">
        <p>Item <c:out value="${aValue}"/></p>
    </c:forEach>

    <br>
    <hr>

    <ul>
        <c:forEach items="${numbers}" var="aValue">
            <li>Item <c:out value="${aValue}"/></li>
        </c:forEach>
    </ul>

    <br>
    <hr>

    <table border="1">
        <tr>
            <th>Numbers</th>
        </tr>
        <c:forEach items="${numbers}" var="aValue">
            <tr><td><c:out value="${aValue}"/></td></tr>
        </c:forEach>
    </table>

    <br>
    <hr>

    <%
        ArrayList<Person> myListOfPersons = new ArrayList<>();

        myListOfPersons.add(new Person("Joe", "Smith", 50000));
        myListOfPersons.add(new Person("Sally", "Thomas", 100000));
        myListOfPersons.add(new Person("Arnold", "Johnson", 30000));
        myListOfPersons.add(new Person("Bruce", "Lee", 20000));
        myListOfPersons.add(new Person("Michelle", "Anderson", 250000));

        request.setAttribute("persons", myListOfPersons);
    %>

    <table border="2">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Salary</th>
        </tr>
        <c:set var="total" value="${0.0}"/>
        <c:forEach items="${persons}" var="person">
            <tr>
                <td><c:out value="${person.firstName}"/></td>
                <td><c:out value="${person.lastName}"/></td>
                <td><fmt:formatNumber value="${person.salary}" type="currency"/></td>
            </tr>
            <c:set var="total" value="${total + person.salary}"/>
        </c:forEach>
        <tr>
            <th colspan="2">Total of all salaries</th>
            <td><fmt:formatNumber value="${total}" type="currency"/></td>
        </tr>
    </table>
</body>
</html>
