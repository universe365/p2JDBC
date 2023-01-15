package Controller.Selling;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;
import Model.orders;
import Model.cart;
import Model.customer;
import Model.product;
import Dao.DaoOrders;
import Dao.DaoProduct;
import Dao.DaoCustomer;
import Dao.DaoCart;



public class orderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public orderAction() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//用 session 抓 cart/customer 中所有資料
		//建立order 資料 (order_id 用DaoOrder().random_id() 製造)
		//建立完成 刪除cart 資料
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String user = (String) session.getAttribute("user");

		customer customerinfo = (customer) session.getAttribute("customerinfo");
		ArrayList<Object> productinfo = (ArrayList<Object>) session.getAttribute("productinfo");
		ArrayList<Object> cartinfo = (ArrayList<Object>) session.getAttribute("cartinfo");
		List<Object> orderlist = new DaoOrders().queryAll();
		
//		System.out.println(customerinfo+"\t"+productinfo+"\t"+cartinfo);
		
		
		
		//customer.java
		Integer customer_id = customerinfo.getId();
		String customer_name =customerinfo.getName();
		String mobile_number =customerinfo.getPhone();
		String email_id =customerinfo.getEmail();
		String address =customerinfo.getAddress();
		
		//session get from order.jsp
		int product_total_price = (Integer) session.getAttribute("totalSellingPrice");
		
		//order.java
		int order_no = new DaoOrders().random_id(orderlist);
		String order_status = "InProgress";
		String address_type = request.getParameter("postalcode"); //postalcode
		

		//product.java (用迴圈撈)
		String image=null;
		String image_name=null;
		String product_name=null;
		int product_price=0;
		
		//cart.java (用迴圈)
		int quantity=0;
		int product_selling_price=0;
		
		for(int i=0; i<cartinfo.size(); i++) {
			cart currcart = (cart) cartinfo.get(i);
			
			product p = (product) new DaoProduct().queryId(currcart.getProduct_id());
			image=p.getImage();
			image_name=p.getImage_name();
			product_name=p.getName();
			product_price=p.getPrice();
			
			//cart:
			quantity=currcart.getQuantity();
			product_selling_price=currcart.getTotal_price();
			
			
			//建立order資料:
			orders order = new orders(order_no, customer_name, mobile_number, email_id, address,
									address_type, image, image_name, product_name, quantity, product_price,
									product_selling_price, product_total_price,	order_status, customer_id);
			
			boolean addstatus = new DaoOrders().addOrder(order);
			
			
			//刪除cart資料:
			if(addstatus==true) {
				new DaoCart().delete(currcart.getId());
			}
			
		}
		//set order_no in session
		session.setAttribute("currentOrderNo", order_no);
		
		session.removeAttribute("customerinfo");
		session.removeAttribute("userinfo");
		session.removeAttribute("productinfo");
		
		response.sendRedirect("selling/customer/orderlist.jsp");
	}
	

}
