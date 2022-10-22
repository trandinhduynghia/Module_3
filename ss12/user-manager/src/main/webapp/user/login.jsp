<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/26/2022
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <form method="post">
        <p>username:</p>
        <input type="text" name="user"><br>
        <p>password:</p>
        <input type="password" name="pass"><br>
        <p></p>
        <button type="submit" value="Sing in" text>Sing in</button><br>
        <a href="/Signup">Sign up</a>

    </form>
</div>
</body>
</html>
