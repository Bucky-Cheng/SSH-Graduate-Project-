package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.NoticeTableDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.model.AD_login;
import com.ssh.model.NoticeTable;

@SuppressWarnings("serial")
public class TeacherNoticeAction extends ActionSupport{
	
	private List<NoticeTable> TNT;
	@Autowired
	private NoticeTableDao NTD;
	@Autowired
	private TeacherMDao TMD;
	
	
	
	public List<NoticeTable> getTNT() {
		return TNT;
	}



	public void setTNT(List<NoticeTable> tNT) {
		TNT = tNT;
	}



	public NoticeTableDao getNTD() {
		return NTD;
	}



	public void setNTD(NoticeTableDao nTD) {
		NTD = nTD;
	}



	public TeacherMDao getTMD() {
		return TMD;
	}



	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}



	public String execute() throws Exception{
		//获取当前教职工类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		TNT=new ArrayList();
		TNT=NTD.getTeacherNotice(Type);
		System.out.println("NOTICE THEME:"+TNT.get(0).getNoticeTheme());
		return SUCCESS;
	}
}
