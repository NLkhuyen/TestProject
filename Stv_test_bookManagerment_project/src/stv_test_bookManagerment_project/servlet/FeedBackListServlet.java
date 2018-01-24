package stv_test_bookManagerment_project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
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
import stv_test_bookManagerment_project.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/feedBackList" })
public class FeedBackListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public FeedBackListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
 
        String errorString = null;
        List<FeedBack> list = null;
        try {
            list = DBUtils.queryFeedBack(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("feedBackList", list);
         
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/feedBackListView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}