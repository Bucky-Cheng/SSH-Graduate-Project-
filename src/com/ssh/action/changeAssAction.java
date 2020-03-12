package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.ssh.model.ScoreCombination;
import com.ssh.model.assistantTable;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.rowcol;
import com.ssh.model.serveTable;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class changeAssAction extends ActionSupport{

	private String name;
	private String content;
	private List<assistantTable> assistantList;
	private String result;
	@Autowired
	private assistantTableDao ATD;
	@Autowired
	private RowcolAssDao RCAD;
	private assistantTable At;
	
	public changeAssAction(){
		
	}

	

	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
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
		return At;
	}




	public void setAt(assistantTable at) {
		At = at;
	}




	public String execute() throws Exception {
		System.out.println("½øÈëaction");
		if(name.contains("Score")&&!name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			System.out.println(name);
			ATD.updateEduScore(name, content);
			
		}else if(name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			ATD.updateEduScoreA(name, content);
		}else{
			System.out.println("content is"+content);
		if(content == null || content.length() <= 0){
			System.out.println("content is null");
			ATD.deleteContent(name);
		}else{
		ATD.updateEduTable(name, content);
		}
		}
		
		return INPUT;
	}
	
	
}

