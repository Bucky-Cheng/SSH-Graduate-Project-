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
         <button type="button" class="btn btn-primary" id="add" onclick="AddNotice()">
             
              <span style="width:100%"> <i class="fa fa-plus-square-o fa-fw"></i>&nbsp;&nbsp;添加</span>
          </button>
          
         
          </div>
         
        <br/><br/>
        <div id="table1">
           	<table class="table table-bordered">
	  		<thead>
                <tr>
                	
                    <th style="text-align:center">通知编号</th>
                    <th style="text-align:center">通知内容</th>
                    <th style="text-align:center">通知类别</th>
                    <th style="text-align:center">发布时间</th>
                 
                   <th style="text-align:center">操作</th>
                </tr>
            </thead>


			
			<tbody id="tbody1">
				
			</tbody>
			</table>
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

    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="assets/bootstrap-select.js"></script> 
    <script src="js/jquery.jqChart.min.js" type="text/javascript"></script> 
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/fileinput.min.js"></script>
	<script type="text/javascript" src="js/zh.js"></script>
    <script>
    
    function AddNotice(){
    jQuery("#buttonAdd").html("");
    jQuery("#table1").html("");
    var option="<option >教师</option><option >辅导员</option><option >教辅</option><option >管理组</option><option >全体教职工</option>";
    var type="<span>收取通知的教职工类别：</span><select name='save1'  class='form-control selectpicker'  id='AddSelect'   ></select><br/>";
    var theme="<span>主题：</span><input type='text' id='Theme'  class='form-control' ><br/>";
    var content="<span>正文：</span><textarea id='TextA' rows='20' cols='122'></textarea><br/>";
    var upload="<span>附件上传：</span><div><div style='width:50%;float:left'><input type='file' name='upload' id='upload' style='width:40%' ></div><div style='margin-left:29%;position:absolute;z-index:1001'><button type='button' id='upload' onclick='FileSave()' class='btn btn-success' style='140%' >上传</button></div></div>";
    var buttonA= "<button type='button' class='btn btn-success'><span style='width:100%' onclick='save()'> <i class='fa fa-file-o fa-fw'></i>&nbsp;&nbsp;保存</span></button>&nbsp;&nbsp;";
	var buttonC= "<button type='button' class='btn btn-warning'><span style='width:100%' onclick='cancel()'> <i class='fa fa-close fa-fw'></i>&nbsp;&nbsp;取消</span></button>";
 	jQuery("#buttonAdd").append(buttonA);  
 	jQuery("#buttonAdd").append(buttonC); 
 	jQuery("#table1").append(type);
 	jQuery("#AddSelect").append(option);
 	jQuery("#table1").append(theme);	
 	jQuery("#table1").append(content);
 	jQuery("#table1").append(upload);
 	jQuery("#AddSelect").selectpicker('refresh');
	jQuery("#AddSelect").selectpicker('render');
	initFileInput("upload");
    }
    
    function cancel(){
    	jQuery.ajax({
 	
		url:"getTableNoticeAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data)
			jQuery("#buttonAdd").html("");
    		jQuery("#table1").html("");
			var table1="<table class='table table-bordered'><thead><tr>";
	  		var table2=table1+" <th style='text-align:center'>通知编号</th><th style='text-align:center'>通知主题</th><th style='text-align:center'>通知类别</th><th style='text-align:center'>发布时间</th><th style='text-align:center'>操作</th>";
            var table3=table2+"</tr> </thead><tbody id='tbody1'></tbody></table>";    
 			jQuery("#table1").append(table3);
			var json=eval('('+data+')');
			//alert(json);
			var option="<option >教师</option><option >辅导员</option><option >教辅</option><option >管理组</option><option >全体教职工</option>";
			for(var i in json){
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='delButton(this)'  >删除</button>";
				var td1="<tr><td style='text-align:center'>"+json[i].noticeID+"</td><td style='text-align:center'>"+json[i].noticeTheme+"</td><td style='text-align:center'>"+json[i].type+"</td><td style='text-align:center'>"+json[i].startTime+"</td><td style='text-align:center'>"+delButton+"</td></tr>";
                jQuery("#tbody1").append(td1);  
　　　			
                  
  			}	
  			var AddButton1="<button type='button' class='btn btn-primary' id='add' onclick='AddNotice()'>";
            var AddButton2=AddButton1+" <span style='width:100%'> <i class='fa fa-plus-square-o fa-fw'></i>&nbsp;&nbsp;添加</span> </button>"; 
            jQuery("#buttonAdd").append(AddButton2); 
		}
	})
    }
    
    function delButton(delButton){
    	var delID=jQuery(delButton).attr("id");
    	jQuery.ajax({
 	
		url:"DelIDNoticeAction",
		type:"post",
		data:{delID:delID},
		dataType:  "json", 
		success:function(data){
			
			//alert(data)
			
			jQuery("#tbody1").html("");
			var json=eval('('+data+')');
			//alert(json);
			var option="<option >教师</option><option >辅导员</option><option >教辅</option><option >管理组</option><option >全体教职工</option>";
			for(var i in json){
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='delButton(this)'  >删除</button>";
				var td1="<tr><td style='text-align:center'>"+json[i].noticeID+"</td><td style='text-align:center'>"+json[i].noticeTheme+"</td><td style='text-align:center'>"+json[i].type+"</td><td style='text-align:center'>"+json[i].startTime+"</td><td style='text-align:center'>"+delButton+"</td></tr>";
                jQuery("#tbody1").append(td1);  
　　　			
                  
  			}	
		}
	})
    }
    
    function initFileInput(ctrlName) {
	
        var control = jQuery('#' + ctrlName);
        control.fileinput({
        	language: 'zh',
        	showUpload: false, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : false, //是否显示预览
            showCancel:false,
            showCaption: true,//是否显示标题
            browseClass: "btn btn-primary",
        })
        }
    
    function save(){
    	
    	var type=jQuery("#AddSelect").val();
    	var Theme=jQuery("#Theme").val();
    	var Content=jQuery("#TextA").val();
    	jQuery.ajax({
 	
		url:"SaveNoticeAction",
		type:"post",
		data:{Type:type,Theme:Theme,Content:Content},
		dataType:  "json", 
		success:function(data){
			
			//alert(data)
			jQuery("#buttonAdd").html("");
    		jQuery("#table1").html("");
			var table1="<table class='table table-bordered'><thead><tr>";
	  		var table2=table1+" <th style='text-align:center'>通知编号</th><th style='text-align:center'>通知主题</th><th style='text-align:center'>通知类别</th><th style='text-align:center'>发布时间</th><th style='text-align:center'>操作</th>";
            var table3=table2+"</tr> </thead><tbody id='tbody1'></tbody></table>";    
 			jQuery("#table1").append(table3);
			var json=eval('('+data+')');
			
			var option="<option >教师</option><option >辅导员</option><option >教辅</option><option >管理组</option><option >全体教职工</option>";
			for(var i in json){
			 	
			 	
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='delButton(this)'  >删除</button>"
	
				var td1="<tr><td style='text-align:center'>"+json[i].noticeID+"</td><td style='text-align:center'>"+json[i].noticeTheme+"</td><td style='text-align:center'>"+json[i].type+"</td><td style='text-align:center'>"+json[i].startTime+"</td><td style='text-align:center'>"+delButton+"</td></tr>";
                jQuery("#tbody1").append(td1);  
　　　			
                  
  			}
  			var AddButton1="<button type='button' class='btn btn-primary' id='add' onclick='AddNotice()'>";
            var AddButton2=AddButton1+" <span style='width:100%'> <i class='fa fa-plus-square-o fa-fw'></i>&nbsp;&nbsp;添加</span> </button>"; 
            jQuery("#buttonAdd").append(AddButton2); 
         
		}
	})
    
    }
    
    
    function FileSave(){
    	jQuery.ajaxFileUpload({
					url : 'FileSaveNoticeAction',//后台请求地址
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
    
    }
    
    
    jQuery(document).ready(function(){
    
    	
		jQuery.ajax({
 	
		url:"getTableNoticeAction",
		type:"post",
		data:{},
		dataType:  "json", 
		success:function(data){
			
			//alert(data)
			
			
			
			var json=eval('('+data+')');
			//alert(json);
			var option="<option >教师</option><option >辅导员</option><option >教辅</option><option >管理组</option><option >全体教职工</option>";
			for(var i in json){
			 	
			 	
  				var delButton="<button type='button' class='btn btn-danger btn-sm' id='"+json[i].ID+"' onclick='delButton(this)'  >删除</button>"
	
				var td1="<tr><td style='text-align:center'>"+json[i].noticeID+"</td><td style='text-align:center'>"+json[i].noticeTheme+"</td><td style='text-align:center'>"+json[i].type+"</td><td style='text-align:center'>"+json[i].startTime+"</td><td style='text-align:center'>"+delButton+"</td></tr>";
                jQuery("#tbody1").append(td1);  
　　　			
                  
  			}
  			
		}
	
	

	})
    
    });
    
    </script>
    
    
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/main.js"></script>




<script src="assets/js/lib/flot-chart/jquery.flot.spline.js"></script>


<script src="assets/calendar/fullcalendar.min.js"></script>
<script src="assets/calendar/fullcalendar-init.js"></script>cript>
   
	 <script type="text/javascript" src="assets/js/custom.js"></script>
	 <script type="text/javascript" src="assets/js/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
    <script src="assets/js/init/fullcalendar-init.js"></script>
  </body>
</html>
