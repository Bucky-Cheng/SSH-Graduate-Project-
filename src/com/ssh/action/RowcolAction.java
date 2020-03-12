package com.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.educationTableDao;
import com.ssh.model.educationTable;
import com.ssh.model.rowcol;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RowcolAction extends ActionSupport{

	
	private List<educationTable> educationList;
	private List<rowcol> R1;
	private String result;
	private List<educationTable> eduList;
	private List endRowcolList;
	
	
	@Autowired
	private RowcolDao RD;
	@Autowired
	private educationTableDao ETD;
	private educationTable et;
	public RowcolAction(){
		
	}
	
	
	public RowcolDao getRD() {
		return RD;
	}
	public void setRD(RowcolDao rD) {
		RD = rD;
	}
	public List getEducationList() {
		return educationList;
	}
	

	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	public educationTableDao getETD() {
		return ETD;
	}


	public void setETD(educationTableDao eTD) {
		ETD = eTD;
	}
	

	


	public List<educationTable> getEduList() {
		return eduList;
	}


	public void setEduList(List<educationTable> eduList) {
		this.eduList = eduList;
	}


	public educationTable getEt() {
		return et;
	}


	public void setEt(educationTable et) {
		this.et = et;
	}


	public void setEducationList(List<educationTable> educationList) {
		this.educationList = educationList;
	}
	

	public List<rowcol> getR1() {
		return R1;
	}


	public void setR1(List<rowcol> r1) {
		R1 = r1;
	}


	public List getEndRowcolList() {
		return endRowcolList;
	}


	public void setEndRowcolList(List endRowcolList) {
		this.endRowcolList = endRowcolList;
	}


	public String execute() throws Exception{
		eduList=ETD.getTable();
		educationList=new ArrayList();
		R1=RD.getCombination();
		System.out.println("1+"+educationList.size());
		for(int p=eduList.size()-1;p>=0;p--){
			et=eduList.get(p);
			
			if(p<=eduList.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(et.getName());
			if(isNum.matches()){
				eduList.remove(et);
			}else{
				
			}
			}
		}
		List<educationTable> tempList=new ArrayList();
		for(int t=0;t<eduList.size();t++){
			tempList.add(eduList.get(t));
		}
		for(int q=0;q<eduList.size();q++){
			String head=eduList.get(q).getName().substring(0,1);
			int NameNum=Integer.parseInt(eduList.get(q).getName().substring(1, 2));
			if(NameNum==1){
				educationList.add(eduList.get(q));
			}
			for(int w=0;w<tempList.size();w++){
				String headW=tempList.get(w).getName().substring(0, 1);
				String nameW=tempList.get(w).getName();
				if(head.equals(headW)&&(!eduList.get(q).getName().equals(nameW))){
					educationList.add(tempList.get(w));
					educationTable temp=new educationTable();
					temp=tempList.get(w);
					eduList.remove(temp);
				}
			}
		}
			System.out.println("aaaaaaaaaaaa");
			for(int i=0;i<educationList.size();i++){
				System.out.println(educationList.get(i).getName());
			}
			List returnList=new ArrayList();
			for(int q=0;q<educationList.size();q++){
				returnList.add(educationList.get(q).getName());
			}
			System.out.println("====================================================");
			for(int w=0;w<returnList.size();w++){
				System.out.println(returnList.get(w));
			}
			System.out.println("====================================================");
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> session = actionContext.getSession(); 
			session.put("list", returnList);
			
			
			  //JSONObject json = JSONObject.fromObject(educationList);
			  //result = json.toString();  
			//System.out.println(result);
			return SUCCESS;
		}
	
}
