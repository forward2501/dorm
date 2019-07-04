<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>宿管登录界面</title>
       <style type="text/css">
 
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
          function showFirst(){
        	 document.getElementById("FirstLiselect").style.display="block"; 
          }
          
          function hiddenFirst(){
              document.getElementById("FirstLiselect").style.display="none";
          }
          
          function showSecond(){
         	 document.getElementById("SecondLiselect").style.display="block"; 
           }
           
           function hiddenSecond(){
               document.getElementById("SecondLiselect").style.display="none";
           }
          
          
       </script>
    </head>
    <body>
       <div style="width:200px;height:300px;background-color:white;border:2px transparent;border-radius:15px;">
          <div style="background-color:blue;width:200px;height:40px;color:white;line-height:40px;font-size:20px;border:2px transparent;border-radius:10px">菜单栏</div>
          <div style="background-color:white;width:200px;">
       <ul class="menu">
         <li onmouseleave="hiddenFirst()"><a onmouseover="showFirst()" style="font-size:20px;"  href="#">报修管理</a>
              <ul id="FirstLiselect" style="display:none">
                <li><a href="../recordingServlet" target="right">查看未处理记录</a></li>
                <li><a href="../recordedServlet" target="right">查看已完成记录</a></li>
              </ul>         
         </li>
         <li onmouseleave="hiddenSecond()"><a onmouseover="showSecond()" style="font-size:20px;"  href="#">晚归管理</a>
            <ul  id="SecondLiselect" style="display:none">
               <li><a href="registerLater.jsp" target="right">登记</a></li>
               <li><a href="../lateRecordServlet" target="right">查看记录</a></li>
            </ul>     
         </li>
         <li><a href="DormUpdatePw.jsp" target="right" style="font-size:20px">修改密码</a></li>
         <li><a href="../loginOutServlet" target=_top style="font-size:20px">退出系统</a></li>
       </ul>
       </div>
       </div>

    </body>
</html>