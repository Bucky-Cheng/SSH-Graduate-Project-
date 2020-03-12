package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.QualityDao;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.dao.TeacherQSDao;
import com.ssh.model.Quality;
import com.ssh.model.TeacherQS;

import net.sf.json.JSONArray;

public class QualityAction extends ActionSupport {
	
	private String Type;
	private String result;
	public String SaveQ;
	public String PreT;
	public String QualityContent;
	@Autowired
	private QualityDao QLD;
	@Autowired
	private TeacherMDao TMD;
	@Autowired
	private TeacherQSDao TQD;

	
	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSaveQ() {
		return SaveQ;
	}

	public void setSaveQ(String saveQ) {
		SaveQ = saveQ;
	}

	public QualityDao getQLD() {
		return QLD;
	}

	public void setQLD(QualityDao qLD) {
		QLD = qLD;
	}
	
	public String getPreT() {
		return PreT;
	}

	public void setPreT(String preT) {
		PreT = preT;
	}
	public TeacherMDao getTMD() {
		return TMD;
	}

	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}

	//获取权重列表
	public String getTable(){
		
		List<Quality> QLL=new ArrayList();
		QLL=QLD.getQualityByType(Type);
		List returnList=new ArrayList();
		String[] edu=QLL.get(0).getEducation().split("-");
		returnList.add(edu[0]);
		returnList.add(edu[1]);
		String[] rea=QLL.get(0).getResearch().split("-");
		returnList.add(rea[0]);
		returnList.add(rea[1]);
		String[] ser=QLL.get(0).getServe().split("-");
		returnList.add(ser[0]);
		returnList.add(ser[1]);
		String[] ass=QLL.get(0).getAssistant().split("-");
		returnList.add(ass[0]);
		returnList.add(ass[1]);
		JSONArray json = JSONArray.fromObject(returnList);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存权重
	public String Save(){
		
		String updateHql="update Quality  set "+PreT+"='"+SaveQ+ "' where Type ='"+Type+"'";
		QLD.updateQuality(updateHql);
		System.out.println("SAVEQ:"+SaveQ);
		List aaa=new ArrayList();
		aaa.add("aaa");
		JSONArray json = JSONArray.fromObject(aaa);
		result = json.toString();
		return SUCCESS;
	}
	
	//获取教学表权重
	public String getEdu(){
		//获取教师类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		List<Quality> QL=new ArrayList();
		QL=QLD.getQualityByType(Type);
		JSONArray json = JSONArray.fromObject(QL);
		result = json.toString();
		return SUCCESS;
	}
	
	//获取相应部门的权重
	public String getEduCon(){
		//获取教师类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		List<TeacherQS> QS=new ArrayList();
		QS=TQD.getTableByTID(TeacherID);
		JSONArray json = JSONArray.fromObject(QS);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存选择教学表的权重
	public String saveEdu(){
		//获取教师类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		System.out.println("TYPE:"+Type);
		List<TeacherQS> TQL=new ArrayList();
		TeacherQS TQ=new TeacherQS();
		TQL=TQD.getTableByTID(TeacherID);
		TQ=TQL.get(0);
		String quality=QualityContent;
		String Num=QualityContent;
		if(QualityContent.contains("%")){
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getEducation().replace("%", "");
			
			String[] TNum=tackleNum.split("-");
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
		}else{
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getEducation().replace("%", "");
			System.out.println("MAX:"+tackleNum);
			String[] TNum=tackleNum.split("-");
			System.out.println("MAX:"+TNum[1]);
			if(Integer.parseInt(QualityContent)<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent)>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
			quality=QualityContent+"%";
		}
		
		TQ.setEduQuality(quality);
		TQD.updateNoticeID(TQ);
		List<TeacherQS> QS=new ArrayList();
		QS=TQD.getTableByTID(TeacherID);
		JSONArray json = JSONArray.fromObject(QS);
		result = json.toString();
		return SUCCESS;
	}
	
	//教辅

	public String saveAss(){
		//获取教师类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		System.out.println("TYPE:"+Type);
		List<TeacherQS> TQL=new ArrayList();
		TeacherQS TQ=new TeacherQS();
		TQL=TQD.getTableByTID(TeacherID);
		TQ=TQL.get(0);
		String quality=QualityContent;
		String Num=QualityContent;
		if(QualityContent.contains("%")){
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getAssistant().replace("%", "");
			
			String[] TNum=tackleNum.split("-");
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
		}else{
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getAssistant().replace("%", "");
			System.out.println("MAX:"+tackleNum);
			String[] TNum=tackleNum.split("-");
			System.out.println("MAX:"+TNum[1]);
			if(Integer.parseInt(QualityContent)<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent)>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
			quality=QualityContent+"%";
		}
		
		TQ.setAssQuality(quality);
		TQD.updateNoticeID(TQ);
		List<TeacherQS> QS=new ArrayList();
		QS=TQD.getTableByTID(TeacherID);
		JSONArray json = JSONArray.fromObject(QS);
		result = json.toString();
		return SUCCESS;
	}
	
	//研究
	public String saveRea(){
		//获取教师类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		System.out.println("TYPE:"+Type);
		List<TeacherQS> TQL=new ArrayList();
		TeacherQS TQ=new TeacherQS();
		TQL=TQD.getTableByTID(TeacherID);
		TQ=TQL.get(0);
		String quality=QualityContent;
		String Num=QualityContent;
		if(QualityContent.contains("%")){
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getResearch().replace("%", "");
			
			String[] TNum=tackleNum.split("-");
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
		}else{
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getResearch().replace("%", "");
			System.out.println("MAX:"+tackleNum);
			String[] TNum=tackleNum.split("-");
			System.out.println("MAX:"+TNum[1]);
			if(Integer.parseInt(QualityContent)<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent)>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
			quality=QualityContent+"%";
		}
		
		TQ.setReaQuality(quality);
		TQD.updateNoticeID(TQ);
		List<TeacherQS> QS=new ArrayList();
		QS=TQD.getTableByTID(TeacherID);
		JSONArray json = JSONArray.fromObject(QS);
		result = json.toString();
		return SUCCESS;
	}
	
	//服务
	public String saveSer(){
		//获取教师类别
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		System.out.println("TYPE:"+Type);
		List<TeacherQS> TQL=new ArrayList();
		TeacherQS TQ=new TeacherQS();
		TQL=TQD.getTableByTID(TeacherID);
		TQ=TQL.get(0);
		String quality=QualityContent;
		String Num=QualityContent;
		if(QualityContent.contains("%")){
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getServe().replace("%", "");
			
			String[] TNum=tackleNum.split("-");
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent.substring(0, QualityContent.length()-1))>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
		}else{
			List<Quality> QL=new ArrayList();
			QL=QLD.getQualityByType(Type);
			String tackleNum=QL.get(0).getServe().replace("%", "");
			System.out.println("MAX:"+tackleNum);
			String[] TNum=tackleNum.split("-");
			System.out.println("MAX:"+TNum[1]);
			if(Integer.parseInt(QualityContent)<Integer.parseInt(TNum[0])){
				QualityContent=TNum[0];
			}
			if(Integer.parseInt(QualityContent)>Integer.parseInt(TNum[1])){
				QualityContent=TNum[1];
			}
			quality=QualityContent+"%";
		}
		
		TQ.setSerQuality(quality);
		TQD.updateNoticeID(TQ);
		List<TeacherQS> QS=new ArrayList();
		QS=TQD.getTableByTID(TeacherID);
		JSONArray json = JSONArray.fromObject(QS);
		result = json.toString();
		return SUCCESS;
	}
}
