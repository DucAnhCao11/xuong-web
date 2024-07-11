<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2024
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thong tin</title>
</head>
<body>
    <label for="ma">Ma Sinh vien</label>
    <input type="text" id="ma" name="ma" value="${sv.ma}" readonly>
    <br>
    <label for="ten">Ten Sinh vien</label>
    <input type="text" id="ten" name="ten" value="${sv.ten}" readonly>
    <br>
    <label for="tuoi">Tuoi Sinh vien</label>
    <input type="text" id="tuoi" name="m" value="${sv.tuoi}" readonly>
    <br>
    <label for="gt" >Gioi Tinh</label>
    <input type="text" id="gt" name="maa" value="${sv.gioiTinh ?"Nam" : "Nữ"}" readonly>
</body>
</html>
