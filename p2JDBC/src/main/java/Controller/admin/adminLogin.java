package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoAdmin;
import Model.admin;

public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminLogin() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		admin a = (admin) new DaoAdmin().queryUser(name, password);
		if(a==null) {
			System.out.println("login Failure: a == null");
			response.sendRedirect("admin/login.jsp");
		}else {
			
			//create session
			HttpSession session= request.getSession();
			
			//store data in session (key, value)
			session.setAttribute("adid", a.getId());
			session.setAttribute("aduser", a.getName());
			
			//get session id:
			String sessionId = session.getId();
			System.out.println(sessionId);
			
//			//判斷此session是否為新建 
//			if(session.isNew()) {
//				response.getWriter().print("session created, session id: "+sessionId);
//			}else {
//				response.getWriter().print("session is already exist. session id:"+ sessionId);
//			}
			
			System.out.println("login success");
			response.sendRedirect("admin/loginSuccess.jsp");
		}
		
	}

}
