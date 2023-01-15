package Controller.Selling;

import Model.customer;
import Dao.DaoCustomer;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class userLogin
 */
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		customer c = (customer) new DaoCustomer().queryUser(user, password);
		if(c==null) {
			response.sendRedirect("selling/customer/customerlogin.jsp");
		}else {
			
			HttpSession session = request.getSession();
			if(session.isNew()) {
				System.out.println("新建一個session. id:"+ session.getId());
			}else { System.out.println("session 訪問成功");
			
			session.setAttribute("user", user);
			
			}
			
			response.sendRedirect("selling/sells.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
