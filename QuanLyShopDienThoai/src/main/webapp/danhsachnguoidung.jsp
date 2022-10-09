<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/3/2022
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .danhsach{
        background-color: black;
        text-align: center;
        height: 50px;
    }
    .danhsach h2{
        font-family: Arial;
        color: white;
        line-height: 50px;
    }
    .timkiem a{
        font-family: Arial;
        color: black;
        text-decoration: none;
    }
    .timkiem a:hover{
        text-decoration: none;
    }
    .phantrang{
        text-align: center;
    }
    .phantrang a{
        font-family: Arial;
        text-decoration: none;
    }
    .phantrang a:hover{
        text-decoration: none;
        color: #aaaaaa;
    }
    .phantrang td{
        width: 5px;
    }
    .bang a{
        font-family: Arial;
        color: black;
        text-decoration: none;
    }
    .bang a:hover{
        text-decoration: none;
    }

    * {box-sizing: border-box;}

    body {
        margin: 0;
        <%--font-family: Arial, Helvetica, sans-serif;--%>
        margin-left: 20%;
        margin-right: 20%;
    }

    .topnav {
        overflow: hidden;
        background-color: #e9e9e9;
    }

    .topnav a {
        float: left;
        display: block;
        color: black;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
        height: 60px;
        text-align: center;
    }

    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    .topnav a.active {
        background-color: #2196F3;
        color: white;
    }

    .topnav .search-container {
        float: right;
    }

    .topnav input[type=text] {
        padding: 6px;
        margin-top: 8px;
        font-size: 17px;
        border: none;
    }

    .topnav .search-container button {
        float: right;
        padding: 6px;
        margin-top: 8px;
        margin-right: 16px;
        background: #ddd;
        font-size: 17px;
        border: none;
        cursor: pointer;
    }

    .topnav .search-container button:hover {
        background: #ccc;
    }


</style>


<body>

<div class="danhsach">
    <h2>Danh sách người dùng</h2>
</div>

<div class="topnav">
    <a href="/TrangChu">Trang chủ</a>
    <a href="/DangKy">Thêm mới</a>
    <div class="search-container">
        <form action="/DanhSachNguoiDung">
            <input type="text" hint="search" value="${requestScope.hoTen}"  name="hoTen">
            <button type="get">Tìm</button>
        </form>
    </div>
</div>


<div style="overflow-x: auto;" class="bang">
    <table>
        <tr>
            <th>Mã người dùng</th>
            <th>Họ tên</th>
            <th>Email</th>
            <th>Điện thoại</th>
            <th>Mật khẩu</th>
            <th>ID quyền</th>
        </tr>


            <c:forEach var="o" items="${listNguoiDung}">
                <tr>
                <td>${o.getManguoidung()}</td>
                <td>${o.getHoten()}</td>
                <td>${o.getEmail()}</td>
                <td>${o.getDienthoai()}</td>
                <td>${o.getMatkhau()}</td>
                <td>${o.getIDquyen()}</td>
                    <td>
                        <a href="/DanhSachNguoiDung?action=edit&manguoidung=${o.getManguoidung()}" >sửa</a>
                        <a href="/DanhSachNguoiDung?action=delete&manguoidung=${o.getManguoidung()}">xóa</a>
                    </td>
                </tr>
            </c:forEach>

    </table>
</div>

    <div class="phantrang" >
        <table style="width: 100px">
            <tr>
                <c:forEach begin="1" end="${soLuongTrang}" var="i">
                    <c:choose>
                        <c:when test="${trang eq i}">
                            <td>${i}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="/DanhSachNguoiDung?trang=${i}">${i}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>
    </div>



</body>
</html>
