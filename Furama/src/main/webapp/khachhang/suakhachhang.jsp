<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/2/2022
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa khách hàng</title>
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


<html>
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
        <h2>Sửa thông tin khách hàng</h2>
    </div>

    <div>
        <form class="row g-3" method="post">
            <c:if test="${khachHang != null}">

            </c:if>
            <div class="col-12">
                <label  class="form-label">Mã KH</label>
                <input type="text" class="form-control" name="MaKH" value="${khachHang.getMaKH()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Mã loại khách</label>
                <select class="form-select" aria-label="Default select example" name="MaLoaiKhach">
                    <option selected>Chọn mã loại khách</option>
                    <c:forEach var="o" items="${maLoaiKhachs}">
                        <option value="${o.getMaLoaiKhach()}">${o.getTenLoaiKhach()}</option>
                    </c:forEach>
                </select>
                <input type="text" class="form-control" name="MaLoaiKhach" value="${khachHang.getMaLoaiKhach()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Họ tên</label>
                <input type="text" class="form-control" name="HoTen" value="${khachHang.getHoTen()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Ngày sinh</label>
                <input type="date" class="form-control" name="NgaySinh" value="${khachHang.getNgaySinh()}">

            </div>
            <div class="col-12">
                <label  class="form-label">Giới tính</label>
                <select class="form-select" aria-label="Default select example" name="GioiTinh" >
                    <option selected>Chọn giới tính</option>
                    <option value="nam">Nam</option>
                    <option value="nữ">Nữ</option>
                </select>
                <input type="text" class="form-control" name="GioiTinh" value="${khachHang.getGioiTinh()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Số CMND</label>
                <input type="text" class="form-control" name="SoCMND" value="${khachHang.getSoCMND()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" name="SoDT" value="${khachHang.getSoDT()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Email</label>
                <input type="text" class="form-control" name="Email" value="${khachHang.getEmail()}">
            </div>
            <div class="col-12">
                <label  class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" name="DiaChi" value="${khachHang.getDiaChi()}">
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Cập nhật</button>
            </div>
        </form>
    </div>

</div>

<div class="footer">
    Copyright © 2022
</div>

</body>
</html>
