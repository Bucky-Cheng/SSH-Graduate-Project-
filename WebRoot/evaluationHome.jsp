<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>evaluationHome</title>
    
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

   	<!--START SCROLL TOP BUTTON -->
    <a class="scrollToTop" href="#">
      <i class="fa fa-angle-up"></i>
    </a>
 	<!-- END SCROLL TOP BUTTON -->
  	
  	<!-- Start Header -->
	<header id="mu-hero">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light mu-navbar">
				<!-- Text based logo -->
				<a class="navbar-brand mu-logo" href="index.html"><span>Evaulation-S</span></a>
				<!-- image based logo -->
			   	<!-- <a class="navbar-brand mu-logo" href="index.html"><img src="assets/images/logo.png" alt="logo"></a> -->
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="fa fa-bars"></span>
			  </button>

			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto mu-navbar-nav">
			     <li class="nav-item">
			        <a href="teacher_Home.jsp">主页</a>
			      </li>
			      <li class="nav-item"><a href="educationTable?flag=a">教学自评</a></li>
			      <li class="nav-item"><a href="GetReaTable">研究自评</a></li>
			      <li class="nav-item"><a href="GetSerTable">服务自评</a></li>
			       <li class="nav-item" id="AddLoc"><a href="GetAssTable">辅导自评</a></li>
			       
			        <li class="nav-item"><a href="TeacherNoticeAction">通知</a></li>
			       <li class="nav-item"><a href="SSAction">结果</a></li>
			       
			    </ul>
			  </div>
			</nav>
		</div>
	</header>
	<!-- End Header -->

	<!-- Start Page Header area -->
	
	<!-- End Page Header area -->

	<!-- Start Breadcrumb -->
	<div id="mu-breadcrumb">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<nav aria-label="breadcrumb" role="navigation">
					  <ol class="breadcrumb mu-breadcrumb">
					    <li class="breadcrumb-item"><a href="#">Home</a></li>
					    <li class="breadcrumb-item active" aria-current="page">Services</li>
					  </ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumb -->
	
	<!-- Start main content -->
	<main>
		
		<!-- Start Services -->
		<section id="mu-service">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-service-area">
							<!-- Title -->
							<div class="row">
								<div class="col-md-12">
									<div class="mu-title">
										<h2>所有自评项目及流程</h2>
										<p>所有教职员自评均有系统自动填写的分数以及需要自己填写的分数，自己填写项目均
										需要上传相关的文件证明，所有教职员工的考核流程为统一流程，系统自动填写项目完成前，所有自评项目都不会开放。在填写完毕自己填写项目后，进行保存操作可再次修改，进行提交操作将无法修改，到截至日期所有内容将会自动提交。</p>
									</div>
								</div>
							</div>
							<!-- Start Service Content -->
							<div class="row">
								<div class="col-md-12">
									<div class="mu-service-content">
										<div class="row">
											<!-- Start single service -->
											<div class="col-md-4">
												<div class="mu-single-service">
													<div class="mu-single-service-icon"><i class="fa fa-shopping-cart" aria-hidden="true"></i></div>
													<div class="mu-single-service-content">
														<h3><a href="educationTable?flag=a">教学自评</a></h3>
														<p>此类自评均为系统自动填写，自评开放后教师可查看，无法修改。</p>
													</div>
												</div>
											</div>
											<!-- End single service -->
											<!-- Start single service -->
											<div class="col-md-4">
												<div class="mu-single-service">
													<div class="mu-single-service-icon"><i class="fa fa-bullhorn" aria-hidden="true"></i></div>
													<div class="mu-single-service-content">
														<h3>研究自评</h3>
														<p>此类自评均为系统自动填写，自评开放后教师可查看，无法修改</p>
													</div>
												</div>
											</div>
											<!-- End single service -->
											<!-- Start single service -->
											<div class="col-md-4">
												<div class="mu-single-service">
													<div class="mu-single-service-icon"><i class="fa fa-laptop" aria-hidden="true"></i></div>
													<div class="mu-single-service-content">
														<h3>服务自评</h3>
														<p>此类自评均为系统自动填写，自评开放后教师可查看，无法修改</p>
													</div>
												</div>
											</div>
											<!-- End single service -->
											<!-- Start single service -->
											<div class="col-md-4">
												<div class="mu-single-service">
													<div class="mu-single-service-icon"><i class="fa fa-mobile" aria-hidden="true"></i></div>
													<div class="mu-single-service-content">
														<h3>辅导自评</h3>
														<p>此类自评均为系统自动填写，自评开放后教师可查看，无法修改</p>
													</div>
												</div>
											</div>
											<!-- End single service -->
											<!-- Start single service -->
											<div class="col-md-4">
												<div class="mu-single-service">
													<div class="mu-single-service-icon"><i class="fa fa-clock-o" aria-hidden="true"></i></div>
													<div class="mu-single-service-content">
														<h3>自评总览</h3>
														<p>此类自评均为系统自动填写，自评开放后教师可查看，无法修改</p>
													</div>
												</div>
											</div>
											<!-- End single service -->
											<!-- Start single service -->
											<div class="col-md-4">
												<div class="mu-single-service">
													<div class="mu-single-service-icon"><i class="fa fa-cog" aria-hidden="true"></i></div>
													<div class="mu-single-service-content">
														<h3>考核结果</h3>
														<p>此类自评均为系统自动填写，自评开放后教师可查看，无法修改</p>
													</div>
												</div>
											</div>
											<!-- End single service -->
										</div>
									</div>
								</div>
							</div>
							<!-- End Service Content -->
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Services -->	

		<!-- Start Counter -->
		<section id="mu-counter">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="mu-counter-area">

							<div class="mu-counter-block">
								<div class="row">

									<!-- Start Single Counter -->
									<div class="col-md-3 col-sm-6">
										<div class="mu-single-counter">
											<span class="fa fa-suitcase"></span>
											<div class="mu-single-counter-content">
												<div class="counter-value" data-count="250">4个</div>
												<h5 class="mu-counter-name">大项</h5>
											</div>
										</div>
									</div>
									<!-- / Single Counter -->

									<!-- Start Single Counter -->
									<div class="col-md-3 col-sm-6">
										<div class="mu-single-counter">
											<span class="fa fa-user"></span>
											<div class="mu-single-counter-content">
												<div class="counter-value" data-count="56">40个</div>
												<h5 class="mu-counter-name">小项</h5>
											</div>
										</div>
									</div>
									<!-- / Single Counter -->

									<!-- Start Single Counter -->
									<div class="col-md-3 col-sm-6">
										<div class="mu-single-counter">
											<span class="fa fa-coffee"></span>
											<div class="mu-single-counter-content">
												<div class="counter-value" data-count="15">67位</div>
												<h5 class="mu-counter-name">教职工</h5>
											</div>
										</div>
									</div>
									<!-- / Single Counter -->

									<!-- Start Single Counter -->
									<div class="col-md-3 col-sm-6">
										<div class="mu-single-counter">
											<span class="fa fa-clock-o"></span>
											<div class="mu-single-counter-content">
												<div class="counter-value" data-count="290">30天</div>
												<h5 class="mu-counter-name">自评期限</h5>
											</div>
										</div>
									</div>
									<!-- / Single Counter -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Counter -->

		

		
							<!-- End Clients brand logo -->

						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Clients -->

	</main>
	
	<!-- End main content -->	
			
			
	<!-- Start footer -->
	<footer id="mu-footer">
		<div class="mu-footer-top" style="background:#0091ea">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="mu-single-footer">
							<img class="mu-footer-logo" src="assets/images/logo.PNG" alt="logo" width=70% >
							<p> </p>
							<div class="mu-social-media">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a class="mu-twitter" href="#"><i class="fa fa-twitter"></i></a>
								<a class="mu-pinterest" href="#"><i class="fa fa-pinterest-p"></i></a>
								<a class="mu-google-plus" href="#"><i class="fa fa-google-plus"></i></a>
								<a class="mu-youtube" href="#"><i class="fa fa-youtube"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>Twitter feed</h3>
							<ul class="list-unstyled">
							  	<li class="media">
								   <span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<p><strong>@b_hero</strong> Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
								    	<a href="#">2 hours ago</a>
								    </div>
							  	</li>
							  	<li class="media">
								   	<span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<p><strong>@b_hero</strong> Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
								    	<a href="#">2 hours ago</a>
								    </div>
							  	</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>快速链接</h3>
							<ul class="mu-useful-links">
								<li><a href="#">自评中心</a></li>
								<li><a href="#">结果中心</a></li>
								<li><a href="#">通知中心</a></li>
								
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>联系信息</h3>
							<ul class="list-unstyled">
							  <li class="media">
							    <span class="fa fa-home"></span>
							    <div class="media-body">
							    	<p>ZA310室, A座, 知行楼, 北京理工大学珠海学院</p>
							    </div>
							  </li>
							  <li class="media">
							    <span class="fa fa-phone"></span>
							    <div class="media-body">
							       <p>+00 123 456 789 00</p>
							     	<p>+ 00 254 632 548 00</p>
							    </div>
							  </li>
							  <li class="media">
							    <span class="fa fa-envelope"></span>
							    <div class="media-body">
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
							<p class="mu-copy-right">&copy; Copyright Bucky Cheng Bok-gaai. All right reserved. </p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</footer>
	<!-- End footer -->

	
	<!-- JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	<!-- Slick slider -->
    <script type="text/javascript" src="assets/js/slick.min.js"></script>
    <!-- Progress Bar -->
    <script src="https://unpkg.com/circlebars@1.0.3/dist/circle.js"></script>
    <!-- Filterable Gallery js -->
    <script type="text/javascript" src="assets/js/jquery.filterizr.min.js"></script>
    <!-- Gallery Lightbox -->
    <script type="text/javascript" src="assets/js/jquery.magnific-popup.min.js"></script>
    <!-- Counter js -->
    <script type="text/javascript" src="assets/js/counter.js"></script>
    <!-- Ajax contact form  -->
    <script type="text/javascript" src="assets/js/app.js"></script>
    
	
    <!-- Custom js -->
	<script type="text/javascript" src="assets/js/custom.js"></script>

	<!-- About us Skills Circle progress  -->
	
  </body>
</html>
