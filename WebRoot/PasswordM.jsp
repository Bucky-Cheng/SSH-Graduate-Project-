<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师绩效考核系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta charset="utf-8">
	
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/bootstrap-table.css" rel="stylesheet">
	 <link rel="shortcut icon" type="image/icon" href="assets/images/favicon.ico"/>
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <!-- Slick slider -->
    <link href="assets/css/slick.css" rel="stylesheet">
    <!-- Gallery Lightbox -->
    <link href="assets/css/magnific-popup.css" rel="stylesheet">
    <!-- Skills Circle CSS  -->
    <link rel="stylesheet" type="text/css" href="assets/css/circle.css">
    

    <!-- Main Style -->
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- Fonts -->

    <!-- Google Fonts Raleway -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,500,500i,600,700" rel="stylesheet">
	<!-- Google Fonts Open sans -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,700,800" rel="stylesheet">
  </head>
  
  <body>
  
	<header id="mu-hero" style="height:100px">
		<div style="position: fixed;right:20px;text-align:right;height:90px;width:700px;padding-top:35px">
			<a style="font-size:20px;color:white;text-align:right" href="PasswordM">${ sessionScope.t_Name}</a>
		</div>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light mu-navbar" style="margin-left:-26%">
				<!-- Text based logo -->
				<a class="navbar-brand mu-logo" href="index.html" style="width:80%"><span style="width:15%;"><img src="images/Logo.png" style="width:40%"/></span><span style="font-size:36px; margin-left:-8%; white-space: nowrap;">教师绩效考核系统</span></a>
				<!-- image based logo -->
			   	<!-- <a class="navbar-brand mu-logo" href="index.html"><img src="assets/images/logo.png" alt="logo"></a> -->
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="fa fa-bars"></span>
			  </button>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left:-20%;padding-top:15px">
			    <ul class="navbar-nav mr-auto mu-navbar-nav">
			      <li class="nav-item">
			        <a href="teacher_Home.jsp" style="font-size:15px">主页</a>
			      </li>
			      <li class="nav-item"><a href="educationTable?flag=a" style="font-size:15px">教学自评</a></li>
			      <li class="nav-item"><a href="GetReaTable" style="font-size:15px">研究自评</a></li>
			      <li class="nav-item"><a href="GetSerTable" style="font-size:15px">服务自评</a></li>
			       <li class="nav-item" id="AddLoc"><a href="GetAssTable" style="font-size:15px">辅导自评</a></li>
			      
			        <li class="nav-item"><a href="TeacherNoticeAction" style="font-size:15px">系统通知</a></li>
			        <li class="nav-item"><a href="SSAction" style="font-size:15px">考核结果</a></li>
			       	<li class="nav-item  active"><a href="PasswordM" style="font-size:15px">修改密码</a></li>
			    </ul>
			  </div>
			</nav>
		</div>
	</header>

	<center>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div style="height:10%;width:150px"></div>
			<input type="password" style="font-size:20px" placeholder="输入旧密码"  id="OPassword" name="uname" />
              <p><p>
              <input type="password" style="font-size:20px" placeholder="输入新密码" id="addContent" name="uname"/>
              <p>
              <input type="password" style="font-size:20px" placeholder="再次输入新密码" id="checkPwd" name="uname" />
              <p id="rejectInfo" style="color:red;font-size:20px;display:none">密码不一致</p>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <span class="input-group-btn">
               <button type="button" id="SearchButton" class="btn btn-primary" onclick="save()">
              <span style="font-size:20px">提交</span>
          </button>
          </span>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <div style="height:20%"></div>
		</center>
		
	</div>
	
	<!-- Start footer -->
	<footer id="mu-footer">
		<div class="mu-footer-top" style="background:#0091ea">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="mu-single-footer">
							
							<p> </p>
							<div class="mu-social-media">
								<img class="mu-footer-logo" src="assets/images/wechat.jpg" alt="logo" width=70% >
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>友情链接</h3>
							<ul class="list-unstyled">
							  	<li class="media">
								   	<span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<a href="http://www.bitzh.edu.cn/" style="font-size:15px">学校主页</a>
								    </div>
							  	</li>
							  	<li class="media">
								   	<span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<a href="http://jwc.bitzh.edu.cn/" style="font-size:15px">教务处</a>
								    </div>
							  	</li>
							  	<li class="media">
								   	<span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<a href="http://eol.bitzh.edu.cn/" style="font-size:15px">网络教学平台</a>
								    </div>
							  	</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>快速链接</h3>
							<ul class="mu-useful-links">
								<li ><a href="PasswordM" style="font-size:15px">修改密码</a></li>
								<li><a href="SSAction" style="font-size:15px">结果中心</a></li>
								<li><a href="TeacherNoticeAction" style="font-size:15px">通知中心</a></li>
								<li><a href="QUIT" style="font-size:15px">退出登录</a></li>
								
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>联系信息</h3>
							<ul class="list-unstyled">
							  <li class="media">
							    <span class="fa fa-home"></span>
							    <div class="media-body" style="font-size:15px">
							    	<p>北京理工大学珠海学院 知行楼A座ZA308室</p>
							    </div>
							  </li>
							  <li class="media">
							    <span class="fa fa-phone"></span>
							    <div class="media-body" style="font-size:15px">
							       <p>0756-3622861</p>
							    </div>
							  </li>
							  <li class="media">
							    <span class="fa fa-envelope"></span>
							    <div class="media-body" style="font-size:15px">
							     <p>support@evaluations.com</p>
							     <p>help.evaluations@gmail.com</p>
							    </div>
							  </li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="mu-footer-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-footer-bottom-area">
							<p class="mu-copy-right">&copy; Copyright 北京理工大学珠海学院. All right reserved. </p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</footer>
	<!-- End footer -->

	
	
   <script src="js/jquery-2.1.4.min.js"></script>
     <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript">
    document.getElementById("checkPwd").addEventListener("focus", checkPwd);
	document.getElementById("checkPwd").addEventListener("blur", checkPwd);
	var reject= document.getElementById("rejectInfo");
	function checkPwd(){
    if($("#addContent").val() != $("#checkPwd").val()){
    	
         $("#checkPwd").attr("placeholder","再次输入新密码").show();
         reject.style.display = "block";
     } else {
         $("#checkPwd").text("").show();
         reject.style.display = "none";
     }
 }

    function save(){
    var addContent=jQuery("#addContent").val();
    var OPassword=jQuery("#OPassword").val();
    	jQuery.ajax({
 	
	url:"AddContentInfoAction",
	type:"post",
	data:{addContent:addContent,OPassword:OPassword},
	dataType: "json",
	success:function(data){
			var json=eval('('+data+')');
			alert(json[0]);
			window.location.reload();
						
						
					
					
					}
					
	

	})
    }

     $(document).ready(function(){
   
  
   
     
    
	
		
		jQuery.ajax({
 	
		url:"getDepartmrntInfoAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data)
			var json=eval('('+data+')');
			//alert(json[0]);
			if(json[0]=="true"){
			var NewLi="<li class='nav-item'><a href='DocumentShow' style='font-size:15px'>审批成绩</a></li>"
			jQuery("#AddLoc").after(NewLi);
			<!--jQuery("#AddUL").append(NewLi);-->
			}
		}
	})

     })
    </script>
    
	<!-- Slick slider -->
    <script type="text/javascript" src="assets/js/slick.min.js"></script>
    
    <script type="text/javascript" src="assets/js/jquery.magnific-popup.min.js"></script>
    
	<script type="text/javascript" src="assets/js/custom.js"></script>

	
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-table.js"></script>
<script src="assets/js/bootstrap-table-zh-CN.js"></script>
  </body>
</html>
