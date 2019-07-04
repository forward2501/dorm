<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>宿管登录界面</title>
        <style type="text/css">
      .td1{
      width:140px;
      height:50px;
      font-size:20px;
      }
      .td2{
      width:100px;
      height:50px;
       font-size:20px;
      }
      .td3{
      width:240px;
      height:100px;
      }
      </style>
    </head>
    <body>
     <div id="jump_div" style="display:none;"><b>密码修改成功！<span id="jump" style="color:red;">5</span> 秒钟后页面将自动返回登录页面...</b></div> 
    <div id="changePw_div" style="margin:0 auto;width:400px;height:300px;margin-top:100px;border:1px solid;border-radius:20px;background-color:skyblue;">
     <form action="../userPwChangeServlet" method="post" onsubmit="return checkForm()">
           <table>
             <tr>
               <td class="td1"><span style="color:red">*</span>原密码:</td>
               <td class="td2"><input name="old_pw" id="old_pw" type="password"/></td>
             </tr>
              <tr>
               <td class="td1"><span style="color:red">*</span>新密码:</td>
               <td class="td2"><input name="new_pw" id="new_pw" type="password" maxlength="16" placeholder="最多16位"/></td>
             </tr>
              <tr>
               <td class="td1"><span style="color:red">*</span>再次输入密码:</td>
               <td class="td2"><input name="renew_pw" id="renew_pw" type="password" maxlength="16" placeholder="再次输入"/></td>
             </tr>
             <tr></tr>
              <tr>
               <td class="td3" align="center" colspan="2"><input name="pw_sbmit" type="submit" value="提交" style="width:70px;height:40px;"/>
                             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <input name="pw_reset" type="reset" value="重置" style="width:70px;height:40px;"/>
               </td>
             </tr>
           </table>
       </form>  
       </div>
       
        <c:if test="${error_order==0}">
                 <script type="text/javascript">
                   alert("原密码输入错误，请重新输入!");
                   setTimeout(function(){
                	   document.getElementById("old_pw").value="";
                       document.getElementById("new_pw").value="";
                       document.getElementById("renew_pw").value="";    
                   },1000); 
                </script>
       </c:if>
       
       <c:if test="${error_order==1}">
            <script type="text/javascript">
                 document.getElementById("changePw_div").style.display="none";
                 document.getElementById("jump_div").style.display="block";
                 <%
              	  response.setHeader("Refresh","5;transition.jsp");
                 %>
                 function countDown(secs){
                     jump.innerText=secs;
                     if(--secs>0)
                              setTimeout("countDown("+secs+" )",1000);
                 }
                 countDown(5);
             </script>
       </c:if>
       
       
       <script type="text/javascript">
          function checkForm(){
             var oldPw=document.getElementById("old_pw").value;
             var newPw=document.getElementById("new_pw").value;
             var reNewPw=document.getElementById("renew_pw").value;
          
             if(oldPw==""||newPw==""||reNewPw==""){
        	    alert("信息填写不完整!");
        	    return false;
             }
             else if(newPw!=reNewPw){
        	    alert("两次输入的密码不一致!");
        	    return false;
             }
            return true;
         }       
       </script>
       
    </body>
</html>