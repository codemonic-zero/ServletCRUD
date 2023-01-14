<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
</head>
<body>
	<h1>Employee CRUD Operation</h1>
	<hr>
	<%
	String msg = (String)request.getAttribute("msg");
	if(msg!=null){
	%>
	<p style="color: green;"><%=msg%></p>
	<%} %>
</body>
</html>