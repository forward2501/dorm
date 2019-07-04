<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>宿管登录界面</title>
        <style type="text/css">
          #table1 tr:hover{
            background-color:#E6E6FA;
         }
          #table1 th{
            background-color:black;
            color:white;
         }    
      </style>
    </head>
    <body>
     <h3>您当前正在查看晚归记录：</h3>
     <div style="width:500px;height:700px;margin:0 auto;">
   <table border=1  cellspacing=0 id="table1"> 
   <thead>
      <tr>
         <th>序号</th>
         <th>学号</th>
         <th>晚归日期</th>
         <th>晚归时间</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach varStatus="i" var="record" items="${lateRecordLists}">
        <tr>
           <td><c:out value="${record.recordId}"/></td>
           <td><c:out value="${record.studentID}"/></td>
           <td><c:out value="${record.lateDate}"/></td>
           <td><c:out value="${record.lateTime}"/></td>
        </tr>
       </c:forEach>
     </tbody>
   </table>
   </div>

    </body>
</html>