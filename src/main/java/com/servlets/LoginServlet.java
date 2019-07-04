package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.dao.UserLoginDAO;
import com.model.*;


public class LoginServlet  extends HttpServlet{
	
	 UserLoginDAO userDao=new UserLoginDAO ();
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 HttpSession session=request.getSession();//session
		 //用户名
		 String userName=request.getParameter("username");
		 //密码
		 String password=request.getParameter("password");
		 //用户类型
		 String userType=request.getParameter("userType");
		 //验证码
		 String verifyCode = request.getParameter("verifyCode");
		
	      //获得服务器session 存放数据 ,如果没有返回null
	     String sessionCacheData = (String) request.getSession().getAttribute("sessionCacheData");
	       //将服务器缓存session数据移除
	     request.getSession().removeAttribute("sessionCacheData");
		  
	     try {
		       Students currentStudent=null;
		       DormManagers currentDormer=null;
		      
		       if("dorm_manager".equals(userType)) {
			       DormManagers dormManager=new  DormManagers(userName,password);
			       currentDormer =userDao.DormLogin(dormManager);
			       if(currentDormer==null) {
				       request.setAttribute("message",0);
				       request.getRequestDispatcher("/login.jsp").forward(request, response);
				       return;
			       }
			       else {
				       if(sessionCacheData == null){
			                request.setAttribute("message", 2);
			                request.getRequestDispatcher("/login.jsp").forward(request, response);
			                return;
			           }
			            //比较
			           if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
			                //用户输入验证码错误
			                //存放request作用域
			        	  request.setAttribute("r_userName",userName);//自动填充用户名和密码
			        	  request.setAttribute("r_password", password);
			              request.setAttribute("message", 1);
			                //请求转发
			              request.getRequestDispatcher("/login.jsp").forward(request, response);
			              return;
			          }
			           session.setAttribute("userName",userName);
			           session.setAttribute("password", password);//登录成功，把用户名和密码保存在session中
			           session.setAttribute("userType",userType) ;
				      request.getRequestDispatcher("/admin/dormMain.jsp").forward(request, response);	     
			     }
		      }
		      else if("student".equals(userType)) {
			      Students student=new Students(userName,password);
			      currentStudent =userDao.StudentLogin(student);
			      String dormId=userDao.getDormId(student);
			      if(currentStudent==null) {
				        request.setAttribute("message",0);
				        request.getRequestDispatcher("/login.jsp").forward(request, response);
				        return;
			      }
			      else {
			    	  if(sessionCacheData == null){
			                request.setAttribute("message", 2);
			                request.getRequestDispatcher("/login.jsp").forward(request, response);
			                return;
			                
			           }
			            //比较
			           if(!sessionCacheData.equalsIgnoreCase(verifyCode)){
			                //用户输入验证码错误
			                //存放request作用域
			        	  request.setAttribute("r_userName",userName);//自动填充用户名和密码
				          request.setAttribute("r_password", password);
			              request.setAttribute("message", 1);
			                //请求转发
			              request.getRequestDispatcher("/login.jsp").forward(request, response);
			              return;
			          }
			           session.setAttribute("userName",userName);
			           session.setAttribute("password", password);//登录成功，把用户名和密码保存在session中
			           session.setAttribute("dormId",dormId);
			           session.setAttribute("userType",userType) ;
				      request.getRequestDispatcher("/student/studentMain.jsp").forward(request, response);   
			      }
		
		     }
		       
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
