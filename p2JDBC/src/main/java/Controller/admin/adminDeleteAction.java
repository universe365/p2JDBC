package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoAdmin;

public class adminDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminDeleteAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("did");
		new DaoAdmin().delete(Integer.parseInt(id));
		response.sendRedirect("admin/admin_page.jsp");
	}

}
