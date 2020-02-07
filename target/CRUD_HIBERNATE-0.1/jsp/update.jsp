<%--
  Created by IntelliJ IDEA.
  User: 00sna
  Date: 03.02.2020
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>color</th>
        <th>age</th>
    </tr>
    <c:forEach items="${usersInJDBC}" var="User">
        <tr>
            <th>${User.id}</th>
            <th>${User.name}</th>
            <th>${User.color}</th>
            <th>${User.age}</th>
        </tr>
    </c:forEach>
</table>
</br>
</br>
<h5>Input new parametrs</h5>
<h4>update User in dataBase</h4>
<form method="post" action="/updateUser">
    <label for="name">name
        <input id="name" name="name">
    </label></br>
    <label for="color">color
        <input id="color" name="color">
    </label></br>
    <label for="age">age
        <input id="age" name="age">
    </label></br>
    <input type="submit" value="update in JDBC">
</form>

</body>
</html>
