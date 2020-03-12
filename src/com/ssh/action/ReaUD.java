package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;

public class ReaUD extends ActionSupport{

	
	private List<researchTable> reaList;
	private List<researchTable> researchList;
	private researchTable rt;
	@Autowired
	private researchTableDao RTD;
	
	public ReaUD(){
		
	}

	public List<researchTable> getReaList() {
		return reaList;
	}









	public void setReaList(List<researchTable> reaList) {
		this.reaList = reaList;
	}









	public List<researchTable> getResearchList() {
		return researchList;
	}









	public void setResearchList(List<researchTable> researchList) {
		this.researchList = researchList;
	}









	public researchTable getRt() {
		return rt;
	}









	public void setRt(researchTable rt) {
		this.rt = rt;
	}









	public researchTableDao getRTD() {
		return RTD;
	}









	public void setRTD(researchTableDao rTD) {
		RTD = rTD;
	}









	public String execute() throws Exception{
		reaList=RTD.getTable();
		researchList=new ArrayList();
		
		System.out.println("1+"+researchList.size());
		for(int p=reaList.size()-1;p>=0;p--){
			rt=reaList.get(p);
			
			if(p<=reaList.size()){
				Pattern pattern = Pattern.compile("[0-9]*");
		           Matcher isNum = pattern.matcher(rt.getName());
			if(isNum.matches()){
				reaList.remove(rt);
			}else{
				
			}
			}
		}
		List<researchTable> tempList=new ArrayList();
		for(int t=0;t<reaList.size();t++){
			tempList.add(reaList.get(t));
		}
		for(int q=0;q<reaList.size();q++){
			String head=reaList.get(q).getName().substring(0,1);
			int NameNum=Integer.parseInt(reaList.get(q).getName().substring(1, 2));
			if(NameNum==1){
				researchList.add(reaList.get(q));
			}
			for(int w=0;w<tempList.size();w++){
				String headW=tempList.get(w).getName().substring(0, 1);
				String nameW=tempList.get(w).getName();
				if(head.equals(headW)&&(!reaList.get(q).getName().equals(nameW))){
					if(NameNum==1&&(!reaList.get(q).getName().equals("s1"))){
						researchList.remove(reaList.get(q));
					}
					researchList.add(tempList.get(w));
					researchTable temp=new researchTable();
					temp=tempList.get(w);
					reaList.remove(temp);
				}
			}
		}
			System.out.println("aaaaaaaaaaaa");
			for(int i=0;i<researchList.size();i++){
				System.out.println(researchList.get(i).getName());
			}
			List returnList=new ArrayList();
			for(int q=0;q<researchList.size();q++){
				returnList.add(researchList.get(q).getName());
			}
			System.out.println("====================================================");
			for(int w=0;w<returnList.size();w++){
				System.out.println(returnList.get(w));
			}
			System.out.println("====================================================");
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> session = actionContext.getSession(); 
			session.put("realist1", returnList);
			
			
			  //JSONObject json = JSONObject.fromObject(educationList);
			  //result = json.toString();  
			//System.out.println(result);
			return SUCCESS;
		}
}
