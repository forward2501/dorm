package com.dao;

import java.sql.*;
import com.db.DBConnection;
import com.model.*;

public class UserPwChangeDAO {
   public void  stuPwChange(String studentID,String password) throws Exception{
	   

		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		try {
			con=DBConnection.getDBconnection();
			
			 String sql="update student_table set password=? where stu_id=?";
			    prepStmt=con.prepareStatement(sql);
			    prepStmt.setString(1,password);
			    prepStmt.setString(2, studentID);
			    prepStmt.executeUpdate();
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		
	  
   }
   
   public void  dormMgPwChange(String workId,String password) throws Exception{
	   

		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		try {
			con=DBConnection.getDBconnection();
	    String sql="update manager_table set password=? where work_id=?";
	    prepStmt=con.prepareStatement(sql);
	    prepStmt.setString(1,password);
	    prepStmt.setString(2, workId);
	    prepStmt.executeUpdate();
	    
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
  }
  
   
   
}
