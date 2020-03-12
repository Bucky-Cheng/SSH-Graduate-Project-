<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
   
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="" />
    <title>教师绩效考核系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	
	
	

	<!-- Custom Theme files -->
	<!-- css -->
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="css/style.css" type="text/css" rel="stylesheet" media="all">   

	<!-- js -->

	<!-- //js -->
	<!-- web-fonts -->  
	<link href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300i,700" rel="stylesheet"> 
  </head>
  
  <body>
     <div class="agileits-banner" style="width:100%;height:97%;">  
		
		
		<div class="banner-w3text w3layouts">
			<h2> <img src="images/Logo.png" style="width:6%" style="top-margin:40%"/>&nbsp;<span ><font color="#0055A6">教师绩效考核系统</font></span></h2> 
			<div class="wthree-bnr-login">
				<s:form  name="form" role="form" action="login" method="post">
					<ul style="font-size:15px">   
						<li><s:textfield id="a1" name="t_login.t_ID" placeholder="工号"/></li>
						<li><s:password id="a2" name="t_login.password" placeholder="密码" /> </li>
						<li><s:submit id="a3" value="登录"/></li>
					</ul>
				</s:form>
			</div> 
			<h6></h6> 
		</div>  
	</div>
	<!-- //banner --> 
	
	<!-- footer -->
	
	<!-- Stats -->
	
	<!-- //Stats --> 
	<!-- start-smooth-scrolling -->
	
	
	<center><p class="mu-copy-right" >&copy; Copyright 北京理工大学珠海学院  All right reserved.</p></center>
  </body>
</html>
