package Controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.product;
import Dao.DaoProduct;

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddProduct() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String description=request.getParameter("add_description");
		String name=request.getParameter("addname");
		String pricestr=request.getParameter("addprice");
		String discountstr=request.getParameter("add_discount");
		String category=request.getParameter("addcategoryOpt");
		String image=request.getParameter("addimage");
		String imageType=request.getParameter("addimageOpt");
		String image_name=request.getParameter("addimage_name");
		int price = Integer.parseInt(pricestr);
		int discount=0;
		
		if(discountstr!="" && discountstr!=null) {
			 discount = Integer.parseInt(discountstr);
		}
		
		
			product o = null;
			
			if( (description=="" || description==null) && (image=="" || image==null) && ( image_name=="" || image_name==null) ) {
				
				o =  new product(name, price, category);
			}else {
				o = new product(description, image+imageType, image_name, name, price,discount, category);
			}
			new DaoProduct().addProduct(o);
			
			response.sendRedirect("admin/products_page.jsp");
			
		
		
	}

}
