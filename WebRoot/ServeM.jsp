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

    

    <link href="assets/css/bootstrap-table.css" rel="stylesheet">
	<link rel="stylesheet" href="assets/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/themify-icons.css">
	<link rel="stylesheet" href="assets/css/pe-icon-7-filled.css">
   
    <link rel="stylesheet" href="assets/css/style_a.css">
    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
   
	<link href="assets/calendar/fullcalendar.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	 <!--<script src="assets/js/jquery-3.3.1.min.js"></script>-->
	  <script>




function change(nowTd){   

if(!$(nowTd).is('.input')){    

$(nowTd).addClass('textarea').html("<textarea  class='form-control' name='ed1' id='a1'>"+$(nowTd).text()+"</textarea>" ).find('textarea').focus().blur(function(){    

var thisid = $(this).parent().attr("id");   
var thisvalue=$(this).val();    
var thisclass = $(this).parent().attr("class");   

$.ajax({
 	
	url:"CSAction",
	type:"post",
	data:{name:thisid,content:thisvalue},
	dataType: "text",
	
	

})

$(this).parent().removeClass('textarea');
alert("保存成功")
	remake();

 
});

}
} 

function addContent(){
jQuery("#HJ").parent().remove();
var newtr="<tr><td id='newtr' colspan='3' onclick='newclick(this)'></td><td></td><td></td><td></td>"
var HJ="<td id='HJ' colspan='5' style='text-align: center'>合计</td><td></td>"
 jQuery("#tbody1").append(newtr);  
 jQuery("#tbody1").append(HJ);  
	

}
function newclick(nowTd){

if(!$(nowTd).is('.input')){    

$(nowTd).addClass('textarea').html("<textarea  class='form-control' name='ed1' id='a1'>"+$(nowTd).text()+"</textarea>" ).find('textarea').focus().blur(function(){    


var thisvalue=$(this).val();    
var thisclass = $(this).parent().attr("class");   

$.ajax({
 	
	url:"newSerAction",
	type:"post",
	data:{content:thisvalue},
	dataType: "text",
	
	

})
$(nowTd).parent().remove();
alert("保存成功")
	remake();


 
});

}
}
function remake(){

	 jQuery.ajax({
 	
		url:"getSerTableMAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			
			jQuery("#tbody1").html("");
			var json=eval('('+data+')');
			var thread="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td><td><center>通过项目</center></td><td>单项得分</td><td>得分</td></tr>"
			 jQuery("#tbody1").append(thread);  
			for(var i in json){
			 	
			 	
  			
	
				var tr1="<tr>"+json[i]+"</tr>";
                jQuery("#tbody1").append(tr1);  
                
               
                  
  			
  			}
  			
		}
	
	

})
}

 $(document).ready(function(){
     
     	 jQuery.ajax({
 	
		url:"getSerTableMAjaxAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			
			
			var json=eval('('+data+')');
			var thread="<tr><td colspan='3'><center><h3>评分内容及标准</h3></center></td><td><center>通过项目</center></td><td>单项得分</td><td>得分</td></tr>"
			 jQuery("#tbody1").append(thread);  
			for(var i in json){
			 	
			 	
  			
	
				var tr1="<tr>"+json[i]+"</tr>";
                jQuery("#tbody1").append(tr1);  
                
               
                  
  			
  			}
  			
		}
	
	

})

});

  	


  </script>
   <script src="assets/js/jquery-3.3.1.min.js"></script>
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
        </header>
        <!-- /#header -->
        <!-- Content -->
        <div class="content">
            
            
            <center>
		<h2>服务自评</h2>
		
	<div class="table-responsive" style="width:100%">
		<table class="table table-bordered" id="table2">
		<center>
				
				
			
			<tbody id="tbody1">
				
				

			</tbody>
		</table>
		<button type="button" id="addbutton2" class="btn btn-info" style="float:center;" onclick="addContent()">增加一项</button>
		<div >
		<p align="left" style="font-size:12px"> 1.</h12><h10>本表中所有加分项目均不可重复计算，如遇可多处加分的条件，只可选择一处。</br>2. 授课负担度=∑（班型系数 ×计划学分数×课程系数）  注：班型系数按工作量计算办法规定计算: 学生人数N≤90→1，90&lt;N&lt;180: →1+（N-90）÷180, N≥180→1.5，课程系数为：新开课2，开新课1.5，其他1，新课不计重复班，毕业设计（班型系数、课程系数均为1）按一门课计，每指导3人计1学分）；新入职教师一年内承担的所有课程均不计入新课。因兼职其他工作减免工作量的，按比例缩放。</br>3.包括:大学生创新创业项目、学生竞赛获奖等（毕业设计除外），以结果计。</br>4.本项指教职工个人在校内外参加各种比赛竞赛、评奖评优、论文评比等获奖，如与其他评分项目重叠，则不累加计算。
</p>
		</div>
		</center>
		<a href="EducationM.jsp"><button type="button" class="btn btn-info" style="float:right" >修改评分表</button></a>
	</div>
	</form>
	<!-- .animated -->
        </div>
        <!-- /.content -->
        <div class="clearfix"></div>
        <!-- Footer -->
        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row" >
                
                    <div class="col-sm-6"  align="right">
                       <!--   Copyright &copy;Bucky Cheng Bok-gaai. All right reserved.-->
                    </div>
                    
                    
                </div>
            </div>
        </footer>
        <!-- /.site-footer -->
    </div>
    <!-- /#right-panel -->

   
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
    <script src="assets/js/bootstrap-table.js"></script>
	<script src="assets/js/bootstrap-table-zh-CN.js"></script>
	
  </body>
</html>
