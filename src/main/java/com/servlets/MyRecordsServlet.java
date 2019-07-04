package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import com.dao.RepairOpDAO;
import com.model.*;

public class MyRecordsServlet extends HttpServlet{
	
	RepairOpDAO MyRecordDao=new RepairOpDAO();

	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		
		 HttpSession session=request.getSession();//session
		 
		 String studentId=(String)session.getAttribute("userName");
		 //System.out.println("我的"+ studentId);
		 
		 RepairRecord record=new RepairRecord(studentId);
		 try {
		    List<RepairRecord> myRecordLists=MyRecordDao.MyRecordLists(studentId);
		    request.setAttribute("myRecordLists", myRecordLists);
		    request.getRequestDispatcher("/student/MyRepairRecords.jsp").forward(request, response);	    
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
