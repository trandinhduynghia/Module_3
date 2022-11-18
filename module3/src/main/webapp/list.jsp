<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2022
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phòng trọ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<div style="text-align: center">
    <h2>Danh sách phòng trọ</h2>
</div>

<form class="row g-3" action="/PhongTro">
    <div class="col-auto">
        <input type="text" class="form-control" value="${requestScope.q}" placeholder="Mã phòng trọ" name="q">
    </div>

    <div class="col-auto">
       <input type="text" class="form-control" value="${requestScope.q1}" placeholder="Tên người thuê trọ" name="q1">--%>
    </div>

    <div class="col-auto">
        <input type="text" class="form-control" value="${requestScope.q2}" placeholder="Sđt" name="q2">--%>
    </div>

    <div class="col-auto">
        <button type="submit" class="btn btn-primary mb-3">Tìm kiếm</button>
    </div>

    </form>

<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã phòng trọ</th>
            <th scope="col">Tên người thuê trọ</th>
            <th scope="col">SĐT</th>
            <th scope="col">Ngày bắt đầu</th>
            <th scope="col">Hình thức thanh toán</th>
            <th scope="col">Ghi chú </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="o" items="${phongTros}">
            <tr>
                <td><c:out value="${o.getMaPhongTro()}"/></td>
                <td><c:out value="${o.getTenNguoiThueTro()}"/></td>--%>
                <td><c:out value="${o.getSdt()}"/></td>
                <td><c:out value="${o.getNgayBatDau()}"/></td>

                <c:forEach var="u" items="${hinhThucThanhToans}">--%>
                    <c:if test="${o.getHinhThucThanhToan() == u.getMaHinhThuc()}">
                        <td><c:out value="${u.getTenHinhThuc()}"/></td>
                    </c:if>
                </c:forEach>
                <td><c:out value="${o.getGhiChu()}"/></td>

                <td>
                    <button type="button" onclick="info('${o.getMaPhongTro()}')" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Xóa
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/PhongTro?action=create">Thêm phòng trọ</a>
        </li>
    </ul>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/PhongTro" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xác nhận</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <%--                    chú ý action và value và name--%>
                    <input name="action" value="delete" hidden>
                        <input name="MaPhongTro" id="MaPhongTro1" hidden>
                    <span class="text-danger">Bạn có muốn xóa mã phòng trọ  </span><span id="MaPhongTro"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary">Xóa</button>
                </div>
            </div>
        </form>

    </div>
</div>

<script>
    function info(MaPhongTro) {
        document.getElementById("MaPhongTro1").value=MaPhongTro;
        document.getElementById("MaPhongTro").innerText=MaPhongTro;
    }
</script>
</body>
</html>
