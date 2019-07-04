package com.dao;

import java.sql.*;
import com.db.DBConnection;
import com.model.*;

public class UserLoginDAO {
	
	public Students StudentLogin(Students student) throws Exception{
		Students resultStudent=null;
		
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		try {
			con=DBConnection.getDBconnection();
			prepStmt=con.prepareStatement("SELECT * FROM student_table WHERE stu_id=? and password=?"); 
			prepStmt.setString(1, student.getStudentID());
			prepStmt.setString(2, student.getStudentPw());
			rs=prepStmt.executeQuery();
			if(rs.next()) {
				resultStudent=new Students();
				resultStudent=new Students();
				resultStudent.setStudentID(rs.getString(1));
				resultStudent.setStudentPw(rs.getString(2));
				resultStudent.setName(rs.getString(3));
				resultStudent.setAcademy(rs.getString(4));
				resultStudent.setTheClass(rs.getString(5));
				resultStudent.setDormId(rs.getString(6));
				resultStudent.setSex(rs.getBoolean(7));	
				
			}
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		
		return resultStudent;
	}
	
	public DormManagers DormLogin(DormManagers dormManager) throws Exception{
		DormManagers resultDormer=null;
		
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		try {
			con=DBConnection.getDBconnection();
			prepStmt=con.prepareStatement("SELECT * FROM manager_table WHERE work_id=? and password=?"); 
			prepStmt.setString(1, dormManager.getWorkID());
			prepStmt.setString(2, dormManager.getDormManagerPw());
			rs=prepStmt.executeQuery();
			if(rs.next()) {
				resultDormer=new DormManagers();
				resultDormer.setWorkID(rs.getString(1));
				resultDormer.setDormManagerPw(rs.getString(2));
				resultDormer.setName(rs.getString(3));
				resultDormer.setSex(rs.getBoolean(4));
				resultDormer.setAge(rs.getInt(5));
				resultDormer.setRegisterTime(rs.getString(6));		
			}
		}
		catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
			
		return resultDormer;
	}
	
	public String getDormId(Students student) throws Exception{
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		String dormId=null;
		
		try {
			con=DBConnection.getDBconnection();
			String selectDorm="select dorm_id from student_table  where stu_id=?";
			prepStmt=con.prepareStatement(selectDorm); 
			prepStmt.setString(1, student.getStudentID());
			rs=prepStmt.executeQuery();
			if(rs.next()) {//有记录
				dormId=rs.getString(1);
			}
			
			
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return  dormId;
		
	}

}
