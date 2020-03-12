package com.ssh.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.RowcolSerDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.serveTable;

public class newSerAction extends ActionSupport{

	
	private String content;
	private List<serveTable> serveList;
	private String result;
	@Autowired
	private serveTableDao STD;
	@Autowired
	private RowcolSerDao RCSD;
	private serveTable st;
	
	public newSerAction(){
		
	}

	public String getContent() {
		return content;
	}





	public void setContent(String content) {
		this.content = content;
	}





	public List<serveTable> getServeList() {
		return serveList;
	}





	public void setServeList(List<serveTable> serveList) {
		this.serveList = serveList;
	}





	public String getResult() {
		return result;
	}





	public void setResult(String result) {
		this.result = result;
	}





	public serveTableDao getSTD() {
		return STD;
	}





	public void setSTD(serveTableDao sTD) {
		STD = sTD;
	}





	public RowcolSerDao getRCSD() {
		return RCSD;
	}





	public void setRCSD(RowcolSerDao rCSD) {
		RCSD = rCSD;
	}





	public serveTable getSt() {
		return st;
	}





	public void setSt(serveTable st) {
		this.st = st;
	}





	public String execute() throws Exception {
		try{
		System.out.println("½øÈëaction");
		serveList=new ArrayList();
		serveList=STD.getTable();
		String ID=content.substring(0, 1);
		boolean flag=true;
		String num="";
		for(int i=0;i<serveList.size();i++){
			String EduName=serveList.get(i).getName().substring(0, 1);
			if(ID.toLowerCase().equals(EduName)){
				num=serveList.get(i).getName().substring(1,2);
				flag=false;
			}else{
				
			}
		}
		System.out.println(num);
		if(!flag){
			st=new serveTable();
			num=String.valueOf(Integer.parseInt(num)+1);
			ID=ID.toLowerCase()+num;
			st.setName(ID);
			st.setContent(content);
			STD.insertOne(st);
			}else{
				st=new serveTable();
				ID=ID.toLowerCase()+"1";
				st.setName(ID);
				st.setContent(content);
				STD.insertOne(st);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	
	
}
