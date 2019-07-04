package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.db.DBConnection;
import com.model.*;

import java.util.Date;
import java.text.*;

public class LateOpDAO {
	
	public int getLateCount()throws Exception{
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		int  rowCount=0;
		try {
			con=DBConnection.getDBconnection();
			prepStmt=con.prepareStatement("select * from late_table");
			rs = prepStmt.executeQuery();
			rs.last(); //移到最后一行
		    rowCount = rs.getRow();//得到当前行号，也就是记录数 
		   // System.out.println("下一条晚归记录:"+(rowCount+1));
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return  rowCount+1;	
	}
	
	
	
	public void LateRecordAdd(LateRecord lateRecord)throws Exception{
		
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;

		try {
			con=DBConnection.getDBconnection();
			LateOpDAO late=new LateOpDAO();
			int lateId=late.getLateCount();
			DateFormat  date1 = new SimpleDateFormat("yyyy-MM-dd"); 
			DateFormat  time1 = new SimpleDateFormat("HH:mm:ss"); 
			
			Date inputDate=date1.parse(lateRecord.getLateDate());
			Date inputTime=time1.parse(lateRecord.getLateTime());
			 
			prepStmt=con.prepareStatement("insert into late_table values(?,?,?,?)"); 
			prepStmt.setInt(1,lateId);
			prepStmt.setString(2,lateRecord.getStudentID());
			prepStmt.setDate(3,java.sql.Date.valueOf(date1.format(inputDate)));
			prepStmt.setTime(4,java.sql.Time.valueOf(time1.format(inputTime.getTime())));
		
			//System.out.println(lateRecord.getStudentID());
			
			 prepStmt.executeUpdate();			
			
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		
	}
	
     public List<LateRecord> LateRecordLists(LateRecord lateRecord)throws Exception{//列出所有报修记录
		
		List<LateRecord> lateRecordLists=new ArrayList<LateRecord>();
		
		LateRecord record=null;
		
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		
		try {
			con=DBConnection.getDBconnection();
			prepStmt=con.prepareStatement("select * from late_table"); 
			rs = prepStmt.executeQuery();
			while(rs.next()) {
				java.sql.Date date=new java.sql.Date(rs.getDate(3).getTime());
				java.sql.Time time=new java.sql.Time(rs.getTime(4).getTime());
				record=new LateRecord();
				record.setRecordId(rs.getInt(1));
				record.setStudentID(rs.getString(2));
				record.setLateDate(date.toString());
				record.setLateTime(time.toString());
				
				lateRecordLists.add(record);
				
			}
			
		}catch (Exception e)	{
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return lateRecordLists;	
	}

}
