package Controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.DaoCustomer;
import Model.customer;

public class customerUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public customerUpdateAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("uname");
		String address = request.getParameter("uaddress");
		String gender = request.getParameter("ugender");
		String email = request.getParameter("uemail");
		String phone = request.getParameter("uphone");
		String idstr = request.getParameter("uid");
		
		if(idstr!=null && idstr!="") {
			int id = Integer.parseInt(idstr);
			
			customer c =(customer) new DaoCustomer().queryId(id);
				if(gender!="" || gender!=null) {
					if(gender.equals("1")) {
						gender="F";
					}else if(gender.equals("2")) {
						gender="M";
					}else if(gender.equals("3")) {
						gender="O";
					}else{
						gender="N/A";
					}
				}else {
					gender = c.getGender();
				}
				if(name=="" || name==null) name = c.getName();
				if(address==""|| address==null) address =c.getAddress();
				if(email==""||email==null) email = c.getEmail();
				if(phone==""||phone==null) phone = c.getPhone();
					
				new DaoCustomer().update(address, gender, email, phone,name, id);
					
				response.sendRedirect("admin/customer_page.jsp");
			}
			
	}

}
