package Controller.orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoOrders;
import Model.customer;
import Model.orders;

import Dao.DaoCustomer;
import Model.product;
import Dao.DaoProduct;

public class addAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addAction() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String de="N/A";
		String userids = request.getParameter("adduserid");
		String postal = request.getParameter("addpostal");
		String pname = request.getParameter("addproduct");
		String qtys = request.getParameter("addqty");
		String email=de;
		String address=de;
		String mobile=de;
		String username=de;
		
		List<Object> orderlist = new DaoOrders().queryAll();
	
		int order_no= (int) new DaoOrders().random_id(orderlist),
			userid=0,
			qty=0;
		
		product p = (product) new DaoProduct().queryName(pname).get(0);
		boolean status;
		String image = p.getImage();
		String imagename = p.getImage_name();
		String orderstatus="InProgress";
		int product_selling_price=p.getPrice(), price=p.getPrice();
		
		if(p.getDiscount()!=0) product_selling_price = p.getDiscount()*price/100;
		
		if( userids !=null && qtys!=null) {
			userid = Integer.parseInt(userids);
			qty = Integer.parseInt(qtys);
			
		}else {
			response.sendRedirect("admin/orders_page.jsp");
		}
		
		customer c = (customer) new DaoCustomer().queryId(userid);
		if(c!=null) {
			email = c.getAddress();
			address = c.getAddress();
			mobile = c.getPhone();
			username = ( (customer) new DaoCustomer().queryId(userid) ).getName();
		}
		
		orders o = (orders) new orders(order_no, username, mobile, email, address, postal, image, imagename, pname,
				qty, price ,product_selling_price, product_selling_price, orderstatus, userid);
		
		status = new DaoOrders().addOrder(o);
		
		PrintWriter pw = response.getWriter();
		
		if(status==true) {
			response.sendRedirect("admin/orders_page.jsp");
		}
		
		
//		response.sendRedirect("admin/orders_page.jsp");
	}

}
