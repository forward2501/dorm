<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>学生登录界面</title>
      
      <style type="text/css">
         
         #menu1{
            font-size:20px;
         }
         
         .menu li a:link {
            font-size:15px;
            color: #000000;
            text-decoration: none;
         }
   
         .menu li a:visited {
            font-size: 15px;
            color: #000000;;
            text-decoration: none;
         }
   
         .menu li a:hover {
            font-size: 15px;
            color:blue;
            text-decoration:underline;
         }
       </style>
       <script type="text/javascript">
          function show(){
        	 document.getElementById("FirstLiselect").style.display="block"; 
          }
          
          function hiddenE(){
              document.getElementById("FirstLiselect").style.display="none";
          }
       </script>
    </head>

    <body>
      <div style="width:200px;height:200px;background-color:white;border:2px transparent;border-radius:15px;">
      <div style="background-color:blue;width:200px;height:40px;color:white;line-height:40px;font-size:20px;border:2px transparent;border-radius:10px">菜单栏</div>
      <div style="background-color:white;width:200px;">
        <ul class="menu">
           <li  onmouseleave="hiddenE()"><a onmouseover="show()" id="menu1" href="#">报修管理</a>
              <ul id="FirstLiselect" style="display:none">
                <li><a href="ApplyRepair.jsp" target="right" id="select1">我要报修</a></li>
                <li><a href="../myRecordsServlet" target="right" id="select2">我的报修记录</a></li>
              </ul>
           </li>
           <li><a href="StuUpdatePw.jsp" target="right" id="select3" style="font-size:20px">修改密码</a></li>
           <li><a href="../loginOutServlet" target=_top  id="select4" style="font-size:20px">退出系统</a></li>
       </ul>
       </div>
      </div>
   </body>
</html>