<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<style>
  body {
    align-items: center;
    text-align: center;
  }
  table {
    width: 80%;
    border-collapse: collapse;
    margin: 0 auto;
  }
  th, td {
    padding: 8px;
    text-align: center;
    border: 1px solid #ccc;
  }
</style>
<body>
<h1><%= "TrietKun" %></h1>
<br/>
<table>
  <th><a href="xeServlet">Danh sách xe</a></th>
  <th><a href="loaiXeServlet">Danh sách loại xe </a></th>
  <th><a href="ThemXe.jsp">Thêm xe</a></th>
</table>

</body>
</html>