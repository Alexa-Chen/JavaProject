package com.imooc.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;


public class JdbcDemo1 {
	
	@Test
	
	public void demo1() {
		
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet resultSet = null;
		
		
		// 1 ��������
		try {
			//DriverManager.registerDriver(new Driver());
			
			Class.forName("com.mysql.jdbc.Driver");
			// 2 �������
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "root");
			// 3 ����ִ�е�sql������ ����ִ��sql
			String sql = "select * from goods where price <= 3500";
			//  ����ִ��sql�Ķ��� 
		    stmt  = conn.createStatement();
		    // ִ��sql
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
}
