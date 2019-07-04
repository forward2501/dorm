package com.dao;

import java.sql.*;
import com.db.DBConnection;
import com.model.*;
import java.text.*;
import java.util.Date;
//import java.sql.Date;
import java.util.*;

public class RepairOpDAO {

	public RepairOpDAO() {
	}

	public int getRepairCount() throws Exception {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		
		int rowCount = 0;

		try {
			con = DBConnection.getDBconnection();
			prepStmt = con.prepareStatement("select count(*) as rep_count from repair_table");
			rs = prepStmt.executeQuery();
			rs.next();
			rowCount = rs.getInt("rep_count");
			System.out.println(rowCount + 1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return rowCount+1;
	}

	public void recordAdd(RepairRecord repairRecord) throws Exception {

		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getDBconnection();
			RepairOpDAO repair = new RepairOpDAO();
			int recordId = repair.getRepairCount();
			//System.out.println("id" + recordId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			sdf.format(date);
			// System.out.println(repairRecord.studentID());
			// System.out.println(repairRecord.getReasons());
			// System.out.println( sdf.format(date));
			// System.out.println(repairRecord.getStatus());

			prepStmt = con.prepareStatement("insert into repair_table values(?,?,?,?,?)");
			prepStmt.setInt(1, recordId);
			prepStmt.setString(2, repairRecord.getStudentID());
			prepStmt.setString(3, repairRecord.getReasons());
			prepStmt.setDate(4, java.sql.Date.valueOf(sdf.format(date)));
			prepStmt.setByte(5, repairRecord.getStatus());

			System.out.println(java.sql.Date.valueOf(sdf.format(date)));
			System.out.println(repairRecord.getStudentID());
			System.out.println(repairRecord.getReasons());
			System.out.println(sdf.format(date));
			System.out.println(repairRecord.getStatus());
			prepStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
	}

	public List<RepairRecord> MyRecordLists(String id) throws Exception {// 列出我的报修记录

		List<RepairRecord> repairRecordLists = new ArrayList<RepairRecord>();

		RepairRecord record = null;
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		//System.out.println(id);

		try {
			con = DBConnection.getDBconnection();
			prepStmt = con.prepareStatement("select * from repair_table where stu_id=?");
			prepStmt.setString(1, id);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				java.sql.Date date = new java.sql.Date(rs.getDate(4).getTime());
				record = new RepairRecord();
				record.setRecordId(rs.getInt(1));
				record.setStudentID(rs.getString(2));
				record.setReasons(rs.getString(3));
				record.setCommitTime(date.toString());
				record.setStatus(rs.getByte(5));
				repairRecordLists.add(record);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return repairRecordLists;
	}

	public String getDormId(RepairRecord repairRecord) throws Exception {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		String dormId = null;

		try {
			con = DBConnection.getDBconnection();
			String selectDorm = "select dorm_id from student_table  where stu_id=?";
			prepStmt = con.prepareStatement(selectDorm);
			prepStmt.setString(1, repairRecord.getStudentID());
			rs = prepStmt.executeQuery();
			if (rs.next()) {// 有记录
				dormId = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		//System.out.println("寝室号" + dormId);
		return dormId;

	}

	public List<RepairRecord> RecordingLists(RepairRecord repairRecord) throws Exception {// 列出所有未处理报修记录
		List<RepairRecord> repairRecordingLists = new ArrayList<RepairRecord>();
		RepairRecord record = null;

		RepairOpDAO repair = new RepairOpDAO();

		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		List<String> dormIdLists = new ArrayList<>();

		try {
			con = DBConnection.getDBconnection();
			prepStmt = con.prepareStatement("select * from repair_table where status=?");
			prepStmt.setByte(1, (byte) 0);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				java.sql.Date date = new java.sql.Date(rs.getDate(4).getTime());
				record = new RepairRecord();
				record.setRecordId(rs.getInt(1));
				record.setStudentID(rs.getString(2));
				record.setReasons(rs.getString(3));
				record.setCommitTime(date.toString());
				record.setStatus(rs.getByte(5));
				dormIdLists.add(repair.getDormId(record));
				repairRecordingLists.add(record);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return repairRecordingLists;

	}

	public List<RepairRecord> RecordedLists(RepairRecord repairRecord) throws Exception {// 列出所有已处理报修记录

		List<RepairRecord> repairRecordedLists = new ArrayList<RepairRecord>();
		RepairRecord record = null;

		RepairOpDAO repair = new RepairOpDAO();

		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		List<String> dormIdListsYes = new ArrayList<>();

		try {
			con = DBConnection.getDBconnection();
			prepStmt = con.prepareStatement("select * from repair_table where status=?");
			prepStmt.setByte(1, (byte) 1);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				java.sql.Date date = new java.sql.Date(rs.getDate(4).getTime());
				record = new RepairRecord();
				record.setRecordId(rs.getInt(1));
				record.setStudentID(rs.getString(2));
				record.setReasons(rs.getString(3));
				record.setCommitTime(date.toString());
				record.setStatus(rs.getByte(5));
				dormIdListsYes.add(repair.getDormId(record));
				repairRecordedLists.add(record);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return repairRecordedLists;

	}

	public List<String> dormIdListsNo(RepairRecord repairRecord) throws Exception {

		List<RepairRecord> repairRecordLists = new ArrayList<RepairRecord>();
		RepairRecord record = null;

		RepairOpDAO repair = new RepairOpDAO();

		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		List<String> dormIdListsNo = new ArrayList<>();

		try {
			con = DBConnection.getDBconnection();
			prepStmt = con.prepareStatement("select * from repair_table where status=?");
			prepStmt.setByte(1, (byte) 0);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				java.sql.Date date = new java.sql.Date(rs.getDate(4).getTime());
				record = new RepairRecord();
				record.setRecordId(rs.getInt(1));
				record.setStudentID(rs.getString(2));
				record.setReasons(rs.getString(3));
				record.setCommitTime(date.toString());
				record.setStatus(rs.getByte(5));
				dormIdListsNo.add(repair.getDormId(record));
				repairRecordLists.add(record);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return dormIdListsNo;

	}

	public List<String> dormIdListsYes(RepairRecord repairRecord) throws Exception {

		List<RepairRecord> repairRecordLists = new ArrayList<RepairRecord>();
		RepairRecord record = null;

		RepairOpDAO repair = new RepairOpDAO();

		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		List<String> dormIdListsYes = new ArrayList<>();

		try {
			con = DBConnection.getDBconnection();
			prepStmt = con.prepareStatement("select * from repair_table where status=?");
			prepStmt.setByte(1, (byte) 1);
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				java.sql.Date date = new java.sql.Date(rs.getDate(4).getTime());
				record = new RepairRecord();
				record.setRecordId(rs.getInt(1));
				record.setStudentID(rs.getString(2));
				record.setReasons(rs.getString(3));
				record.setCommitTime(date.toString());
				record.setStatus(rs.getByte(5));
				dormIdListsYes.add(repair.getDormId(record));
				repairRecordLists.add(record);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}
		return dormIdListsYes;

	}


	public void addRecorded(RepairRecord repairRecord) throws Exception {// 修改状态为已完成

		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		int recordId = repairRecord.getRecordId();

		try {
			con = DBConnection.getDBconnection();
			String sentence = "update repair_table set status= ? where id= ?"; 
			prepStmt = con.prepareStatement(sentence);
			prepStmt.setByte(1, (byte) 1);
			prepStmt.setInt(2, recordId);
			prepStmt.executeUpdate();//更新
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, prepStmt, rs);
		}

	}

}
