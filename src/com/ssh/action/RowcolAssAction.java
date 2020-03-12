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
import com.ssh.model.rowcol;
import com.ssh.model.rowcolAss;
import com.ssh.model.rowcolRea;
import com.ssh.model.rowcolSer;
import com.ssh.model.serveTable;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RowcolAssAction extends ActionSupport{

	
	private List<assistantTable> assistantList;
	private List<rowcolAss> A1;
	private String result;
	private List<assistantTable> assList;
	private List endRowcolList;
	
	
	@Autowired
	private RowcolAssDao RAD;
	@Autowired
	private assistantTableDao ATD;
	private assistantTable At;
	public RowcolAssAction(){
		
	}
	
	
	
	
	public List<assistantTable> getAssistantList() {
		return assistantList;
	}




	public void setAssistantList(List<assistantTable> assistantList) {
		this.assistantList = assistantList;
	}




	public List<rowcolAss> getA1() {
		return A1;
	}




	public void setA1(List<rowcolAss> a1) {
		A1 = a1;
	}




	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public List<assistantTable> getAssList() {
		return assList;
	}




	public void setAssList(List<assistantTable> assList) {
		this.assList = assList;
	}




	public List getEndRowcolList() {
		return endRowcolList;
	}




	public void setEndRowcolList(List endRowcolList) {
		this.endRowcolList = endRowcolList;
	}




	public RowcolAssDao getRAD() {
		return RAD;
	}




	public void setRAD(RowcolAssDao rAD) {
		RAD = rAD;
	}




	public assistantTableDao getATD() {
		return ATD;
	}




	public void setATD(assistantTableDao aTD) {
		ATD = aTD;
	}




	public assistantTable getAt() {
		return At;
	}




	public void setAt(assistantTable at) {
		At = at;
	}




	public String execute() throws Exception{
		assList=ATD.getTable();
		assistantList=new ArrayList();
		A1=RAD.getCombination();
		System.out.println("1+"+assistantList.size());
		for(int p=assList.size()-1;p>=0;p--){
			At=assList.get(p);
			
			if(p<=assList.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(At.getName());
			if(isNum.matches()){
				assList.remove(At);
			}else{
				
			}
			}
		}
		List<assistantTable> tempList=new ArrayList();
		for(int t=0;t<assList.size();t++){
			tempList.add(assList.get(t));
		}
		for(int q=0;q<assList.size();q++){
			String head=assList.get(q).getName().substring(0,1);
			int NameNum=Integer.parseInt(assList.get(q).getName().substring(1, 2));
			if(NameNum==1){
				assistantList.add(assList.get(q));
			}
			for(int w=0;w<tempList.size();w++){
				String headW=tempList.get(w).getName().substring(0, 1);
				String nameW=tempList.get(w).getName();
				if(head.equals(headW)&&(!assList.get(q).getName().equals(nameW))){
					assistantList.add(tempList.get(w));
					assistantTable temp=new assistantTable();
					temp=tempList.get(w);
					assList.remove(temp);
				}
			}
		}
			System.out.println("aaaaaaaaaaaa");
			for(int i=0;i<assistantList.size();i++){
				System.out.println(assistantList.get(i).getName());
			}
			List returnList=new ArrayList();
			for(int q=0;q<assistantList.size();q++){
				returnList.add(assistantList.get(q).getName());
			}
			System.out.println("====================================================");
			for(int w=0;w<returnList.size();w++){
				System.out.println(returnList.get(w));
			}
			System.out.println("====================================================");
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> session = actionContext.getSession(); 
			session.put("asslist", returnList);
			
			
			  //JSONObject json = JSONObject.fromObject(educationList);
			  //result = json.toString();  
			//System.out.println(result);
			return SUCCESS;
		}
	
}
