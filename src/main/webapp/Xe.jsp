<%@ page import="com.example.on.Services.XeService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.on.models.Xe" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.on.models.LoaiXe" %>
<%@ page import="com.example.on.fontend.models.LoaiXeModel" %><%--
  Created by IntelliJ IDEA.
  User: cudan
  Date: 10/26/2023
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xe</title>
    <style>

        body{
           align-content: center;
            text-align: center;
            align-items: center;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1 style="align-self: center">Xe</h1>
    <form action="XeTheoLoai.jsp" method="get">
        <label for="loai">Chọn loại xe: </label>
        <select name="sel_loaixe" id="loai">
<%--            <option value="So">Xe số</option>--%>
<%--            <option value="TayGa">Xe Tay Ga</option>--%>
<%--            <option value="ConTay">Xe Côn Tay</option>--%>
    <%
        LoaiXeModel loaiXeModel = new LoaiXeModel();
        List<LoaiXe> loaiXes = loaiXeModel.getAllLoai();
        for (LoaiXe loaiXe: loaiXes) {
    %>
    <option><%=loaiXe.getTenLoai()%></option>
    <%
        }
    %>
        </select>
        <input type="hidden" name="action" value="loai">
        <input type="submit" value="Lấy Xe Theo Loại">
    </form>
    <table>
        <th>ID</th>
        <th>Ten</th>
        <th>Gia</th>
        <th>Nam san xuat</th>
        <th>Loai</th>
        <%
            XeService xeService = new XeService();
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            List<Xe> xeList = xeService.getAll();
            for (Xe xe : xeList){
        %>
            <tr>
                <td><%= xe.getId()%></td>
                <td><%= xe.getTenXe()%></td>
                <td><%= decimalFormat.format(xe.getGia())%></td>
                <td><%= xe.getNamSX()%></td>
                <td><%= xe.getLoaiXe().getTenLoai()%></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
