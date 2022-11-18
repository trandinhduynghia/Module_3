<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2022
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm phòng trọ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<div style="text-align: center">
    <h2>Thêm phòng trọ</h2>
</div>

<div>
    <form class="row g-3" method="post" action="/PhongTro?action=create">

        <div class="col-12">
            <label  class="form-label">Mã phòng trọ</label>
           <input type="text" class="form-control" name="MaPhongTro" readonly>
        </div>

        <div class="col-12">
            <label  class="form-label">Tên người thuê trọ</label>
            <input type="text" class="form-control" name="TenNguoiThueTro">
            <p style="color: red"> ${errorMap.get('HoTen')}</p>
        </div>

        <div class="col-12">
            <label  class="form-label">Số điện thoại</label>
            <input type="text" class="form-control" name="Sdt">
            <p style="color: red"> ${errorMap.get('SDT')}</p>
        </div>
        <div class="col-12">
            <label  class="form-label">Ngày bắt đầu</label>
            <input type="date" class="form-control" name="NgayBatDau">
            <p style="color: red"> ${errorMap.get('NgayBatDau')}</p>
        </div>

        <div class="col-12">
            <label  class="form-label">Hình thức thanh toán</label>
            <select class="form-select" aria-label="Default select example" name="HinhThucThanhToan">
                <option value="0">Chọn hình thức thanh toán</option>
                <option value="1">theo tháng</option>
                <option value="2">theo quý</option>
                <option value="3">theo năm</option>
            </select>
<%--            <input type="date" class="form-control" name="HinhThucThanhToan">--%>
           <p style="color: red"> ${errorMap.get('HinhThuc')}</p>
        </div>

        <div class="col-12">
            <label  class="form-label">Ghi chú</label>
            <input type="text" class="form-control" name="GhiChu">
            <p style="color: red"> ${errorMap.get('GhiChu')}</p>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Lưu</button>
        </div>

        <div>
            <ul class="nav nav-pills">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/PhongTro" style="background-color: darkred">Hủy</a>
                </li>
            </ul>
        </div>
    </form>
</div>

</body>
</html>
