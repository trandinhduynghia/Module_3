<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/20/2022
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table style="text-align: center; width: 50%; border: 1px; border-color: black">
        <caption><h2>Danh sách nhân viên</h2></caption>
        <tr>
            <th>Mã Nhân Viên</th>
            <th>Họ Tên</th>
            <th>Ngày Sinh</th>
            <th>Số CMND</th>
            <th>Lương</th>
            <th>Số ĐT</th>
            <th>Email</th>
            <th>Địa Chỉ</th>
            <th>Mã Vị Trí</th>
            <th>Mã Trình Độ</th>
            <th>Mã Bộ Phận</th>
        </tr>
        <c:forEach var="nhanvien" items="${listNhanVien}">
            <tr>
                <td><c:out value="${nhanvien.getMaNV()}"/></td>
                <td><c:out value="${nhanvien.getHoTen()}"/></td>
                <td><c:out value="${nhanvien.getNgaySinh()}"/></td>
                <td><c:out value="${nhanvien.getSoCMND()}"/></td>
                <td><c:out value="${nhanvien.getLuong()}"/></td>
                <td><c:out value="${nhanvien.getSoDT()}"/></td>
                <td><c:out value="${nhanvien.getEmail()}"/></td>
                <td><c:out value="${nhanvien.getDiaChi()}"/></td>
                <td><c:out value="${nhanvien.getMaViTri()}"/></td>
                <td><c:out value="${nhanvien.getMaTrinhDo()}"/></td>
                <td><c:out value="${nhanvien.getMaBoPhan()}"/></td>
            </tr>

        </c:forEach>
</table>
</div>
</body>
</html>
