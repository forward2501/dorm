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

public class RecordIngServlet  extends HttpServlet{
	RepairOpDAO MyRecordDao=new RepairOpDAO();
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 RepairRecord record=new RepairRecord();//建立对象
		 
		 try {
		    List<RepairRecord> recordingList=MyRecordDao.RecordingLists(record); 
		    List<String> dormIdListsNo=MyRecordDao.dormIdListsNo(record);
		    request.setAttribute("RecordIngLists", recordingList);
		    request.setAttribute("dormIdListsNo", dormIdListsNo);
		    request.getRequestDispatcher("/admin/IncompleteRecords.jsp").forward(request,response);	 	    
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