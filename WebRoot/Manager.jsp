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

    

    
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="assets/css/bootstrap-table.css" >
	<link rel="stylesheet" href="assets/bootstrap-select.min.css"  />
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/themify-icons.css">
	<link rel="stylesheet" href="assets/css/pe-icon-7-filled.css">
 
    <link href="assets/css/slick.css" rel="stylesheet">
    <!-- Gallery Lightbox -->
    <link href="assets/css/magnific-popup.css" rel="stylesheet">
    <!-- Skills Circle CSS  -->
    
    <link rel="stylesheet" href="assets/css/style_a.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
    
	<link href="assets/calendar/fullcalendar.css" rel="stylesheet" />
	<link href="assets/minimal/minimal.css" rel="stylesheet">
	 <!-- Google Fonts Raleway -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,500,500i,600,700" rel="stylesheet">
	<!-- Google Fonts Open sans -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,700,800" rel="stylesheet">
	
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
          
         
          </div>
         
        <br/><br/>
			
			<table class="table table-bordered">
	  		<thead>
                <tr>
                	
                    <th style="text-align:center">工作岗位</th>
                    <th style="text-align:center">部门人员</th>
                    <th style="text-align:center">主管</th>
                    <th style="text-align:center">备注</th>
                   <th style="text-align:center">操作</th>
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

    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/bootstrap-select.js"></script> 



<script type="text/javascript">

function addContent(){

jQuery("#tbody1").html("");
jQuery("#buttonAdd").html("");
var option="<option >教师岗位</option><option >辅导员岗位</option><option >教辅人员</option><option >管理组</option>";
var option1="";
var newtr="<tr><td><select name='save1' class='form-control selectpicker' id='addSelect' ></select></td><td><input type='text' id='Members' class='form-control'></td><td><input type='text' id='Manager' class='form-control'></td><td><input type='text' id='Remarks' class='form-control'></td></tr>";
var buttonA= "<button type='button' class='btn btn-success'><span style='width:100%' onclick='save()'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;保存</span></button>&nbsp;&nbsp;";
var buttonC= "<button type='button' class='btn btn-warning'><span style='width:100%' onclick='cancel()'> <i class='fa fa-close fa-fw'></i>&nbsp;&nbsp;取消</span></button>";
 jQuery("#buttonAdd").append(buttonA);  
 jQuery("#buttonAdd").append(buttonC); 
 jQuery("#tbody1").append(newtr);  

 jQuery("#addSelect").append(option);
 
 jQuery("#addSelect").selectpicker('refresh');
 jQuery("#addSelect").selectpicker('render');
	

}

function save(){
	var type=jQuery("#addSelect").val();
	var Members=jQuery("#Members").val();
	var Manager=jQuery('#Manager').val();
	var Remarks=jQuery('#Remarks').val();
	jQuery.ajax({
 	
					url:"SaveDataManagerAction",
					type:"post",
					data:{Type:type,Members:Members,Manager:Manager,Remarks:Remarks},
					dataType:  "json",
					success:function(data){
						//alert(data);
						jQuery("#tbody1").html("");
						var json=eval('('+data+')');
						for(var i in json){
			 	
			 		var tr="<tr>"+json[i]+"</tr>";
  				jQuery("#tbody1").append(tr);  
                var button1="<button type='button' class='btn btn-primary' id='add' onclick='addContent()'>"
             
              	var button2=button1+"<span style='width:100%'> <i class='fa fa-plus-square-o fa-fw'></i>&nbsp;&nbsp;添加</span>  </button>"
        
          		jQuery("#buttonAdd").html("");
         		jQuery("#buttonAdd").append(button2);
                 
                  
  			}
					
					}
					
	
	

		})
}

function cancel(){
	
	jQuery.ajax({
 	
					url:"InitializationManagerAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						//alert(data);
						jQuery("#tbody1").html("");  
						var json=eval('('+data+')');
						for(var i in json){
			 	
			 		var tr="<tr>"+json[i]+"</tr>";
  				jQuery("#tbody1").append(tr);  
                var button1="<button type='button' class='btn btn-primary' id='add' onclick='addContent()'>"
             
              	var button2=button1+"<span style='width:100%'> <i class='fa fa-plus-square-o fa-fw'></i>&nbsp;&nbsp;添加</span>  </button>"
        
          		jQuery("#buttonAdd").html("");
         		jQuery("#buttonAdd").append(button2);
                 
                  
  			}
					
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
 	
	url:"ChangeInfoManagerAction",
	type:"post",
	data:{changeID:thisid,changeContent:thisvalue},
	

})
jQuery(this).parent().removeClass('textarea');
alert("保存成功");
cancel();
	

 
});

}
} 

function delRow(delID){
	var editTable=document.getElementById("tbody1");
	if(confirm("确认删除所选?")){
	//alert(delID);
	var delID=jQuery(delID).parent().attr("id"); 
	
	
	
	jQuery.ajax({
 	
					url:"delInfoManagerAction",
					type:"post",
					data:{delID:delID},
					dataType:  "json",
					
		})
		alert("删除成功");
		cancel();
		
		
	}
}

function iCheckRemake(){
jQuery('input').iCheck({
    checkboxClass: 'icheckbox_minimal',
    radioClass: 'iradio_minimal',
    increaseArea: '20%' // optional
  })
}

 jQuery(document).ready(function(){
  jQuery('input').iCheck({
    checkboxClass: 'icheckbox_minimal',
    radioClass: 'iradio_minimal',
    increaseArea: '20%' // optional
  });
  
  jQuery.ajax({
 	
					url:"InitializationManagerAction",
					type:"post",
					data:{},
					dataType:  "json",
					success:function(data){
						//alert(data);
						var json=eval('('+data+')');
						for(var i in json){
			 	
			 		var tr="<tr>"+json[i]+"</tr>";
  				jQuery("#tbody1").append(tr);  
                
                 
                  
  			}
					
					}
					
	
	

		})
  
});
</script>

<script src="assets/js/popper.min.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/main.js"></script>
<script src="js/icheck.js"></script>
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
