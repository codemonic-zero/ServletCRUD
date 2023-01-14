package code.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.api.connection.DAO;

@WebServlet("/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	ResultSet rs = null;

	public EmpLogin() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sql = "SELECT * FROM API_TABLE WHERE EMAIL=? AND PASSWORD=?";
		try {
			con = DAO.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);

			rs = pst.executeQuery();
			if (rs.next()) {
				request.setAttribute("msg", "Login Success");
				request.getRequestDispatcher("empHome.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Login Failed");
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

}
