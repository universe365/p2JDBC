package Controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoAdmin;
import Dao.DaoCustomer;
import Model.admin;
import Model.customer;

public class AddCustomerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCustomerAction() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("addname");
		String password = request.getParameter("addpassword");
		String email = request.getParameter("addemail");
		String address = request.getParameter("add_address");
		String gender = request.getParameter("addgender");
		String phone = request.getParameter("addphone");
		
		if(gender!=null || gender!="") {
			if(gender.equals("1")) {
				gender = "F";
			}else if(gender.equals("2")) {
				gender = "M";
			}else if(gender.equals("3")) {
				gender = "O";
			}else {
				gender = "N/A";
			}
		}else gender ="";
		if(name==null) name="";
		if(password==null) password="";
		if(email==null) email="";
		if(address==null) address="";
		if(phone==null) phone="";

		customer c = new customer(name, password, address, email, phone, gender);
		
		new DaoCustomer().addCustomer(c);
		
		response.sendRedirect("admin/customer_page.jsp");
		
	}

}
