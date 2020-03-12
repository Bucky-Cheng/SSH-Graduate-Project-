package com.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;

public class newReAction extends ActionSupport{

	
	private String content;
	private List<researchTable> researchList;
	private String result;
	@Autowired
	private researchTableDao RTD;
	@Autowired
	private RowcolReaDao RCRD;
	private researchTable et;
	
	public newReAction(){
		
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	public List<researchTable> getResearchList() {
		return researchList;
	}



	public void setResearchList(List<researchTable> researchList) {
		this.researchList = researchList;
	}



	public researchTableDao getRTD() {
		return RTD;
	}



	public void setRTD(researchTableDao rTD) {
		RTD = rTD;
	}



	public RowcolReaDao getRCRD() {
		return RCRD;
	}



	public void setRCRD(RowcolReaDao rCRD) {
		RCRD = rCRD;
	}



	public researchTable getEt() {
		return et;
	}



	public void setEt(researchTable et) {
		this.et = et;
	}



	public String execute() throws Exception {
		try{
		System.out.println("½øÈëaction");
		researchList=new ArrayList();
		researchList=RTD.getTable();
		String ID=content.substring(0, 1);
		boolean flag=true;
		String num="";
		for(int i=0;i<researchList.size();i++){
			String EduName=researchList.get(i).getName().substring(0, 1);
			if(ID.toLowerCase().equals(EduName)){
				num=researchList.get(i).getName().substring(1,2);
				flag=false;
			}else{
				
			}
		}
		System.out.println(num);
		if(!flag){
			et=new researchTable();
			num=String.valueOf(Integer.parseInt(num)+1);
			ID=ID.toLowerCase()+num;
			et.setName(ID);
			et.setContent(content);
			RTD.insertOne(et);
			}else{
				et=new researchTable();
				ID=ID.toLowerCase()+"1";
				et.setName(ID);
				et.setContent(content);
				RTD.insertOne(et);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	
	
}
