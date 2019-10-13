<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String name = request.getParameter("name");
%>

<!DOCTYPE html>
<html>
<head>
<title><%= name %></title>
</head>
<body>
<div style="text-align: center;">
<h2>ようこそ</h2>
<%= name%>
さん、いらっしゃいませ。<br/>
</div>
</body>
</html>
