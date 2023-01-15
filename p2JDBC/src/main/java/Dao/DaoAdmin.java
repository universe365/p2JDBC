package Dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.admin;

public class DaoAdmin implements implAdmin {

	@Override
	public void addAdmin(Object o) {
		String sql = "INSERT INTO admin(name, password, email) VALUES(?,?,?)";
		Connection conn = Conn.getDB();
		admin a = (admin) o;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getEmail());
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}

	@Override
	public List<Object> queryAll() {
		String sql = "SELECT * FROM admin";
		List<Object> list = new ArrayList();
		
		Connection conn = Conn.getDB();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				admin a = new admin();
				a.setId(rs.getInt("id"));
				a.setAdded_date(rs.getString("added_date"));
				a.setName(rs.getString("name"));
				a.setPassword(rs.getString("password"));
				a.setEmail(rs.getString("email"));
				list.add(a);
			}
			
		}catch(SQLException e) { e.printStackTrace(); }
		
		return list;
	}

	@Override
	public Object queryId(int id) {
		String sql = "SELECT *  FROM admin WHERE id=?";
		Connection conn = Conn.getDB();
		admin a=null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new admin();
				a.setId(rs.getInt("id"));
				a.setAdded_date(rs.getString("added_date"));
				a.setName(rs.getString("name"));
				a.setPassword(rs.getString("password"));
				a.setEmail(rs.getString("email"));
			}
		}catch(SQLException e) { e.printStackTrace(); }
		
		return a;
	}

	@Override
	public Object queryUser(String name) {
		String sql="SELECT * FROM admin WHERE name=?";
		Connection conn = Conn.getDB();
		admin a = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a=new admin();
				a.setId(rs.getInt("id"));
				a.setAdded_date(rs.getString("added_date"));
				a.setName(rs.getString("name"));
				a.setPassword(rs.getString("password"));
				a.setEmail(rs.getString("email"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return a;
	}

	@Override
	public Object queryUser(String name, String password) {
		String sql="SELECT * FROM admin WHERE name=? and password=?";
		Connection conn=Conn.getDB();
		admin a = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new admin();
				a.setId(rs.getInt("id"));
				a.setAdded_date(rs.getString("added_date"));
				a.setName(rs.getString("name"));
				a.setPassword(rs.getString("password"));
				a.setEmail(rs.getString("email"));
			}
		}catch(SQLException e) {e.printStackTrace();}
		
		return a;
	}

	@Override
	public void update(String password, int id) {
		String sql="UPDATE admin SET password=? WHERE id=?";
		Connection conn = Conn.getDB();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}

	@Override
	public void update(String name, String password, String email, int id) {
		String sql="UPDATE admin SET name=?, password=?, email=? WHERE id=?";
		Connection conn=Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
	}

	@Override
	public void delete(int id) {
		String sql="DELETE FROM admin WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}

	}
	

	public static void main(String[] args) {
		//queryAll queryId queryUser
//		System.out.println(new DaoAdmin().queryAll());
//		admin a =(admin) new DaoAdmin().queryUser("omega");
//		System.out.println(a.getId()+", "+a.getName()+","+ a.getAdded_date() +","+a.getPassword()+","+a.getEmail());
//		admin a1 =(admin) new DaoAdmin().queryUser("admin06","admin006");
//		System.out.println(a1.getId()+", "+a1.getName()+","+ a1.getAdded_date() +","+a1.getPassword()+","+a1.getEmail());
		//addAdmin
//		new DaoAdmin().addAdmin(new admin("test02","test02","test02@mail.com"));
//		System.out.println(new DaoAdmin().queryUser("test02", "test02"));
		//update
//		new DaoAdmin().update("testpass02", 17);
//		new DaoAdmin().update("test2","pass02","test2@yahoo.tw",17);
		//delete
//		new DaoAdmin().delete(17);
		
	}

}
