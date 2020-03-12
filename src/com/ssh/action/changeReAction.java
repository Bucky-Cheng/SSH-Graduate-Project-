package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.model.ScoreCombination;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.rowcol;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class changeReAction extends ActionSupport{

	private String name;
	private String content;
	private List<researchTable> researchList;
	private String result;
	@Autowired
	private researchTableDao RTD;
	@Autowired
	private RowcolReaDao RCRD;
	private researchTable rt;
	
	public changeReAction(){
		
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

	public researchTable getRt() {
		return rt;
	}

	public void setRt(researchTable rt) {
		this.rt = rt;
	}

	public String execute() throws Exception {
		System.out.println("½øÈëaction");
		if(name.contains("Score")&&!name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			System.out.println(name);
			RTD.updateEduScore(name, content);
			
		}else if(name.contains("AllScore")){
			String[] a=name.split("\\+");
			name=a[0];
			RTD.updateEduScoreA(name, content);
		}else{
			System.out.println("content is"+content);
		if(content == null || content.length() <= 0){
			System.out.println("content is null");
			RTD.deleteContent(name);
		}else{
		RTD.updateEduTable(name, content);
		}
		}
		
		return INPUT;
	}
	
	
}

