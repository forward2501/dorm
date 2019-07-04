package com.db;

import java.sql.*;

public class DBConnection {
	
	public static Connection getDBconnection() {
		try {
			 Class.forName("org.mariadb.jdbc.Driver"); //加载指定的数据库驱动程序
	         String dburl = "jdbc:mariadb://127.0.0.1:3306/dorm"; 
	         Connection conn= DriverManager.getConnection(dburl, "root", "my-secret-pw"); //获取连接对象
	         return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void closeDB(Connection conn,PreparedStatement pstm,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
			if(conn!=null) conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}	
}
