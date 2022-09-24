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
    <title>Trang chu</title>


</head>
<style>
    .header{
        width: 100%;
        height: 100px;
        background-color: black;
    }
    .menu{
        width: 100%;
        height: 30px;
        border: solid 1px black;
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
        color: black;
        font-family: Arial;
        font-size: smaller;
        padding: 5px;
    }
    .left{
        width: 400px;
        height: 900px;
        border: solid 1px black;
        float: left;
    }
    .right{
        width: 1098px;
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
    }
</style>
<body>
<div class="header">
<img src="https://naturatex.com.my/wp-content/uploads/2016/05/Furama-RiverFront-Logo-White-HiRes.jpg"
style="height: 100px; width: 100%">
</div>

<div class="menu">
        <ul>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="#">Nhân viên</a></li>
            <li><a href="#">Khách hàng</a></li>
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
