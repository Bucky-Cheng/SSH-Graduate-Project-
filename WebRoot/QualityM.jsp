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
   
    <link href="assets/css/slick.css" rel="stylesheet">
    <!-- Gallery Lightbox -->
    <link href="assets/css/magnific-popup.css" rel="stylesheet">
    <!-- Skills Circle CSS  -->
    <link rel="stylesheet" type="text/css" href="assets/css/circle.css">
    <link rel="stylesheet" href="assets/css/style_a.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    
	<link href="assets/calendar/fullcalendar.css" rel="stylesheet" />
	<link href="assets/minimal/minimal.css" rel="stylesheet">
	 <!-- Google Fonts Raleway -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,500,500i,600,700" rel="stylesheet">
	<!-- Google Fonts Open sans -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,700,800" rel="stylesheet">
	
	 <style> 
        .black_overlay{ 
            display: none; 
            position: absolute; 
            top: 0%; 
            left: 0%; 
            width: 100%; 
            height: 100%; 
            background-color: black; 
            z-index:1001; 
            -moz-opacity: 0.8; 
            opacity:.0; 
            filter: alpha(opacity=88); 
        } 
        </style> 
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
                    <a class="navbar-brand" href="AD_Home.jsp" style="margin-left:-8%"><span style=" white-space: nowrap;"><img src="images/Logo.png" style="width:10%"/>&nbsp;教师绩效考核系统&nbsp;&nbsp;</span></a>
                     
                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                </div>
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <div class="header-left">
                        

                        <div class="dropdown for-notification">
                            
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
        <!-- Content -->
        <div class="content">
          
            <div class="container" style="width:100%">
             
        
        <br/><br/>
			<nav class="navbar navbar-expand-lg navbar-light mu-navbar" style="width:100%">
				<!-- Text based logo -->
				
				<!-- image based logo -->
			   	<!-- <a class="navbar-brand mu-logo" href="index.html"><img src="assets/images/logo.png" alt="logo"></a> -->
			  

			
			    <ul class="navbar-nav mr-auto mu-navbar-nav">
			      
			      <li class="nav-item" style="width:25%;text-align:center;" ><span onclick="Teacher()" id="TeacherColor" style="color:#0997F7">教师人员</span></li>
			      <li class="nav-item" style="width:25%;text-align:center" ><span onclick="Instructor()" id="InstructorColor" style="color:black">辅导员人员</span></li>
			      <li class="nav-item" style="width:25%;text-align:center" ><span onclick="Assistant()" id="AssistantColor" style="color:black">教辅人员</span></li>
			       <li class="nav-item" style="width:25%;text-align:center" ><span onclick="Manager()" id="ManagerColor" style="color:black">管理组人员</span></li>
			       
			    </ul>
			  
			</nav>
			<table class="table table-hover">
	  		<thead>
                <tr>
                	
                    <th> </th>
                    <th>教学</th>
                    <th>研究</th>
                    <th>服务</th>
                    <th>教辅</th>
                    
                </tr>
            </thead>


			
			<tbody id="tbody1">
				
			</tbody>
			</table>
		</div>
            
       
       
       
	

        <!-- /.content -->
        <div class="clearfix"></div>
        <!-- Footer -->
        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row">
                    <div class="col-sm-6">
                       
                    </div>
                    <div class="col-sm-6 text-right"> 
                    </div>
                </div>
            </div>
        </footer>
        <!-- /.site-footer -->
    </div>
    <!-- /#right-panel -->

	<div id="fade" class="black_overlay" onclick = "closeDialog()"></div>

    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="js/icheck.js"></script>



<script>
var type='教师';




function remake(){
	
	jQuery.ajax({
 	
					url:"getTableQualityAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td >权重范围</td>";
							var td3=td2+"<td id='Education' name='TeacherID' onclick='change(this)'><a >"+json[0]+"</a>-<a id='EH' >"+json[1]+"</a></td>";
							var td4=td3+"<td id='Research' name='TeacherName' onclick='change(this)'><a >"+json[2]+"</a>-<a id='RH' >"+json[3]+"</a></td>";
							var td5=td4+"<td id='Serve' name='TeacherSex' onclick='change(this)'><a>"+json[4]+"</a>-<a id='SH' >"+json[5]+"</a></td>";
							var td6=td5+"<td id='Assistant' name='TeacherBirthday' onclick='change(this)'><a >"+json[6]+"</a>-<a id='AH'>"+json[7]+"</a></td></tr>";
							jQuery("#tbody1").append(td6);
							
						
					
					
					}
					
	
	

		})
		
}



function change(nowTd){   

if(!jQuery(nowTd).is('.input')){    

jQuery(nowTd).addClass('textarea').html("<textarea  class='form-control' name='ed1' id='a1'>"+jQuery(nowTd).text()+"</textarea>" ).find('textarea').focus().blur(function(){    

var thisid = jQuery(this).parent().attr("id");   
var thisvalue=jQuery(this).val();    
var thisclass = jQuery(this).parent().attr("name");   
jQuery.ajax({
 	
					url:"SaveQualityAction",
					type:"post",
					data:{SaveQ:thisvalue,Type:type,PreT:thisid},
					dataType:  "json",
					success:function(data){
					
						jQuery("#tbody1").html("");
						
						}

		})

 
alert("保存成功");
remake();
	

 
});

}
} 


function Instructor(){
	type="辅导员"
	
	jQuery("#InstructorColor").css("color","#0997F7");
	jQuery("#TeacherColor").css("color","black");
	jQuery("#AssistantColor").css("color","black");
	jQuery("#ManagerColor").css("color","black");
	jQuery("#tbody1").html("");
	remake();
		
}

function Assistant(){
	type="教辅"
	
	jQuery("#InstructorColor").css("color","black");
	jQuery("#TeacherColor").css("color","black");
	jQuery("#AssistantColor").css("color","#0997F7");
	jQuery("#ManagerColor").css("color","black");
	jQuery("#tbody1").html("");
	remake();
		
}

function Teacher(){
	type="教师"
	
	jQuery("#InstructorColor").css("color","black");
	jQuery("#TeacherColor").css("color","#0997F7");
	jQuery("#AssistantColor").css("color","black");
	jQuery("#ManagerColor").css("color","black");
	jQuery("#tbody1").html("");
	remake();
		
		
}

function Manager(){
	type="管理组"
	
	jQuery("#InstructorColor").css("color","black");
	jQuery("#TeacherColor").css("color","black");
	jQuery("#AssistantColor").css("color","black");
	jQuery("#ManagerColor").css("color","#0997F7");
	jQuery("#tbody1").html("");
	remake();
		
		
}






jQuery(document).ready(function(){
	remake();
});
</script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/lib/flot-chart/jquery.flot.spline.js"></script>


<script src="assets/calendar/fullcalendar.min.js"></script>
<script src="assets/calendar/fullcalendar-init.js"></script>
   
	<script type="text/javascript" src="assets/js/custom.js"></script>
	 <script type="text/javascript" src="assets/js/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
    <script src="assets/js/init/fullcalendar-init.js"></script>
  </body>
</html>








