package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Model.orders;

public class DaoOrders implements implOrders {

	@Override
	public boolean addOrder(Object o) {
		boolean status=false;
		String sql = "INSERT INTO orders(order_no,customer_name,mobile_number,email_id,"
				+ "address,address_type,image,image_name,product_name,quantity,product_price,"
				+ "product_selling_price,product_total_price,order_status,customer_id) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = Conn.getDB();
		orders or = (orders)o;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, or.getOrder_no());
			ps.setString(2, or.getCustomer_name());
			ps.setString(3, or.getMobile_number());
			ps.setString(4, or.getEmail_id());
			ps.setString(5, or.getAddress());
			ps.setString(6, or.getAddress_type());
			ps.setString(7, or.getImage());
			ps.setString(8, or.getImage_name());
			ps.setString(9, or.getProduct_name());
			ps.setInt(10, or.getQuantity());
			ps.setInt(11, or.getProduct_price());
			ps.setInt(12, or.getProduct_selling_price());
			ps.setInt(13, or.getProduct_total_price());
			ps.setString(14, or.getOrder_status());
			ps.setInt(15, or.getCustomer_id());
			ps.executeUpdate();
			status=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("ADD COMPLETED");
		return status;
	}

	@Override
	public List<Object> queryAll() {
		String sql = "SELECT * FROM orders";
		Connection conn = Conn.getDB();
		List<Object> list = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orders or = new orders();
				or.setId(rs.getInt("id"));
				or.setOrder_no(rs.getInt("order_no"));
				or.setCustomer_name(rs.getString("customer_name"));
				or.setMobile_number(rs.getString("mobile_number"));
				or.setEmail_id(rs.getString("email_id"));
				or.setAddress(rs.getString("address"));
				or.setAddress_type(rs.getString("address_type"));
				or.setImage(rs.getString("image"));
				or.setImage_name(rs.getString("image_name"));
				or.setProduct_name(rs.getString("product_name"));
				or.setQuantity(rs.getInt("quantity"));
				or.setProduct_price(rs.getInt("product_price"));
				or.setProduct_selling_price(rs.getInt("product_selling_price"));
				or.setProduct_total_price(rs.getInt("product_total_price"));
				or.setOrder_status(rs.getString("order_status"));
				or.setOrder_date(rs.getString("order_date"));
				or.setCustomer_id(rs.getInt("customer_id"));
				list.add(or);
			}
		}catch(SQLException e) { e.printStackTrace(); }
		return list;
	}

	@Override
	public Object queryId(int id, int order_no) {
		String sql = "SELECT * FROM orders WHERE id=? AND order_no=?";
		Connection conn = Conn.getDB();
		orders or = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, order_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				or = new orders();
				or.setId(rs.getInt("id"));
				or.setOrder_no(rs.getInt("order_no"));
				or.setCustomer_name(rs.getString("customer_name"));
				or.setMobile_number(rs.getString("mobile_number"));
				or.setEmail_id(rs.getString("email_id"));
				or.setAddress(rs.getString("address"));
				or.setAddress_type(rs.getString("address_type"));
				or.setImage(rs.getString("image"));
				or.setImage_name(rs.getString("image_name"));
				or.setProduct_name(rs.getString("product_name"));
				or.setQuantity(rs.getInt("quantity"));
				or.setProduct_price(rs.getInt("product_price"));
				or.setProduct_selling_price(rs.getInt("product_selling_price"));
				or.setProduct_total_price(rs.getInt("product_total_price"));
				or.setOrder_status(rs.getString("order_status"));
				or.setOrder_date(rs.getString("order_date"));
				or.setCustomer_id(rs.getInt("customer_id"));
			}
		}catch(SQLException e) { e.printStackTrace(); }
		return or;
	}

	@Override
	public Object queryId(int id) {
		String sql = "SELECT * FROM orders WHERE id=? ";
		Connection conn = Conn.getDB();
		orders or = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				or = new orders();
				or.setId(rs.getInt("id"));
				or.setOrder_no(rs.getInt("order_no"));
				or.setCustomer_name(rs.getString("customer_name"));
				or.setMobile_number(rs.getString("mobile_number"));
				or.setEmail_id(rs.getString("email_id"));
				or.setAddress(rs.getString("address"));
				or.setAddress_type(rs.getString("address_type"));
				or.setImage(rs.getString("image"));
				or.setImage_name(rs.getString("image_name"));
				or.setProduct_name(rs.getString("product_name"));
				or.setQuantity(rs.getInt("quantity"));
				or.setProduct_price(rs.getInt("product_price"));
				or.setProduct_selling_price(rs.getInt("product_selling_price"));
				or.setProduct_total_price(rs.getInt("product_total_price"));
				or.setOrder_status(rs.getString("order_status"));
				or.setOrder_date(rs.getString("order_date"));
				or.setCustomer_id(rs.getInt("customer_id"));
			}
		}catch(SQLException e) { e.printStackTrace(); }
		return or;
	}
	

	@Override
	public List<Object> queryOrderN(int order_no) {
		String sql = "SELECT * FROM orders WHERE order_no=?";
		Connection conn = Conn.getDB();
		List<Object> list= new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orders or = new orders();
				or = new orders();
				or.setId(rs.getInt("id"));
				or.setOrder_no(rs.getInt("order_no"));
				or.setCustomer_name(rs.getString("customer_name"));
				or.setMobile_number(rs.getString("mobile_number"));
				or.setEmail_id(rs.getString("email_id"));
				or.setAddress(rs.getString("address"));
				or.setAddress_type(rs.getString("address_type"));
				or.setImage(rs.getString("image"));
				or.setImage_name(rs.getString("image_name"));
				or.setProduct_name(rs.getString("product_name"));
				or.setQuantity(rs.getInt("quantity"));
				or.setProduct_price(rs.getInt("product_price"));
				or.setProduct_selling_price(rs.getInt("product_selling_price"));
				or.setProduct_total_price(rs.getInt("product_total_price"));
				or.setOrder_status(rs.getString("order_status"));
				or.setOrder_date(rs.getString("order_date"));
				or.setCustomer_id(rs.getInt("customer_id"));
				list.add(or);
			}
		}catch(SQLException e) { e.printStackTrace(); }
		return list;
	}
	
	@Override
	public List<Object> queryByUserId(int customer_id) {
		String sql = "SELECT * FROM orders WHERE customer_id=?";
		Connection conn = Conn.getDB();
		List<Object> list= new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				orders or = new orders();
				or = new orders();
				or.setId(rs.getInt("id"));
				or.setOrder_no(rs.getInt("order_no"));
				or.setCustomer_name(rs.getString("customer_name"));
				or.setMobile_number(rs.getString("mobile_number"));
				or.setEmail_id(rs.getString("email_id"));
				or.setAddress(rs.getString("address"));
				or.setAddress_type(rs.getString("address_type"));
				or.setImage(rs.getString("image"));
				or.setImage_name(rs.getString("image_name"));
				or.setProduct_name(rs.getString("product_name"));
				or.setQuantity(rs.getInt("quantity"));
				or.setProduct_price(rs.getInt("product_price"));
				or.setProduct_selling_price(rs.getInt("product_selling_price"));
				or.setProduct_total_price(rs.getInt("product_total_price"));
				or.setOrder_status(rs.getString("order_status"));
				or.setOrder_date(rs.getString("order_date"));
				or.setCustomer_id(rs.getInt("customer_id"));
				list.add(or);
			}
		}catch(SQLException e) { e.printStackTrace(); }
		return list;
	}
	
	@Override
	public void update(String order_status, int order_no, int id) {
		String sql = "UPDATE orders SET order_status=? WHERE order_no=? and id=?";
		Connection conn = Conn.getDB();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, order_status);
			ps.setInt(2, order_no);
			ps.setInt(3, id);
			ps.executeUpdate();
			
		}catch(SQLException e) { e.printStackTrace(); }
		
		
		
		
	}

	@Override
	public void delete(int order_no) {
		String sql = "DELETE FROM orders WHERE order_no=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order_no);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	@Override
	public void delete(int id, int order_no) {
		String sql = "DELETE FROM orders WHERE order_no=? and id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order_no);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	
	@Override
	public Integer random_id(List<Object> orderlist) {
		Integer randomNum= (int) (Math.random()*100_000_000+1);
		//loop找有無重複id 沒有救回傳，
		if(orderlist!=null) {
			for(int i=0; i<orderlist.size(); i++ ) {
				orders o = (orders) orderlist.get(i);
				int orderno = o.getOrder_no();
				if(orderno==randomNum) {
					//一樣 重建
					random_id(orderlist);
				}
			}
		}
		return randomNum;
	}
	

	public static void main(String[] args) {
//		System.out.println((long)(Math.random()*100_000_000+1));
		System.out.println( new DaoOrders().queryByUserId(1));
		System.out.println( ((orders)new DaoOrders().queryId(1, 32445340)).getOrder_date()  );
	}



}
