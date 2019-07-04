<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>top</title>
       <style type="text/css">
       body{
         background-image:url("../images/stuTop_bg.jpeg");
         background-position:center center;
         background-repeat:no-repeat;/*不重复*/
         background-attachment:fixed;/*背景图像固定，不随页面滚动*/
         -webkit-background-size: cover;
         -moz-background-size: cover;
         -o-background-size: cover;
         background-size: cover; /* 让背景图基于容器大小伸缩 */
         background-color:#6495ED;
         margin:0;
         padding:0;
       }
       </style>
    </head>
    <body>
      <h1 style="color:white;float:left">宿舍管理系统</h1><br/>
      <div style="float:right"><img src="../images/person.png"  style="width:40px;height:40px;"/>当前用户:${sessionScope.userName}
      <br/><br/>
        <a style="color:red;"  href="../loginOutServlet">退出登录</a>
      </div>
     
    </body>
</html>