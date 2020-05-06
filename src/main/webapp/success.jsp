<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
     <script type="text/javascript">
          //del
         function del(obj,id){
            alert(id);
         }
     
         $(function(){             
                  var $tr="<tr><td>编号</td><td>用户名</td><td>日期</td><td>地址</td><td>操作</td><tr>";
                  $.ajax({
                     type:'get',
                     url:'user.do',
                     dataType:'json',
                     success:function(result){
                         for(var i=0;i<result.length;i++){
                           var obj=result[i];
                           $tr+="<tr><td>"+obj.id+"</td><td>"+obj.userCode2+"</td><td>"+obj.birthday+"</td><td>"+obj.address+"</td><td><button onclick='del(this,"+obj.id+")'>删除</button></td><tr>";
                         }
                         $("#myTable").append($tr);
                     },
                     error:function(){
                        alert("响应失败！！");
                     }      
                  });        
         });
     </script>
  </head>
  
  <body>
     <table border="1" id="myTable">
        
     </table>
     <button onclick="">添加</button>
  </body>
</html>
