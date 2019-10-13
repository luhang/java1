<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="cb" class="mybeans.CarBean" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<title>サンプル</title>
</head>
<body>
<div style="text-align: center;">
<h2>おわび</h2>
<jsp:getProperty name="cb" property="cardata"/>
をお買い上げいただくことはできません。<br/>
</div>
</body>
</html>
