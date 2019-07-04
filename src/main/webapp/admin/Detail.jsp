<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="returnA"  type="button" value="点击返回" onclick="returnLast()">
	<h3 id="nav" style="margin-left: 150px;">您当前查看的记录为:</h3>

<div style="width:400px;height:330px;margin:0 auto;margin-top:50px;border:1px solid;border-radius:20px">
   <table>
      <tr>
         <td>学号:</td>
         <td><input type="text" name="stuId" readonly="readonly" style="background-color:#F0E68C" value="<%=request.getParameter("stuId")%>"/></td>
      </tr>
      <tr>
         <td>寝室号:</td>
         <td><input type="text" name="dormId" readonly="readonly" style="background-color:#F0E68C" value="<%=request.getParameter("dormId")%>"/></td>
      </tr>
      <tr>
         <td>报修提交时间:</td>
         <td><input type="text" name="comTime" readonly="readonly" style="background-color:#F0E68C"  value="<%=request.getParameter("commitTime")%>"/></td>
      </tr>
      <tr>
         <td>处理状态:</td>
         <td><input style="color:green;background-color:#F0E68C" type="text"name="status"  id="satus" readonly="readonly"  value="<%=request.getParameter("status")%>"/></td>
      </tr>
      <tr>
         <td>报修原因:</td>
         <td><textarea   name="reason" cols="30" rows="10" style="OVERFLOW:visible;background-color:#F0E68C" readonly="readonly"><%=request.getParameter("reason")%></textarea></td>
      </tr>
      <tr>
         <td colspan="2" align="center"><input id="tijiao" disabled="disabled" type="submit" value="确认" /></td>       
      </tr>
      
   </table>
     <iframe frameborder="0" id="myIframe" name="myIframe"></iframe> 
   </form>
   </div>
   <script type="text/javascript">
      function returnLast(){
   	      window.location.href="../recordedServlet";
   }
   </script>


</body>
</html>