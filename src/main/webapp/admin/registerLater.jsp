<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>宿管登录界面</title>
       <script type="text/javascript"  src="../My97DatePicker/WdatePicker.js"></script> 
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
         
        /* .input{
             width:200px;
             height:30px;
             font-size:20px;
         }*/
       </style>   
    </head>
    <body>
       <h3 style="margin-left:100px">您当前正在登记：</h3>
        <div style="width:350px;height:250px;border:1px solid;border-radius:20px;margin:0 auto;margin-top:100px;background-color:skyblue;">
          <form name="registerForm" action="../registerLateServlet" method="post" target="myIframe" onSubmit="return submitOnce(this)">
              <table>
                  <tr>
                     <td class="td1">学号:</td>
                     <td><input  class="input"id="register_id" type="text" placeholder="13位学号" name="register_id"> </td>
                  </tr>
                  <tr>
                      <td class="td2">晚归日期:</td>
                      <td><input class="input" id="late_date" type="text"  placeholder="例：2010-03-21" name="late_date" id="late_date" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"/></td>
                  </tr>
                  <tr>
                       <td class="td1">晚归时间:</td>
                       <td class="td2"><input   class="input" id="late_time" placeholder="例： 23:32:12" type="text" name="late_time" id="late_time" onclick="WdatePicker({dateFmt:'HH:mm:ss'})"/></td>
                  </tr>  
                  <tr>
                       <td class="td3"  align="center" colspan="2"><input id="submit" style="width:75px;height:30px;" type="submit" value="确认"/></td>
                  </tr>
              </table>
              <iframe frameborder="0" id="myIframe" name="myIframe"></iframe> 
          </form>
        </div>
         <script type="text/javascript">
         function submitOnce(){
        	var id=document.getElementById("register_id").value;
        	var comDate=document.getElementById("late_date").value;
        	var comTime=document.getElementById("late_time").value;
        	 if(id==null||id==""||comDate==null||comDate==""||comTime==null||comTime==""){
        		 alert("登记信息填写不完整！");
        		 return false;
        	 }
        	 else if(id.length!=13){
        		 alert("学号格式不正确！必须为13位！");
        		 return false;
        	 }
        	 else{ 
        	 document.getElementById('submit').value='正在处理...'
        	 document.getElementById('submit').disabled="true";
        	 setTimeout(changeContent,1000); 
        	 return true;//提交
        	 }
         }
         function changeContent(){
        	 document.getElementById("register_id").value="";
        	 document.getElementById("late_date").value="";
        	 document.getElementById("late_time").value="";
        	 document.getElementById('submit').value='确认'
        	 document.getElementById('submit').removeAttribute('disabled');  
        	 alert("已完成提交!"); 
         }
      </script>
    </body>
</html>