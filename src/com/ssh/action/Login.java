package com.ssh.action;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AD_loginDao;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.dao.administorDao;
import com.ssh.dao.loginDao;
import com.ssh.model.AD_login;
import com.ssh.model.administor;
import com.ssh.model.educationTable;
import com.ssh.model.login;

@SuppressWarnings("serial")
public class Login extends ActionSupport{

	private login t_login;
	private AD_login A_login;
	private List<administor> adList;
	@Autowired
	private loginDao LD;
	@Autowired
	private EduScoreDao ESD;
	private AD_loginDao ALD;
	private administorDao AD;
	private administor Adm;
	private TeacherMDao TMD;
	
	public Login(){
		
	}
	public login getT_login() {
		return t_login;
	}

	public void setT_login(login t_login) {
		this.t_login = t_login;
	}

	public loginDao getLD() {
		return LD;
	}

	public void setLD(loginDao lD) {
		LD = lD;
	}
	

	public AD_login getA_login() {
		return A_login;
	}
	public void setA_login(AD_login a__login) {
		A_login = a__login;
	}
	public AD_loginDao getALD() {
		return ALD;
	}
	public void setALD(AD_loginDao aLD) {
		ALD = aLD;
	}
	
	public List getAdList() {
		return adList;
	}

	
	public administorDao getAD() {
		return AD;
	}
	public void setAD(administorDao aD) {
		AD = aD;
	}
	public administor getAdm() {
		return Adm;
	}
	public void setAdm(administor adm) {
		Adm = adm;
	}
	
	public EduScoreDao getESD() {
		return ESD;
	}
	public void setESD(EduScoreDao eSD) {
		ESD = eSD;
	}
	
	public TeacherMDao getTMD() {
		return TMD;
	}
	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}
	public void setAdList(List<administor> adList) {
		this.adList = adList;
	}
	public String execute() throws Exception{
		//String testHql="select s1s from EduScore ";
		//ESD.queryScore(testHql);
		System.out.println("IN ACTION");
		Map session = ActionContext.getContext().getSession();
		System.out.println(t_login.getT_ID()+"    "+t_login.getPassword());
		A_login=new AD_login();
		if(A_login==null){
			System.out.println("AD is null");
		}
		A_login.setAD_ID(t_login.getT_ID());
		A_login.setPassword(t_login.getPassword());
		System.out.println("TTTT_ID:"+t_login.getT_ID()+"TTTTT_PWD:"+t_login.getPassword());
		if(LD.checkpassword(t_login)){
			String t_Name=TMD.getTableByTID(t_login.getT_ID()).get(0).getTeacherName();
			session.put("t_ID", t_login.getT_ID());
			session.put("t_Name", t_Name);
			System.out.println("login action success");
			System.out.println(t_login.getT_ID()+"    "+t_login.getPassword());
			return SUCCESS;
		}else if(ALD.checkpassword(A_login)){
			
			adList=AD.getTable();
			
			System.out.println(adList.get(0).getA_department());
			ActionContext.getContext().put("ADList", adList);
			
			session.put("A_ID", A_login.getAD_ID());
			
			System.out.println("Administrator login action success");
			System.out.println(A_login.getAD_ID()+"    "+A_login.getPassword());
			return "Admin";
		}else{		
			addFieldError("password","旧密码错误");
			System.out.println("login action fail");
			System.out.println(t_login.getID()+"    "+t_login.getPassword());
			return INPUT;
			
		}
		
	}
	
	
}
