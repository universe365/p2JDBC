package Dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.customer;

public class DaoCustomer implements implCustomer {

	@Override
	public void addCustomer(Object o) {
		String sql = "INSERT INTO customer(name, password, address, email, phone, gender) VALUES(?,?,?,?,?,?)";
		Connection conn = Conn.getDB();
		customer c = (customer) o;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getPhone());
			ps.setString(6, c.getGender());
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}

	@Override
	public List<Object> queryAll() {
		String sql = "SELECT * FROM customer";
		Connection conn = Conn.getDB();
		List<Object> list = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer c = new customer();
				c.setId(rs.getInt("id"));
				c.setAdded_date(rs.getString("added_date"));
				c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getString("gender"));
				c.setPhone(rs.getString("phone"));
				list.add(c);
			}
		}catch(SQLException e) {e.printStackTrace();}
		return list;
	}

	@Override
	public Object queryId(int id) {
		String sql = "SELECT * FROM customer WHERE id=?";
		Connection conn = Conn.getDB();
		customer c =null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c=new customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setGender(rs.getString("gender"));
				c.setAdded_date(rs.getString("added_date"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return c;
	}

	@Override
	public Object queryUser(String name, String password) {
		String sql = "SELECT * FROM customer WHERE name=? and password=?";
		Connection conn =  Conn.getDB();
		customer c = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c=new customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setGender(rs.getString("gender"));
				c.setAdded_date(rs.getString("added_date"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return c;
	}

	@Override
	public Object queryUser(String name) {
		String sql = "SELECT * FROM customer WHERE name=?";
		Connection conn =  Conn.getDB();
		customer c = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c=new customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setGender(rs.getString("gender"));
				c.setAdded_date(rs.getString("added_date"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return c;
	}
	
	@Override
	public void update(String address, String gender, String email, String phone, int id) {
		String sql = "UPDATE customer SET address=?, gender=?, email=?, phone=? WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2, gender);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setInt(5, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		
	}

	@Override
	public void update(String password, int id) {
		String sql = "UPDATE customer SET password=? WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM customer WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		// queryAll
//		List<Object> list = new DaoCustomer().queryAll();
//		customer[] cus = list.toArray(new customer[list.size()]);
//		
//		for(customer c : cus) {
//			System.out.print(c.getId()+", Name: "+c.getName()+", Password: "+c.getPassword()+", Added_date: "+
//						c.getAdded_date()+", Address: "+c.getAddress()+", Gender: "+c.getGender()+", Email: "+
//						c.getEmail()+", Phone: "+c.getPhone()+"\n");
//		}
//		customer c = (customer) new DaoCustomer().queryId(20);
//		customer c = (customer) new DaoCustomer().queryUser("user20", "userpass20");
//		customer c = (customer) new DaoCustomer().queryUser("user12");
//		customer cus = new customer("usertest","userpass","addressuser","test@yahoo.tw.com","0123123012","F") ;
//		new DaoCustomer().addCustomer(cus);
//		customer c =(customer) new DaoCustomer().queryUser("usertest");
//		System.out.print(c.getId()+", Name: "+c.getName()+", Password: "+c.getPassword()+", Added_date: "+
//				c.getAdded_date()+", Address: "+c.getAddress()+", Gender: "+c.getGender()+", Email: "+
//				c.getEmail()+", Phone: "+c.getPhone()+"\n");
		
		//delete
//		new DaoCustomer().delete(62);
		
	}



}
