package com.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.EButtonDao;
import com.ssh.dao.TeacherFileDao;
import com.ssh.model.EButton;

import net.sf.json.JSONArray;

public class EAction extends ActionSupport{

	private String result;
	@Autowired
	private EButtonDao EBD;

	public EButtonDao getEBD() {
		return EBD;
	}

	public void setEBD(EButtonDao eBD) {
		EBD = eBD;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTable(){
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		JSONArray json = JSONArray.fromObject(EBL);
		result = json.toString();
		return SUCCESS;
	}
	
	public String open(){
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		
		if(EBL.get(0).getAllCheck().equals("T")){
			System.out.println("EACTION:"+EBL.get(0).getAllCheck());
			EBL.get(0).setAllCheck("F");
			System.out.println("EACTION:"+EBL.get(0).getAllCheck());
			EBD.updateE(EBL.get(0));
		}else if(EBL.get(0).getAllCheck().equals("F")){
			System.out.println("EACTION:"+EBL.get(0).getAllCheck());
			EBL.get(0).setAllCheck("T");
			System.out.println("EACTION:"+EBL.get(0).getAllCheck());
			EBD.updateE(EBL.get(0));
		}
		List aaa=new ArrayList();
		aaa.add("Aaa");
		JSONArray json = JSONArray.fromObject(aaa);
		result = json.toString();
		return SUCCESS;
	}
}
