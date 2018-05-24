package com.imooc.jdbc.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.chenmo.jdbc.utils.JDBCUtils;

/**
 * ÑÝÊ¾JDBC µÄ×¢ÈëÂ©¶´
 * @author chenmo
 *
 */

public class JdbcDemo3 {
	
	@Test
	public void Demo() {
		
		boolean flag = JdbcDemo3.login2("aaa' or '1=1", "111");
		if(flag ==true) {
			System.out.println("success");
		}else {
			System.out.println("error");
		}
		
	}

public static boolean  login2(String username,String password){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			
			conn = JDBCUtils.getConnection();
			String sql = "select * from user where username = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}else {
				flag = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.release(rs, pstmt, conn);
		}
		
		return flag;
		
}
	
	
	public static boolean  login(String username,String password){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			
			conn = JDBCUtils.getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				flag =  true;
			}else {
				flag = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally{
			
			JDBCUtils.release(rs, stmt, conn);
		}
		
		
		return flag;
		
	}
	
	
}
