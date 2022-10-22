<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/14/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Danh sách khách hàng</title>
  </head>

  <style>
    body{
      text-align: center;
    }
    .table{

      padding-left: 35%;
    }
    .table tr, th, td{
      border: black 1px solid;
    }
  </style>

  <body>
  <h1 >Danh sách khách hàng</h1>
  <div>
    <table class="table">
      <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
      </tr>
      <c:forEach items="${customers}" var="customers">
        <tr>
          <td>${customers.getName()}</td>
          <td>${customers.getBirthday()}</td>
          <td>${customers.getAddress()}</td>
          <td><img src="${customers.getPictureLink()}" style="width: 40px; height: 40px"></td>
        </tr>
      </c:forEach>
    </table>
  </div>

  </body>

</html>
