package code.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import code.api.connection.DAO;

@WebServlet("/EmpReg")
public class EmpReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;

	public EmpReg() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ename = request.getParameter("ename");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sql = "INSERT INTO API_TABLE(ENAME,EMAIL,PASSWORD)VALUES(?,?,?)";
		try {
			con = DAO.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ename);
			pst.setString(2, email);
			pst.setString(3, password);

			int result = pst.executeUpdate();
			if (result == 1) {
				System.out.println(result + " Record Saved.");
				request.setAttribute("msg", "Record Saved");
				request.getRequestDispatcher("home.jsp").include(request, response);
			} else {
				request.setAttribute("msg", "Record Not Saved");
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

}
