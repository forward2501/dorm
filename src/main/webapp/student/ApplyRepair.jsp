<%@ page isELIgnored="false" language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
     <meta charset="UTF-8">
     <title>学生登录界面</title>
   </head>
   <body>
      <form action="../applyRepairServlet" method="post" name="myApply" target="myIframe" onSubmit="return submitOnce(this)">
      <div style="margin:0 auto;width:400px;height:400px;margin-top:50px">
         <table border=1 cellspacing=0>
            <tr>
               <td width=100px>学号:</td>
               <td><input type="text" style="background-color:#F0E68C" name="stu_id" readonly="readonly" value="${sessionScope.userName}"/></td>
            </tr>
            <tr>
               <td width=100px>寝室号:</td>
               <td><input type="text" style="background-color:#F0E68C" name="dorm_id" readonly="readonly" value="${sessionScope.dormId}"/></td>
            </tr>
            <tr>
               <td width=100px>报修时间:</td>
               <td> <c:set var='now' value='<%=new java.util.Date()%>'/>
                   <input   style="background-color:#F0E68C" type="text" name="commit_time" readonly="readonly" 
                      value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd'/>"/>
              </td>
            </tr>
            <tr>
               <td width=100px>处理状态:</td>
               <td><input  style="background-color:#F0E68C;color:red;" name="status" type="text" readonly="readonly" value="未完成"/></td>
            </tr>
            <tr>
              <td colspan="2">报修原因:
                <textarea id="repair_reason"  name="repair_reason" maxlength="200" cols="30" rows="10" style="OVERFLOW:visible"></textarea>
              </td>
            </tr>
            <tr>
             <td colspan="2" align="center"><input type="submit" id="submitId" name="submit" value="提交"/></td>
            </tr>
            
         </table>
         </div>
          <iframe frameborder="0" id="myIframe" name="myIframe"></iframe> 
      </form>
       <!--<iframe frameborder="0" id="myIframe" name="myIframe"></iframe> -->
      <script type="text/javascript">
         function submitOnce(){
        	 var isEmpty= document.getElementById("repair_reason").value;
        	 if(isEmpty==null||isEmpty==""){
        		 alert("报修原因不能为空!");
     	         return false;
             }
             else{
            	 document.getElementById('submitId').value='正在处理...';
             	 document.getElementById('submitId').disabled="true";
             	 setTimeout(changeContent,1000);  
             	 return true;//提交
             }
          }
         
         function changeContent(){
        	 document.getElementById("repair_reason").value="";
        	 alert("已完成提交!");
        	 document.getElementById('submitId').value='确认';
        	 document.getElementById('submitId').removeAttribute('disabled');  	 
        	 
         }
      </script>

   </body>
</html>