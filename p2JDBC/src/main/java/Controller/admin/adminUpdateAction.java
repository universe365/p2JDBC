package Controller.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoAdmin;
import Model.admin;
public class adminUpdateAction  extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public adminUpdateAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("uname");
		String password = request.getParameter("upassword");
		String email = request.getParameter("uemail");
		String idstr = request.getParameter("uid");
		int id = Integer.parseInt(idstr);
		
		
		if(!(idstr=="" && idstr==null)){
			admin a = (admin)new DaoAdmin().queryId(id);
			
			if(name==""||name==null) {
				name=a.getName();
			}
			if(password==""||password==null) {
				password=a.getPassword();
			}
			if(email=="" || email==null) {
				email=a.getEmail();
			}
			if(password=="" || password==null) {
				password=a.getPassword();
			}
			new DaoAdmin().update(name, password, email, id);
			
			response.sendRedirect("admin/admin_page.jsp");
		}
		
		
	}
}
