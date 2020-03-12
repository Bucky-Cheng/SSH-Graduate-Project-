package com.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.educationTableDao;
import com.ssh.model.educationTable;

public class newEduAction extends ActionSupport{

	
	private String content;
	private List<educationTable> educationList;
	private String result;
	@Autowired
	private educationTableDao ETD;
	@Autowired
	private RowcolDao RCD;
	private educationTable et;
	
	public newEduAction(){
		
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public educationTableDao getETD() {
		return ETD;
	}

	public void setETD(educationTableDao etd) {
		this.ETD = etd;
	}

	public educationTable getEt() {
		return et;
	}

	public void setEt(educationTable et) {
		this.et = et;
	}
	
	
	
	public List<educationTable> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<educationTable> educationList) {
		this.educationList = educationList;
	}

	public RowcolDao getRCD() {
		return RCD;
	}

	public void setRCD(RowcolDao rCD) {
		RCD = rCD;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() throws Exception {
		try{
		System.out.println("½øÈëaction");
		educationList=new ArrayList();
		educationList=ETD.getTable();
		String ID=content.substring(0, 1);
		boolean flag=true;
		String num="";
		for(int i=0;i<educationList.size();i++){
			String EduName=educationList.get(i).getName().substring(0, 1);
			if(ID.toLowerCase().equals(EduName)){
				num=educationList.get(i).getName().substring(1,2);
				flag=false;
			}else{
				
			}
		}
		System.out.println(num);
		if(!flag){
			et=new educationTable();
			num=String.valueOf(Integer.parseInt(num)+1);
			ID=ID.toLowerCase()+num;
			et.setName(ID);
			et.setContent(content);
			ETD.insertOne(et);
			}else{
				et=new educationTable();
				ID=ID.toLowerCase()+"1";
				et.setName(ID);
				et.setContent(content);
				ETD.insertOne(et);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	
	
}
