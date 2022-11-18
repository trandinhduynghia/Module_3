<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2022
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div style="text-align: center">
    <h2>Danh sách sách</h2>
</div>

<div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã Sách</th>
            <th scope="col">Tên Sách</th>
            <th scope="col">Tác giả</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Số Lượng</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="o" items="${listSach}">
            <tr>
                <td><c:out value="${o.getMaSach()}"/></td>
                <td><c:out value="${o.getTenSach()}"/></td>
                <td><c:out value="${o.getTacGia()}"/></td>
                <td><c:out value="${o.getMoTa()}"/></td>
                <td><c:out value="${o.getSoLuong()}"/></td>

                <td>
                    <ul class="nav nav-pills">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/TheMuonSach?action=create" style="">Mượn</a>
                        </li>
                    </ul>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
