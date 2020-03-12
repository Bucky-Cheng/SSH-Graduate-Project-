package com.ssh.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AD_loginDao;
import com.ssh.model.AD_login;

public class PasswordUpdateAction extends ActionSupport{
	String oldpwd;
	String newpwd;
	@Autowired
	public AD_loginDao ad;
	
	public AD_loginDao getAd() {
		return ad;
	}

	public void setAd(AD_loginDao ad) {
		this.ad = ad;
	}

	public PasswordUpdateAction(){
		
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		String aid=session.get("A_ID").toString();
		int r=ad.updatepassword(aid,oldpwd, newpwd);
		if(r==1){
			return SUCCESS;
		}else if(r==0){
			addFieldError("oldpwd","旧密码错误");
			return INPUT;
		}else{
			return INPUT;
		}
	}
}
