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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
                    <button type="button" onclick="infoDelete('${user1.getId()}','${user1.getName()}')" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/users" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="id" id="deleteId" hidden>
                    <span class="text-danger">Bạn có muốn xoá user </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>

    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("deleteName").innerText=name;
        document.getElementById("deleteId").value=id;
    }
</script>
</body>
</html>
