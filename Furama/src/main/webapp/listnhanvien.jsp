<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/20/2022
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
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
    .right table,th, td{
        border: solid 1px black;
    }
    .right table{
        border-collapse: collapse;
    }
    .right a{
        text-decoration: none;
        color: lightskyblue;

    }
    .footer{
        width: 100%;
        height: 30px;
        border: solid 1px black;
        clear: both;
        text-align: center;
        background-color: grey;
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
    <div>
        <table >
            <caption><h2>Danh sách nhân viên</h2></caption>
            <tr>
                <th>Mã Nhân Viên</th>
                <th>Họ Tên</th>
                <th>Ngày Sinh</th>
                <th>Số CMND</th>
                <th>Lương</th>
                <th>Số ĐT</th>
                <th>Email</th>
                <th>Địa Chỉ</th>
                <th>Mã Vị Trí</th>
                <th>Mã Trình Độ</th>
                <th>Mã Bộ Phận</th>
            </tr>
            <c:forEach var="nhanvien" items="${listNhanVien}">
                <tr>
                    <td><c:out value="${nhanvien.getMaNV()}"/></td>
                    <td><c:out value="${nhanvien.getHoTen()}"/></td>
                    <td><c:out value="${nhanvien.getNgaySinh()}"/></td>
                    <td><c:out value="${nhanvien.getSoCMND()}"/></td>
                    <td><c:out value="${nhanvien.getLuong()}"/></td>
                    <td><c:out value="${nhanvien.getSoDT()}"/></td>
                    <td><c:out value="${nhanvien.getEmail()}"/></td>
                    <td><c:out value="${nhanvien.getDiaChi()}"/></td>
                    <td><c:out value="${nhanvien.getMaViTri()}"/></td>
                    <td><c:out value="${nhanvien.getMaTrinhDo()}"/></td>
                    <td><c:out value="${nhanvien.getMaBoPhan()}"/></td>
                    <td>
                        <a href="/NhanVien?action=edit&MaNV=${nhanvien.getMaNV()}">Sửa</a>
                        <a href="/NhanVien?action=delete&MaNV=${nhanvien.getMaNV()}">Xóa</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
    <div>
        <a href="/NhanVien?action=create">Thêm mới nhân viên</a>
    </div>

</div>

<div class="footer">
    Copyright © 2022
</div>
</body>
</html>
