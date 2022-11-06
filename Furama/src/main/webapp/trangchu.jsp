<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang chủ</title>
</head>
<style>
    body{
        margin: 0;
    }
    .header{
        width: 100%;
        height: 100px;
        border: solid 1px black;
    }
    .menu{
        width: 100%;
        height: 30px;
        border: solid 1px black;
        background-color: grey;
        text-align: center;
    }
    .menu ul{
        padding: 0px;
        line-height: 0px;
    }
    .menu li{
        display: inline-block;
    }
    .menu a{
        text-decoration: none;
        color: white;
        font-family: Arial;
        font-size: smaller;
        padding: 5px;
    }
    .left{
        width: 200px;
        height: 900px;
        border: solid 1px black;
        float: left;
    }
    .right{
        width: 1314px;
        height: 900px;
        border: solid 1px black;
        float: left;
    }
    .footer{
        width: 100%;
        height: 30px;
        border: solid 1px black;
        clear: both;
        text-align: center;
        background-color: grey;
        color: aliceblue;
    }
</style>
<body>
<div class="header">
<img src="https://naturatex.com.my/wp-content/uploads/2016/05/Furama-RiverFront-Logo-White-HiRes.jpg"
style="height: 100px; width: 30%">
</div>

<div class="menu">
        <ul>
            <li><a href="/TrangChu">Trang chủ</a></li>
            <li><a href="/NhanVien">Nhân viên</a></li>
            <li><a href="/KhachHang">Khách hàng</a></li>
            <li><a href="#">Dịch vụ</a></li>
            <li><a href="#">Hợp đồng</a></li>
        </ul>
</div>

<div class="left">

</div>

<div class="right">

</div>

<div class="footer">
    Copyright © 2022
</div>
</body>
</html>
