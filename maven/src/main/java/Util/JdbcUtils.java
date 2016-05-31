package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
/*
 *  
 * 	
 */
public class JdbcUtils {
	
	private static String driverClass = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static{		
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		driverClass = bundle.getString("driverClass");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
		
	}
	
	
	//������Ӷ���
	public static Connection getConnection(){
		
		
		loadDriver();
		
		
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	private static void loadDriver() {
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	public static void release(ResultSet rs, Statement stmt, Connection conn){
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			rs=null;
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=null;
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=null;
		}
		
	}
	
	
	
}
