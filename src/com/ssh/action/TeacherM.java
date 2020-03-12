package com.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.model.TeacherInfo;

public class TeacherM extends ActionSupport{

	public String Type;
	public List<TeacherInfo> TMList;
	@Autowired
	private TeacherMDao TMD;
	
	
	
	public String getType() {
		return Type;
	}



	public void setType(String type) {
		Type = type;
	}



	public List<TeacherInfo> getTMList() {
		return TMList;
	}



	public void setTMList(List<TeacherInfo> tMList) {
		TMList = tMList;
	}



	public TeacherMDao getTMD() {
		return TMD;
	}



	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}



	public String execute() throws Exception{
		TMList=TMD.getTable("教师");
		if(TMList.size()>0){
			return SUCCESS; 
		}else{
			return INPUT;
		}
	}
}
