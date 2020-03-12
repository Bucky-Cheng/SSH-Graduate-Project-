//根据id删除用户
function deleteTest(id){
	if(confirm("你确定删除该用户吗?")){
		location.href="deleteTest?id="+id;
	}
}

//修改，现根据id查询用户详细信息，以供修改
function queryTestDetails(id){
	location.href="queryTestById?id="+id;
}