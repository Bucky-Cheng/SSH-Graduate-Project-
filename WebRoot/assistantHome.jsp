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
	<header id="mu-hero"  style="height:100px">
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
			       <li class="nav-item active" id="AddLoc"><a href="GetAssTable" style="font-size:15px">辅导自评</a></li>
			      
			        <li class="nav-item"><a href="TeacherNoticeAction" style="font-size:15px">系统通知</a></li>
			        <li class="nav-item"><a href="SSAction" style="font-size:15px">考核结果</a></li>
			       	<li class="nav-item"><a href="PasswordM" style="font-size:15px">修改密码</a></li>
			    </ul>
			  </div>
			</nav>
		</div>
	</header>

	<center>
		<h2>辅导自评</h2>
	<div class="table-responsive" style="width:70%">
		<table class="table table-bordered">
		<center>
				
				
			
			<tbody id="tbody1">
				<tr>
					<td colspan="3"><center><h3>评分内容及标准</h3></center></td>

					<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td>
					<td>单项得分</td>
					<td>得分</td>
					
				</tr>
				
				

			</tbody>
		</table>
		<div id="SDEL">
		  <i class="fa fa-exclamation" style="color:red"></i><span>请输入教辅表分值权重</span>
        
         
          
             
            <input type="text" placeholder="输入权重" class="form-control" id="qualityContent" name="uname" style="width:50%;height:6%;font-size:15px">
              
              
          
              
         
             
               <button type="button" id="SearchButton" class="btn btn-primary" style="width:50%;height:5%;font-size:15px" onclick="qualitySave()">
              <span>确定</span>
          </button>
         
         
         <br/>
         
         <span>可选范围<span id="quality"></span></span>
      <br/><br/>
     	<i class="fa fa-exclamation" style="color:red"></i><span>佐证资料上传</span>
			<input type="file" name="upload" id="upload" value="佐证资料选择">
			<input type="button" class="uploadFile" value="上传">
			<p align="center" style="font-size:12px"> 建议为单个压缩包文件上传</br>最大为20M</p>
			<button type="button" id="SearchButton" class="btn btn-success" style="width:30%;height:5%;font-size:15px" onclick="Submit()">
              <span>提交</span>
          </button>
          <p align="center" style="font-size:12px;color:red"> 提交后将无法更改此表</p>
		<div >
		<p align="left" style="font-size:12px"> 1.</h12><h10>本表中所有加分项目均不可重复计算，如遇可多处加分的条件，只可选择一处。</br>2. 授课负担度=∑（班型系数 ×计划学分数×课程系数）  注：班型系数按工作量计算办法规定计算: 学生人数N≤90→1，90&lt;N&lt;180: →1+（N-90）÷180, N≥180→1.5，课程系数为：新开课2，开新课1.5，其他1，新课不计重复班，毕业设计（班型系数、课程系数均为1）按一门课计，每指导3人计1学分）；新入职教师一年内承担的所有课程均不计入新课。因兼职其他工作减免工作量的，按比例缩放。</br>3.包括:大学生创新创业项目、学生竞赛获奖等（毕业设计除外），以结果计。</br>4.本项指教职工个人在校内外参加各种比赛竞赛、评奖评优、论文评比等获奖，如与其他评分项目重叠，则不累加计算。
</p>
		</div>
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
    
function remake(){

jQuery.ajax({
 	
		url:"getAssTableAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			var json=eval('('+data+')');
			jQuery("#tbody1").html("");
			var thread="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td><td><center>通过项目</center></td><td>单项得分</td><td>得分</td></tr>"
			 jQuery("#tbody1").append(thread); 
			for(var i in json){
			 	
			 	
  			
	
				var tr1="<tr>"+json[i]+"</tr>";
                jQuery("#tbody1").append(tr1);  
                
               
                  
  			
  			}
  			
		}
	
	

})
}


function change(nowTd){   

if(!$(nowTd).is('.input')){    

$(nowTd).addClass('textarea').html("<textarea  class='form-control' name='ed1' id='a1'>"+$(nowTd).text()+"</textarea>" ).find('textarea').focus().blur(function(){    

var thisid = $(this).parent().attr("id");   
var thisvalue=$(this).val();    
var thisclass = $(this).parent().attr("class");   


$.ajax({
 	
	url:"AssScoreTeacherAction",
	type:"post",
	data:{name:thisid,content:thisvalue},
	dataType: "text",
	success:function(data){
	remake();
	}
	

})
remake();

 
});

}
} 
   
function ContentChange(nowTd){   

if(!$(nowTd).is('.input')){    

$(nowTd).addClass('textarea').html("<textarea  class='form-control' name='ed1' id='a1'>"+$(nowTd).text()+"</textarea>" ).find('textarea').focus().blur(function(){    

var thisid = $(this).parent().attr("id");   
var thisvalue=$(this).val();    
var thisclass = $(this).parent().attr("class");   


$.ajax({
 	
	url:"AssContentTeacherAction",
	type:"post",
	data:{name:thisid,content:thisvalue},
	dataType: "text",
	success:function(data){
	remake();
	}
	

})
remake();

 
});

}
} 

function remakeQ(){
	jQuery.ajax({
 	
		url:"getEduConQualityAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			var json=eval('('+data+')');
			jQuery("#qualityContent").val(json[0].assQuality);
  			
		}
		});
	}

function qualitySave(){
		var quality=jQuery("#qualityContent").val();
		var tail=quality.substring(quality.length-1,quality.length);
		//alert(tail);
		var qualitytemp=quality.substring(0,quality.length-1);
		var ival = parseInt(qualitytemp);
		var ivalA = parseInt(quality);
		if(tail=='%'){
		if(isNaN(ival)){
			alert("输入的权重非法，请重新输入");
			remakeQ();
		}else{
		 jQuery.ajax({
 	
		url:"saveAssQualityAction",
		type:"post",
		data:{QualityContent:quality },
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			var json=eval('('+data+')');
			jQuery("#qualityContent").val(json[0].assQuality);
  			
				}
	
	

			})
			}
		}else{
			if(isNaN(ivalA)){
			alert("输入的权重非法，请重新输入");
			remakeQ();
		}else{
		 jQuery.ajax({
 	
		url:"saveAssQualityAction",
		type:"post",
		data:{QualityContent:quality },
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			var json=eval('('+data+')');
			jQuery("#qualityContent").val(json[0].assQuality);
  			
				}
	
	

				})
			}
		}
		
	}

	function submitA(){
	//alert("C");
		if(FLAGA=='T'&&FLAG=='T'){
		tableMake();
		}else if(FLAG=='F'){
		tableMakeB();
		}else{
		tableMakeC();
		}
	}

			var FLAGA='T'
	function getSubmit(){
		jQuery.ajax({
 	
					url:"TSubmitExamineAction",
					type:"post",
					data:{},
					async: false,
					dataType:  "json",
					success:function(data){
				
					var json=eval('('+data+')');
					if(json[0].assistant=='1'){
					FLAGA='F';
					}else{
						FLAGA='T'
					}
					//alert("B"+FLAGA);
					}
		})
	}

	 function tableMakeC(){
     var TID = '<%= session.getAttribute("t_ID")%>';
	  //alert(TID)
		jQuery.ajax({
 	
					url:"AssistantExamineAction",
					type:"post",
					data:{TID:TID},
					dataType:  "json",
					success:function(data){
						jQuery("#tbody1").html("");
						jQuery("#SDEL").html("");
						var Dspan="<span style='color:red'>您已提交自评，不可更改</span>"
						var trHead1="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td>";
						var trHead2=trHead1+"<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td><td>单项得分</td><td>得分</td></tr>";
						jQuery("#tbody1").append(trHead2);
						jQuery("#SDEL").append(Dspan);
						var json=eval('('+data+')');
						
						for(var i in json){

							var tr1="<tr>"+json[i]+"</tr>";
                			jQuery("#tbody1").append(tr1);  
  						}
  						
  						
  						
					}

		})
    
    	
    }
		
	    var FLAG='T'
    
    function getType(){
    	 jQuery.ajax({
 	
					url:"getTableEAction",
					type:"post",
					data:{},
					async: false,
					dataType:  "json",
					success:function(data){
				
					var json=eval('('+data+')');
					
					FLAG=json[0].allCheck;
					//alert("A"+FLAG);
					}
		})
    }
    
    function tableMake(){
    	 
     	 jQuery.ajax({
 	
		url:"getAssTableAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			var json=eval('('+data+')');
			for(var i in json){
			 	
			 	
  			
	
				var tr1="<tr>"+json[i]+"</tr>";
                jQuery("#tbody1").append(tr1);  
                
               
                  
  			
  			}
  			
		}
	
	

})
	
	 jQuery.ajax({
 	
		url:"getEduQualityAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			//alert(data);
			//alert(data);
			
			var json=eval('('+data+')');
			jQuery("#quality").html(json[0].assistant);
  			
		}
		
	
	

})

	 jQuery.ajax({
 	
		url:"getEduConQualityAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			var json=eval('('+data+')');
			jQuery("#qualityContent").val(json[0].assQuality);
  			
		}
		});
	
    }
    
    
    function tableMakeB(){
     var TID = '<%= session.getAttribute("t_ID")%>';
	  //alert(TID)
		jQuery.ajax({
 	
					url:"AssistantExamineAction",
					type:"post",
					data:{TID:TID},
					dataType:  "json",
					success:function(data){
						jQuery("#tbody1").html("");
						jQuery("#SDEL").html("");
						var Dspan="<span style='color:red'>自评尚未开始</span>"
						var trHead1="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td>";
						var trHead2=trHead1+"<td><center><h4>通过项目</br>(请注明或勾选)</h4></center></td><td>单项得分</td><td>得分</td></tr>";
						jQuery("#tbody1").append(trHead2);
						jQuery("#SDEL").append(Dspan);
						var json=eval('('+data+')');
						
						for(var i in json){

							var tr1="<tr>"+json[i]+"</tr>";
                			jQuery("#tbody1").append(tr1);  
  						}
  						
  						
  						
					}

		})
    
    	
    }
	
	
	  function Submit(){
    	 jQuery.ajax({
 	
		url:"submitAExamineAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data);
			
			window.location.reload();
  			
		}
		});
    }
   
     $(document).ready(function(){
     
     getType();
	getSubmit();
	submitA();
	
	jQuery(".uploadFile").click(function() {
				jQuery.ajaxFileUpload({
					url : 'AssFileUpload',//后台请求地址
					type : 'post',//请求方式  当要提交自定义参数时，这个参数要设置成post
					secureuri : false,//是否启用安全提交，默认为false。 
					fileElementId : 'upload',// 需要上传的文件域的ID，即<input type="file">的ID。
					dataType : 'content',//服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。如果json返回的带pre,这里修改为json即可解决。
					async : false, //是否是异步
					success : function(data,status) {//提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
						alert("上传成功");
 
					},
					error : function(data,status,e) {//提交失败自动执行的处理函数。
						alert(e);
					}
				});
			});

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
    
    <script type="text/javascript" src="assets/js/jquery.magnific-popup.min.js"></script>
    
	<script type="text/javascript" src="assets/js/custom.js"></script>

	
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/bootstrap-table.js"></script>
<script src="assets/js/bootstrap-table-zh-CN.js"></script>
  </body>
</html>
