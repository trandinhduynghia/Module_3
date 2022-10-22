<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/27/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>Product</h2>
<div>
    <ul>
        <c:forEach var="o" items="${list1}">
            <li><a href="/Category?id=${o.id}">${o.name}</a></li>
        </c:forEach>
    </ul>
</div>
<div>
<c:forEach var="o" items="${list}">
 <div>
    <img src="${o.image}">
    <div>
        <a href="/Detail?id=${o.id}">${o.name}</a>
        <p>${o.title}</p>
        <p>${o.description}</p>
        <p>${o.price}</p>
    </div>

 </div>
</c:forEach>
</div>
</body>
</html>
