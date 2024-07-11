<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2024
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach</title>
</head>
<body>
<div>
    <h1>Danh sach Sinh vien</h1>
    <div>
        <button><a href="/sinh-vien/view-add">Them sinh vien</a></button>
        <table>
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã Sinh viên</th>
                <th>Họ Tên</th>
                <th>Tuổi</th>
                <th>Giới Tính</th>
                <th rowspan="3"></th>

            </tr>
            </thead>

            <tbody>
                <c:forEach items="${danhSach}" var="sv" varStatus="i">
                    <tr>
                        <td>${i.index +1}</td>
                        <td>${sv.ma}</td>
                        <td>${sv.ten}</td>
                        <td>${sv.tuoi}</td>
                        <td>${sv.gioiTinh ? "Nam" : "Nữ"}</td>
                        <td>
                            <button><a href="/sinh-vien/detail?id=${sv.ma}">detail</a></button>
                            <button><a href="/sinh-vien/update?id=${sv.ma}">Update</a></button>
                            <button><a href="/sinh-vien/delete?id=${sv.ma}">delete</a></button>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
