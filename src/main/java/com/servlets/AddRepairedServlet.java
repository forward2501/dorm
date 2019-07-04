package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.dao.RepairOpDAO;
import com.model.*;



public class AddRepairedServlet extends HttpServlet{
	
	RepairOpDAO dao=new RepairOpDAO();
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 	 
		 String stuId=request.getParameter("studentId");
		 String theDormId=request.getParameter("theDormId");
		 String comTime=request.getParameter("comTime");
		 String theStatus=request.getParameter("theStatus");
		 String theReason=request.getParameter("theReason");
		 String rId=request.getParameter("rId");
		
		 int recordId=Integer.parseInt(rId); 

		 RepairRecord record=new RepairRecord(recordId);
		 
		 try {
			 dao.addRecorded(record);
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
