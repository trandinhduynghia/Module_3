<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
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
    body{
        margin-left: 20%;
        margin-right: 20%;
        margin-top: 0;
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
    .timkiem p{
        font-weight: bolder;
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
    input[type=text], input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }

    /* Add a background color when the inputs get focus */
    input[type=text]:focus, input[type=password]:focus {
        background-color: #ddd;
        outline: none;
    }

    /* Set a style for all buttons */
    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }

    button:hover {
        opacity:1;
    }

    /* Extra styles for the cancel button */
    .cancelbtn {
        padding: 14px 20px;
        background-color: #f44336;
    }

    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn, .signupbtn {
        float: left;
        width: 50%;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* The Modal (background) */
    .modal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 1; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: #474e5d;
        padding-top: 50px;
    }

    /* Modal Content/Box */
    .modal-content {
        background-color: #fefefe;
        /* margin: 5% auto 15% auto;  5% from the top, 15% from the bottom and centered */
        /* border: 1px solid #888; */
        width: 50%; /* Could be more or less, depending on screen size */

    }

    /* Style the horizontal ruler */
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }

    /* The Close Button (x) */
    .close {
        position: absolute;
        right: 35px;
        top: 15px;
        font-size: 40px;
        font-weight: bold;
        color: #f1f1f1;
    }

    .close:hover,
    .close:focus {
        color: #f44336;
        cursor: pointer;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
        .cancelbtn, .signupbtn {
            width: 100%;
        }
    }
</style>

<body>

<div class="danhsach">
    <h2>Thông tin cá nhân</h2>
</div>
<p></p>
<form method="post" class="modal-content" >
    <div class="container">
<%--        <label ><b>Mã người dùng</b></label>--%>
        <input type="hidden" placeholder="Mã người dùng" name="manguoidung" required value="${existingNguoiDung.getManguoidung()}" >

        <label ><b>Họ tên</b></label>
        <input type="text" placeholder="Họ tên" name="hoten" required value="${existingNguoiDung.getHoten()}">

        <label ><b>Email</b></label>
        <input type="text" placeholder="Email" name="email" required value="${existingNguoiDung.getEmail()}">

        <label ><b>Điện thoại</b></label>
        <input type="text" placeholder="Điện thoại" name="dienthoai" required value="${existingNguoiDung.getDienthoai()}">

        <label ><b>Mật khẩu</b></label>
        <input type="text" placeholder="Mật khẩu" name="matkhau" required value="${existingNguoiDung.getMatkhau()}">

        <label ><b>Nhập lại mật khẩu</b></label>
        <input type="text" placeholder="Mật khẩu" name="matkhaulai" required value="${existingNguoiDung.getMatkhau()}">

<%--    <label ><b>ID quyền</b></label>--%>
    <input type="hidden" placeholder="ID quyền" name="idquyen" required value="${existingNguoiDung.getIDquyen()}" hidden>

    <label ><b>Địa chỉ</b></label>
    <input type="text" placeholder="Địa chỉ" name="diachi" required value="${existingNguoiDung.getDiachi()}">

        <div class="clearfix">
            <button type="button" class="cancelbtn"><a href="/TrangChu" style="color: white; text-decoration: none">Hủy</a></button>
            <button type="submit" class="signupbtn">Cập nhật</button>
        </div>
    </div>
</form>




</body>

</html>
