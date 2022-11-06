<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2022
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
        padding-top: 10px;
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
        height: auto;
        border: solid 1px black;
        float: left;
    }
    .right{
        width: 1314px;
        height: auto;
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
        <li><a href="/KhachHang">Khách hàng</a></li>
        <li><a href="#">Dịch vụ</a></li>
        <li><a href="#">Hợp đồng</a></li>

    </ul>
</div>

<div class="left">

</div>

<div class="right">
    <div style="text-align: center">
        <h2>Danh sách khách hàng</h2>
    </div>

    <form class="row g-3" action="/KhachHang">
        <div class="col-auto">
            <input type="text" class="form-control" value="${requestScope.q}" placeholder="Tìm kiếm" name="q">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Tìm kiếm</button>
        </div>
    </form>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã KH</th>
                <th scope="col">Mã Loại Khách</th>
                <th scope="col">Họ Tên</th>
                <th scope="col">Ngày Sinh</th>
                <th scope="col">Giới Tính</th>
                <th scope="col">Số CMND</th>
                <th scope="col">Số Điện Thoại</th>
                <th scope="col">Email</th>
                <th scope="col">Địa Chỉ</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="o" items="${listKH}">
                <tr>
                    <td><c:out value="${o.getMaKH()}"/></td>

                    <c:forEach var="u" items="${maLoaiKhachs}">
                        <c:if test="${o.getMaLoaiKhach() == u.getMaLoaiKhach()}">
                            <td><c:out value="${u.getTenLoaiKhach()}"/></td>
                        </c:if>
                    </c:forEach>


                    <td><c:out value="${o.getHoTen()}"/></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${o.getNgaySinh()}"/></td>
<%--                    <td><c:out value="${o.getNgaySinh()}"/></td>--%>
                    <td><c:out value="${o.getGioiTinh()}"/></td>
                    <td><c:out value="${o.getSoCMND()}"/></td>
                    <td><c:out value="${o.getSoDT()}"/></td>
                    <td><c:out value="${o.getEmail()}"/></td>
                    <td><c:out value="${o.getDiaChi()}"/></td>

                    <td>
                        <ul class="nav nav-pills">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/KhachHang?action=edit&MaKH=${o.getMaKH()}" style="">Sửa</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/KhachHang?action=delete&MaKH=${o.getMaKH()}" style="background-color: darkred">Xóa</a>
                            </li>
                            </ul>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>

    <div>
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/KhachHang?action=create">Thêm mới khách hàng</a>
            </li>
        </ul>
    </div>

</div>

<div class="footer">
    Copyright © 2022
</div>
</body>
</html>
