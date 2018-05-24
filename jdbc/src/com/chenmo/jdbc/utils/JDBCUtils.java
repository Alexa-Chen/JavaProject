package com.chenmo.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Statement;

/**
 * jdbc utils
 * @author chenmo
 *
 */

public class JDBCUtils {
	
    private static  final String url; 
	
	private static  final String username;
	
	private static  final String password; 
	
	private static  final String driverClass;
	
	static {
		
		//加载属性文件并解析
		
		Properties props = new Properties();
		
		InputStream is =  JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properies");
		try {
			props.load(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driverClass = props.getProperty("driverClass");
		url = props.getProperty("url");
		username = props.getProperty("username");
		password = props.getProperty("password");
		 
	}

	/**
	 * 注册驱动
	 * @throws ClassNotFoundException
	 */
	
	public static void loadDriver() throws ClassNotFoundException {
		
		Class.forName(driverClass);
	}
	
	/**
	 * 获得连接
	 * @return
	 * @throws Exception
	 */
	
	
	public static Connection  getConnection() throws Exception {
		
		 Connection conn =  DriverManager.getConnection(url,username,password);
		
		 return conn;
		
	}
	
	
	/**
	 * 资源释放
	 */
	
	public static void release(Statement stmt, Connection conn) {
	
		if(stmt != null) {
			try {
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null) {
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		
	}
	
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
    	
    	if(rs != null) {
			try {
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			    rs = null;
		}
    	    	
    	if(stmt != null) {
			try {
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null) {
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
