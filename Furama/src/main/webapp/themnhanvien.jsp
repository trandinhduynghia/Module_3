<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/24/2022
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm nhân viên</title>
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
        <li><a href="#">Khách hàng</a></li>
        <li><a href="#">Dịch vụ</a></li>
        <li><a href="#">Hợp đồng</a></li>
    </ul>
</div>

<div class="left">

</div>

<div class="right">
    <div >
        <form method="post">
            <table>
                <caption><h2>Thêm mới nhân viên</h2></caption>
                <tr>
                    <th>Họ Tên:</th>
                    <td>
                        <input type="text" name="HoTen" id="HoTen">
                    </td>
                </tr>
                <tr>
                    <th>Ngày Sinh:</th>
                    <td>
                        <input type="text" name="NgaySinh" id="NgaySinh">
                    </td>
                </tr>
                <tr>
                    <th>Số CMND:</th>
                    <td>
                        <input type="text" name="SoCMND" id="SoCMND">
                    </td>
                </tr>
                <tr>
                    <th>Lương:</th>
                    <td>
                        <input type="text" name="Luong" id="Luong">
                    </td>
                </tr>
                <tr>
                    <th>Số ĐT:</th>
                    <td>
                        <input type="text" name="SoDT" id="SoDT">
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="Email" id="Email">
                    </td>
                </tr>
                <tr>
                    <th>Địa Chỉ:</th>
                    <td>
                        <input type="text" name="DiaChi" id="DiaChi">
                    </td>
                </tr>
                <tr>
                    <th>Mã Vị Trí:</th>
                    <td>
                        <input type="text" name="MaViTri" id="MaViTri">
                    </td>
                </tr>
                <tr>
                    <th>Mã Trình Độ:</th>
                    <td>
                        <input type="text" name="MaTrinhDo" id="MaTrinhDo">
                    </td>
                </tr>
                <tr>
                    <th>Mã Bộ Phận:</th>
                    <td>
                        <input type="text" name="MaBoPhan" id="MaBoPhan">
                    </td>
                </tr>
                <tr >
                    <td colspan="2" style="text-align: center"><input type="submit" value="Lưu"></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<div class="footer">
    Copyright © 2022
</div>

</body>
</html>
