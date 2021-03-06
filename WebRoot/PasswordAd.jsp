<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <meta name="description" content="Ela Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    

    
	<link rel="stylesheet" href="assets/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/themify-icons.css">
	<link rel="stylesheet" href="assets/css/pe-icon-7-filled.css">
   
    <link rel="stylesheet" href="assets/css/style_a.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
   <link rel="stylesheet" type="text/css" href="js/jquery.jqChart.css" />  
	<link href="assets/calendar/fullcalendar.css" rel="stylesheet" />
	
  </head>
  
  <body>
              <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                       
                    </li>
                    <li class="menu-title">评分表修改</li><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>教学评分表</a>
                        <ul class="sub-menu children dropdown-menu">                            
                        
                            <li><i class="fa fa-id-badge"></i><a href="educationTable?flag=b">评分表总览</a></li>
                            <li><i class="fa fa-bars"></i><a href="educationTable?flag=c">评分项目内容管理</a></li>
							 <li><i class="fa fa-bars"></i><a href="educationC">合并项管理</a></li>
                          </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>研究评分表</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="GetAdReaTable">评分表总览</a></li>
                            <li><i class="fa fa-table"></i><a href="GetMReaTable">评分项目管理</a></li>
                            <li><i class="fa fa-bars"></i><a href="researchC">合并项管理</a></li>
                          </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>服务评分表</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="GetAdSerTable">评分表总览</a></li>
                            <li><i class="menu-icon fa fa-th"></i><a href="GetMSerTable">评分项目管理</a></li>
                       		<li><i class="fa fa-bars"></i><a href="serveC">合并项管理</a></li>
                          </ul>
                    </li>
					<li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>辅导评分表</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="GetAdAssTable">评分表总览</a></li>
                            <li><i class="menu-icon fa fa-th"></i><a href="GetMAssTable">评分项目管理</a></li>
                            <li><i class="fa fa-bars"></i><a href="assistantC">合并项管理</a></li>
                          </ul>
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>总评分表</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="TurnQ">权重修改</a></li>
                            
                        </ul>
                    </li>
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>佐证资料查看</a>
                        <ul class="sub-menu children dropdown-menu">
                           <li><i class="menu-icon fa fa-line-chart"></i><a href="DocumentShowAd">佐证资料列表</a></li>
                        </ul>
                    </li>
                    <li class="menu-title">人员管理</li><!-- /.menu-title -->

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>教职工管理</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="TeacherM">教职工管理</a></li>
                            
                           
                        </ul>
                    </li>
                   
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>审核管理</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="ManagerShow">审核员列表</a></li>
                           
                        </ul>
                    </li>
					
					
					
					<li class="menu-title">评分表操作</li><!-- /.menu-title -->

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>导入导出评分表</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon ti-themify-logo"></i><a href="EduUD">导入导出教学默认评分表</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="ReaUD">导入导出研究默认评分表</a></li>
                             <li><i class="menu-icon ti-themify-logo"></i><a href="SerUD">导入导出服务默认评分表</a></li>
                              <li><i class="menu-icon ti-themify-logo"></i><a href="AssUD">导入导出辅导默认评分表</a></li>
                            
                          
                        </ul>
                    </li>
                   
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>导出结果</a>
                        <ul class="sub-menu children dropdown-menu">
                            
                            <li><i class="menu-icon fa fa-area-chart"></i><a href="ScoreDownload">导出结果</a></li>
                            
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>考核管理</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="BackTAction">退回评分表</a></li>
                           <li><i class="menu-icon fa fa-line-chart"></i><a href="EButton">开启考核</a></li>
                        </ul>
                    </li>
                    </li>
                    <li class="menu-title">通知与信息</li><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>通知</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="NAction">发布通知</a></li>
                            
                        </ul>
                    </li>
                    </li>
                     <li class="menu-title">退出</li><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>退出</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon"></i><a href="QUIT">退出登录</a></li>
                            
                        </ul>
                    </li>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside>
    <!-- /#left-panel -->
    <!-- Right Panel -->
    <div id="right-panel" class="right-panel">
        <!-- Header-->
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="AD_Home.jsp" style="margin-left:-8%"><span style="width:20%;"><img src="images/Logo.png" style="width:10%"/></span>&nbsp;<span style="font-size:22px; white-space: nowrap;">教师绩效考核系统&nbsp;&nbsp;</span></a>
                      
                   
                </div>
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <div class="header-left" style="margin-top:10px">
                      
                       <a style="font-size:22px" href="PasswordAd.jsp">当前管理员：${ sessionScope.A_ID}</a>

                        <div class="dropdown for-notification">
                           
                            <div class="dropdown-menu" aria-labelledby="notification">
                               
                            </div>
                        </div>

                        <div class="dropdown for-message">
                           
                        </div>
                    </div>

                    <div class="user-area dropdown float-right">
                       
                        
                    </div>

                </div>
            </div>
        </header>
        <!-- /#header -->

		<center>
		<div style="height:700px;width:200px">
			<div style="height:150px;"></div>
			<h2>密码修改</h2>
			<div style="height:20px;"></div>
			<form method="post" action="passwordUpdateAction">
			<input type="password" style="font-size:20px" placeholder="输入旧密码"  id="OPassword" name="oldpwd" /><s:fielderror/>
              <p><p>
			<input type="password" style="font-size:20px" placeholder="输入新密码" id="addContent" name="newpwd"/>
              <p>
			<input type="password" style="font-size:20px" placeholder="再次输入新密码" id="checkPwd" name="newpwd2" />
              <p id="rejectInfo" style="color:red;font-size:20px;display:none">密码不一致</p>
 			<span class="input-group-btn">
               <button type="submit" id="SearchButton" class="btn btn-primary" >
              		<span style="font-size:20px">提交</span>
          		</button>
			</span>
			</form>
		</div>
		</center>
		<div class="clearfix"></div>
        <!-- Footer -->
        <center>
	        <footer class="site-footer">
	            <div class="footer-inner bg-white">
	                <div class="row">
	                    <div class="col-sm-6">
	                        Copyright &copy;北京理工大学珠海学院. All right reserved.
	                    </div>
	                    <div class="col-sm-6 text-right"> 
	                    </div>
	                </div>
	            </div>
	        </footer>
        </center>
        <!-- /.site-footer -->
    <!-- /#right-panel -->

    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="js/jquery.jqChart.min.js" type="text/javascript"></script> 
    <script>
    
    function EType(){
    	 jQuery.ajax({
                    url:"TypeChartAction",
                    type:"post",
                    data:{},
                    dataType:"json",
                    success:function(data){
                   
                    	var json=eval('('+data+')');
                    	 //alert("EEE"+json[0]);
                    	jQuery("#EButton").append(json[0]);
    				}
    });
    }
    
    jQuery(document).ready(function(){
    	EType();
		 var background = {
                type: '',
                x0: 0,
                y0: 0,
                x1: 0,
                y1: 1,
                colorStops: [{ offset: 0, color: 'white' },
                             { offset: 1, color: 'white' }]
            };
			
			jQuery.ajax({
                    url:"PieChartAction",
                    type:"post",
                    data:{},
                    dataType:"json",
                    success:function(data){
                    //alert(data);
                    var json=eval('('+data+')');
                    //alert(json[0].teacher);
                    jQuery("#jqChart1").jqChart({
				title : {},
				legend : {
				
				},
				border : {
				strokeStyle : '#AAAAAA'
				},
				background : background,
				animation : {
				duration : 1
				},
				shadows : {
				enabled : true
				},
				series : [ 
				 {
                        type: 'pie',
                        fillStyles: ['#418CF0', '#FCB441', '#E0400A', '#056492', '#BFBFBF', '#1A3B69', '#FFE382'],
                        labels: {
                            stringFormat: '%.1f%%',
                            valueType: 'percentage',
                            font: '15px sans-serif',
                            fillStyle: 'white'
                        },
                        explodedRadius: 10,
                        explodedSlices: [5],
                        data: [['教师', Number(json[0].teacher)], ['辅导员', Number(json[0].instructor)], ['教辅/行政', Number(json[0].assistant)],
                               ['管理组', Number(json[0].administrator)]]
                    }
				]
			})
			
			jQuery("#Teacher").html("");
			
			var Num=json[0].teacher/(json[0].teacher+json[0].instructor+json[0].administrator+json[0].assistant);
			var PersentNum=Number(Num*100).toFixed(0);
			PersentNum=PersentNum+"%";
			var Teacher=json[0].teacher+"人 "+PersentNum;
			jQuery("#Teacher").append(Teacher);
			var Num1=json[0].instructor/(json[0].teacher+json[0].instructor+json[0].administrator+json[0].assistant);
			var PersentNum1=Number(Num1*100).toFixed(0);
			PersentNum1=PersentNum1+"%";
			var instructor=json[0].instructor+"人 "+PersentNum1;
			jQuery("#Instructor").append(instructor);
			var Num1=json[0].assistant/(json[0].teacher+json[0].instructor+json[0].administrator+json[0].assistant);
			var PersentNum1=Number(Num1*100).toFixed(0);
			PersentNum1=PersentNum1+"%";
			var assistant=json[0].assistant+"人 "+PersentNum1;
			jQuery("#Assistant").append(assistant);
			var Num1=json[0].administrator/(json[0].teacher+json[0].instructor+json[0].administrator+json[0].assistant);
			var PersentNum1=Number(Num1*100).toFixed(0);
			PersentNum1=PersentNum1+"%";
			var assistant=json[0].administrator+"人 "+PersentNum1;
			jQuery("#Administrator").append(assistant);
			jQuery("#AllNum").html("");
			var AllNum=json[0].teacher+json[0].instructor+json[0].administrator+json[0].assistant;
			
			jQuery("#AllNum").append(AllNum);
			jQuery("#Complited").html("");
			//alert(json[0].complited);
			jQuery("#Complited").append(json[0].complited);
			jQuery("#Uncomplited").html("");
			jQuery("#Uncomplited").append(json[0].uncomplited);
                    }
                    
                    });    
    
   
     });
    </script>
    
    
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/main.js"></script>




<script src="assets/js/lib/flot-chart/jquery.flot.spline.js"></script>


<script src="assets/calendar/fullcalendar.min.js"></script>
<script src="assets/calendar/fullcalendar-init.js"></script>
   

    <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
    <script src="assets/js/init/fullcalendar-init.js"></script>
    
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
