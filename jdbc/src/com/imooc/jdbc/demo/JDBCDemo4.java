package com.imooc.jdbc.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.chenmo.jdbc.utils.JDBCUtils;

public class JDBCDemo4 {

	
	@Test
	public void demo5() {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = JDBCUtils.getConnection();
			
			String sql = "select * from user where uid = ?";
			
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setObject(1, 2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt("uid") + "  " + rs.getString("username") + "  " + rs.getString("password") + "  " + rs.getString("name"));
				
			} 	
					
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			
			JDBCUtils.release(rs, pstmt, conn);
			
		}
		
		
	}
	
	
	
	@Test
	public void demo4() {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = JDBCUtils.getConnection();
			
			String sql = "select * from user";
			
			pstmt = conn.prepareStatement(sql);	
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				System.out.println(rs.getInt("uid") + "  " + rs.getString("username") + "  " + rs.getString("password") + "  " + rs.getString("name"));
				
			}
					
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			
			JDBCUtils.release(rs, pstmt, conn);
			
		}
		
		
	}
	
	
	
	@Test
	public void demo3() {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = JDBCUtils.getConnection();
			String sql = "delete from user where uid = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			
			int num =  pstmt.executeUpdate();
			
			if(num > 0) {
				System.out.println("success");
			}
			
		
			
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			
			JDBCUtils.release(pstmt, conn);
			
		}
		
		
	}
	
	
	
	@Test
	public void demo2() {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = JDBCUtils.getConnection();
			String sql = "update user set username = ?,password = ?,name = ? where uid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "www");
			pstmt.setString(2, "123456");
			pstmt.setString(3, "sdfd");
			pstmt.setInt(4, 6);
			
			int num =  pstmt.executeUpdate();
			
			if(num > 0) {
				System.out.println("success");
			}
			
		
			
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			
			JDBCUtils.release(pstmt, conn);
			
		}
		
		
	}
	
	@Test
	public void demo1() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = JDBCUtils.getConnection();
			String sql = "insert into user values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "qqq");
			pstmt.setString(2, "123");
			pstmt.setString(3, "zhang");
			
			int num =  pstmt.executeUpdate();
			if(num > 0) {
				System.out.println("success");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtils.release(pstmt, conn);
			
		}
		
	}
	
}
