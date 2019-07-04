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
        a:link{
         color:blue;
        }
        a:visited {
          color:blue;
        }
        a:hover{
         color:blue;
        }
      
      </style>
    </head>
    <body>
     <h3>您当前正在查看已处理记录：</h3>
      <div style="width:500px;height:700px;margin:0 auto;margin-top:50px;">
            <table border=1  cellspacing=0 id="table1"> 
            <thead>
              <tr>
                 <th>序号</th>
                 <th>学号</th>
                 <th>寝室号</th>
                 <th>提交日期</th>
                <th>状态</th>
                <th>报修原因</th>
             </tr>
          </thead>
          <tbody>
              <c:forEach varStatus="i" var="record" items="${RecordedLists}">
                <tr>
                   <td><c:out value="${i.index+1}"/></td>
                  <td><c:out value="${record.studentID}"/></td>
                  <td><c:out value="${dormIdListsYes[i.index]}"/></td>
                  <td><c:out value="${record.commitTime}"/></td>
                   <td><c:set var="status" value="已完成"/><c:out value='${status}'/></td>
                   <td><a href="admin/Detail.jsp?stuId=${record.studentID}&dormId=${dormIdListsYes[i.index]}&commitTime=${record.commitTime}&status=${status}&reason=${record.reasons}">点击查看</a></td>
                </tr>
              </c:forEach>
          </tbody>
       </table>
     </div>
     
    </body>
</html>