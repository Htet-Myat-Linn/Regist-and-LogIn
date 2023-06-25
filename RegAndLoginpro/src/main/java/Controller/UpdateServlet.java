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
import Dto.RespDto;
import Model.UserBean;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao=new Dao();
		ReqDto dto=new ReqDto();
		dto.setId(request.getParameter("id"));
		
		//System.out.print(request.getParameter("id"));
		RespDto resp=dao.SelectOne(dto);
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("Update.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean=new UserBean();
		bean.setId(request.getParameter("id"));
		bean.setUsername(request.getParameter("username"));
		bean.setPassword(request.getParameter("password"));
		
		
		Dao dao=new Dao();
		
		
		ReqDto req=new ReqDto();
		req.setId(bean.getId());
		req.setUserName(bean.getUsername());
		req.setPassWord(bean.getPassword());
		
		int i=dao.UpdateData(req);
		if(i>0)
		{
			response.sendRedirect("DisplayServlet");
		}
		else
		{
			request.setAttribute("error","Update Fail");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
	}

}
