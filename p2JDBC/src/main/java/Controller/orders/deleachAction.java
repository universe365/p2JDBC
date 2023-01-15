package Controller.orders;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoOrders;
import Model.orders;

public class deleachAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleachAction() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String orderids = request.getParameter("did");
		String ordernos = request.getParameter("deonum");
		int orderid = Integer.parseInt(orderids);
		int orderno = Integer.parseInt(ordernos);
		
		orders order = (orders) new DaoOrders().queryId(orderid, orderno);
		
		if(order!=null) {
			new DaoOrders().delete(orderid, orderno);
		}
		
		response.sendRedirect("admin/orders_page.jsp");
	}

}
