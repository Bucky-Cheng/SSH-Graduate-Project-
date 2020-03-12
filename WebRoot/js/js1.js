//根据id删除用户
function deleteScore(userId){
	if(confirm("你确定删除该用户吗?")){
		location.href="deleteScoreAction?ID="+userId;
	}
}

//修改，现根据id查询用户详细信息，以供修改
function queryUserDetails(userId){
	location.href="queryActionById?id="+userId;
}