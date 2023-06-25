package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import Model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
//			out.print(request.getParameter("username"));
//			out.print(request.getParameter("password"));
			UserBean bean=new UserBean();
			response.setContentType("text/html");
		bean.setUsername(request.getParameter("username"));
		bean.setPassword(request.getParameter("password"));
		 String name=bean.getUsername();
		Dao dao=new Dao();
		boolean b=dao.isValidUser(name,bean.getPassword());
	
		if(b)
		{
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		
		}
		else
		{
			response.sendRedirect("LoginError.jsp");
		}
			
			
	}

}
