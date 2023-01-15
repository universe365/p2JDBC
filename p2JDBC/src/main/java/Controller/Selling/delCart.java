package Controller.Selling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoCart;

public class delCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public delCart() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new DaoCart().queryAll();
		
		String q = request.getParameter("qty");
		String i = request.getParameter("cid");
		
		System.out.println("q:"+q);
		
		new DaoCart().delete(Integer.parseInt(q));
		response.sendRedirect("selling/cart.jsp");
		
		
	}

}
