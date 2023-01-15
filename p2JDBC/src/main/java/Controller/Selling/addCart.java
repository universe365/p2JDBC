package Controller.Selling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.customer;
import Model.cart;
import Model.product;

import Dao.DaoCustomer;
import Dao.DaoCart;
import Dao.DaoProduct;

import java.util.List;

public class addCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addCart() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String user = (String) session.getAttribute("user");
		int userId=0;
		if(user!=null){
			userId = ((customer) new DaoCustomer().queryUser(user)).getId();
		}
		
		//catch session
		ArrayList<String> plist = (ArrayList<String>) session.getAttribute("plist");
		
		//if 有東西
		if(plist!=null ){
			
			for(int i=0; i<plist.size(); i++){
				
				//抓資料先
				product p=null;
				String t = plist.get(i);
				List<Object> pl = new DaoProduct().queryName(t.toString());
				
				if(pl!=null){
					 p = (product) pl.get(0);
				}
				
				int discount=p.getDiscount();
				int ptotalprice = p.getPrice();
				if(discount!=0){
					ptotalprice = ptotalprice*discount/100;
				}
				
				
				int qty=0;
				//檢查是否有相同商品: 有:數量+1 沒有就不理他(數量=1)
				for(int j=0; j<=i; j++) {
						
						String current_product = t;
						String check_product = plist.get(j);
						
						
						if(current_product.equals(check_product)) {
							qty+=1;
						}
						
						
						
						
				} // 2.for end
				//調出此使用者所有cart紀錄
				cart querycart = (cart) new DaoCart().queryCustomer(userId, p.getId());
				
				if(querycart!=null) {
					new DaoCart().update(querycart.getQuantity()+qty, querycart.getId());
				}else {
					cart addc = new cart(userId, p.getId(), qty, ptotalprice, discount);
					new DaoCart().addCart(addc);
				}
					
				
				
				
			}// 1.for end
			System.out.println("add cart success");
			
			
		
		}
		
//		PrintWriter pw = response.getWriter();
//		pw.print(" addcart.java add cart success");
//		pw.print(" <script> alert('add cart') location.href=('selling/cart.jsp') ");
		response.sendRedirect("selling/cart.jsp");
		
	}
}
