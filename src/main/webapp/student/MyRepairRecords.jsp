<%@ page isELIgnored="false" language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="UTF-8">
      <title>学生登录界面</title>
      <style type="text/css"> 
         #table1 tr:hover{
            background-color:#E6E6FA;
         }
        
         #table1 th{
            background-color:black;
            color:white;
         }
        
         .td1 {
	        width: 140px;
	        height: 50px;
	        font-size: 15px;
         }

         .td2 {
	        width: 100px;
	        height: 50px;
	        font-size: 15px;
         }

         .td3 {
	        width: 240px;
	        height: 100px;
         }

         .input {
	        width: 200px;
	        height: 30px;
	       font-size: 15px;
        }
      
     </style>
   </head>
   <body>
    <h3 id="note">您的报修记录为:</h3>
	  <div id="apply_div" style="width: 500px; height: 700px; margin: 0 auto; margin-top: 50px;">
		<table border=1 cellspacing=0 id="table1">
			<thead>
				<tr>
					<th>序号</th>
					<th>学号</th>
					<th>提交日期</th>
					<th>状态</th>
					<th>报修原因</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach varStatus="i" var="record" items="${myRecordLists}">
					<tr>
						<td><c:out value="${i.index+1}" /></td>
						<td><c:out value="${record.studentID}" /></td>
						<td><c:out value="${record.commitTime}" /></td>
						<td><c:if test="${record.status==0}">
								<span style="color:red"><c:set var='tstatus'
										value='未完成'/>
									<c:out value='${tstatus}' /></span>
							</c:if> <c:if test="${record.status==1}">
								<c:set var='tstatus' value='已完成'/>
								<c:out value='${tstatus}' />
							</c:if></td>
						<td align=center style="width: 100px; height: 30px"><input
							style="background-color: teal; color: white" type="button"
							name="detail" value="点击查看"
							onclick="showDetails('${record.studentID}','${record.commitTime}','${tstatus}','${record.reasons}')" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<input id="returnA" type="button" value="点击返回" onclick="returnLast()">
	<h3 id="nav" style="display: none; margin-left: 150px;">您当前查看的记录为:</h3>
	<div id="div"
		style="display: none; width: 410px; height: 370px; border: 1px solid; border-radius: 20px; margin: 0 auto; margin-top: 50px; clear: both">
		<table>
			<tr>
				<td class="td1">学号:</td>
				<td class="td2"><input class="input"  style="background-color:#F0E68C"  type="text" id="stuId"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td class="td1">提交时间:</td>
				<td class="td2"><input  style="background-color:#F0E68C"  class="input" type="text" id="time"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td class="td1">状态:</td>
				<td class="td2"><input   style="background-color:#F0E68C" class="input" type="text" id="status"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td class="td1">报修原因:</td>
				<td><textarea style="font-size: 15px;OVERFLOW:visible;background-color:#F0E68C" id="reason"
						readonly="readonly" cols="30" rows="10"></textarea></td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	
        function showDetails(id,time,status,reason){
         document.getElementById("apply_div").style.display="none";
         document.getElementById("note").style.display="none";
         document.getElementById("stuId").value=id;
         document.getElementById("time").value=time;
         
         document.getElementById("status").value=status;
         if(status=="未完成"){
        	 document.getElementById("status").style.color="red";
         }
         if(status=="已完成"){
        	 document.getElementById("status").style.color="green";
         }
         document.getElementById("reason").value=reason;
         document.getElementById("returnA").style.display="block";
         document.getElementById("nav").style.display="block";
         document.getElementById("div").style.display="block";
        }
        
        function returnLast(){
        	document.getElementById("apply_div").style.display="block";
        	document.getElementById("note").style.display="block";
        	document.getElementById("returnA").style.display="none";
        	document.getElementById("nav").style.display="none";
            document.getElementById("div").style.display="none";
        }
    </script>

</body>
</html>