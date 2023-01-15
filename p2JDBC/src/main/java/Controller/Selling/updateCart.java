package Controller.Selling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoCart;

/**
 * Servlet implementation class updateCart
 */
public class updateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateCart() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String qtys = request.getParameter("qty");
		String cIds = request.getParameter("cartId");
		int qty = Integer.parseInt(qtys);
		int cid = Integer.parseInt(cIds);
		
		//if qty>0 更新 else delete
		if(qty>0) {
			new DaoCart().update(qty, cid);
		}else {
			new DaoCart().delete(cid);
		}
		
//		System.out.println("qtys:"+qtys+" cartId:"+cIds);
//		PrintWriter pw = response.getWriter();
//		pw.print("<p>qty="+qty+" cid:"+cid);
//		pw.print("<br><a href='selling/cart.jsp'>回傳</a>");
		
		response.sendRedirect("selling/cart.jsp");

	}

}
