package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import com.dao.RepairOpDAO;
import com.model.*;

public class ApplyRepairServlet  extends HttpServlet{
	
	RepairOpDAO ApplyDao=new RepairOpDAO();
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		// HttpSession session=request.getSession();//session
		 String studentId=request.getParameter("stu_id");
		 String commitTime=request.getParameter("commit_time");
		 String reasons=request.getParameter("repair_reason");
		 
		 RepairRecord record=new RepairRecord(studentId,reasons);
		
		 Byte isStatus=Byte.parseByte("0");
		 try {
			 record.setStatus(isStatus);
			 ApplyDao.recordAdd(record);		 
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
