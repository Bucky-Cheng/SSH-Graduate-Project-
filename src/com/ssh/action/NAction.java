package com.ssh.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NAction  extends ActionSupport{

	//跳转至通知页面
	public String execute() throws Exception{
		Map session = ActionContext.getContext().getSession();
		String ADName=(String) session.get("A_ID");
		if(ADName==null||ADName.length()<=0){
			return INPUT;
		}else{
		return SUCCESS;
		}
	}
}
