<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>学生登录界面</title>
       <link rel="icon" href="../images/favicon.ico" type="images/x-icon">
       <link rel="shortcut icon" href="images/favicon.ico" type="images/x-icon">
       <style type="text/css">
          #leftFrame{
            background-color:#F0F8FF;
          }     
        </style>
    </head>
    
   <frameset rows="110,*">
       <frame src="student/studentTop.jsp" name="top" scrolling="no" noresize>
       <frameset cols="220,*">
         <frame src="student/studentLeft.jsp" id="leftFrame" name="left" scrolling="no" noresize>
         <frame src="student/studentRight.jsp" name="right" scrolling="no" noresize>
       </frameset>
    </frameset>
    <noframes><body></body></noframes>
      
</html>