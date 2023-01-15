package Controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.product;
import Dao.DaoProduct;

public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProduct() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String idstr = request.getParameter("did");
		
		if(idstr!=null && idstr!="") {
			int id = Integer.parseInt(idstr);
			
			new DaoProduct().delete(id);
			
			response.sendRedirect("admin/products_page.jsp");
			
		}
		
		
	}

}
