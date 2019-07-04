package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import com.dao.LateOpDAO;
import com.model.*;

public class LateRecordsServlet extends HttpServlet{
	
	LateOpDAO lateDao=new LateOpDAO();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	// HttpSession session=request.getSession();//session	 
	 
	LateRecord record=new LateRecord();
	 try {
	    List<LateRecord> recordList=lateDao.LateRecordLists(record);
	    request.setAttribute("lateRecordLists", recordList);
	    request.getRequestDispatcher("/admin/LateRecords.jsp").forward(request, response);    
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
