<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Employee CRUD Operation</h1>
	<a href="register.jsp">New Employee</a> | <a href="view.jsp">View All Employee</a>
	<hr>
	<h2>Employee Login</h2>
	<%
	String msg = (String)request.getAttribute("msg");
	if(msg!=null){
	%>
	<p style="color: red;"><%=msg%></p>
	<%} %>
	<hr>
	
	<form action="EmpLogin" method="post">
	Email : <input type="email" name="email" /> <br>
	Password: <input type="password" name="password"> <br>
	<input type="submit" value="Login">
	</form>
</body>
</html>