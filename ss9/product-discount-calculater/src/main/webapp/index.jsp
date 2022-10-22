<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/2/2022
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product discount calculater</title>
  </head>
  <body>
  <form method="post" action="/calculate">
    <h2>Product Description:</h2>
    <input type="text" name="sanpham">
    <h2>List Price:</h2>
    <input type="text" name="price">
    <h2>Discount Percent:</h2>
    <input type="text" name="discount">
    <p></p>
    <input type="submit" value="Calculate Discount" style="padding-top: 10px">
  </form>
  </body>
</html>
