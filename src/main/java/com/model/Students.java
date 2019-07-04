package com.model;
import java.io.*;

public class Students {
	private String stuendID;//学号
	private String password;//密码
	private String name;//姓名
	private String academy;//学院
	private String theClass;//班级
	private String dormId;//寝室号
	private Boolean sex;//性别
	
	public Students() {}
	
	public Students(String stuendID,String password) {
		this.stuendID=stuendID;
		this.password=password;
	}
	
	public Students(String stuendID,String password,String name,String academy,String theClass,String dormId,Boolean sex) {
		this.stuendID=stuendID;
		this.password=password;
		this.name=name;
		this.academy=academy;
		this.theClass=theClass;
		this.dormId=dormId;
		this.sex=sex;
	}
	
	public String getStudentID() {
		return stuendID;
	}
	
	public void setStudentID(String stuendID) {
	     this.stuendID=stuendID;
	}
	
	public String getStudentPw() {
		return password;
	}
	
	public void setStudentPw(String password) {
		this.password=password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getAcademy() {
		return academy;
	}
	
	public void setAcademy(String academy) {
		this.academy=academy;
	}
	
	public String getTheClass() {
		return theClass;
	}
	
	public void setTheClass(String theClass) {
		this.theClass=theClass;
	}
	
	public String getDormId() {
		return dormId;
	}
	
	public void setDormId(String dormId) {
		this.dormId=dormId;
	}
	
	public Boolean getSex(){
		return sex;
	}
	
	public void  setSex(Boolean sex) {
		this.sex=sex;
	}
	
	
	

}
