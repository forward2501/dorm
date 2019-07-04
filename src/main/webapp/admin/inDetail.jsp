<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>宿管登录界面</title>
    </head>
    <body>
        <h3 id="note" style="display:none">处理完毕，请点击左部菜单栏刷新或点击“返回”按钮</h3>
        <input id="returnA"  type="button" value="点击返回" onclick="returnLast()">
        <form name="form"  action="../addRepairedServlet"  method="post"  target="myIframe"  onSubmit="return submitOnce(this)">
           <div style="width:400px;height:330px;margin:0 auto;margin-top:50px;border:1px solid;border-radius:20px">
             <table>
                <tr>
                   <td></td>
                   <td><input type="text"  style="display:none" name="rId" readonly="readonly" value="<%=request.getParameter("recordId")%>"/></td>
                </tr>
                <tr>
                    <td>学号:</td>
                    <td><input type="text" name="studentId" readonly="readonly" style="background-color:#F0E68C" value="<%=request.getParameter("stuId")%>"/></td>
                </tr>
                <tr>
                    <td>寝室号:</td>
                    <td><input type="text" name="theDormId" readonly="readonly" style="background-color:#F0E68C" value="<%=request.getParameter("dormId")%>"/></td>
                </tr>
                <tr>
                     <td>报修提交时间:</td>
                     <td><input type="text" name="comTime" readonly="readonly" style="background-color:#F0E68C" value="<%=request.getParameter("commitTime")%>"/></td>
                </tr>
                <tr>
                     <td>处理状态:</td>
                     <td><input style="color:red;background-color:#F0E68C" type="text" name="theStatus"  id="theStatus" readonly="readonly"  value="<%=request.getParameter("status")%>"/></td>
                </tr>
                <tr>
                      <td>报修原因:</td>
                      <td><textarea   name="theReason" cols="30" rows="10" style="OVERFLOW:visible;background-color:#F0E68C" readonly="readonly"><%=request.getParameter("reason")%></textarea></td>
                </tr>
                <tr>
                      <td colspan="2" align="center"><input id="tijiao" type="submit" value="确认" /></td>       
                </tr>
            </table>
          </div>
          <iframe frameborder="0" id="myIframe" name="myIframe"></iframe> 
      </form>

      <script type="text/javascript">
          function submitOnce(){
    	     document.getElementById('tijiao').value="正在处理...";
    	     document.getElementById('tijiao').disabled="true";
    	     setTimeout(changeContent,1000); 	 
    	     return true;//提交
          }
          function changeContent(){
    	     alert("已完成处理!");
    	     document.getElementById("theStatus").value="已完成";
    	     document.getElementById('tijiao').value="确认";
    	     document.getElementById("theStatus").style.color="blue";
    	     document.getElementById("note").style.display="block";	 	 
         }
          function returnLast(){
       	      window.location.href="../recordingServlet";
       }
      </script>
      
    </body>
</html>