package Controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.product;
import Dao.DaoProduct;

public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProduct() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String description=request.getParameter("udescription");
		String name=request.getParameter("uname");
		String pricestr=request.getParameter("uprice");
		String discountstr=request.getParameter("udiscount");
		String category=request.getParameter("ucategoryOpt");
		String image=request.getParameter("uimage");
		String imageType=request.getParameter("uimageOpt");
		String image_name=request.getParameter("uimage_name");
		String idstr=request.getParameter("uid");
		int price;
		int discount;
		
		if(idstr!=null && idstr!="") {
			int id=Integer.parseInt(idstr);
			product o = (product) new DaoProduct().queryId(id);
			
			if(o==null) {
				
			}else {
				if(description=="" ||description ==null) {
					description=o.getDescription();
				}
				if(name==""|| name==null) {
					name=o.getName();
				}
				if(pricestr=="" || pricestr==null) {
					price=o.getPrice();
				}else {
					price = Integer.parseInt(pricestr);
				}
				if(discountstr==""|| discountstr==null) {
					discount=0;
				}else {
					discount = Integer.parseInt(discountstr);
				}
				if(image==""|| image==null) {
					image=o.getImage();
				}
				if(image_name==""||image_name==null) {
					image_name=o.getImage_name();
				}
				if(category==""||category==null) {
					category=o.getProduct_category();
				}
				System.out.println(category);
				o.setId(id);
				o.setDescription(description);
				o.setName(name);
				o.setPrice(price);
				o.setDiscount(discount);
				o.setProduct_category(category);
				o.setImage(image+imageType);
				o.setImage_name(image_name);
				
				new DaoProduct().update(o);
		
			}
					
			response.sendRedirect("admin/products_page.jsp");
		}
	}

}
