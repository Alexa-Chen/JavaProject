package com.imooc.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;


public class JDBCDemo2 {
	
	private static  final String URL = "jdbc:mysql://localhost:3306/jdbctest";
	
	private static  final String ROOT = "root";
	
	private static  final String PASSWORD = "root";
	
	
	@Test
	public void demo5() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
			
			stmt = conn.createStatement();
			
			String sql = "select * from user where uid = 2";
			
			stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(rs.getInt("uid") + "  " + rs.getString("username") + " " + rs.getString("password") + " " + rs.getString("name"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			if(rs  != null) {
				try {
					rs.close();
					
				}catch(SQLException sql) {
					sql.printStackTrace();
				}
				rs = null;
			}
			
			if(stmt != null) {
				try {
					
					stmt.close();
				
				}catch (SQLException sql) {
					sql.printStackTrace();
				}
				stmt = null;
			}
			
			if(conn != null) {
				try {
					
					conn.close();;
					
				}catch(SQLException sql) {
					sql.printStackTrace();
					
				}
				
				conn = null;
			}
		
	  }
}
	
	@Test
	public void demo4() {
		
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet resultSet = null;
		
		
		// 1 加载驱动
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			// 2 获得连接
			 conn = DriverManager.getConnection(URL,ROOT,PASSWORD);
			// 3 创建执行的sql语句对象 并且执行sql
			 String sql = "select * from user";
			//  创建执行sql的对象 
		    stmt  = conn.createStatement();
		    // 执行sql
		     resultSet = stmt.executeQuery(sql);
		    
		    while(resultSet.next()) {
		    	int uid = resultSet.getInt("id");
		    	String name = resultSet.getString("name");
		    	float price = resultSet.getFloat("price");
		    	String desp = resultSet.getString("desp");
		    	
		    	System.out.println("id : " + uid + " name : " + name + " price :" + price +"desp: " + desp);
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			
			if(resultSet != null) {
				try {
					resultSet.close();
					
				}catch(SQLException sqlEX) {
					sqlEX.printStackTrace();
					
				}
				resultSet = null;
			}
			
			if(stmt != null) {
				try {
					
					stmt.close();
					
				}catch(SQLException sqlEX) {
					sqlEX.printStackTrace();
					
				}
				stmt = null;
			}
			if(conn != null) {
				try {
					conn.close();
					
				}catch(SQLException sqlEX) {
					sqlEX.printStackTrace();
				}
				conn = null;
			}	
		}	
	}
	
	
	
	@Test
	public void  demo3() {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
			
			stmt = conn.createStatement();
			
			String sql = "delete from user where uid = 4";
			
			int i =  stmt.executeUpdate(sql);
			
			if(i > 0) {
				System.out.println("delete  successed");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			
			if(conn != null) {
				try {
					conn.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		
		
		
	}
	
	
	
	
     @Test	
	public void demo2() {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
			
			stmt = conn.createStatement();
			
			String sql = "update user set username = 'qqq',password = '456' where uid = 4";
			
			int i =  stmt.executeUpdate(sql);
			
			if(i > 0) {
				System.out.println("fix  successed");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			
			if(conn != null) {
				try {
					conn.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
	
	/**
	 * 保存操作
	 */

     
	@Test
	public void demo1() {
	
		Connection conn = null;
		Statement stmt = null;
		try {
			
			//注册驱动：
			Class.forName("com.mysql.jdbc.Driver");
			
			//获得连接
			
			conn = DriverManager.getConnection(URL,ROOT,PASSWORD);
			
			// 获得执行sql 语句执行对象 
			
			stmt = conn.createStatement();
			
			//编写sql
			
			String sql = "insert into user values(null,'eee','123','zhangsan')";
			
			// 执行sql 
			
			int i = stmt.executeUpdate(sql);
			
			if(i > 0) {
				System.out.println("save success!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			if(stmt != null) {
				try {
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			
			if(conn != null) {
				try {
					conn.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
	
}
