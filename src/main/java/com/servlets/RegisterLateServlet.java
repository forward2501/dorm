package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.dao.LateOpDAO;
import com.model.*;

public class RegisterLateServlet  extends HttpServlet {
	  LateOpDAO lateDao=new  LateOpDAO();
	  
	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 //HttpSession session=request.getSession();//session
		 
		 String studentId=request.getParameter("register_id");
		 String lateDate=request.getParameter("late_date");
		 String lateTime=request.getParameter("late_time");
			 
		 LateRecord record=new LateRecord(studentId,lateDate,lateTime);
		
		 try {
			 lateDao.LateRecordAdd(record);//增加一条记录 
		 }catch(Exception e) {
		     e.printStackTrace();
	      }finally {
		
	      }
	  }
		 
		 public void doGet(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        this.doPost(request, response);
		 } 
		 
	 }
	 

