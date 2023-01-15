package Controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DaoCustomer;
import Model.customer;

import Dao.DaoCustomer;
import Model.customer;

public class customerDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public customerDeleteAction() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String idstr = request.getParameter("did");
		if(idstr!="" && idstr!=null) {
			int id = Integer.parseInt(idstr);
			
			new DaoCustomer().delete(id);
			
			response.sendRedirect("admin/customer_page.jsp");
		}
	}

}
