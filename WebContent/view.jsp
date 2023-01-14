<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="code.api.connection.DAO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employee Details</title>
</head>
<h1>All Employee Details</h1>
<a href="home.jsp">Go to Home</a>
<br>
<br>
<%
	String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
<p style="color: red;"><%=msg%></p>
<%
	}
%>
<hr>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Employee Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			try {
			Connection con = DAO.getConnection();
			String sql = "SELECT * FROM API_TABLE";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("ename")%></td>
			<td><%=rs.getString("email")%></td>
			<td><%=rs.getString("password")%></td>
			<td><a href="edit.jsp?id=<%=rs.getInt("id")%>">update</a></td>
			<td><a href="EmpDelete?id=<%=rs.getInt("id")%>">remove</a></td>
		</tr>
		<%
			}
		con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
	</table>
</body>
</html>