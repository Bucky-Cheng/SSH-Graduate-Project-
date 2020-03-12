package com.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.EvaluateNumDao;
import com.ssh.dao.loginDao;
import com.ssh.model.EvaluateNum;

public class ScoreDownload extends ActionSupport{

	public List<EvaluateNum> ENL;
	@Autowired
	private EvaluateNumDao END;
	
	
	
	public List<EvaluateNum> getENL() {
		return ENL;
	}



	public void setENL(List<EvaluateNum> eNL) {
		ENL = eNL;
	}



	public EvaluateNumDao getEND() {
		return END;
	}



	public void setEND(EvaluateNumDao eND) {
		END = eND;
	}
	


	public String execute() throws Exception{
		
		ENL=new ArrayList();
		ENL=END.getTable();
		System.out.println("ENL SIZE:"+ENL.size());
		return SUCCESS;
	}
}
