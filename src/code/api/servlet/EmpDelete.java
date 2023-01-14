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

@WebServlet("/EmpDelete")
public class EmpDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	public EmpDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "DELETE FROM API_TABLE WHERE ID=?";
		try {
			con = DAO.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int result = pst.executeUpdate();
			if (result == 1) {
				System.out.println(result + " Record Deleted.");
				request.setAttribute("msg", "Record Deleted");
				request.getRequestDispatcher("view.jsp").include(request, response);
			} else {
				request.setAttribute("msg", "Record Not Deleted");
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
