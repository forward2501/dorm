package com.model;
import java.io.*;

public class RepairRecord {
	private int recordId;//记录编号
	private String studentID ;//学号
	private String reasons;//报修原因
	private String commitTime;//报修时间
	private Byte status;//处理状态
	
	public RepairRecord() {}
	
	public RepairRecord(String studentID,String reasons) {
		this.studentID=studentID;
		this.reasons=reasons;
	}
	
	public RepairRecord(int recordId) {
		this.recordId=recordId;
	}
	
	public RepairRecord(String studentID,String commitTime,String reasons,Byte status) {
		this.studentID=studentID;
		this.commitTime=commitTime;
		this.status=status;
		this.reasons=reasons;
	}
	
	
	
	public RepairRecord(String studentID) {
		this.studentID=studentID;
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
	
	public String getReasons() {
		return reasons;
	}
	
	public void setReasons(String reasons) {
		this.reasons=reasons;
	}
	
	public String getCommitTime() {
		return commitTime;
	}
	
	public void setCommitTime(String commitTime) {
		this.commitTime=commitTime;
	}
	
	public Byte getStatus() {
		return status;
	}
	
	public void setStatus(Byte status) {
		this.status=status;
	}
}
