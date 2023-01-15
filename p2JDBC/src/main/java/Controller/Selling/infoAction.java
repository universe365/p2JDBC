package Controller.Selling;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.customer;
import Dao.DaoCustomer;


public class infoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public infoAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String user = (String) request.getSession().getAttribute("user");
		customer c = (customer) new DaoCustomer().queryUser("user");
		int id =c.getId();
		
		String address =request.getParameter("address");
		String gender =request.getParameter("gender");
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		
		if(address==null || address=="") {
			address = c.getAddress();
		}
		if(gender==null || gender=="") {
			gender = c.getGender();
		}
		if(email==null || email=="") {
			email = c.getEmail();
		}
		if(phone==null || phone=="") {
			phone = c.getPhone();
		}
		
		new DaoCustomer().update(address, gender, email, phone, id);
		
		response.sendRedirect("selling/customer/customer_home.jsp");
		
	}

}
