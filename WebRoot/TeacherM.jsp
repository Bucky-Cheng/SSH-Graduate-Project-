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
        <!-- Content -->
        <div class="content">
          
            <div class="container" style="width:100%">
             <div style="float:left;" id="buttonAdd">
         <button type="button" class="btn btn-primary" id="add" onclick="addContent()">
             
              <span style="width:100%"> <i class="fa fa-plus-square-o fa-fw"></i>&nbsp;&nbsp;添加</span>
          </button>
          <button type="button" class="btn btn-danger" id="del" onclick="delRow()">
             
              <span style="width:100%"> <i class="fa fa-minus-square-o fa-fw"></i>&nbsp;&nbsp;删除</span>
          </button>
         
          </div>
         <div class="input-group col-sm-3" style="float:right">
          <span class="input-group-addon">
            <i class="fa fa-search fa-fw"></i>
          </span>
              <input type="text" placeholder="输入查询信息" class="form-control" id="SearchContent" name="uname">
              <span class="input-group-btn">
               <button type="button" id="SearchButton" class="btn btn-primary" onclick="Search()">
              <span>搜索</span>
          </button>
          </span>
          <div id="lns" style="background:#F0F8FF;z-index:1002"></div>
      </div>
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
                	<th style="width:3%">
            			<input type="checkbox">
          				</th>
                    <th>工号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>生日</th>
                    <th>类别</th>
                    <th>部门</th>
                </tr>
            </thead>


			
			<tbody id="tbody1">
				<s:iterator value="TMList" status="li">
				<tr id="TbodyTr">
				<td style="width:3%"><input type="checkbox" name="checkRow" id=<s:property value="ID"/>></td>
				<td id=<s:property value="TeacherID"/> name="TeacherID" onclick="change(this)"><s:property value="TeacherID"/></td>
				<td id=<s:property value="TeacherID"/> name="TeacherName" onclick="change(this)"><s:property value="TeacherName"/></td>
				<td id=<s:property value="TeacherID"/> name="TeacherSex" onclick="change(this)"><s:property value="TeacherSex"/></td>
				<td id=<s:property value="TeacherID"/> name="TeacherBirthday" onclick="change(this)"><s:property value="TeacherBirthday"/></td>
				<td id=<s:property value="TeacherID"/> ><s:property value="Department"/></td>
				<td id=<s:property value="TeacherID"/> name="Programme" onclick="change(this)"><s:property value="Programme"/></td>
				</tr>
				</s:iterator>
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
function addContent(){
 var delSave="";
	jQuery.ajax({
 	
					url:"SaveDelListInfoAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
					//alert(data);
					var json=eval('('+data+')');
					if(json == null || json == "" || json == undefined){
						jQuery("#tbody1").html("");
						jQuery("#buttonAdd").html("");
						var newtr="<tr><td style='width:3%''></td><td> <input type='text' name='SId' id='tID0' class='form-control'></td><td><input type='text' id='tName0'  class='form-control'></td><td><input type='text' id='tSex0'  class='form-control'></td><td><input type='text' id='tBirthday0'  class='form-control'></td><td>"+type+"</td><td><input type='text' id='tDepartment0' class='form-control'></td></tr>"
						var buttonA= "<button type='button' class='btn btn-success' onclick='Save()'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;保存</span></button>&nbsp;&nbsp;";
						var buttonC= "<button type='button' class='btn btn-warning' onclick='cancel()'><span style='width:100%'> <i class='fa fa-close fa-fw'></i>&nbsp;&nbsp;取消</span></button>";
						jQuery("#buttonAdd").append(buttonA);  
 						jQuery("#buttonAdd").append(buttonC); 
 						jQuery("#tbody1").append(newtr);  
					}else{
						if(confirm("是否添加被删除内容?")){
							jQuery("#tbody1").html("");
							jQuery("#buttonAdd").html("");
							
							for(var i in json){
								var newtr="<tr><td style='width:3%''></td><td> <input type='text' name='SId' id='tID"+i+"' class='form-control' value='"+json[i].teacherID+"'></td><td><input type='text' id='tName"+i+"'  class='form-control' value="+json[i].teacherName+"></td><td><input type='text' id='tSex"+i+"'  class='form-control' value="+json[i].teacherSex+"></td><td><input type='text' id='tBirthday"+i+"'  class='form-control' value="+json[i].teacherBirthday+"></td><td>"+type+"</td><td><input type='text' id='tDepartment"+i+"' class='form-control' value="+json[i].programme+"></td></tr>"
								jQuery("#tbody1").append(newtr);  
							}
							var buttonA= "<button type='button' class='btn btn-success' onclick='Save()'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;保存</span></button>&nbsp;&nbsp;";
							var buttonC= "<button type='button' class='btn btn-warning' onclick='cancel()'><span style='width:100%'> <i class='fa fa-close fa-fw'></i>&nbsp;&nbsp;取消</span></button>";
							jQuery("#buttonAdd").append(buttonA);  
 							jQuery("#buttonAdd").append(buttonC); 
							resetSession()
						}else{
						jQuery("#tbody1").html("");
						jQuery("#buttonAdd").html("");
						var newtr="<tr><td style='width:3%''></td><td> <input type='text' name='SId0' id='tID' class='form-control'></td><td><input type='text' id='tName0'  class='form-control'></td><td><input type='text' id='tSex0'  class='form-control'></td><td><input type='text' id='tBirthday0'  class='form-control'></td><td>"+type+"</td><td><input type='text' id='tDepartment0' class='form-control'></td></tr>"
						var buttonA= "<button type='button' class='btn btn-success' onclick='Save()'><span style='width:100%'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;保存</span></button>&nbsp;&nbsp;";
						var buttonC= "<button type='button' class='btn btn-warning' onclick='cancel()'><span style='width:100%'> <i class='fa fa-close fa-fw'></i>&nbsp;&nbsp;取消</span></button>";
						jQuery("#buttonAdd").append(buttonA);  
 						jQuery("#buttonAdd").append(buttonC); 
 						jQuery("#tbody1").append(newtr);  
 						resetSession()
						}
						
					}
					
					}
		})
		

 
	

}

function resetSession(){
	jQuery.ajax({
 	
					url:"reSetInfoAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
					
					}
				})

}

function remake(){
	
	jQuery.ajax({
 	
					url:"TypeFInfoAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					
					iCheckRemake();
					}
					
	
	

		})
		
}

function Search(){
	var SearchContent=jQuery("#SearchContent").val();
	jQuery.ajax({
 	
	url:"SearchContentInfoAction",
	type:"post",
	data:{SearchContent:SearchContent},
	dataType: "json",
	success:function(data){
				jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+" /></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					
					iCheckRemake();
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
 	
	url:"ChangeTInfoAction",
	type:"post",
	data:{changeID:thisid,changeContent:thisvalue,changeClass:thisclass,Type:type},
	dataType: "text",
	
	

})
jQuery(this).parent().removeClass('textarea');
alert("保存成功");
remake();
	

 
});

}
} 

function cancel(){

	jQuery.ajax({
 	
					url:"TypeFInfoAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						jQuery("#buttonAdd").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					var button1= "<button type='button' class='btn btn-primary' id='add' onclick='addContent()'>";
             
              var button2=button1+"<span style='width:100%'> <i class='fa fa-plus-square-o fa-fw'></i>&nbsp;&nbsp;添加</span></button>&nbsp;"
          
          		var button3=button2+"<button type='button' class='btn btn-danger' id='del' onclick='delRow()''>"
             
              	var button4=button3+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span></button>"
          
					jQuery("#buttonAdd").append(button4);
					iCheckRemake();
					}
					
	
	

		})
	
}

function Save(){

	
	
	var SaveID=[];
	var num=0;
	jQuery("input[name='SId']").each(function(){
			var tID=jQuery("#tID"+num).val();
			var tName=jQuery("#tName"+num).val();
			var tSex=jQuery("#tSex"+num).val();
			var tBirthday=jQuery("#tBirthday"+num).val();
			var tDepartment=jQuery("#tDepartment"+num).val();
			 SaveID.push("["+tID);
			 SaveID.push(tName);
			 SaveID.push(tSex);
			 SaveID.push(tBirthday);
			 SaveID.push(tDepartment+"!");
           	num++;
            
        })
		//alert(SaveID);
	jQuery.ajax({
 	
					url:"AddTeacherInfoAction",
					type:"post",
					data:{saveID:JSON.stringify(SaveID),Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						jQuery("#buttonAdd").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					var button1= "<button type='button' class='btn btn-primary' id='add' onclick='addContent()'>";
             
              var button2=button1+"<span style='width:100%'> <i class='fa fa-plus-square-o fa-fw'></i>&nbsp;&nbsp;添加</span></button>&nbsp;"
          
          		var button3=button2+"<button type='button' class='btn btn-danger' id='del' onclick='delRow()''>"
             
              	var button4=button3+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span></button>"
          
					jQuery("#buttonAdd").append(button4);
					iCheckRemake();
					}
					
	
	

		})
}

function Instructor(){
	type="辅导员"
	
	jQuery("#InstructorColor").css("color","#0997F7");
	jQuery("#TeacherColor").css("color","black");
	jQuery("#AssistantColor").css("color","black");
	jQuery("#ManagerColor").css("color","black");
	jQuery.ajax({
 	
					url:"TypeFInfoAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					
					iCheckRemake();
					}
					
	
	

		})
		
}

function Assistant(){
	type="教辅"
	
	jQuery("#InstructorColor").css("color","black");
	jQuery("#TeacherColor").css("color","black");
	jQuery("#AssistantColor").css("color","#0997F7");
	jQuery("#ManagerColor").css("color","black");
	jQuery.ajax({
 	
					url:"TypeFInfoAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					
					iCheckRemake();
					}
					
	
	

		})
		
}

function Teacher(){
	type="教师"
	
	jQuery("#InstructorColor").css("color","black");
	jQuery("#TeacherColor").css("color","#0997F7");
	jQuery("#AssistantColor").css("color","black");
	jQuery("#ManagerColor").css("color","black");
	jQuery.ajax({
 	
					url:"TypeFInfoAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							
						}
					
					iCheckRemake();
					}
					
	
	

		})
		
}

function Manager(){
	type="管理组"
	
	jQuery("#InstructorColor").css("color","black");
	jQuery("#TeacherColor").css("color","black");
	jQuery("#AssistantColor").css("color","black");
	jQuery("#ManagerColor").css("color","#0997F7");
	jQuery.ajax({
 	
					url:"TypeFInfoAction",
					type:"post",
					data:{Type:type},
					dataType:  "json",
					success:function(data){
					//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						
						for(var i in json){
						
							var td1="<tr id='TbodyTr'>";
							var td2=td1+"<td style='width:3%''><input type='checkbox' name='checkRow' id="+json[i].ID+"></td>";
							var td3=td2+"<td id="+json[i].teacherID+" name='TeacherID' onclick='change(this)'>"+json[i].teacherID+"</td>";
							var td4=td3+"<td id="+json[i].teacherID+" name='TeacherName' onclick='change(this)'>"+json[i].teacherName+"</td>";
							var td5=td4+"<td id="+json[i].teacherID+" name='TeacherSex' onclick='change(this)'>"+json[i].teacherSex+"</td>";
							var td6=td5+"<td id="+json[i].teacherID+" name='TeacherBirthday' onclick='change(this)'>"+json[i].teacherBirthday+"</td>";
							var td7=td6+"<td id="+json[i].teacherID+">"+json[i].department+"</td>";
							var td8=td7+"<td id="+json[i].teacherID+" name='Programme' onclick='change(this)'>"+json[i].programme+"</td></tr>";
							jQuery("#tbody1").append(td8);
							jQuery('#'+json[i].ID).iCheck({
    						checkboxClass: 'icheckbox_minimal',
    						radioClass: 'iradio_minimal',
    						increaseArea: '20%' // optional
  							})
						}
					
					
					}
					
	
	

		})
		
}

function delRow(){
	var editTable=document.getElementById("tbody1");
	if(confirm("确认删除所选?")){
	var delID=[];
	jQuery("input[name='checkRow']").each(function(){
			if(jQuery(this).is(':checked')){
			 delID.push("["+jQuery(this).attr('id'));
           }
            
        })
	
	
	
	jQuery.ajax({
 	
					url:"delTeacherInfoAction",
					type:"post",
					data:{delID:JSON.stringify(delID)},
					dataType:  "json",
					success:function(data){
						
					jQuery("input[name='checkRow']").each(function(){
						if(jQuery(this).is(':checked')){
						
			 			jQuery(this).parent().parent().parent().remove();
           				}
            
        			})
					
					}
					
	
	

		})
		
		
		
	}
}

function closeDialog(){
	
	 		document.getElementById('lns').style.display='none';
            document.getElementById('fade').style.display='none'
}

function iCheckRemake(){
//alert(jQuery('input[name=checkRow]').val());
jQuery('input[name=checkRow]').iCheck({
    checkboxClass: 'icheckbox_minimal',
    radioClass: 'iradio_minimal',
    increaseArea: '20%' // optional
  })
}

function LiClick(ThisLi){
	 jQuery("#SearchContent").val(jQuery(ThisLi).html());
     jQuery("#SearchButton").focus();
     jQuery("#lns").hide();
}

jQuery("#SearchContent").keyup(function(){
       // alert($("input[name=uname]").val());
            var uname = jQuery(this).val();
            
            if(uname != ""){
                jQuery.ajax({
                    url:"LenovoServlet.servlet",
                    type:"post",
                    data:{"uname":uname},
                    dataType:"html",
                    async:true,
                    success:function(result){
                    //alert("联想");
                        jQuery("#lns").show();
                        jQuery("#fade").show();
                        jQuery("#lns").html(result);
						jQuery.getScript("js/icheck.js");
						
						
                        
                      
                    }
                });
            }else{
                jQuery("#lns").html("");
                jQuery("#lns").hide();
               
            }
        });

  jQuery("#lns").css({
            "border":"1px #ccc solid",
            "width":"70%",
            "position":"absolute",
           "float":"right",
            "margin-top":"14%",
            "margin-left":"18%",
            "display":"none"
        });

 jQuery(document).ready(function(){
 
 	jQuery('input').iCheck({
    checkboxClass: 'icheckbox_minimal',
    radioClass: 'iradio_minimal',
    increaseArea: '20%' // optional
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
   
	<script type="text/javascript" src="assets/js/custom.js"></script>
	 <script type="text/javascript" src="assets/js/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
    <script src="assets/js/init/fullcalendar-init.js"></script>
  </body>
</html>
