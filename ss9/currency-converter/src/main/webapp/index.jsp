<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/1/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <h1>Currency Converter</h1>
    <form method="post" action="/convert">
      <h3>Rate</h3>
    <input type="text" name="rate" placeholder="RATE" value="23000">
    <h3>USD</h3>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <input type="submit" value="Converter">
    </form>
  </div>
  </body>
</html>
