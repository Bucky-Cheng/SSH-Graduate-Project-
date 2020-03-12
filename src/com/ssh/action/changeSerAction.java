package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.RowcolSerDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.ScoreCombination;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.rowcol;
import com.ssh.model.serveTable;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class changeSerAction extends ActionSupport{

	private String name;
	private String content;
	private List<serveTable> researchList;
	private String result;
	@Autowired
	private serveTableDao STD;
	@Autowired
	private RowcolSerDao RCSD;
	private serveTable st;
	
	public changeSerAction(){
		
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



	public List<serveTable> getResearchList() {
		return researchList;
	}



	public void setResearchList(List<serveTable> researchList) {
		this.researchList = researchList;
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
		System.out.println("½øÈëaction");
		if(name.contains("Score")&&!name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			System.out.println(name);
			STD.updateEduScore(name, content);
			
		}else if(name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			STD.updateEduScoreA(name, content);
		}else{
			System.out.println("content is"+content);
		if(content == null || content.length() <= 0){
			System.out.println("content is null");
			STD.deleteContent(name);
		}else{
		STD.updateEduTable(name, content);
		}
		}
		
		return INPUT;
	}
	
	
}

