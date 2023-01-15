package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoAdmin;
import Model.admin;

public class addAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addAdminAction() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String name = request.getParameter("addname");
		String password = request.getParameter("addpassword");
		String email = request.getParameter("addemail");
		
		admin a = new admin(name, password, email);
		
		new DaoAdmin().addAdmin(a);
		
		response.sendRedirect("admin/admin_page.jsp");
		
		
	}

}
