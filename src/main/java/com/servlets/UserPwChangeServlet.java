package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.dao.UserPwChangeDAO;
import com.model.*;

public class UserPwChangeServlet  extends HttpServlet{
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 UserPwChangeDAO userPwChange=new  UserPwChangeDAO();
		 
		 HttpSession session=request.getSession();//session
		 
		 String Id=(String)session.getAttribute("userName");
		 String trueOldPw=(String)session.getAttribute("password");//正确的旧密码
		 String userType=(String)session.getAttribute("userType");//用户类型
		 
		 
		 String oldPw=request.getParameter("old_pw");
		 String newPw=request.getParameter("new_pw");
		 
		// System.out.println("用户id:"+Id);
		// System.out.println("原密码:"+trueOldPw);
		// System.out.println("输入的原密码:"+oldPw);
		// System.out.println("再次密码:"+newPw);
		// System.out.println("用户类型:"+userType);
		 
		 	 
		 if("dorm_manager".equals(userType)) {//宿管改密
			 if(oldPw.equals(trueOldPw)) {
				 //System.out.println("修改成功！"); 
				 request.setAttribute("error_pw", "修改成功!");
				 request.setAttribute("error_order", "1");
				 try {
					    userPwChange.dormMgPwChange(Id,newPw);
					    request.getRequestDispatcher("/admin/DormUpdatePw.jsp").forward(request, response);
					 }catch(Exception e) {
					     e.printStackTrace();
				      }finally {
					
				      }	
		      
			 }
			 else {
				 request.setAttribute("error_pw","原密码输入错误!");
				 request.setAttribute("error_order", "0");
				 request.getRequestDispatcher("/admin/DormUpdatePw.jsp").forward(request, response);
				
			 }	  
		 }else if("student".equals(userType)) {//学生改密
		 
		         if(oldPw.equals(trueOldPw)){//输入的原密码正确
		        	 
		        	    //System.out.println("修改成功！"); 
				        request.setAttribute("error_pw","修改成功!");
				        request.setAttribute("error_order",1);
				        try {
				           userPwChange.stuPwChange(Id,newPw);
				           request.getRequestDispatcher("/student/StuUpdatePw.jsp").forward(request, response);
				        }catch(Exception e) {
				           e.printStackTrace();
			            }finally {
				
			            }
		        	 
	      
		         }
		         else {//不正确
		        	   // System.out.println("原密码输入错误");
				        request.setAttribute("error_pw","原密码错误，请重新输入!");
				        request.setAttribute("error_order",0);
				        //System.out.println(request.getAttribute("error_order"));
				       // System.out.println("错误");
			            request.getRequestDispatcher("/student/StuUpdatePw.jsp").forward(request, response);
		        }
	   }	 
		 
	 }
	 
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        this.doPost(request, response);
	    }

}
