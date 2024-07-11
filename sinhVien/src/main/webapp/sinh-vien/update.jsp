<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2024
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>
    <h2>Form</h2>
    <form action="/sinh-vien/update" method="post">
        <input type="text">
        Ma sinh vien: <input type="text" name="ma" value="${sv.ma}"> <br>
        Ten: <input type="text" name="ten" value="${sv.ten}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${sv.tuoi}"> <br>
        Gioi tinh: <input type="radio" name="gioiTinh" value="true" ${sv.gioiTinh ? 'checked' : ''}> Nam
        <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh ?'' : 'checked'}> Nu <br>
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>
