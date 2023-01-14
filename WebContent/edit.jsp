<%@page import="code.api.connection.DAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Update Employee</h1>
	<hr>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		try {
		Connection con = DAO.getConnection();
		String sql = "SELECT * FROM API_TABLE WHERE ID=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
	%>
	<form action="EmpEdit" method="post">
		Employee ID: <input type="text" name="id" readonly="readonly" value="<%=rs.getInt("id")%>" />
		<br> Employee Name: <input type="text" name="ename"
			value="<%=rs.getString("ename")%>" /> <br> Employee Email: <input
			type="email" name="email" value="<%=rs.getString("email")%>" /> <br>
		Employee Password: <input type="text" name="password"
			value="<%=rs.getString("password")%>" /> <br> <input
			type="submit" value="Update" />
	</form>
	<%
		}
	con.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</body>
</html>