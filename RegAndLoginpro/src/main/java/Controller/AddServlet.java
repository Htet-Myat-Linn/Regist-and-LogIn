package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import Dto.ReqDto;
import Model.UserBean;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
//		PrintWriter out=response.getWriter();
//		out.println(request.getParameter("id"));
//		out.println(request.getParameter("username"));
//		out.println(request.getParameter("password"));
		
		UserBean bean=new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setUsername(request.getParameter("username"));
		bean.setPassword(request.getParameter("password"));
		
		
		Dao dao=new Dao();
		
		
		ReqDto req=new ReqDto();
		req.setId(bean.getId());
		req.setUserName(bean.getUsername());
		req.setPassWord(bean.getPassword());
		
		int i=dao.insertData(req);
		if(i>0)
		{
			response.sendRedirect("Alert.jsp");
		}
		else
		{
			response.sendRedirect("Error.jsp");
		}
		
		
	}

}
