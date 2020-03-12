package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.ManagerInfoDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.dao.loginDao;
import com.ssh.model.ManagerInfo;
import com.ssh.model.TeacherInfo;
import com.ssh.model.login;

import net.sf.json.JSONArray;

public class InfoAction extends ActionSupport{

	public String Type;
	public String tID;
	public String tName;
	public String tSex;
	public String tBirthday;
	public String tDepartment;
	public String delID;
	public String saveID;
	public String result;
	public String changeID;
	public String changeClass;
	public String changeContent;
	public String SearchContent;
	public String addContent;
	public String OPassword;
	public List<TeacherInfo> TMList;
	public List<TeacherInfo> SaveList;
	public List<ManagerInfo> ManagerList;
	@Autowired
	private TeacherMDao TMD;
	@Autowired
	private loginDao LD;
	@Autowired
	private ManagerInfoDao MID;
	private login t_login;
	
	
	public String getAddContent() {
		return addContent;
	}



	public void setAddContent(String addContent) {
		this.addContent = addContent;
	}



	public loginDao getLD() {
		return LD;
	}



	public void setLD(loginDao lD) {
		LD = lD;
	}



	public login getT_login() {
		return t_login;
	}



	public void setT_login(login t_login) {
		this.t_login = t_login;
	}



	public String getType() {
		return Type;
	}



	public void setType(String type) {
		Type = type;
	}



	public String getDelID() {
		return delID;
	}



	public void setDelID(String delID) {
		this.delID = delID;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public TeacherMDao getTMD() {
		return TMD;
	}



	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}
	


	public List<TeacherInfo> getTMList() {
		return TMList;
	}



	public void setTMList(List<TeacherInfo> tMList) {
		TMList = tMList;
	}
	


	public String gettID() {
		return tID;
	}



	public void settID(String tID) {
		this.tID = tID;
	}



	public String gettName() {
		return tName;
	}



	public void settName(String tName) {
		this.tName = tName;
	}



	public String gettSex() {
		return tSex;
	}



	public void settSex(String tSex) {
		this.tSex = tSex;
	}



	public String gettBirthday() {
		return tBirthday;
	}



	public void settBirthday(String tBirthday) {
		this.tBirthday = tBirthday;
	}



	public String gettDepartment() {
		return tDepartment;
	}



	public void settDepartment(String tDepartment) {
		this.tDepartment = tDepartment;
	}
	


	public String getChangeID() {
		return changeID;
	}



	public void setChangeID(String changeID) {
		this.changeID = changeID;
	}



	public String getChangeClass() {
		return changeClass;
	}



	public void setChangeClass(String changeClass) {
		this.changeClass = changeClass;
	}



	public String getChangeContent() {
		return changeContent;
	}

	 public List<TeacherInfo> getSaveList() {
			return SaveList;
		}



		public void setSaveList(List<TeacherInfo> saveList) {
			SaveList = saveList;
		}

	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	public String getSaveID() {
		return saveID;
	}
	public void setSaveID(String saveID) {
		this.saveID = saveID;
	}
	public String getSearchContent() {
		return SearchContent;
	}



	public void setSearchContent(String searchContent) {
		SearchContent = searchContent;
	}
	


	public String getOPassword() {
		return OPassword;
	}



	public void setOPassword(String oPassword) {
		OPassword = oPassword;
	}
	


	public List<ManagerInfo> getManagerList() {
		return ManagerList;
	}



	public void setManagerList(List<ManagerInfo> managerList) {
		ManagerList = managerList;
	}



	public ManagerInfoDao getMID() {
		return MID;
	}



	public void setMID(ManagerInfoDao mID) {
		MID = mID;
	}


	public String SaveDelList(){
		SaveList=new ArrayList();
		Map session = ActionContext.getContext().getSession();
		SaveList=(List<TeacherInfo>) session.get("SaveDelList");
		//System.out.println("SAVELIST SIZE:"+SaveList.size());
		//for(int i=0;i<SaveList.size();i++){
			//System.out.println("AFTER DEL:"+SaveList.get(i).getTeacherName());
		//}
		JSONArray json = JSONArray.fromObject(SaveList);
		result=json.toString();
		return SUCCESS;
	}
	
	public String SearchContent(){
		List<TeacherInfo> SearchList=new ArrayList();
		SearchList=TMD.getTableByName(SearchContent);
		JSONArray json = JSONArray.fromObject(SearchList);
		result=json.toString();
		return SUCCESS;
	}
	
	public String reSet(){
		
		Map session = ActionContext.getContext().getSession();
		session.remove("SaveDelList");
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result=json.toString();
		return SUCCESS;
	}

	public String delTeacher(){
		Map session = ActionContext.getContext().getSession();
		System.out.println("delID:"+delID);
		String replace1=delID.replace("[","");
		SaveList=new ArrayList();
		
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		System.out.println("after tackle:"+replace4);
		
		String[] IDArray=replace4.split(",");

		List<TeacherInfo> TMList=new ArrayList();
		 TMList=TMD.getT();
		 System.out.println("TMLIST SIZE:"+TMList.size());
		 for(int i=0;i<TMList.size();i++){
			 for(int j=0;j<IDArray.length;j++){
					if(TMList.get(i).getID()==Integer.parseInt(IDArray[j])){
						System.out.println("DEL ID:"+TMList.get(i).getID());
						SaveList.add(TMList.get(i));
					}
				}
		 }

		for(int i=0;i<IDArray.length;i++){
			TMD.deleteCombinationAById(Integer.parseInt(IDArray[i]));
		}
		
		 for(int i=0;i<SaveList.size();i++){
				System.out.println(" DELING:"+SaveList.get(i).getTeacherName());
			}
		 session.put("SaveDelList", SaveList);
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result=json.toString();
		return SUCCESS;
	}
	
	public String TypeF(){
		System.out.println("delID:"+Type);
		TMList=TMD.getTable(Type);
		
		
		JSONArray json = JSONArray.fromObject(TMList);
		result=json.toString();
		return SUCCESS;
	}
	

	 public String AddTeacher(){
		 System.out.println("AddID:"+Type);
		 System.out.println("saveID before tackle:"+saveID);
		 String replace1=saveID.replace("[","");
			String replace2=replace1.replace("\"","");
			String replace3=replace2.replace("\"","");
			String replace4=replace3.replace("]","");
			System.out.println("saveID after tackle:"+replace4);
			String[] IDArray=replace4.split("!");
		 for(int i=0;i<IDArray.length;i++){
			 String[] ContentArray = null;
			 TeacherInfo TFT=new TeacherInfo();
			 if(i!=0){
				 String temp=IDArray[i].substring(1, IDArray[i].length());
				 ContentArray=temp.split(",");
			 }else{
				 ContentArray=IDArray[i].split(",");
			 }
				 TFT.setTeacherID(ContentArray[0]);
				 TFT.setTeacherName(ContentArray[1]);
				 TFT.setTeacherSex(ContentArray[2]);
				 TFT.setTeacherBirthday(ContentArray[3]);
				 TFT.setDepartment(Type);
				 TFT.setProgramme(ContentArray[4]);
				 TFT.setNotice("");
				 TMD.insertOne(TFT);
		 }
		
		 
		
		 List<TeacherInfo> TMList=new ArrayList();
		 TMList=TMD.getTable(Type);
		 JSONArray json = JSONArray.fromObject(TMList);
		result=json.toString();
		 return SUCCESS;
	 }
	 
	public String ChangeT(){
		 System.out.println("Class:"+changeClass+" ID:"+changeID+" content"+changeContent);
		 String updateEduSeHql="update TeacherInfo  set "+changeClass+"='"+changeContent+ "'where TeacherID ='"+changeID+"'";
		 TMD.updateTeacherInfo(updateEduSeHql);	
		 List<TeacherInfo> TMList=new ArrayList();
		 TMList=TMD.getTable(Type);
		 JSONArray json = JSONArray.fromObject(TMList);
		result=json.toString();
		 return SUCCESS;
	 }

	public String getDepartmrnt(){
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		List<TeacherInfo> TIF=new ArrayList();
		TIF=TMD.getTableByTID(TID);
		List returnList=new ArrayList();
		ManagerList=MID.getManager();
		for(int i=0;i<ManagerList.size();i++){
			if(TIF.get(0).getTeacherName().equals(ManagerList.get(i).getManager())){
			returnList.add("true");
			}
		}
		
		JSONArray json = JSONArray.fromObject(returnList);
		result=json.toString();
		return SUCCESS;
		
	}
	
	public String AddContent(){
		Map session = ActionContext.getContext().getSession();
		List a=new ArrayList();
		String TID=(String) session.get("t_ID");
		login LG=LD.getTeacher(TID).get(0);
		if(LG.getPassword().equals(OPassword)){
		LG.setT_ID(TID);
		LG.setPassword(addContent);
		LD.updatePassword(LG);
		a.add("密码修改成功！");
		}else{
			a.add("旧密码错误！");
		}
		JSONArray json = JSONArray.fromObject(a);
		result=json.toString();
		return SUCCESS;
	}
}
