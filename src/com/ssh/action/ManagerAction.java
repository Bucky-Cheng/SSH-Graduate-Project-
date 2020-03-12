package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ManagerInfoDao;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.model.ManagerInfo;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class ManagerAction extends ActionSupport{

	public String Type;
	public String Members;
	public String Manager;
	public String Remarks;
	private String result;
	public String changeID;
	public String changeContent;
	private String delID;
	@Autowired
	private ManagerInfoDao MID;
	@Autowired
	private TeacherMDao TMD;
	
	
	
	
	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public ManagerInfoDao getMID() {
		return MID;
	}




	public void setMID(ManagerInfoDao mID) {
		MID = mID;
	}




	public TeacherMDao getTMD() {
		return TMD;
	}




	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}
	



	public String getType() {
		return Type;
	}




	public void setType(String type) {
		Type = type;
	}




	public String getMembers() {
		return Members;
	}




	public void setMembers(String members) {
		Members = members;
	}




	public String getManager() {
		return Manager;
	}




	public void setManager(String manager) {
		Manager = manager;
	}




	public String getRemarks() {
		return Remarks;
	}




	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	public String getChangeID() {
		return changeID;
	}




	public void setChangeID(String changeID) {
		this.changeID = changeID;
	}




	public String getChangeContent() {
		return changeContent;
	}




	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	



	public String getDelID() {
		return delID;
	}




	public void setDelID(String delID) {
		this.delID = delID;
	}




	//显示各个部门
	public String Initialization(){
		
		System.out.println("进入Action");
		
		try{
		List HtmlCode=new ArrayList();
		
		//教师
		List<ManagerInfo> MI=new ArrayList();
		String DepartmentHql="from ManagerInfo where Department='教师岗位'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>教师岗位</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
		             
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		
		//辅导员
		MI=new ArrayList();
		DepartmentHql="from ManagerInfo where Department='辅导员岗位'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>辅导员岗位</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		
		//教辅
		MI=new ArrayList();
		DepartmentHql="from ManagerInfo where Department='教辅人员'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>教辅/行政人员</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		
		//管理组
		MI=new ArrayList();
		DepartmentHql="from ManagerInfo where Department='管理组'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>管理组</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		Map session = ActionContext.getContext().getSession();
		session.put("code", HtmlCode);
		JSONArray json = JSONArray.fromObject(HtmlCode);
		result = json.toString();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//更改部门信息
	public String ChangeInfo(){
		
		String updateMISeHql="update ManagerInfo  set Manager='"+changeContent+ "'where ID ='"+changeID+"'";
		MID.updateTeacherInfo(updateMISeHql);
		List HtmlCode=new ArrayList();
		
		
		JSONArray json = JSONArray.fromObject(HtmlCode);
		result = json.toString();
		return SUCCESS;
	}
	
	//删除部门信息
	public String delInfo(){
		
		MID.deleteById(Integer.parseInt(delID));
		List returnList=new ArrayList();
		JSONArray json = JSONArray.fromObject(returnList);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存新信息
	public String SaveData(){
		//添加
		ManagerInfo saveMI=new ManagerInfo();
		saveMI.setMembers(Members);
		saveMI.setManager(Manager);
		saveMI.setDepartment(Type);
		saveMI.setRemarks(Remarks);
		MID.insertOne(saveMI);
		//获取表格
		List HtmlCode=new ArrayList();
		
		//教师
		List<ManagerInfo> MI=new ArrayList();
		String DepartmentHql="from ManagerInfo where Department='教师岗位'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>教师岗位</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			
			HtmlCode.add(tr);
		}
		
		//辅导员
		MI=new ArrayList();
		DepartmentHql="from ManagerInfo where Department='辅导员岗位'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>辅导员岗位</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		
		//教辅
		MI=new ArrayList();
		DepartmentHql="from ManagerInfo where Department='教辅人员'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>教辅人员</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		
		//管理组
		MI=new ArrayList();
		DepartmentHql="from ManagerInfo where Department='管理组'";
		MI=MID.getManager(DepartmentHql);
		for(int j=0;j<MI.size();j++){
			
			String tr="";
			String FindTeacherHql="select TeacherName from TeacherInfo where Programme='"+MI.get(j).getMembers()+"'";
			String MembersTemp=TMD.queryID(FindTeacherHql);
			String Members=MI.get(j).getMembers()+"："+MembersTemp.substring(1, MembersTemp.length()-1);
			if(j==0){
				tr="<td rowspan='"+MI.size()+"'>管理组</td><td style='width:50%'>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}else{
				tr="<td>"+Members+"</td><td id='"+MI.get(j).getID()+"' onclick='change(this)'>"+MI.get(j).getManager()+"</td><td>"+MI.get(j).getRemarks()+"</td>";
			}
			String button1="<td style='width:10%' id='"+MI.get(j).getID()+"'><button type='button' class='btn btn-danger' id='del' onclick='delRow(this)'>";
            
	        String button2=button1+"<span style='width:100%'> <i class='fa fa-minus-square-o fa-fw'></i>&nbsp;&nbsp;删除</span> </button></td>";
	        tr=tr+button2;	
			HtmlCode.add(tr);
		}
		
		JSONArray json = JSONArray.fromObject(HtmlCode);
		result = json.toString();
		return SUCCESS;
	}
}
