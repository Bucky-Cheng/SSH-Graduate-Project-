package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.assistantTableDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.assistantTable;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.serveTable;

public class AssUD extends ActionSupport{

	
	private List<assistantTable> assList;
	private List<assistantTable> assistantList;
	private assistantTable at;
	@Autowired
	private assistantTableDao ATD;
	
	public AssUD(){
		
	}
	
	


	public List<assistantTable> getAssList() {
		return assList;
	}




	public void setAssList(List<assistantTable> assList) {
		this.assList = assList;
	}




	public List<assistantTable> getAssistantList() {
		return assistantList;
	}




	public void setAssistantList(List<assistantTable> assistantList) {
		this.assistantList = assistantList;
	}




	public assistantTable getAt() {
		return at;
	}




	public void setAt(assistantTable at) {
		this.at = at;
	}




	public assistantTableDao getATD() {
		return ATD;
	}




	public void setATD(assistantTableDao aTD) {
		ATD = aTD;
	}




	public String execute() throws Exception{
		assList=ATD.getTable();
		assistantList=new ArrayList();
		
		System.out.println("1+"+assistantList.size());
		for(int p=assList.size()-1;p>=0;p--){
			at=assList.get(p);
			
			if(p<=assList.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(at.getName());
			if(isNum.matches()){
				assList.remove(at);
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
					if(NameNum==1&&(!assList.get(q).getName().equals("s1"))){
						assistantList.remove(assList.get(q));
					}
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
			session.put("asslist1", returnList);
			
			
			  //JSONObject json = JSONObject.fromObject(educationList);
			  //result = json.toString();  
			//System.out.println(result);
			return SUCCESS;
		}
}
