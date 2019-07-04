package com.model;
import java.io.*;


public class LateRecord {
	private int recordId;//记录编号
	private String studentID ;//学号
	private String lateDate;//晚归日期
	private String lateTime;//晚归时间
	
	public LateRecord() {}
	
	public LateRecord(String studentID,String lateDate, String lateTime) {
		this.studentID=studentID;
        this.lateDate=lateDate;
        this.lateTime=lateTime;
	}
	
	public int getRecordId() {
		return recordId;
	}
	
	public void setRecordId(int recordId) {
		this.recordId=recordId;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID=studentID;
	}
	
	public String getLateDate() {
		return lateDate;
	}
	
	public void setLateDate(String lateDate) {
		this.lateDate=lateDate;
	}
	
	public String getLateTime() {
		return lateTime;
	}
	
	public void setLateTime(String lateTime) {
		this.lateTime=lateTime;
	}
	
	
}
