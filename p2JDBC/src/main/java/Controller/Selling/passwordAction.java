package Controller.Selling;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.customer;
import Dao.DaoCustomer;


public class passwordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public passwordAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String user = (String) request.getSession().getAttribute("user");
		String newPassword = request.getParameter("password");
		int id =((customer) new DaoCustomer().queryUser("user")).getId();
		
		new DaoCustomer().update(newPassword, id);
		
		response.sendRedirect("selling/customer/customer_home.jsp");
		
	}

}
