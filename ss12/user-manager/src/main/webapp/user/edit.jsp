<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/23/2022
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center">
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</div>
<div>
    <form method="post">
        <table>
            <caption><h2>Edit User</h2></caption>
            <c:if test="${user != null}">

            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" value="<c:out value='${user.name}'/>">
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" value="<c:out value='${user.email}'/>">
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" value="<c:out value='${user.country}'/>">
                </td>
            </tr>
            <tr >
                <td colspan="2" style="text-align: center"><input type="submit" value="Save"></td>
            </tr>
        </table>

    </form>
</div>

</body>
</html>
