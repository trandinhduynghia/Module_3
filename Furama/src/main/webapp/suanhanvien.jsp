<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/24/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa nhân viên</title>
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
    <div>
        <form method="post">
            <table>
                <caption><h2>Sửa thông tin nhân viên</h2></caption>
                <c:if test="${existingNhanVien != null}">

                </c:if>
                <tr>
                    <th>Họ Tên:</th>
                    <td>
                        <input type="text" name="HoTen" value="<c:out value='${existingNhanVien.getHoTen()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Ngày Sinh:</th>
                    <td>
                        <input type="text" name="NgaySinh" id="NgaySinh" value="<c:out value='${existingNhanVien.getNgaySinh()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Số CMND:</th>
                    <td>
                        <input type="text" name="SoCMND" id="SoCMND" value="<c:out value='${existingNhanVien.getSoCMND()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Lương:</th>
                    <td>
                        <input type="text" name="Luong" id="Luong" value="<c:out value='${existingNhanVien.getLuong()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Số ĐT:</th>
                    <td>
                        <input type="text" name="SoDT" id="SoDT" value="<c:out value='${existingNhanVien.getSoDT()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="Email" id="Email" value="<c:out value='${existingNhanVien.getEmail()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Địa Chỉ:</th>
                    <td>
                        <input type="text" name="DiaChi" id="DiaChi" value="<c:out value='${existingNhanVien.getDiaChi()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Mã Vị Trí:</th>
                    <td>
                        <input type="text" name="MaViTri" id="MaViTri" value="<c:out value='${existingNhanVien.getMaViTri()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Mã Trình Độ:</th>
                    <td>
                        <input type="text" name="MaTrinhDo" id="MaTrinhDo" value="<c:out value='${existingNhanVien.getMaTrinhDo()}'/>">
                    </td>
                </tr>
                <tr>
                    <th>Mã Bộ Phận:</th>
                    <td>
                        <input type="text" name="MaBoPhan" id="MaBoPhan" value="<c:out value='${existingNhanVien.getMaBoPhan()}'/>">
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
