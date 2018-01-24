package stv_test_bookManagerment_project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stv_test_bookManagerment_project.connector.MySQLConnUtils;
import stv_test_bookManagerment_project.utils.DBUtils;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet(urlPatterns = { "/deleteFeedBack" })
public class DeleteFeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFeedBackServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int id = Integer.parseInt(request.getParameter("id"));

		String errorString = null;

		try {
			DBUtils.deleteFeedBack(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If everything nice.
		// Redirect to the product listing page.
		response.sendRedirect(request.getContextPath() + "/feedBackList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
