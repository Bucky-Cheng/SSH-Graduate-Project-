package com.ssh.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.ScoreresultDao;
import com.ssh.model.Scoreresult;

public class SSAction extends ActionSupport{
	List<Scoreresult> SSL;
	@Autowired
	private ScoreresultDao ESD;
	
	public List<Scoreresult> getSSL() {
		return SSL;
	}

	public void setSSL(List<Scoreresult> sSL) {
		SSL = sSL;
	}

	public ScoreresultDao getESD() {
		return ESD;
	}

	public void setESD(ScoreresultDao eSD) {
		ESD = eSD;
	}

	public String execute() throws Exception{
		
		SSL=ESD.getTable();
		
		
		
		return SUCCESS;
	}
}
