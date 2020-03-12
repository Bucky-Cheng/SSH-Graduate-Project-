package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ManagerInfoDao;
import com.ssh.dao.TeacherFileDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.dao.educationTableDao;
import com.ssh.model.ManagerInfo;
import com.ssh.model.TeacherFile;
import com.ssh.model.TeacherInfo;

public class DocumentShowAd extends ActionSupport{

	private List<TeacherFile> DocList;
	@Autowired
	private TeacherFileDao TFD;
	@Autowired
	private TeacherMDao TMD;
	@Autowired
	private ManagerInfoDao MID;
	
	public List<TeacherFile> getDocList() {
		return DocList;
	}
	public void setDocList(List<TeacherFile> docList) {
		DocList = docList;
	}
	public TeacherFileDao getTFD() {
		return TFD;
	}
	public void setTFD(TeacherFileDao tFD) {
		TFD = tFD;
	}
	
	public String execute() throws Exception{
		//teacher ID
//		Map session = ActionContext.getContext().getSession();
//		String TeacherID=(String) session.get("t_ID");
//		String TeacherName=TMD.getTableByTID(TeacherID).get(0).getTeacherName();
//		List<ManagerInfo> MIL=new ArrayList();
//		MIL=MID.getManagerByName(TeacherName);
//		List MembersL=new ArrayList();
//		for(int i=0;i<MIL.size();i++){
//			MembersL.add(MIL.get(i).getMembers());
//		}
//		List<TeacherInfo> TIL=new ArrayList();
//		for(int j=0;j<MembersL.size();j++){
//			TIL.addAll(TMD.getTableByPro((String) MembersL.get(j)));
//		}
		List<TeacherFile> tf=TFD.getTable();
		DocList=new ArrayList();
//		for(int q=0;q<tf.size();q++){
			DocList.addAll(tf);
//		}
		System.out.println("DOC 0:"+DocList.get(0).getTeacherName());
		return SUCCESS;
	}
}
