<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/21/2022
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Describe:</td>
                <td>${requestScope["product"].getDescribe()}</td>
            </tr>
            <tr>
                <td>Manufacturer:</td>
                <td>${requestScope["product"].getManufacturer()}</td>
            </tr>
            <tr>
                <td></td>
                <td><td><input type="submit" value="Product customer"></td></td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>
