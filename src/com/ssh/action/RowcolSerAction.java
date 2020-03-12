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
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.RowcolSerDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.rowcol;
import com.ssh.model.rowcolRea;
import com.ssh.model.rowcolSer;
import com.ssh.model.serveTable;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RowcolSerAction extends ActionSupport{

	
	private List<serveTable> serveList;
	private List<rowcolSer> R1;
	private String result;
	private List<serveTable> serList;
	private List endRowcolList;
	
	
	@Autowired
	private RowcolSerDao RSD;
	@Autowired
	private serveTableDao STD;
	private serveTable St;
	public RowcolSerAction(){
		
	}
	
	
	
	public List<serveTable> getServeList() {
		return serveList;
	}



	public void setServeList(List<serveTable> serveList) {
		this.serveList = serveList;
	}



	public List<rowcolSer> getR1() {
		return R1;
	}



	public void setR1(List<rowcolSer> r1) {
		R1 = r1;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public List<serveTable> getSerList() {
		return serList;
	}



	public void setSerList(List<serveTable> serList) {
		this.serList = serList;
	}



	public List getEndRowcolList() {
		return endRowcolList;
	}



	public void setEndRowcolList(List endRowcolList) {
		this.endRowcolList = endRowcolList;
	}



	public RowcolSerDao getRSD() {
		return RSD;
	}



	public void setRSD(RowcolSerDao rSD) {
		RSD = rSD;
	}



	public serveTableDao getSTD() {
		return STD;
	}



	public void setSTD(serveTableDao sTD) {
		STD = sTD;
	}



	public serveTable getSt() {
		return St;
	}



	public void setSt(serveTable st) {
		St = st;
	}



	public String execute() throws Exception{
		serList=STD.getTable();
		serveList=new ArrayList();
		R1=RSD.getCombination();
		System.out.println("1+"+serveList.size());
		for(int p=serList.size()-1;p>=0;p--){
			St=serList.get(p);
			
			if(p<=serList.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(St.getName());
			if(isNum.matches()){
				serList.remove(St);
			}else{
				
			}
			}
		}
		List<serveTable> tempList=new ArrayList();
		for(int t=0;t<serList.size();t++){
			tempList.add(serList.get(t));
		}
		for(int q=0;q<serList.size();q++){
			String head=serList.get(q).getName().substring(0,1);
			int NameNum=Integer.parseInt(serList.get(q).getName().substring(1, 2));
			if(NameNum==1){
				serveList.add(serList.get(q));
			}
			for(int w=0;w<tempList.size();w++){
				String headW=tempList.get(w).getName().substring(0, 1);
				String nameW=tempList.get(w).getName();
				if(head.equals(headW)&&(!serList.get(q).getName().equals(nameW))){
					serveList.add(tempList.get(w));
					serveTable temp=new serveTable();
					temp=tempList.get(w);
					serList.remove(temp);
				}
			}
		}
			System.out.println("aaaaaaaaaaaa");
			for(int i=0;i<serveList.size();i++){
				System.out.println(serveList.get(i).getName());
			}
			List returnList=new ArrayList();
			for(int q=0;q<serveList.size();q++){
				returnList.add(serveList.get(q).getName());
			}
			System.out.println("====================================================");
			for(int w=0;w<returnList.size();w++){
				System.out.println(returnList.get(w));
			}
			System.out.println("====================================================");
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> session = actionContext.getSession(); 
			session.put("serlist", returnList);
			
			
			  //JSONObject json = JSONObject.fromObject(educationList);
			  //result = json.toString();  
			//System.out.println(result);
			return SUCCESS;
		}
	
}
