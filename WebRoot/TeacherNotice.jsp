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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link rel="stylesheet" href="assets/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
    
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
			      <li class="nav-item">
			        <a href="teacher_Home.jsp" style="font-size:15px">主页</a>
			      </li>
			      <li class="nav-item"><a href="educationTable?flag=a" style="font-size:15px">教学自评</a></li>
			      <li class="nav-item"><a href="GetReaTable" style="font-size:15px">研究自评</a></li>
			      <li class="nav-item"><a href="GetSerTable" style="font-size:15px">服务自评</a></li>
			      <li class="nav-item" id="AddLoc" style="font-size:15px"><a href="GetAssTable" style="font-size:15px">辅导自评</a></li>
			       
			      <li class="nav-item active"><a href="TeacherNoticeAction" style="font-size:15px">系统通知</a></li>
			      <li class="nav-item"><a href="SSAction" style="font-size:15px">考核结果</a></li>
			      <li class="nav-item"><a href="PasswordM" style="font-size:15px">修改密码</a></li>
			    </ul>
			  </div>
			</nav>
		</div>
	</header>
	<!-- End Header -->

	<!-- Start slider area -->
	<div  >
		 <div class="container" style="width:100%;height:800px" id="AllDiv">
        
		
			<nav class="navbar navbar-expand-lg navbar-light mu-navbar" style="width:100%">
				
			    <ul class="navbar-nav mr-auto mu-navbar-nav">
			      
			      <li class="nav-item" style="width:50%;text-align:center;float:left" ><span onclick="SystemN()" id="TeacherColor" style="color:#0997F7">系统通知<i id="AttentionSystemNotice" style="display:block;background:#f00;border-radius:50%;width:0.45em;height:0.45em;top:34%;right:71%;position:absolute;z-index:2001"></i></span></li>
			      <li class="nav-item" style="width:50%;text-align:center;float:left" ><span onclick="Decline()" id="InstructorColor" style="color:black">成绩驳回通知<i id="AttentionDDeclineNotice" style="display:block;background:#f00;border-radius:50%;width:0.45em;height:0.45em;top:34%;right:19.5%;position:absolute;z-index:2001"></i></span></li>
			      
			    </ul>
			  
			</nav>
			<table class="table table-hover" >
	  		<thead>
                <tr>
                	
                    <th style="width:50%;text-align:center" >通知列表</th>
                   
                </tr>
            </thead>


			
			<tbody id="tbody1">
				<s:iterator value="TNT" status="li">
				<tr id=<s:property value="ID"/> >
				<td ><a id=<s:property value="ID"/> onclick="NoticeContent(this)"><span style="float:left;margin-left:5%"><s:property value="noticeTheme"/>&nbsp;<i id=Attention<s:property value="ID"/> style="color:red;font-size:75%;margin-top:0%;position:absolute;" class="fa fa-comment"></i></span><span style="float:right"><s:property value="startTime"/></span></a></td>
				</tr>
				</s:iterator>
			</tbody>
			</table>
			
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
     <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
     
     <script>
     var Type="系统通知";
     function NoticeContent(ThisTr){
     	var NoticeID=jQuery(ThisTr).attr("id");
     	jQuery("#AllDiv").html("");
     	Type="系统通知";
     	jQuery.ajax({
 	
					url:"NumNoticeAction",
					type:"post",
					data:{TID:NoticeID},
					dataType:  "json",
		})
     	
     	jQuery.ajax({
 	
					url:"TeacherShowNoticeAction",
					type:"post",
					data:{NoticeID:NoticeID},
					dataType:  "json",
					success:function(data){
						var json=eval('('+data+')');
						for(var i in json){
						
						var title="<center><h2>"+json[i].noticeTheme+"</h2></center><br/>";
						var Editor="<center><h7>发布人：管理员</h7></center><br/>"
						var Content="<center><div style='width:60%'><p style='height: auto; word-wrap:break-word;word-break:break-all;overflow:hidden;' align='left'>"+json[i].noticeContent+"</p></div></center><br/><br/><br/><br/>"
						if(json[i].fileLoction=="无"){
							var Attachment="<div style='width:60%;margin:auto'><a ><span>相关附件："+json[i].fileLoction+"</span></a></div>"
						
						}else{
						var Attachment="<div style='width:60%;margin:auto'><a href='AttachmentDownload?path="+json[i].fileLoction+"'><span>相关附件："+json[i].fileLoction+"</span></a></div>"
							}
						}
						var buttonC= "<br/><br/><br/><br/><div style='float:right'><button style='background-color:white' type='button' class='btn btn-default btn-sm' onclick='cancelNotice()'><span style='width:100%'> <i class='fa fa-mail-reply'></i>&nbsp;&nbsp;返回</span></button></div>";
						jQuery("#AllDiv").append(title);
						jQuery("#AllDiv").append(Editor);
						jQuery("#AllDiv").append(Content);
						jQuery("#AllDiv").append(Attachment);
						jQuery("#AllDiv").append(buttonC);
					}
					
	
	

		})
     }
     
      function NoticeContentD(ThisTr){
     	var NoticeID=jQuery(ThisTr).attr("id");
     	jQuery("#AllDiv").html("");
     	Type="系统通知";
     	
     	
     	jQuery.ajax({
 	
					url:"TeacherShowDNoticeAction",
					type:"post",
					data:{NoticeID:NoticeID},
					dataType:  "json",
					success:function(data){
						var json=eval('('+data+')');
						for(var i in json){
						var title="<center><h2>"+json[i].declineName+"</h2></center><br/>";
						var Editor="<center><h7>发布人："+json[i].managerName+"</h7></center><br/>"
						var Content="<center><div style='width:60%'><p style='height: auto; word-wrap:break-word;word-break:break-all;overflow:hidden;' align='left'>"+json[i].declineContent+"</p></div></center><br/><br/><br/><br/>"
						
						}
						var buttonC= "<br/><br/><br/><br/><div style='float:right'><button style='background-color:white' type='button' class='btn btn-default btn-sm' onclick='cancelNoticeD()'><span style='width:100%'> <i class='fa fa-mail-reply'></i>&nbsp;&nbsp;返回</span></button></div>";
						jQuery("#AllDiv").append(title);
						jQuery("#AllDiv").append(Editor);
						jQuery("#AllDiv").append(Content);
						
						jQuery("#AllDiv").append(buttonC);
					}
					
	
	

		})
     }
     
     
     
     function cancelNotice(){
     	jQuery("#AllDiv").html("");
     	var Notice1="<nav class='navbar navbar-expand-lg navbar-light mu-navbar' style='width:100%''>";
		var Notice2=Notice1+"<ul class='navbar-nav mr-auto mu-navbar-nav'>"		
		var Notice3=Notice2+"<li class='nav-item' style='width:50%;text-align:center;float:left' ><span onclick='SystemN()' id='TeacherColor' style='color:#0997F7'>系统通知<i id='AttentionSystemNotice' style='display:block;background:#f00;border-radius:50%;width:0.45em;height:0.45em;top:34%;right:71%;position:absolute;z-index:2001'></i></span></li>"	 
		var Notice4=Notice3+"<li class='nav-item' style='width:50%;text-align:center;float:left' ><span onclick='Decline()' id='InstructorColo' style='color:black'>成绩驳回通知<i id='AttentionDDeclineNotice' style='display:block;background:#f00;border-radius:50%;width:0.45em;height:0.45em;top:34%;right:19.5%;position:absolute;z-index:2001'></i></span></li></ul></nav>";
		var Notice5=Notice4+"<table class='table table-hover' ><thead> <tr><th style='width:50%;text-align:center' >通知列表</th></tr></thead><tbody id='tbody1'></tbody></table>";      
		jQuery("#AllDiv").append(Notice5);
		jQuery.ajax({
 	
					url:"getTableByTypeNoticeAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						var json=eval('('+data+')');
						for(var i in json){
							var tr1="<tr id='"+json[i].ID+"' >"
							var td1=tr1+"<td ><a id='"+json[i].ID+"' onclick='NoticeContent(this)'><span style='float:left;margin-left:5%''>"+json[i].noticeTheme+"&nbsp;<i id='Attention"+json[i].ID+"' style='color:red;font-size:75%;margin-top:0%;position:absolute;' class='fa fa-comment'></i></span><span style='float:right'>"+json[i].startTime+"</span></a></td></tr>"
							jQuery("#tbody1").append(td1);
						}
						AttentionNotice();
						AttentionDNotice();
						AllAttention();
					}
					
	
	

		})	     		
     }
     
      function cancelNoticeD(){
     	jQuery("#AllDiv").html("");
     	var Notice1="<nav class='navbar navbar-expand-lg navbar-light mu-navbar' style='width:100%''>";
		var Notice2=Notice1+"<ul class='navbar-nav mr-auto mu-navbar-nav'>"		
		var Notice3=Notice2+"<li class='nav-item' style='width:50%;text-align:center;float:left' ><span onclick='SystemN()' id='TeacherColor' style='color:#0997F7'>系统通知<i id='AttentionSystemNotice' style='display:block;background:#f00;border-radius:50%;width:0.45em;height:0.45em;top:34%;right:71%;position:absolute;z-index:2001'></i></span></li>"	 
		var Notice4=Notice3+"<li class='nav-item' style='width:50%;text-align:center;float:left' ><span onclick='Decline()' id='InstructorColo' style='color:black'>成绩驳回通知<i id='AttentionDDeclineNotice' style='display:block;background:#f00;border-radius:50%;width:0.45em;height:0.45em;top:34%;right:19.5%;position:absolute;z-index:2001'></i></span></li></ul></nav>";
		var Notice5=Notice4+"<table class='table table-hover' ><thead> <tr><th style='width:50%;text-align:center' >通知列表</th></tr></thead><tbody id='tbody1'></tbody></table>";      
		jQuery("#AllDiv").append(Notice5);
		Decline();		
     }
     
     function AttentionNotice(){
     
     	jQuery.ajax({
 	
					url:"AttentionSystemNoticeAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						
						var json=eval('('+data+')');
						for(var i in json){
							//alert("attention"+json[i]);
							jQuery("#Attention"+json[i]).css("display","none");
						}
						
					}
					
	
	

		})	     		
     }
     
      function AttentionDNotice(){
     	jQuery.ajax({
 	
					url:"AttentionDeclineNoticeAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						
						var json=eval('('+data+')');
						for(var i in json){
						
							jQuery("#AttentionD"+json[i]).css("display","none");
						}
						
					}
					
	
	

		})	     		
     }
     
     function Decline(){
     	jQuery.ajax({
 	
					url:"DeclineShowNoticeAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						
						var json=eval('('+data+')');
						jQuery("#tbody1").html("");
						for(var i in json){
						
						var tr1="<tr id='"+json[i].ID+"' >";
						var tr2=tr1+"<td ><a id='"+json[i].ID+"' onclick='NoticeContentD(this)''><span style='float:left;margin-left:5%'>"+json[i].declineName+"&nbsp;";
						var tr3=tr2+"<i id='AttentionD"+json[i].ID+"' style='color:red;font-size:75%;margin-top:0%;position:absolute;' class='fa fa-comment'></i></span>";
						var tr4=tr3+"<span style='float:right'>"+json[i].startTime+"</span></a></td></tr>"
						jQuery("#tbody1").append(tr4);	
						}
						AttentionDNotice();
						AttentionNotice();
						 AllAttention();
					}
					
	
	

		})	     		
     }
     function SystemN(){
     	jQuery.ajax({
 	
					url:"SystemShowNoticeAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						
						var json=eval('('+data+')');
						jQuery("#tbody1").html("");
						for(var i in json){
						
						var tr1="<tr id='"+json[i].ID+"' >";
						var tr2=tr1+"<td ><a id='"+json[i].ID+"' onclick='NoticeContent(this)''><span style='float:left;margin-left:5%'>"+json[i].noticeTheme+"&nbsp;";
						var tr3=tr2+"<i id='Attention"+json[i].ID+"' style='color:red;font-size:75%;margin-top:0%;position:absolute;' class='fa fa-comment'></i></span>";
						var tr4=tr3+"<span style='float:right'>"+json[i].startTime+"</span></a></td></tr>"
						jQuery("#tbody1").append(tr4);	
						}
						AttentionNotice();
						AttentionDNotice();
						AllAttention();
					}
					
	
	

		})	     		
     }
     
     function AllAttention(){
     		jQuery.ajax({
 	
					url:"AllAttentionNoticeAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						
						var json=eval('('+data+')');
						//alert(json[0]);
						if(json[0]=="T"){
						//alert(json[0]);
							jQuery("#AllAttention").css("display","none");
						}
						
					}
					
	
	

		})	     		
     }
     
     jQuery(document).ready(function(){
 		 AttentionNotice();
 		 AttentionDNotice();
 		  AllAttention();
 		  
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
 	 });
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
