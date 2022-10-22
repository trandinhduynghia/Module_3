<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/21/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Manager Application</title>
</head>
<body>

<div style="text-align: center">
<h1>User Management</h1>
<h2>
    <a href="/users?action=create">Add New User</a>
</h2>
</div>
<div style="text-align:center; width: 100%">
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
</div>
</body>
</html>
