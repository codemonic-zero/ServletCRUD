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

@WebServlet("/EmpEdit")
public class EmpEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	public EmpEdit() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String ename = request.getParameter("ename");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sql = "UPDATE API_TABLE SET ENAME=?,EMAIL=?,PASSWORD=? WHERE ID=?";
		try {
			con = DAO.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ename);
			pst.setString(2, email);
			pst.setString(3, password);
			pst.setInt(4, id);

			int result = pst.executeUpdate();
			if (result == 1) {
				System.out.println(result + " Record Updated.");
				request.setAttribute("msg", "Record Updated");
				request.getRequestDispatcher("view.jsp").include(request, response);
			} else {
				request.setAttribute("msg", "Record Not Updated");
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

}
