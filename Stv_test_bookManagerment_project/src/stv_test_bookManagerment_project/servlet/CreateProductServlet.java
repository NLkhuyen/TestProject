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

import stv_test_bookManagerment_project.beans.Book;
import stv_test_bookManagerment_project.beans.FeedBack;
import stv_test_bookManagerment_project.connector.MySQLConnUtils;
import stv_test_bookManagerment_project.utils.DBUtils;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet(urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProductServlet() {
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
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

		String feedBackContent = (String) request.getParameter("feedBackContent");
		FeedBack feedBack = new FeedBack(feedBackContent);

		String errorString = null;

		if (errorString == null) {
			try {
				DBUtils.insertFeedBack(conn, feedBack);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("feedBack", feedBack);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/createFeedbackProduct");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/feedBackList");
		}
	}
}
