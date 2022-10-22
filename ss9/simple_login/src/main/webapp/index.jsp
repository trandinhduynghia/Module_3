<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/1/2022
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style type="text/css">
    .login{
      height: 250px;
      width: 230px;
      margin: 0;
      padding: 10px;
      border: 1px solid black;
    }
    .login input{
      padding: 5px;
      margin: 5px;
    }

  </style>
  <body>
  <form method="post" action="/login">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="user" placeholder="username">
      <input type="password" name="password" placeholder="password" >
      <input type="submit" value="Sign in" >
    </div>
  </form>
  </body>
</html>
