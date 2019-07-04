<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>宿舍管理系统登录</title>
       <link rel="icon" href="images/favicon.ico" type="images/x-icon">
       <link rel="shortcut icon" href="images/favicon.ico" type="images/x-icon">     
       <style type="text/css">
         body {
	         padding-top: 200px;
	         padding-bottom: 40px;
	         background-image: url("images/dorm_bg.png");
	         background-position: center center;
	         background-repeat: no-repeat; /*不重复*/
	         background-attachment: fixed; /*背景图像固定，不随页面滚动*/
	        -webkit-background-size: cover;
	         -moz-background-size: cover;
	        -o-background-size: cover;
	        background-size: cover; /* 让背景图基于容器大小伸缩 */
	        background-color: #6495ED;
	       /*-webkit-background-size: 100% 100%;
           -moz-background-size: 100% 100%;
          -o-background-size: 100% 100%;
           background-size: 100% 100%;*/
        }

        .login_div {
	        margin: 0 auto; /*水平垂直居中*/
	        background-color: steelblue;
	        border: 2px solid transparent;
	        border-radius: 20px;
	        width: 400px;
	       height: 350px;
	       text-align: center
      }

         tr td {
	        font-size: 20px;
        }

       .button {
	        width: 60px;
	        height: 30px;
	        font-size: 20px;
	        background-color: blue;
	        border: 0;
	        color: white;
	        margin: 5px;
       }

       .login_info {
	        display: none;
       }
       </style>
       
       <script type="text/javascript">
            function checkForm(){
            	var userName=document.getElementById("username").value;
            	var password=document.getElementById("password").value;
            	var verifyCode=document.getElementById("verifyCode").value;
            	var userTypes=document.getElementsByName("userType");
            	var userType=null;
            	for(var i=0;i<userTypes.length;i++){
            		if(userTypes[i].checked){
            			userType=userTypes[i].value;
            			break;
            		}
            	}
            	document.getElementById("login_info1").style.display="none";
            	document.getElementById("login_info2").style.display="none";
            	document.getElementById("login_info3").style.display="none";
            	document.getElementById("login_info4").style.display="none";
            	document.getElementById("login_info5").style.display="none";
            	document.getElementById("login_info6").style.display="none";
            	
            	
            	if(userName==null||userName==""){
            		document.getElementById("login_info1").style.display="block";
            		return false;
            	}
            	if(password==null||password==""){
            		document.getElementById("login_info2").style.display="block";
            		return false;
            	}
            	if(userType==null||userType==""){
            		alert("请选择用户类型！");
            		return false;
            	}
            	if(verifyCode==null||verifyCode==""){
            		document.getElementById("login_info3").style.display="block";
            		return false;
            	}   
            	
            	return true;    	     	
            }
            
            function refreshImg() {
    	           var img = document.getElementById("Img");
    	           img.src = "verifyCodeServlet? rnd="+Math.random();//刷新verifyCodeServlet,即验证码
            }
       
            function ininFunc(){
            	 var error_num=document.getElementById("message").value;
            	 if(error_num==0){
            		 document.getElementById("login_info4").style.display="block";
            	 }
            	 else if(error_num==1){
            		 document.getElementById("login_info5").style.display="block";
            		 document.getElementById("username").value="<%=request.getAttribute("r_userName")%>";
            		 document.getElementById("password").value="<%=request.getAttribute("r_password")%>";
            	 }
            	 else if(error_num==2){
            		 document.getElementById("login_info6").style.display="block";
            	 }
            	 else{
            		 
            	 }        	 
             }
       </script>
    </head>
    <body onload=ininFunc()>
       <div class="login_div"> 
           <form action="loginServlet" method="post" onsubmit="return checkForm()">
              <table style="margin:auto;border-collapse:separate; border-spacing:0px 10px;">
                  <caption style="color:white;font-size:30px;">宿舍管理系统</caption>
                  <tr>
                    <td>用户名:</td>
                    <td><input id="username" placeholder="学号或职工号" type="text" name="username" style="width:200px;height:20px;border-style:inset;"></td>
                  </tr>
                  <tr>
                    <td>密&nbsp;&nbsp;&nbsp;码:</td>
                    <td><input id="password" placeholder="密码"  type="password" name="password" style="width:200px;height:20px;border-style:inset;"></td>
                  </tr>
                  <tr>
                    <td>身&nbsp;&nbsp;&nbsp;份: </td>
                    <td align="left" style="font-size:15px;">
                      <input id="dorm_manager" type="radio" name="userType" value="dorm_manager" checked>宿舍管理员
                      <input id="student" type="radio" name="userType" value="student" >学生
                    </td>
                 </tr>
                 <tr>
                   <td>验证码:</td>
                   <td align="left"><input id="verifyCode" type="text" name="verifyCode"  style="width:100px;height:20px;size:5;"/>
                       <img id="Img" src="verifyCodeServlet"/><a href="#" style="color:black;font-size:15px;" onclick="refreshImg()">换一张</a>
                   </td>
                 </tr>
                 <tr>
                  <td><input class="login_info" type="hidden" name="message" id="message" value="<%=request.getAttribute("message")%>" /></td>
                 </tr>
                 
                 <tr>
                    <td align="left" colspan="2">
                       <span id="login_info1" style="font-size:15px;color:red;display:none;">用户名不能为空!</span>
                       <span id="login_info2" style="font-size:15px;color:red;display:none;">密码不能为空!</span>
                       <span id="login_info3" style="font-size:15px;color:red;display:none;">请填写验证码!</span>
                       <span id="login_info4" style="font-size:15px;color:red;display:none;">用户名或密码输入错误，请重新输入!</span>
                       <span id="login_info5" style="font-size:15px;color:red;display:none;">验证码输入错误，请重新输入!</span>
                       <span id="login_info6" style="font-size:15px;color:red;display:none;">请不要重复输入验证码!</span>                   
                    </td>
                 </tr>              
                 <tr>
                    <td><input class="button" type="submit" name="submit" value="登录"></td>        
                    <td align="right"><input class="button" type="reset" name="reset" value="重置"></td>
                 </tr>   
                 <tr>
                    <td colspan="2" align="center" ><span style="font-size:15px;">版权所有：0121610870232</span></td>
                 </tr>       
                </table>
            </form>
        </div>  
    </body>
</html>