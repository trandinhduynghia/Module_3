<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/1/2022
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<style>
    .fakeimg {
        height: 200px;
        background: #aaa;
    }

    .menu li {
        display: inline-block;
        text-decoration: none;
    }

    .menu a {
        color: white;
        font-family: Arial;
        width: 50px;
        height: 50px;
        padding-right: 10px;
        line-height: 50px;

    }

    .menu a:hover {
        text-decoration: none;
        color: #cccccc;
    }

    .sanpham a:hover {
        text-decoration: none;
    }

</style>

<body>

<div class="jumbotron text-center" style="margin-bottom: 0; padding: 0; height: 400px">
    <img src="https://vatvostudio.vn/wp-content/uploads/2021/11/Apple-Store-1.jpg"
         style="width: 1518.4px; height: 400px">
</div>


<div class="menu" style="background-color: black; text-align: center; height: 50px; width: 100%; float: left">

    <ul>
        <li style="float: left"><a href="/TrangChu">Trang chủ</a></li>
        <c:if test="${sessionScope.nguoiDung != null}">
            <li style="float: left"><a href="/ThongTinCaNhan?manguoidung=${sessionScope.nguoiDung.manguoidung}">Cá
                nhân</a></li>
        </c:if>
        <c:if test="${sessionScope.nguoiDung.IDquyen == 1}">
            <li style="float: left"><a href="/DanhSachNguoiDung">Người dùng</a></li>
        </c:if>
        <c:if test="${sessionScope.nguoiDung == null}">
            <li style="float: right"><a href="/DangNhap">Đăng nhập</a></li>
        </c:if>
        <c:if test="${sessionScope.nguoiDung != null}">
            <li style="float: right"><a href="/DangXuat">Đăng xuất</a></li>
        </c:if>
        <li style="float: right"><a href="/DangKy">Đăng ký</a></li>
        <li style="float: right"><a href="/GioHang">Giỏ hàng</a></li>
    </ul>
</div>


<div class="container" style="margin-top:30px">
    <div class="row">


        <div class="col-sm-4">
            <ul class="nav nav-pills flex-column">
                <c:forEach var="o" items="${list1}">
                    <li class="nav-item">
                        <a class="nav-link" href="/HangSanXuat?Mahang=${o.getMahang()}"
                           style="text-align: center; color: #aaaaaa; border: 1px solid #aaaaaa; margin: 20px">${o.getTenhang()}</a>
                    </li>
                </c:forEach>

            </ul>
        </div>


            <div class="col-sm-8">
                <form method="post">
                <c:forEach var="o" items="${list}">
                    <div class="sanpham"
                         style="text-align: center; width: 200px; height: 400px; float: left; margin: 20px">
                        <img src="${o.getAnhbia()}"
                             style="width: 200px; height: 200px"><br>
                        <a href="/ChiTietSanPham?Masp=${o.getMasp()}"
                           style="color: black; font-family: Arial">${o.getTensp()}</a>
                        <p style="font-weight: bolder">${o.getGiatien()} VNĐ</p>
                        <button type="submit" style="font-family: Arial; background-color: #dddddd"><a href="/GioHang?action=create&masp=${o.getMasp()}">Thêm vào giỏ</a></button>
                    </div>
                </c:forEach>
                </form>

            </div>



    </div>
</div>


<div class="footer"
     style="margin-bottom:0; height: 30px; width: 100%; text-align: center; background-color: black; color: white">
    <p>Copyright © 2022 </p>
</div>

</body>
</html>
