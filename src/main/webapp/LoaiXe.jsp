<%@ page import="com.example.on.Services.LoaiXeService" %>
<%@ page import="com.example.on.models.LoaiXe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cudan
  Date: 10/26/2023
  Time: 9:07 PM
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

<table>
    <th>ID</th>
    <th>Ten</th>

    <%
        LoaiXeService xeService = new LoaiXeService();
        List<LoaiXe> xeList = xeService.getAllLoaiXe();
        for (LoaiXe xe : xeList){
    %>
    <tr>
        <td><%= xe.getId()%></td>
        <td><%= xe.getTenLoai()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>