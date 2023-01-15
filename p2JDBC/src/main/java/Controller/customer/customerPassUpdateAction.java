package Controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoCustomer;
import Model.customer;

public class customerPassUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public customerPassUpdateAction() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String password = request.getParameter("upassword");
		String idstr = request.getParameter("pid");
		
		if(idstr!="" && idstr!=null) {

			
			int id = Integer.parseInt(idstr);
			
			new DaoCustomer().update(password, id);
			
			response.sendRedirect("admin/customer_page.jsp");
		}
		
	}

}
