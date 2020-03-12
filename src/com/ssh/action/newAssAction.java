package com.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolAssDao;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.RowcolSerDao;
import com.ssh.dao.assistantTableDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.assistantTable;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.serveTable;

public class newAssAction extends ActionSupport{

	
	private String content;
	private List<assistantTable> assistantList;
	private String result;
	@Autowired
	private assistantTableDao ATD;
	@Autowired
	private RowcolAssDao RCAD;
	private assistantTable at;
	
	public newAssAction(){
		
	}

	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public List<assistantTable> getAssistantList() {
		return assistantList;
	}


	public void setAssistantList(List<assistantTable> assistantList) {
		this.assistantList = assistantList;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public assistantTableDao getATD() {
		return ATD;
	}


	public void setATD(assistantTableDao aTD) {
		ATD = aTD;
	}


	public RowcolAssDao getRCAD() {
		return RCAD;
	}


	public void setRCAD(RowcolAssDao rCAD) {
		RCAD = rCAD;
	}


	public assistantTable getAt() {
		return at;
	}


	public void setAt(assistantTable at) {
		this.at = at;
	}


	public String execute() throws Exception {
		try{
		System.out.println("½øÈëaction");
		assistantList=new ArrayList();
		assistantList=ATD.getTable();
		String ID=content.substring(0, 1);
		boolean flag=true;
		String num="";
		for(int i=0;i<assistantList.size();i++){
			String EduName=assistantList.get(i).getName().substring(0, 1);
			if(ID.toLowerCase().equals(EduName)){
				num=assistantList.get(i).getName().substring(1,2);
				flag=false;
			}else{
				
			}
		}
		System.out.println(num);
		if(!flag){
			at=new assistantTable();
			num=String.valueOf(Integer.parseInt(num)+1);
			ID=ID.toLowerCase()+num;
			at.setName(ID);
			at.setContent(content);
			ATD.insertOne(at);
			}else{
				at=new assistantTable();
				ID=ID.toLowerCase()+"1";
				at.setName(ID);
				at.setContent(content);
				ATD.insertOne(at);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	
	
}
