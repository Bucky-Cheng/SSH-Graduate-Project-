package com.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.educationTableDao;
import com.ssh.model.EducationReturn;
import com.ssh.model.ScoreCombination;
import com.ssh.model.educationTable;
import com.ssh.model.rowcol;

@SuppressWarnings("serial")
public class getEducationTable extends ActionSupport{

	private String flag;
	private educationTable et;
	private EducationReturn ER;
	private rowcol RC;
	private ScoreCombination SC;
	private List<educationTable> educationList;
	private Map educationData;
	private List eduList;
	
	@Autowired
	private educationTableDao etd;
	@Autowired
	private RowcolDao RD;
	public getEducationTable(){
		
	}
	public educationTable getEt() {
		return et;
	}
	public void setEt(educationTable et) {
		this.et = et;
	}
	public educationTableDao getEtd() {
		return etd;
	}
	public void setEtd(educationTableDao etd) {
		this.etd = etd;
	}
	
	public List getEducationList() {
		return educationList;
	}
	
	
	
	
	public Map getEducationData() {
		return educationData;
	}
	public void setEducationData(Map educationData) {
		this.educationData = educationData;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public RowcolDao getRD() {
		return RD;
	}
	public void setRD(RowcolDao rD) {
		RD = rD;
	}
	
	
	
	public EducationReturn getER() {
		return ER;
	}
	public void setER(EducationReturn eR) {
		ER = eR;
	}
	public rowcol getRC() {
		return RC;
	}
	public void setRC(rowcol rC) {
		RC = rC;
	}
	public ScoreCombination getSC() {
		return SC;
	}
	public void setSC(ScoreCombination sC) {
		SC = sC;
	}
	public List getEduList() {
		return eduList;
	}
	public void setEduList(List eduList) {
		this.eduList = eduList;
	}
	public void setEducationList(List<educationTable> educationList) {
		this.educationList = educationList;
	}
	
	//不同请求跳转到不同页面
	public String execute() throws Exception{
		
		
			if(flag.equals("a")){
			return SUCCESS;
			}else if(flag.equals("b")){
				return INPUT;
			}else if(flag.equals("c")){
				return LOGIN;
			}else{
				return ERROR;
			}
		
	}
	
}
