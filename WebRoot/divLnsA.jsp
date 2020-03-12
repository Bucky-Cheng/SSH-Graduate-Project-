<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联想搜索功能</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    $(function(){
        $(".u1").css({
            "padding":"0px",
            "margin":"0px",
            "list-style":"none",
            "width":"100%",
        });

        $(".l1").css({
            "padding":"0px",
            "margin":"0px",
            "width":"100%"
        });

        $(".l1").hover(
            function(){
                $(this).css({"background-color":"#ddd"});
            },
            function(){
                $(this).css({"background-color":"#F0F8FF"});
            }
        );
    }); 
</script>
<body>
    <ul class="u1">
        <c:forEach begin="0" end="15" items="${unames }" var="uname" step="1">
            <li class="l1" id="SLi" onclick="LiClick(this)">${uname }</li>
        </c:forEach>
    </ul>
</body>
</html>