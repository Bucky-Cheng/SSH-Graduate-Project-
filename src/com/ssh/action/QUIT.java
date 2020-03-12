package com.ssh.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class QUIT extends ActionSupport implements SessionAware{

	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		  
		HttpSession session1 = request.getSession();
		  
		session1.invalidate();
		  
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
