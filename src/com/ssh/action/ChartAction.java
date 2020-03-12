package com.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ChartDao;
import com.ssh.dao.EButtonDao;
import com.ssh.dao.ScoreresultDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.model.ChartNum;
import com.ssh.model.EButton;
import com.ssh.model.Scoreresult;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class ChartAction extends ActionSupport{

	private String result;
	private List<ChartNum> NumList;
	private ChartNum CR;
	@Autowired
	private TeacherMDao TMD;
	@Autowired
	private ChartDao CD;
	@Autowired
	private ScoreresultDao SRD;
	@Autowired
	private EButtonDao EBD;
	public ChartAction(){
		
	}
	
	
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public TeacherMDao getTMD() {
		return TMD;
	}


	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}
	

	public ChartNum getCR() {
		return CR;
	}


	public void setCR(ChartNum cR) {
		CR = cR;
	}


	public ChartDao getCD() {
		return CD;
	}


	public void setCD(ChartDao cD) {
		CD = cD;
	}
	

	public List<ChartNum> getNumList() {
		return NumList;
	}


	public void setNumList(List<ChartNum> numList) {
		NumList = numList;
	}
	

	public ScoreresultDao getSRD() {
		return SRD;
	}


	public void setSRD(ScoreresultDao sRD) {
		SRD = sRD;
	}
	

	public EButtonDao getEBD() {
		return EBD;
	}


	public void setEBD(EButtonDao eBD) {
		EBD = eBD;
	}

	//管理员首页饼图
	public String Pie(){
		System.out.println("CHART SUCCESS");
		int compilited=0;
		List<Scoreresult> SRL=new ArrayList();
		SRL=SRD.getTable();
		for(int i=0;i<SRL.size();i++){
			if(SRL.get(i).getAllScore().equals("0")){
				
			}else{
				compilited++;
			}
		}
		int NumAll=TMD.getTable("教师").size()+TMD.getTable("辅导员").size()+TMD.getTable("教辅").size()+TMD.getTable("管理组").size();
		int uncompilited=NumAll-compilited;
		CR=new ChartNum();
		NumList=new ArrayList();
		CR.setID(1);
		CR.setTeacher(TMD.getTable("教师").size());
		CR.setInstructor(TMD.getTable("辅导员").size());
		CR.setAssistant(TMD.getTable("教辅").size());
		CR.setAdministrator(TMD.getTable("管理组").size());
		CR.setComplited(compilited);
		CR.setUncomplited(uncompilited);
		CD.updaterowcol(CR);
		NumList=CD.getNum();
		
		JSONArray json = JSONArray.fromObject(NumList);
		result = json.toString();
		return SUCCESS;
	}
	
	//管理员首页考核状态
	public String Type(){
		
		List<EButton> EBL=new ArrayList();
		EBL=EBD.getTable();
		List RL=new ArrayList();
		if(EBL.get(0).getAllCheck().equals("T")){
			RL.add("已开启");
		}else{
			RL.add("未开启");
		}

		JSONArray json = JSONArray.fromObject(RL);
		result = json.toString();
		return SUCCESS;
	}
}
