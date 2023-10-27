<%@ page import="com.example.on.fontend.models.LoaiXeModel" %>
<%@ page import="com.example.on.models.LoaiXe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cudan
  Date: 10/27/2023
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm xe mới</title>
</head>
<body>
<%
    LoaiXeModel loaiXeModel = new LoaiXeModel();
    List<LoaiXe> loaiXes = loaiXeModel.getAllLoai();
%>
<form action="xeServlet?action=addCar" method="post">
    <label>Tên xe:</label>
    <input type="text" placeholder="Nhập tên xe" name="tenXe"><br>
    <label>Giá xe:</label>
    <input type="text" name="giaXe"><br>
    <label>Năm sản xuất:</label>
    <input type="date" name="namSX"><br>
    <label>Loại xe:  </label>
    <select name="loaixe">
        <%
            for (LoaiXe loaiXe:loaiXes) {
        %>
        <option><%=loaiXe.getTenLoai()%></option>
        <%
            }
        %>
    </select><br>
    <input type="submit" value="Thêm">
</form>
</body>
</html>
