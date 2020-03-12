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
	 <link rel="stylesheet" href="css/fileinput.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/themify-icons.css">
	<link rel="stylesheet" href="assets/css/pe-icon-7-filled.css">
   <link rel="stylesheet" href="assets/bootstrap-select.min.css"  />
    <link rel="stylesheet" href="assets/css/style_a.css">
    
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
   
	<link href="assets/calendar/fullcalendar.css" rel="stylesheet" />
	
	
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
            opacity:.80; 
            filter: alpha(opacity=88); 
        } 
        .white_content { 
            display: none; 
            position: absolute; 
            top: 25%; 
            left: 25%; 
            width: 55%; 
            height: 55%; 
            padding: 20px; 
            border: 5px solid #DDDDDD; 
            background-color: white; 
            z-index:1002; 
            overflow: auto; 
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
           
       <div class="table-responsive" style="width:50%;float:left">
		<table class="table table-hover">
		<center>
				<thead>
				<tr>
					<th>评分项名称</th>
					
				</tr>
				</thead>
				
				
			
			<tbody>
				<s:iterator value="educationList" status="li">
				<tr>
				<th><s:property value="content"/></th>
				
				</tr>
				</s:iterator>
			</tbody>
			</center>
			</table>
			</div>
			<span id="jsonArraySpan" style="display:none">${sessionScope.list1} </span>
			
			<div style="float:right;width:40%;padding-right:20%;"">
				<div style="float:left;padding-left:18%;">
				<table class="table table-hover" >
				
				<thead>
				
				<tr>
				<center>
					<th style="text-align:center;">默认评分项</th>
				</center>
				</tr>
				
				</thead>
				
				<tbody id="Ptbody1" >
				
				</tbody>
				
				</table>
				
				
				<center>
				
				<div >
				<button type="button" id="save1" class="btn btn-info" style="float:center;" >保存</button>
				</div>
				<br/><br/><br/>
				<div>
				<span><strong>下载评分表</strong></span>
				<br/>
				<a href = "JavaScript:void(0)" onclick = "openDialog()">
				<button type="button"  class="btn btn-info" style="width:50%">点击下载评分表</button>
				</a>
				</div>
				<br/>
				
				<br/>
				<br/>
				<span><strong>上传评分表</strong></span>
				<br/>
				<!--<input type="file" name="upload" id="upload"   />-->
				
				  <input type="file" name="upload" id="upload"  >
				 
				<br/>
				<button type="button" id="uploadFile" class="btn btn-info" style="width:50%">上传</button>
				
				</center>
				</div>
				
				
				
			</div>
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
	
	<div id="light" class="white_content">
           <center>
           <span><h3>请选择文件版本</h3></span>
           <br/><br/><br/><br/>
           <a href = "downLoadEduExcelAction?flag=xls" >
           <button type="button"  class="btn btn-info btn-lg" style="float:center;" onclick = "closeDialog()" >.xls文件(Excel 2003及之前版本)</button>
           </a>
           <br/><br/>
           <a href = "downLoadEduExcelAction?flag=xlsx" >
            <button type="button"  class="btn btn-info btn-lg" style="float:center;" onclick = "closeDialog()">.xlsx文件(Excel 2007及之后版本)</button>
			</a>
			<br/><br/>
			<a >
            <button type="button"  class="btn btn-info btn-lg" style="float:center;" onclick = "closeDialog()">取消</button>
			</a>
            </center>
        </div> 
        <div id="fade" class="black_overlay" onclick = "closeDialog()"></div>
	
	
	
	
	
	
    <script src="js/jquery-2.1.4.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/bootstrap-select.js"></script> 
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/fileinput.min.js"></script>
	<script type="text/javascript" src="js/zh.js"></script>
	<script type="text/javascript">
	
	
	
	function initialDeltr1(nowTr){
					
    				var name='Education';
    				jQuery.ajax({
 	
					url:"delEduSeAjaxAction",
					type:"post",
					data:{name:name},
					dataType:  "text",
					success:function(data){
					jQuery("#eduSelect").val(""); 
					jQuery("#eduSelect").selectpicker('refresh');
					jQuery("#eduSelect").selectpicker('render');
					
					}
					
	
	

		})
    				
	}
	<!-- 悬浮窗js-->
	function openDialog(){
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block'
        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none'
        }
	
	function initFileInput(ctrlName) {
	
        var control = jQuery('#' + ctrlName);
        control.fileinput({
        	language: 'zh',
        	showUpload: false, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : false, //是否显示预览
            showCaption: true,//是否显示标题
            browseClass: "btn btn-primary",
        })
        }
	
	
	$(document).ready(function(){
	 
	 initFileInput("upload");
	 
	 jQuery.ajax({
 	
		url:"showEduTypeAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data)
			
			
			var array = document.getElementById("jsonArraySpan").innerHTML;
			var json=eval('('+data+')');
			//alert(json);
			
			 	
			 	//alert(json[0].selections);
  				var delButton="<button type='button' style='float:left' class='btn btn-danger btn-sm' id='eduButton' onclick='initialDeltr1(this)'  >清空</button>"
	
				var td1="<tr><td style='text-align:center'><div style='float:left;width:50%;padding-left:25%;'><select name='save1' class='form-control selectpicker' multiple  id='eduSelect'   ></select></div><div style='float:left;width:30%'>"+delButton+"</div></td></tr>";
                jQuery("#Ptbody1").append(td1);  
                
                 for(var j=1;j<array.length-1;j=j+4){
 								
 
　　　							jQuery("#eduSelect").append("<option >"+array[j]+array[j+1]+"</option>");
 
　					}
					var param2=json[0].selections;
					jQuery("#eduSelect").val(param2.split(',')); 
					jQuery("#eduSelect").selectpicker('refresh');
					jQuery("#eduSelect").selectpicker('render');
                  
  			
  			
		}
	
	

})

	jQuery('#save1').click(function(){
			var selected=jQuery("#eduSelect").val();
			
        console.log(selected);
		jQuery.ajax({
 	
		url:"saveEduSeAjaxAction",
		type:"post",
		data:{selections:JSON.stringify(selected)},
		dataType:  "json", 
		success:function(data){
			alert("已保存成功");
			//alert(data);
			
			
		}
	
	

})
		
		})	
		
		
		
		jQuery("#uploadFile").click(function() {
				jQuery.ajaxFileUpload({
					url : 'upLoadEduExcelAction',//后台请求地址
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
		
		
		

})
	
	</script>
 <script src="assets/js/popper.min.js"></script>
	<script src="assets/js/plugins.js"></script>
	<script src="assets/js/plugins.js"></script>
	<script src="assets/js/main.js"></script>




	<script src="assets/js/lib/flot-chart/jquery.flot.spline.js"></script>


	<script src="assets/calendar/fullcalendar.min.js"></script>
	<script src="assets/calendar/fullcalendar-init.js"></script>cript>


    <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
    <script src="assets/js/init/fullcalendar-init.js"></script>
    <script src="assets/js/bootstrap-table.js"></script>
	<script src="assets/js/bootstrap-table-zh-CN.js"></script>
  </body>
</html>
