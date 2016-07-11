package be.assign.expenseReport.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.assign.expenseReport.dao.UserDao;
import be.assign.expenseReport.model.User;

@WebServlet(name = "UserServlet", value = "/User", initParams = {
		@WebInitParam(name = "page", value = "/WEB-INF/pages/users.jsp") })
public class UserServlet extends HttpServlet {
	private DataSource ds;
	private UserDao dao;
	private String page;

	public void init() throws ServletException {
		try {
			page = getInitParameter("page");
			if (page == null) {
				throw new ServletException("Init parameter is missing");
			}
			dao = new UserDao(ds);
		} catch (Exception ex) {
			throw new ServletException("unable to load driver", ex);
		}
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		try{
			List<User> messages = dao.getUserItems();
			request.setAttribute("messages", messages);
			RequestDispatcher disp=request.getRequestDispatcher(page);
			if(disp!=null){
				disp.forward(request, response);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("connection problem");
		}
	}
}