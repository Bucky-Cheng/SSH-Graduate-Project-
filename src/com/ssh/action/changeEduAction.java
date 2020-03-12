package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.educationTableDao;
import com.ssh.model.ScoreCombination;
import com.ssh.model.educationTable;
import com.ssh.model.rowcol;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class changeEduAction extends ActionSupport{

	private String name;
	private String content;
	private List<educationTable> educationList;
	private String result;
	@Autowired
	private educationTableDao ETD;
	@Autowired
	private RowcolDao RCD;
	private educationTable et;
	
	public changeEduAction(){
		
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
		System.out.println("½øÈëaction");
		if(name.contains("Score")&&!name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			System.out.println(name);
			ETD.updateEduScore(name, content);
			
		}else if(name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			ETD.updateEduScoreA(name, content);
		}else{
			System.out.println("content is"+content);
		if(content == null || content.length() <= 0){
			System.out.println("content is null");
			ETD.deleteContent(name);
		}else{
		ETD.updateEduTable(name, content);
		}
		}
		
		return INPUT;
	}
	
	
}

