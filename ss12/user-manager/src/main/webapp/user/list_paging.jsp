<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/24/2022
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li><a>hello ${sessionScope.acc.user}</a></li>
    <c:if test="${sessionScope.acc != null}">
        <li><a href="/Logout">Logout</a></li>
    </c:if>
    <c:if test="${sessionScope.acc == null}">
        <li><a href="/Login">Login</a></li>
    </c:if>

    <c:if test="${sessionScope.acc.idAdmin == 1}">
        <li><a href="/Product">Product</a></li>
    </c:if>
</ul>
<div style="text-align: center">
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</div>
<div style="text-align:center; width: 100%">
    <form action="users">
        Search:<input type="text" hint="search" value="${requestScope.q}" name="q">
        <button type="get">Submit</button>
    </form>
    <table style="text-align: center; width: 50%; border: 1px; border-color: black">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="user1" items="${listUser}">
            <tr>
                <td><c:out value="${user1.id}"/></td>
                <td><c:out value="${user1.name}"/></td>
                <td><c:out value="${user1.email}"/></td>
                <td><c:out value="${user1.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user1.id}">Edit</a>
                    <a href="/users?action=delete&id=${user1.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <table style="text-align: center">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="users?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

</div>
</body>
</html>
<script>

</script>
