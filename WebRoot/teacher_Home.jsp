<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Favicon -->
    
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
    
  	
  	<!-- Start Header -->
	<header id="mu-hero" >
		<div style="position: fixed;right:20px;text-align:right;height:90px;width:700px;padding-top:35px">
			<a style="font-size:25px;color:white;" href="QUIT">${ sessionScope.t_Name}</a>
		</div>
		<div class="container" >
			<nav class="navbar navbar-expand-lg navbar-light mu-navbar" style="margin-left:-25%">
				<!-- Text based logo -->
				<a class="navbar-brand mu-logo" href="index.html" style="width:8%"><img src="images/Logo.png" style="width:40%"/>&nbsp;<span>教师绩效考核系统</span></a>
				<!-- image based logo -->
			   	<!-- <a class="navbar-brand mu-logo" href="index.html"><img src="assets/images/logo.png" alt="logo"></a> -->
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="fa fa-bars"></span>
			  </button>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto mu-navbar-nav" id="AddUL">
			      <li class="nav-item active">
			        <a href="teacher_Home.jsp" style="font-size:15px">主页</a>
			      </li>
			      <li class="nav-item"><a href="educationTable?flag=a" style="font-size:15px">教学自评</a></li>
			      <li class="nav-item"><a href="GetReaTable" style="font-size:15px">研究自评</a></li>
			      <li class="nav-item"><a href="GetSerTable" style="font-size:15px">服务自评</a></li>
			      <li class="nav-item" id="AddLoc" style="font-size:15px"><a href="GetAssTable" style="font-size:15px">辅导自评</a></li>
			       
			      <li class="nav-item"><a href="TeacherNoticeAction" style="font-size:15px">系统通知</a></li>
			      <li class="nav-item"><a href="SSAction" style="font-size:15px">考核结果</a></li>
			      <li class="nav-item"><a href="PasswordM" style="font-size:15px">修改密码</a></li>
			    </ul>
			  </div>
			</nav>
		</div>
	</header>
	<!-- End Header -->

	<!-- Start slider area -->
	<div id="mu-slider" >
		<div class="mu-slide" >
			

			<!-- Start single slide  -->
			<div class="mu-single-slide">
				<img src="assets/images/slider-img-2.jpg" alt="slider img">
				<div class="mu-single-slide-content-area">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="mu-single-slide-content">
									<h1>欢迎登录</h1>
									<p id="EButton"></p>
									<a class="mu-primary-btn" href="evaluationHome.jsp">开始自评 <span class="fa fa-long-arrow-right"></span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End single slide  -->
			<!-- Start single slide  -->
			<div class="mu-single-slide">
				<img src="assets/images/slider-img-3.jpg" alt="slider img">
				<div class="mu-single-slide-content-area">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="mu-single-slide-content">
									<h1>系统通知</h1>
									<p></p>
									<a class="mu-primary-btn" href="#">点击查看 <span class="fa fa-long-arrow-right"></span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End single slide  -->
			<!-- Start single slide  -->
			<div class="mu-single-slide">
				<img src="assets/images/slider-img-1.jpg" alt="slider img">
				<div class="mu-single-slide-content-area">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="mu-single-slide-content">
									<h1>结果查询</h1>
									<p id="result"></p>
									<a class="mu-primary-btn" href="#">点击查询 <span class="fa fa-long-arrow-right"></span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End single slide  -->
		</div>
	</div>
	<!-- End Slider area -->

	
	<!-- Start main content -->
	
	
	<!-- End main content -->	
			
			
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

	
	<!-- JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <!--  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>-->
     <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
     <script>
     jQuery(document).ready(function(){
     	jQuery.ajax({
 	
		url:"getDepartmrntInfoAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			
			var json=eval('('+data+')');
			
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
    <!-- Progress Bar -->
    
    <!-- Filterable Gallery js -->
    
    <!-- Gallery Lightbox -->
    <script type="text/javascript" src="assets/js/jquery.magnific-popup.min.js"></script>
    <!-- Counter js -->
   
    <!-- Ajax contact form  -->
    
	
    <!-- Custom js -->
	<script type="text/javascript" src="assets/js/custom.js"></script>

	<!-- About us Skills Circle progress  -->
	
  </body>
</html>
