<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/10/2024
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them Sinh Vien</title>
</head>
<body>
    <div>
        <h2>Form</h2>
        <form action="/sinh-vien/add" method="post">
            Ma sinh vien: <input type="text" name="ma"> <br>
            Ten: <input type="text" name="ten"> <br>
            Tuoi: <input type="text" name="tuoi"> <br>
            Gioi tinh: <input type="radio" name="gioiTinh" value="true" checked> Nam
            <input type="radio" name="gioiTinh" value="false"> Nu <br>
            <button type="submit">Add</button>
        </form>
    </div>
</body>
</html>
