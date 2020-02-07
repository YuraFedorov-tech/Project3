<%--
  Created by IntelliJ IDEA.
  User: 00sna
  Date: 02.02.2020
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>crud</title>

</head>
<body>

<form method="post" action="/deleteUser">
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
                <td>
                    <a href="/updateUser?id=<c:out value='${User.id}' />">Edit</a>
                </td>
                <!---------Check box Delete----------->
                <td id="deleteUser">
                    <input type="checkbox" name="Delete" value=${User.id}>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!------------ button Clear Cart--------------->
    <div class="button-update">
        <input type="submit" name="Delete" value="Delete selected users">
    </div>
</form>
<h5>it`s clever man</h5>
</br>
</br>
<h4>add User in dataBase</h4>
<form method="post" action="/work">
    <label for="name">name
        <input id="name" name="name">
    </label></br>
    <label for="color">color
        <input id="color" name="color">
    </label></br>
    <label for="age">age
        <input id="age" name="age">
    </label></br>
    <input type="submit" value="inside in JDBC">
</form>
</br>
</br>

</body>
</html>
</body>
</html>
