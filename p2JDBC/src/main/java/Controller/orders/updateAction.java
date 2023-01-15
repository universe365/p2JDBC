package Controller.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.orders;
import Dao.DaoOrders;
import java.util.List;

import Dao.DaoOrders;


public class updateAction extends HttpServlet {
		private static final long serialVersionUID = 1L;
       
    public updateAction() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
		request.setCharacterEncoding("UTF-8");
		
		String onums = request.getParameter("uonum");//order number
		String status = request.getParameter("ustatus");
		int onum = Integer.parseInt(onums);
		
		List<Object> orderlist = new DaoOrders().queryOrderN(onum);
		
		if(orderlist!=null) {
			for(int i=0; i<orderlist.size(); i++) {
				orders o = (orders) orderlist.get(i);
				new DaoOrders().update( status, onum, o.getId());
			}
		}
		
		
		response.sendRedirect("admin/orders_page.jsp");
		
	}

}
