package com.model;
import java.io.*;

public class DormManagers {
	private String workID;//学号
	private String password;//密码
	private String name;//姓名
	private Boolean sex;//性别
	private int  age;//年龄
	private String registerTime;//入职时间
	
    public DormManagers() {}
	
	public DormManagers(String workID,String password) {
		this.workID=workID;
		this.password=password;
	}
	
	public  DormManagers(String workID,String password,String name,Boolean sex,int age,String registerTime) {
		this.workID=workID;
		this.password=password;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.registerTime=registerTime;
	}
	
	public String getWorkID() {
		return workID;
	}
	
	public void setWorkID(String workID) {
	     this.workID=workID;
	}
	
	public String getDormManagerPw() {
		return password;
	}
	
	public void setDormManagerPw(String password) {
		this.password=password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	

	public Boolean getSex(){
		return sex;
	}
	
	public void  setSex(Boolean sex) {
		this.sex=sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(String registerTime) {
		this.registerTime=registerTime;
	}
	

}
