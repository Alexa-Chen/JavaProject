package com.chenmo.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils2 {
	
	private static final ComboPooledDataSource datasource = new ComboPooledDataSource();
	

		
		/**
		 * �������
		 * @return
		 * @throws Exception
		 */
		
		
		public static Connection  getConnection() throws Exception {
			
			 Connection conn =  datasource.getConnection();
			
			 return conn;
			
		}
		
		
		/**
		 * ��Դ�ͷ�
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
