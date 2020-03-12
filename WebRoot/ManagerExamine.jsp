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
    
    <!-- Favicon -->
    
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="assets/minimal/minimal.css" rel="stylesheet">
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
	<header id="mu-hero" style="height:100px">
		<div style="position: fixed;right:20px;text-align:right;height:90px;width:700px;padding-top:35px">
			<a style="font-size:20px;color:white;text-align:right" href="QUIT">${ sessionScope.t_Name}</a>
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
			       	<li class="nav-item"><a href="PasswordM" style="font-size:15px">修改密码</a></li>
			    </ul>
			  </div>
			</nav>
		</div>
	</header>
	<!-- End Header -->

	
	<div style="width:100%;height:800px" id="HDIV">
	<center>
		<div class="table-responsive" style="width:75%" id="AllDiv">
		<table class="table table-bordered">
		 <thead id="thead1">
                 <tr>
                      <th>工号</th>
                      <th>姓名</th>
                      <th>教育佐证资料</th>
                      <th>研究佐证资料</th>
                      <th>服务佐证资料</th>
                      <th>辅导佐证资料</th>
                      </tr>
         </thead>
		<tbody id="tbody1">
			<s:iterator value="DocList" status="li">
			<tr>
			<td><s:property value="TeacherID"/></td>
			<td><s:property value="TeacherName"/></td>
			<td style="width:21%"><a id=<s:property value="TeacherID"/> href="FileDownload?path=<s:property value='Education'/>" onclick="EducationExamine(this)"><s:property value="Education"/>&nbsp;&nbsp;</a><i id='NO<s:property value="TeacherID"/>教学表驳回'>(未审批)</i><i id='approve<s:property value="TeacherID"/>教学表驳回' class="fa fa-check" style="color:green;display:none"></i><i id='decline<s:property value="TeacherID"/>教学表驳回' style="color:red;display:none" class="fa fa-remove"></i></td>
			<td style="width:21%"><a id=<s:property value="TeacherID"/> href="FileDownload?path=<s:property value='Research'/>" onclick="ResearchExamine(this)"><s:property value="Research"/>&nbsp;&nbsp;</a><i id='NO<s:property value="TeacherID"/>研究表驳回'>(未审批)</i><i id='approve<s:property value="TeacherID"/>研究表驳回' class="fa fa-check" style="color:green;display:none"></i><i id='decline<s:property value="TeacherID"/>研究表驳回' style="color:red;display:none" class="fa fa-remove"></i></td>
			<td style="width:21%"><a id=<s:property value="TeacherID"/> href="FileDownload?path=<s:property value='Serve'/>" onclick="ServeExamine(this)"><s:property value="Serve"/>&nbsp;&nbsp;</a><i id='NO<s:property value="TeacherID"/>服务表驳回' >(未审批)</i><i id='approve<s:property value="TeacherID"/>服务表驳回' class="fa fa-check" style="color:green;display:none"></i><i id='decline<s:property value="TeacherID"/>服务表驳回' style="color:red;display:none" class="fa fa-remove"></i></td>
			<td style="width:21%"><a id=<s:property value="TeacherID"/> href="FileDownload?path=<s:property value='Assistant'/>" onclick="AssistantExamine(this)"><s:property value="Assistant"/>&nbsp;&nbsp;</a><i id='NO<s:property value="TeacherID"/>辅导表驳回' >(未审批)</i><i id='approve<s:property value="TeacherID"/>辅导表驳回' class="fa fa-check" style="color:green;display:none"></i><i id='decline<s:property value="TeacherID"/>辅导表驳回' style="color:red;display:none" class="fa fa-remove"></i></td>
			</tr>
			</s:iterator>
		
		</tbody>		
				
			
			
		</table>
           </div>
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
								    	<p><a>学校主页</a></p>
								    	<a href="#"></a>
								    </div>
							  	</li>
							  	<li class="media">
								   	<span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<p>教务处</p>
								    	<a href="#"></a>
								    </div>
							  	</li>
							  	<li class="media">
								   	<span class="fa fa-twitter"></span>
								    <div class="media-body">
								    	<p>网络教学平台</p>
								    	<a href="#"></a>
								    </div>
							  	</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3">
						<div class="mu-single-footer">
							<h3>快速链接</h3>
							<ul class="mu-useful-links">
								<li ><a href="PasswordM">修改密码</a></li>
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
     <script src="assets/js/bootstrap.min.js"></script>
     <script src="js/icheck.js"></script>
     <script>
    
     
     function EducationExamine(ThisA){
     	var TID=jQuery(ThisA).attr("id");
     	
     	//alert(TID);
     	//alert("aaaaaa");
     	jQuery.ajax({
 	
					url:"EducationExamineAction",
					type:"post",
					data:{TID:TID},
					dataType:  "json",
					success:function(data){
						jQuery("#tbody1").html("");
						jQuery("#thead1").html("");
						var json=eval('('+data+')');
						var trHead1="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td>";
						var trHead2=trHead1+"<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td><td>单项得分</td><td>得分</td></tr>";
						jQuery("#tbody1").append(trHead2);
						for(var i in json){

							var tr1="<tr>"+json[i]+"</tr>";
                			jQuery("#tbody1").append(tr1);  
  						}
  						
  						var Confirmation1="<br/><label onclick='approveF()'><input  type='radio' name='iCheck' id='approve' checked onclick='approveF()'><span>通过</span></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  						var Confirmation2=Confirmation1+"&nbsp;&nbsp;&nbsp;&nbsp;<label id='AddL' onclick='declineF()'><input type='radio' name='iCheck' id='decline' onfocus='declineF()'><span>驳回</span></label>";
  						jQuery("#AllDiv").append(Confirmation2);
  						iCheckRemake();
  						var buttonA= "<br/><button type='button' class='btn btn-success' id='"+TID+"' onclick='Save(this)'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;提交</span></button>&nbsp;&nbsp;";
  						jQuery("#AllDiv").append(buttonA);
  						var height=jQuery("#AllDiv").height();
						jQuery("#HDIV").height(height+100);
					}

		})
		
     }
     
      function ResearchExamine(ThisA){
     	var TID=jQuery(ThisA).attr("id");
     	
     	//alert(TID);
     	//alert("aaaaaa");
     	jQuery.ajax({
 	
					url:"ResearchExamineAction",
					type:"post",
					data:{TID:TID},
					dataType:  "json",
					success:function(data){
						jQuery("#thead1").html("");
						jQuery("#tbody1").html("");
						
						var json=eval('('+data+')');
						var trHead1="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td>";
						var trHead2=trHead1+"<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td><td>单项得分</td><td>得分</td></tr>";
						jQuery("#tbody1").append(trHead2);
						for(var i in json){

							var tr1="<tr>"+json[i]+"</tr>";
                			jQuery("#tbody1").append(tr1);  
  						}
  						
  						var Confirmation1="<br/><label onclick='approveF()'><input  type='radio' name='iCheck' id='approve' checked onclick='approveF()'><span>通过</span></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  						var Confirmation2=Confirmation1+"&nbsp;&nbsp;&nbsp;&nbsp;<label id='AddL' onclick='declineF()'><input type='radio' name='iCheck' id='decline' onfocus='declineF()'><span>驳回</span></label>";
  						jQuery("#AllDiv").append(Confirmation2);
  						iCheckRemake();
  						var buttonA= "<br/><button type='button' class='btn btn-success' id='"+TID+"' onclick='SaveR(this)'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;提交</span></button>&nbsp;&nbsp;";
  						jQuery("#AllDiv").append(buttonA);
  						var height=jQuery("#AllDiv").height();
						jQuery("#HDIV").height(height+100);
					}

		})
		
     }
     
       function ServeExamine(ThisA){
     	var TID=jQuery(ThisA).attr("id");
     	
     	//alert(TID);
     	//alert("aaaaaa");
     	jQuery.ajax({
 	
					url:"ServeExamineAction",
					type:"post",
					data:{TID:TID},
					dataType:  "json",
					success:function(data){
						jQuery("#tbody1").html("");
						jQuery("#thead1").html("");
						var json=eval('('+data+')');
						var trHead1="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td>";
						var trHead2=trHead1+"<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td><td>单项得分</td><td>得分</td></tr>";
						jQuery("#tbody1").append(trHead2);
						for(var i in json){

							var tr1="<tr>"+json[i]+"</tr>";
                			jQuery("#tbody1").append(tr1);  
  						}
  						
  						var Confirmation1="<br/><label onclick='approveF()'><input  type='radio' name='iCheck' id='approve' checked onclick='approveF()'><span>通过</span></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  						var Confirmation2=Confirmation1+"&nbsp;&nbsp;&nbsp;&nbsp;<label id='AddL' onclick='declineF()'><input type='radio' name='iCheck' id='decline' onfocus='declineF()'><span>驳回</span></label>";
  						jQuery("#AllDiv").append(Confirmation2);
  						iCheckRemake();
  						var buttonA= "<br/><button type='button' class='btn btn-success' id='"+TID+"' onclick='SaveS(this)'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;提交</span></button>&nbsp;&nbsp;";
  						jQuery("#AllDiv").append(buttonA);
  						var height=jQuery("#AllDiv").height();
						jQuery("#HDIV").height(height+100);
					}

		})
		
     }
     
      function AssistantExamine(ThisA){
     	var TID=jQuery(ThisA).attr("id");
     	
     	//alert(TID);
     	//alert("aaaaaa");
     	jQuery.ajax({
 	
					url:"AssistantExamineAction",
					type:"post",
					data:{TID:TID},
					dataType:  "json",
					success:function(data){
						jQuery("#tbody1").html("");
						jQuery("#thead1").html("");
						var json=eval('('+data+')');
						var trHead1="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td>";
						var trHead2=trHead1+"<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td><td>单项得分</td><td>得分</td></tr>";
						jQuery("#tbody1").append(trHead2);
						for(var i in json){

							var tr1="<tr>"+json[i]+"</tr>";
                			jQuery("#tbody1").append(tr1);  
  						}
  						
  						var Confirmation1="<br/><label onclick='approveF()'><input  type='radio' name='iCheck' id='approve' checked onclick='approveF()'><span>通过</span></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  						var Confirmation2=Confirmation1+"&nbsp;&nbsp;&nbsp;&nbsp;<label id='AddL' onclick='declineF()'><input type='radio' name='iCheck' id='decline' onfocus='declineF()'><span>驳回</span></label>";
  						jQuery("#AllDiv").append(Confirmation2);
  						iCheckRemake();
  						var buttonA= "<br/><button type='button' class='btn btn-success' id='"+TID+"' onclick='SaveA(this)'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;提交</span></button>&nbsp;&nbsp;";
  						jQuery("#AllDiv").append(buttonA);
  						var height=jQuery("#AllDiv").height();
						jQuery("#HDIV").height(height+100);
					}

		})
		
     }
     
     function approveF(){
     	//alert("return");
     	jQuery("#declineC").html("");
     }
     
     function declineF(){
     jQuery("#declineC").html("");
     //alert("DECLINE");
		var span="<div style='width:45%' id=declineC><br/><span style='float:left'>请输入驳回原因</span>";
		var TextA=span+"<br/><textarea rows='10' cols='50' id='declineContent'></textarea></div>"
		
		jQuery("#AddL").after(TextA);  
		var height=jQuery("#AllDiv").height();
		jQuery("#HDIV").height(height+100);
     }
     jQuery('body').on('click','#decline',function(){
     	//alert("SUCCESS");
     })
     function Save(ThisButton){
      	var DType="教学表驳回";
     	var declineContent=jQuery("#declineContent").val();
     	var TeacherID=jQuery(ThisButton).attr("id");
     	var valA=$('input:radio[id="approve"]:checked').val();
     	var valD=$('input:radio[id="decline"]:checked').val();
     	if(valA==null){
     	}else{
     	jQuery.ajax({
 	
					url:"ApproveExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
     	}
     	if(valD==null){
     	}else{
     	
     	jQuery.ajax({
 	
					url:"SaveExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,declineContent:declineContent,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
		}
     }
     
      function SaveR(ThisButton){
      	var DType="研究表驳回";
     	var declineContent=jQuery("#declineContent").val();
     	var TeacherID=jQuery(ThisButton).attr("id");
     	var valA=$('input:radio[id="approve"]:checked').val();
     	var valD=$('input:radio[id="decline"]:checked').val();
     	if(valA==null){
     	}else{
     	jQuery.ajax({
 	
					url:"ApproveExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
     	}
     	if(valD==null){
     	}else{
     	
     	jQuery.ajax({
 	
					url:"SaveRExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,declineContent:declineContent,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
		}
     }
     
     function SaveS(ThisButton){
      	var DType="服务表驳回";
     	var declineContent=jQuery("#declineContent").val();
     	var TeacherID=jQuery(ThisButton).attr("id");
     	var valA=$('input:radio[id="approve"]:checked').val();
     	var valD=$('input:radio[id="decline"]:checked').val();
     	if(valA==null){
     	}else{
     	jQuery.ajax({
 	
					url:"ApproveExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
     	}
     	if(valD==null){
     	}else{
     	
     	jQuery.ajax({
 	
					url:"SaveSExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,declineContent:declineContent,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
		}
     }
     
      function SaveA(ThisButton){
      	var DType="辅导表驳回";
     	var declineContent=jQuery("#declineContent").val();
     	var TeacherID=jQuery(ThisButton).attr("id");
     	var valA=$('input:radio[id="approve"]:checked').val();
     	var valD=$('input:radio[id="decline"]:checked').val();
     	if(valA==null){
     	}else{
     	jQuery.ajax({
 	
					url:"ApproveExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
     	}
     	if(valD==null){
     	}else{
     	
     	jQuery.ajax({
 	
					url:"SaveAExamineAction",
					type:"post",
					data:{TeacherID:TeacherID,declineContent:declineContent,Type:DType},
					dataType:  "json",
					success:function(data){	
						window.location.reload()
					}

		})
		}
     }
     
     function iCheckRemake(){
     	//alert("ICHECK")
		jQuery('input').iCheck({
		
    	checkboxClass: 'icheckbox_minimal',
    	radioClass: 'iradio_minimal',
    	increaseArea: '20%' // optional
  })
 
}
     
     jQuery(document).ready(function(){
     
     	jQuery.ajax({
 	
		url:"getDepartmrntInfoAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			var height=jQuery("#AllDiv").height();
			jQuery("#HDIV").height(height+100);
			//alert(data)
			var json=eval('('+data+')');
			//alert(json[0]);
			if(json[0]=="true"){
			var NewLi="<li class='nav-item  active'><a href='DocumentShow' style='font-size:15px'>审批成绩</a></li>"
			jQuery("#AddLoc").after(NewLi);
			<!--jQuery("#AddUL").append(NewLi);-->
			}
		}
	})
		
		
		jQuery.ajax({
 	
		url:"returnStatusAExamineAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			var height=jQuery("#AllDiv").height();
			jQuery("#HDIV").height(height+100);
			//alert(data)
			var json=eval('('+data+')');
			//alert(json[0]);
			for(var i in json){
			jQuery("#NO"+json[i]).css('display','none');
			jQuery("#decline"+json[i]).css('display','none');
			jQuery("#approve"+json[i]).show();
			}
		}
	})
     	
     	jQuery.ajax({
 	
		url:"returnStatusDExamineAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			var height=jQuery("#AllDiv").height();
			jQuery("#HDIV").height(height+100);
			//alert(data)
			var json=eval('('+data+')');
			//alert(json[0]);
			for(var i in json){
			jQuery("#NO"+json[i]).css('display','none');
			jQuery("#approve"+json[i]).css('display','none');
			jQuery("#decline"+json[i]).show();
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
