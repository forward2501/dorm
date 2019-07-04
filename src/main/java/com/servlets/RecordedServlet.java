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


public class RecordedServlet  extends HttpServlet{
	RepairOpDAO MyRecordDao=new RepairOpDAO();
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 RepairRecord record=new RepairRecord();//建立对象
		 
		 try {
		    List<RepairRecord> recordedList=MyRecordDao.RecordedLists(record);
		    List<String> dormIdListsYes=MyRecordDao.dormIdListsYes(record);
		    request.setAttribute("RecordedLists", recordedList);
		    request.setAttribute("dormIdListsYes", dormIdListsYes);
		    request.getRequestDispatcher("/admin/completeRecords.jsp").forward(request,response);	 	    
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
