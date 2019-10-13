<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String carname = request.getParameter("cars");
%>

<!DOCTYPE html>
<html>
<head>
<title>サンプル</title>
</head>
<body>
<div style="text-align: center;">
<%
   if(carname.length() != 0){
%>

<h2><%= carname %></h2>
<%= carname %>
のお買い上げありがとうございました。<br/>

<%
   }
   else{
%>

<h2>エラー</h2>
入力してください。<br/>

<%
   }
%>

</div>
</body>
</html>
