<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/10/2022
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
</head>

<style type="text/css">
    /*.table&amp;amp;gt;tfoot&amp;amp;gt;tr&amp;amp;gt;td {*/
    /*                                                 vertical-align: middle;*/
    /*                                                 }*/

    @media screen and (max-width: 600px) {
        table#cart tbody td .form-control {
            width: 20%;
            display: inline !important;
        }

        .actions .btn {
            width: 36%;
            margin: 1.5em 0;
        }

        .actions .btn-info {
            float: left;
        }

        .actions .btn-danger {
            float: right;
        }

        table#cart thead {
            display: none;
        }

        table#cart tbody td {
            display: block;
            padding: .6rem;
            min-width: 320px;
        }

        table#cart tbody tr td:first-child {
            background: #333;
            color: #fff;
        }

        table#cart tbody td:before {
            content: attr(data-th);
            font-weight: bold;
            display: inline-block;
            width: 8rem;
        }

        table#cart tfoot td {
            display: block;
        }

        table#cart tfoot td .btn {
            display: block;
        }
    }
</style>


<body>
<div class="container">
<table id="cart" class="table table-hover table-condensed">
<thead>
<tr>
    <th style="width:40%">Tên sản phẩm</th>
    <th style="width:10%">Giá</th>
    <th style="width:20%">Số lượng</th>
    <th style="width:20%" class="text-center">Thành tiền</th>
    <th style="width:10%"></th>
</tr>
</thead>

<tbody>
<c:forEach var="o" items="${sessionScope.gioHang.matHangs}">
    <tr>
    <td data-th="Product">
    <div class="row">
    <div class="col-sm-2 hidden-xs"><img src="${o.sanpham.anhbia}" alt="Sản phẩm 1" class="img-responsive" width="100">
    </div>
    <div class="col-sm-10">
    <h4 class="nomargin">${o.sanpham.tensp}</h4>
    </div>
    </div>
    </td>
    <td data-th="Price">${o.dongia}</td>
    <td data-th="Quantity" >
        <form method="get" style="display: inline;">
             <a style="text-decoration: none; color: black" href="/GioHang?action=create&soluong=-1&masp=${o.sanpham.masp}">-</a>
<%--          class="form-control text-center"  --%>
            <input style="width: 30px; border: none; text-align: center"  value="${o.soluong}" type="number" readonly>
            <a style="text-decoration: none; color: black" href="/GioHang?action=create&soluong=1&masp=${o.sanpham.masp}">+</a>
        </form>

    </td>
    <td data-th="Subtotal" class="text-center">${o.soluong * o.dongia}</td>
    <td class="actions" data-th="" style="text-align: center">
        <form method="get">
            <button class="btn btn-danger btn-sm" type="submit">
                <a style="text-decoration: none; color: white" href="/GioHang?action=delete&maspxoa=${o.sanpham.masp}">Xóa</a>
            </button>
        </form>
    </td>
    </tr>
</c:forEach>
    </tbody>

    <tfoot>
        <tr class="visible-xs">
            <td class="text-center"><strong>Tổng 200.000 đ</strong>
           </td>
       </tr>
    <tr>
    <td ><a href="/TrangChu" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a>
    </td>
    <td colspan="2" class="hidden-xs"> </td>
    <td class="hidden-xs text-center" ><strong>Tổng tiền ${sessionScope.gioHang.thanhTien} VNĐ</strong>
    </td>
    <td><a href="/DonHang" class="btn btn-success btn-block">Thanh toán <i class="fa fa-angle-right"></i></a>
    </td>
    </tr>
    </tfoot>
    </table>
    </div>

    </body>
    </html>
