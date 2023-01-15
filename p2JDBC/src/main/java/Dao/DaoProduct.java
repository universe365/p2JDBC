package Dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.product;

public class DaoProduct implements implProduct {

	@Override
	public void addProduct(Object o) {
		String sql = "INSERT INTO product(description, image, image_name, name, price,discount, product_category) VALUES(?,?,?,?,?,?,?)";
		Connection conn = Conn.getDB();
		product p = (product) o;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getImage());
			ps.setString(3, p.getImage_name());
			ps.setString(4, p.getName());
			ps.setInt(5, p.getPrice());
			ps.setInt(6, p.getDiscount());
			ps.setString(7, p.getProduct_category());
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		System.out.println("ADD COMPLETED");
	}

	@Override
	public List<Object> queryAll() {
		String sql = "SELECT * FROM product";
		List<Object> list = new ArrayList();
		Connection conn = Conn.getDB();
		try {
			PreparedStatement  ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setImage_name(rs.getString("image_name"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDiscount(rs.getInt("discount"));
				p.setProduct_category(rs.getString("product_category"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Object queryId(int id) {
		String sql = "SELECT * FROM product WHERE id=?";
		Connection conn = Conn.getDB();
		product p = null;
		try {
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setImage_name(rs.getString("image_name"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDiscount(rs.getInt("discount"));
				p.setProduct_category(rs.getString("product_category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public  List<Object> queryCategory(String product_category) {
		String sql = "SELECT * FROM product WHERE product_category=?";
		Connection conn = Conn.getDB();
		List<Object> list = new ArrayList();
		try {
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setString(1, product_category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setImage_name(rs.getString("image_name"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDiscount(rs.getInt("discount"));
				p.setProduct_category(rs.getString("product_category"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public  List<Object> queryPrice(int price) {
		String sql = "SELECT * FROM product WHERE price=?";
		Connection conn = Conn.getDB();
		List<Object> list = new ArrayList();
		try {
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setInt(1, price);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setImage_name(rs.getString("image_name"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDiscount(rs.getInt("discount"));
				p.setProduct_category(rs.getString("product_category"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object> queryName(String name) {
		String sql = "SELECT * FROM product WHERE name=?";
		Connection conn = Conn.getDB();
		List<Object> list = new ArrayList();
		try {
			PreparedStatement  ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product p = new product();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("image"));
				p.setImage_name(rs.getString("image_name"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDiscount(rs.getInt("discount"));
				p.setProduct_category(rs.getString("product_category"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Object o) {
		String sql = "UPDATE product SET description=?, image=?, image_name=?, name=?, price=?,discount=?, product_category=? WHERE id=?";
		product p = (product)o;
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getImage());
			ps.setString(3, p.getImage_name());
			ps.setString(4, p.getName());
			ps.setInt(5, p.getPrice());
			ps.setInt(6, p.getDiscount());
			ps.setString(7, p.getProduct_category());
			ps.setInt(8, p.getId());
			ps.executeUpdate();
		}catch(SQLException e) { e.printStackTrace();}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id=?";
		Connection conn = Conn.getDB();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		System.out.println("DELETE COMPLETED");
	}
	

	public static void main(String[] args) {
//		System.out.println(new DaoProduct().queryPrice(100));
//		new DaoProduct().addProduct(new product("N/A","N/A","N/A","productA",115,"C"));
//		product np =(product) new DaoProduct().queryId(3);
//		np.setDescription("this is a description test");
//		new DaoProduct().update(np);
//		new DaoProduct().delete(9);
	}

}
