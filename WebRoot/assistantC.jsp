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
	
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/themify-icons.css">
	<link rel="stylesheet" href="assets/css/pe-icon-7-filled.css">
   <link rel="stylesheet" href="assets/bootstrap-select.min.css"  />
    <link rel="stylesheet" href="assets/css/style_a.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
   
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
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="DocumentShow">佐证资料列表</a></li>
                           
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
				<s:iterator value="assistantList" status="li">
				<tr>
				<th><s:property value="content"/></th>
				<!--  <th><select class="selectpicker">
    				<option value="1">要求通过</option>
    				
    				<option value="2">无需合并</option>
					</select>
				</th>
				<th><select class="selectpicker">
    				<option value="1">合并算分</option>
    				<option value="2">无需合并</option>
					</select>
				</th> -->
				</tr>
				</s:iterator>
			</tbody>
			</center>
			</table>
			</div>
			<span id="jsonArraySpan" style="display:none">${sessionScope.asslist} </span>
			
			<div style="float:right;width:50%">
				<div style="float:left;padding-left:10%;">
				<table class="table table-hover" >
				<thead>
				<tr>
					<th>要求合并设定</th>
					
				</tr>
				</thead>
				<tbody id="Ptbody1" >
				
				</tbody>
				
				</table>
				<div id="preSpan1" ></div>
				<table class="table table-hover" >
				
				
				<tbody id="tbody1">
				
				</tbody>
				
				</table>
				<center>
				<div >
				<button type="button" id="addbutton1" class="btn btn-info" style="float:center;" >增加合并</button>
				
				</div>
				<br/>
				<div >
				<button type="button" id="save1" class="btn btn-info" style="float:center;" >保存</button>
				</div>
				</center>
				</div>
				<div style="float:right;padding-right:15%;">
				<table class="table table-hover" >
				<thead>
				<tr>
					<th>合并分数设定</th>
					
				</tr>
				</thead>
				<tbody id="Ptbody2" >
				
				</tbody>
				
				</table>
				<div id="preSpan2" ></div>
				<table class="table table-hover" >
				
				<tbody id="tbody2">
				</tbody>
				</table>
				<center>
				<div style="float:left;padding-left:15%">
				<button type="button" id="addbutton2" class="btn btn-info" style="float:center;" >增加合并</button>
				</div>
				<br/>
				<br/>
				<div >
				<button type="button" id="save2" class="btn btn-info" style="float:center;" >保存</button>
				</div>
				</center>
				</div>
			</div>
	<!-- .animated -->
        </div>
        <!-- /.content -->
        <div class="clearfix"></div>
        <!-- Footer -->
        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row" >
                
                    <div class="col-sm-6"  align="right">
                      
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
	 
	
	

	 var a=0;var b=0;var c=0;
	function deltr1(nowTr){
					var editTable=document.getElementById("tbody1");
    				var n=nowTr.parentNode.parentNode.parentNode;
    				editTable.removeChild(n);
			}
	function deltr2(nowTr){
					var editTable=document.getElementById("tbody2");
    				var n=nowTr.parentNode.parentNode.parentNode;
    				editTable.removeChild(n);
			}
	function initialDeltr1(nowTr){
					var editTable=document.getElementById("Ptbody1");
    				var n=nowTr.parentNode.parentNode.parentNode;
    				var name=jQuery(nowTr).attr('id');
    				jQuery.ajax({
 	
					url:"delCombinationAAAjaxAction",
					type:"post",
					data:{name:name},
					dataType:  "text",
					success:function(data){
					editTable.removeChild(n);
					
					}
					
	
	

		})
    				
	}
	function initialDeltr2(nowTr){
					var editTable=document.getElementById("Ptbody2");
    				var n=nowTr.parentNode.parentNode.parentNode;
    				var name=jQuery(nowTr).attr('id');
    				jQuery.ajax({
 	
					url:"delCombinationBAAjaxAction",
					type:"post",
					data:{name:name},
					dataType:  "text",
					success:function(data){
					editTable.removeChild(n);
					
					}
					
	
	

		})
    				
	}
	

	
	 $(document).ready(function(){
	 
	 
	 jQuery.ajax({
 	
		url:"showCombinationAAAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert("A"+data)
			if(data== null || data == "" || data == undefined||data=="[]"){
			}else{
			var spanText="<span id='preSpan1'>以上为已保存合并</span>"
       		jQuery("#preSpan1").append(spanText);
			var array = document.getElementById("jsonArraySpan").innerHTML;
			var json=eval('('+data+')');
			
			for(var i in json){
			 	
			 	
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='initialDeltr1(this)'  >删除</button>"
	
				var td1="<tr><td><div style='float:left;width:50%'><select name='save1' class='form-control selectpicker' multiple  id='"+json[i].ID+"'   ></select></div><div style=''>"+delButton+"</div></td></tr>";
                jQuery("#Ptbody1").append(td1);  
                
                 for(var j=1;j<array.length-1;j=j+4){
 

 
　　　							jQuery("#"+json[i].ID).append("<option >"+array[j]+array[j+1]+"</option>");
 
　					}
					var param2=json[i].including;
					jQuery("#"+json[i].ID).val(param2.split(',')); 
					jQuery("#"+json[i].ID).selectpicker('refresh');
					jQuery("#"+json[i].ID).selectpicker('render');
                  
  			}
  			}
		}
	
	

})
		
	 jQuery.ajax({
 	
		url:"showCombinationBAAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			//alert(data);
			
			if(data== null || data == "" || data == undefined||data=="[]"){
			}else{
			var spanText="<span id='preSpan2'>以上为已保存合并</span>"
       		jQuery("#preSpan2").append(spanText);
			var array = document.getElementById("jsonArraySpan").innerHTML;
			var json=eval('('+data+')');
			for(var i in json){
			 	
			 	
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='initialDeltr2(this)'  >删除</button>"
	
				var td1="<tr><td><div style='float:left;width:50%'><select name='save2' class='form-control selectpicker' multiple  id='"+json[i].ID+"'   ></select></div><div style=''>"+delButton+"</div></td></tr>";
                jQuery("#Ptbody2").append(td1);  
                
                 for(var j=1;j<array.length-1;j=j+4){
 

 
　　　							jQuery("#"+json[i].ID).append("<option >"+array[j]+array[j+1]+"</option>");
 
　					}
					var param2=json[i].including;
					jQuery("#"+json[i].ID).val(param2.split(',')); 
					jQuery("#"+json[i].ID).selectpicker('refresh');
					jQuery("#"+json[i].ID).selectpicker('render');
                  
  			}
  			}
		}
	
	

})
	 
	 
	 
       
      
       
	
	 
	  jQuery("#addbutton1").click(function(){
	  				jQuery("#x").selectpicker('refresh');
					
			<!--	console.log("before"+a);-->
					
					a++;
				<!--console.log(a); -->
					 var array = document.getElementById("jsonArraySpan").innerHTML;
   						
 
							
 
　　　							　
 
　					
	
						
     				
 					var delButton="<button type='button' class='btn btn-danger btn-sm' id='delbutton1' onclick='deltr1(this)'  >删除</button>"
	
					var td1="<tr><td><div style='float:left;width:50%'><select name='save1' class='form-control selectpicker' multiple  id='x"+a+"'   ></select></div><div style=''>"+delButton+"</div></td></tr>";
					
					
					jQuery("#tbody1").append(td1);
					
					for(var i=1;i<array.length-1;i=i+4){
 

 								
　　　							　jQuery("#x"+a).append("<option >"+array[i]+array[i+1]+"</option>");
 
　					}
 
     				
					var sid='x'+a;
					jQuery("#"+sid).selectpicker('refresh');
					jQuery("#"+sid).selectpicker('render');
	 
						});
				
				
				//方式②：  支持事件冒泡(兼容性非常好)
				
			jQuery("#addbutton2").click(function(){
				
					b++;
					
					
					 var array = document.getElementById("jsonArraySpan").innerHTML;
   
	
						
     				
 					var delButton="<button type='button' class='btn btn-danger btn-sm' id='delbutton2' onclick='deltr2(this)'   >删除</button>"
	
					var td1="<tr><td><div style='float:left;width:50%'><select name='save2' class='form-control selectpicker' multiple  id='z"+b+"'   ></select></div><div style=''>"+delButton+"</div></td></tr>";
					
					
					jQuery("#tbody2").append(td1);
					
						
					for(var i=1;i<array.length-1;i=i+4){
 

 
　　　							　jQuery("#z"+b).append("<option >"+array[i]+array[i+1]+"</option>");
 
　					}
 
     				
					
					jQuery("#z"+b).selectpicker('refresh');
					jQuery("#z"+b).selectpicker('render');
	 
						});
				
				//方式②：  支持事件冒泡(兼容性非常好)
				
					
     
        })
	
		$('#save1').click(function(){
			var selectedList=[];
			jQuery("select[name='save1']").each(function(){
			c++;
			 selectedList.push("["+jQuery(this).attr('id'));
            selectedList.push(jQuery(this).val());
            
        })
        console.log(selectedList);
		jQuery.ajax({
 	
		url:"saveCombinationAAAjaxAction",
		type:"post",
		data:{including:JSON.stringify(selectedList)},
		dataType:  "json", 
		success:function(data){
			alert("已保存成功");
			//alert(data);
			
			jQuery("#Ptbody1").html("");
			jQuery("#tbody1").html("");
			var content = jQuery("#preSpan1").html();
			if(content == null || content.length == 0)
			  {
			  		//alert("content为空")
				    var spanText="<span id='preSpan1'>以上为已保存合并</span>"
       				jQuery("#preSpan1").append(spanText);
			  }
			var array = document.getElementById("jsonArraySpan").innerHTML;
			var json=eval('('+data+')');
			for(var i in json){
			 	//alert(json[i].ID);
			 	
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='initialDeltr1(this)'  >删除</button>"
	
				var td1="<tr><td><div style='float:left;width:50%'><select name='save1' class='form-control selectpicker' multiple  id='"+json[i].ID+"'   ></select></div><div style=''>"+delButton+"</div></td></tr>";
                jQuery("#Ptbody1").append(td1);  
                
                 for(var j=1;j<array.length-1;j=j+4){
 

 
　　　							jQuery("#"+json[i].ID).append("<option >"+array[j]+array[j+1]+"</option>");
 
　					}
					var param2=json[i].including;
					jQuery("#"+json[i].ID).val(param2.split(',')); 
					jQuery("#"+json[i].ID).selectpicker('refresh');
					jQuery("#"+json[i].ID).selectpicker('render');
                  
  			}
		}
	
	

})
		
		})	
			$('#save2').click(function(){
			var selectedList=[];
			jQuery("select[name='save2']").each(function(){
			c++;
			 selectedList.push("["+jQuery(this).attr('id'));
            selectedList.push(jQuery(this).val());
            
        })
        console.log(selectedList);
		jQuery.ajax({
 	
		url:"saveCombinationBAAjaxAction",
		type:"post",
		data:{including:JSON.stringify(selectedList)},
		dataType:  "json", 
		success:function(data){
			alert("已保存成功");
			//alert(data);
			jQuery("#Ptbody2").html("");
			jQuery("#tbody2").html("");
			var content = jQuery("#preSpan2").html();
			if(content == null || content.length == 0)
			  {
				    var spanText="<span id='preSpan2'>以上为已保存合并</span>"
       				jQuery("#preSpan2").append(spanText);
			  }
			var array = document.getElementById("jsonArraySpan").innerHTML;
			var json=eval('('+data+')');
			for(var i in json){
			 	//alert(json[i].ID);
			 	
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='initialDeltr2(this)'  >删除</button>"
	
				var td1="<tr><td><div style='float:left;width:50%'><select name='save2' class='form-control selectpicker' multiple  id='"+json[i].ID+"'   ></select></div><div style=''>"+delButton+"</div></td></tr>";
                jQuery("#Ptbody2").append(td1);  
                
                 for(var j=1;j<array.length-1;j=j+4){
 

 
　　　							jQuery("#"+json[i].ID).append("<option >"+array[j]+array[j+1]+"</option>");
 
　					}
					var param2=json[i].including;
					jQuery("#"+json[i].ID).val(param2.split(',')); 
					jQuery("#"+json[i].ID).selectpicker('refresh');
					jQuery("#"+json[i].ID).selectpicker('render');
                  
  			}
		}
	
	

})
		
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
