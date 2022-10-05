<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/1/2022
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<style>
    body {font-family: Arial, Helvetica, sans-serif}
    * {box-sizing: border-box;}

    /* Full-width input fields */
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
    <form method="post" class="modal-content" >
        <div class="container">
            <h1>Đăng ký</h1>
            <p>Vui lòng điền vào biểu mẫu này để tạo một tài khoản.</p>
            <hr>
            <label ><b>Họ tên</b></label>
            <input type="text" placeholder="Họ tên" name="hoten" required>

            <label ><b>Email</b></label>
            <input type="text" placeholder="Email" name="email" required>

            <label ><b>Điện thoại</b></label>
            <input type="text" placeholder="Điện thoại" name="dienthoai" required>

            <label ><b>Mật khẩu</b></label>
            <input type="password" placeholder="Mật khẩu" name="matkhau" required>

            <label><b>Nhập lại mật khẩu</b></label>
            <input type="password" placeholder="Nhập lại mật khẩu" name="matkhaulai" required>


            <p>Bằng cách tạo một tài khoản, bạn đồng ý với <a href="#" style="color:dodgerblue">Điều khoản & Quyền riêng tư</a> của chúng tôi.</p>

            <div class="clearfix">
                <button type="button" class="cancelbtn"><a href="/TrangChu" style="color: white; text-decoration: none">Hủy</a></button>
                <button type="submit" class="signupbtn">Đăng ký</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
