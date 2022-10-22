<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2022
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<div>
    <form method="post">
        <p>username:</p>
        <input type="text" name="user"><br>
        <p>password:</p>
        <input type="password" name="pass"><br>
        <p>repeat password:</p>
        <input type="password" name="repass"><br>
        <p></p>
        <button type="submit" value="Sing up" text>Sign up</button><br>


    </form>
</div>
</body>
</html>
