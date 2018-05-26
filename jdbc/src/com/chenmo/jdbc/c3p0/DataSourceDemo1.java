package com.chenmo.jdbc.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.chenmo.jdbc.utils.JDBCUtils;
import com.chenmo.jdbc.utils.JDBCUtils2;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接池
 * @author chenmo
 *
 */

public class DataSourceDemo1 {
	
	
	/*
	 *  配置文件的方式 
	 */
	
	public void demo2() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
		//	ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			// 连接
			//conn = dataSource.getConnection();
			
			conn = JDBCUtils2.getConnection();
			
			String sql = "select * from user";
			
			//预编译
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("uid") + "  " + rs.getString("username") + "  " + rs.getString("password") + "  " + rs.getString("name"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			JDBCUtils2.release(rs, pstmt, conn);
		}		
	}


	/**
	 * 手动设置连接池
	 */
	
	@Test
	public void demo1() {
	
		// 获得连接
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			// 创建连接池
			
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			
			// 设置连接池的参数 
			
			 dataSource.setDriverClass("com.mysql.jdbc.Driver");
			 dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbctest");
			 dataSource.setUser("root");
			 dataSource.setPassword("root");
			 
			 dataSource.setMaxPoolSize(20);
			 dataSource.setInitialPoolSize(3);
			
			// 连接
			conn = dataSource.getConnection();
			
			String sql = "select * from user";
			
			//预编译
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getInt("uid") + "  " + rs.getString("username") + "  " + rs.getString("password") + "  " + rs.getString("name"));
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.release(rs, pstmt, conn);
		}
		
		
		
		
	}
}











