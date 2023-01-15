package Dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.cart;

public class DaoCart implements implCart {

	@Override
	public void addCart(Object o) {
		String sql = "INSERT INTO cart(customer_id, product_id, quantity, total_price, discount_price) VALUES(?,?,?,?,?)";
		Connection conn = Conn.getDB();
		cart c = (cart) o;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getCustomer_id());
			ps.setInt(2, c.getProduct_id());
			ps.setInt(3, c.getQuantity());
			ps.setInt(4, c.getTotal_price());
			ps.setInt(5, c.getDiscount_price());
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		System.out.println("cart ADD COMPLETED");
	}

	@Override
	public List<Object> queryAll() {
		String sql = "SELECT * FROM cart";
		Connection conn = Conn.getDB();
		List<Object> list= new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cart c = new cart();
				c.setId(rs.getInt("id"));
				c.setCustomer_id(rs.getInt("customer_id"));
				c.setProduct_id(rs.getInt("product_id"));
				c.setDiscount_price(rs.getInt("discount_price"));
				c.setTotal_price(rs.getInt("total_price"));
				c.setQuantity(rs.getInt("quantity"));
				list.add(c);
			}
		}catch(SQLException e) {e.printStackTrace();}
		
		return list;
	}

	@Override
	public List<Object> queryCustomer(int customer_id) {
		String sql = "SELECT * FROM cart WHERE customer_id=?";
		Connection conn = Conn.getDB();
		List<Object> list=  new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cart c = new cart();
				c = new cart();
				c.setId(rs.getInt("id"));
				c.setCustomer_id(rs.getInt("customer_id"));
				c.setDiscount_price(rs.getInt("discount_price"));
				c.setProduct_id(rs.getInt("product_id"));
				c.setQuantity(rs.getInt("quantity"));
				c.setTotal_price(rs.getInt("total_price"));
				list.add(c);
			}
		}catch(SQLException e) {e.printStackTrace();}
		return list;
	}

	@Override
	public Object queryCustomer(int customer_id, int product_id) {
		String sql = "SELECT * FROM cart WHERE customer_id=? and product_id=?";
		Connection conn = Conn.getDB();
		cart c = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, customer_id);
			ps.setInt(2, product_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c = new cart();
				c.setId(rs.getInt("id"));
				c.setCustomer_id(rs.getInt("customer_id"));
				c.setDiscount_price(rs.getInt("discount_price"));
				c.setProduct_id(rs.getInt("product_id"));
				c.setQuantity(rs.getInt("quantity"));
				c.setTotal_price(rs.getInt("total_price"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return c;
	}
	

	@Override
	public void update(int quantity, int id) {
		String sql = "UPDATE cart SET  quantity=? WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM cart WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
//		cart c = new cart(1,1,1,1,1);
//		new DaoCart().addCart(c);
//		List<Object> c = new DaoCart().queryCustomer(1);
//		System.out.println(c);
//		new DaoCart().delete(2);
	}

}
