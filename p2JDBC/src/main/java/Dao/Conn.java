package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	
	public static void main(String[] args) {
		System.out.println(Conn.getDB());
	}
	
	public static Connection getDB() {
		
		String url = "jdbc:mysql://localhost:3306/project?UseUnicode=true &amt; caracterEncodeing=UTF-8";
		String user = "root";
		String password = "123456";
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
