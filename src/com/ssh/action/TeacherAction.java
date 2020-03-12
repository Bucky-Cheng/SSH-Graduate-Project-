package com.ssh.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AssScoreDao;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.ReaScoreDao;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.SerScoreDao;
import com.ssh.dao.TeacherQSDao;
import com.ssh.dao.assistantTableDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.EduScore;
import com.ssh.model.TeacherQS;
import com.ssh.model.assistantScore;
import com.ssh.model.assistantTable;
import com.ssh.model.educationTable;
import com.ssh.model.researchScore;
import com.ssh.model.researchTable;
import com.ssh.model.serveScore;
import com.ssh.model.serveTable;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class TeacherAction extends ActionSupport{

	private String name;
	private String content;
	private String result;
	private EduScore ES;
	private researchScore RS;
	private serveScore SS;
	private assistantScore AS;
	@Autowired
	private EduScoreDao ESD;
	@Autowired
	private ReaScoreDao RSD;
	@Autowired
	private SerScoreDao SSD;
	@Autowired
	private AssScoreDao ASSD;
	@Autowired
	private educationTableDao ETD;
	@Autowired
	private researchTableDao RTD;
	@Autowired
	private serveTableDao STD;
	@Autowired
	private assistantTableDao ATD;
	@Autowired
	private TeacherQSDao TSD;
	
	public TeacherAction(){
		
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



	public EduScore getES() {
		return ES;
	}



	public void setES(EduScore eS) {
		ES = eS;
	}



	public EduScoreDao getESD() {
		return ESD;
	}



	public void setESD(EduScoreDao eSD) {
		ESD = eSD;
	}



	public educationTableDao getETD() {
		return ETD;
	}



	public void setETD(educationTableDao eTD) {
		ETD = eTD;
	}
	


	public researchScore getRS() {
		return RS;
	}

	public void setRS(researchScore rS) {
		RS = rS;
	}

	public ReaScoreDao getRSD() {
		return RSD;
	}

	public void setRSD(ReaScoreDao rSD) {
		RSD = rSD;
	}

	public researchTableDao getRTD() {
		return RTD;
	}

	public void setRTD(researchTableDao rTD) {
		RTD = rTD;
	}
	
	
	
	public serveScore getSS() {
		return SS;
	}

	public void setSS(serveScore sS) {
		SS = sS;
	}

	public SerScoreDao getSSD() {
		return SSD;
	}

	public void setSSD(SerScoreDao sSD) {
		SSD = sSD;
	}

	public serveTableDao getSTD() {
		return STD;
	}

	public void setSTD(serveTableDao sTD) {
		STD = sTD;
	}
	
	
	
	public assistantScore getAS() {
		return AS;
	}

	public void setAS(assistantScore aS) {
		AS = aS;
	}

	public AssScoreDao getASSD() {
		return ASSD;
	}

	public void setASSD(AssScoreDao aSSD) {
		ASSD = aSSD;
	}

	public assistantTableDao getATD() {
		return ATD;
	}

	public void setATD(assistantTableDao aTD) {
		ATD = aTD;
	}
	
	public TeacherQSDao getTSD() {
		return TSD;
	}

	public void setTSD(TeacherQSDao tSD) {
		TSD = tSD;
	}

	//��ѧ�����
	public String EduScore(){
		try{
			//��ȡteacherID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			//��ȡ��ʼ����
			List<educationTable> tempList=new ArrayList();
			tempList=ETD.getTable();
			String initialHql="select "+name+" from EduScore where TeacherID='"+TID+"'";
			String TinitialScore=ESD.queryScore(initialHql);
			String initialScore=TinitialScore.substring(1, TinitialScore.length()-1);
			String EduAll=TSD.getTableByTID(TID).get(0).getEduScore();
			//��ȡ�ܷ���
			System.out.println("NAMENAMENAME:"+name);
			String headName=name.substring(0, 1);
			String AllName=headName+"0";
			System.out.println("Allname:"+AllName+"teacher ID:"+TID);
			String hqlAll="select "+AllName+" from EduScore where TeacherID='"+TID+"'";
			String Alltemp=ESD.queryScore(hqlAll);
			String AllScore=Alltemp.substring(1, Alltemp.length()-1);
			int NewAllEdu=Integer.parseInt(EduAll)-Integer.parseInt(AllScore);
			System.out.println(AllScore);
			//��ȡ���з���
			List ScoreNameList=new ArrayList();
			List<educationTable> AllNameList=new ArrayList();
			AllNameList=ETD.getTable();
			for(int i=0;i<AllNameList.size();i++){
				if(AllNameList.get(i).getName().contains(headName)){
					if(AllNameList.get(i).getName().equals(name.subSequence(0, name.length()-1))){
						
					}else{
					ScoreNameList.add(AllNameList.get(i).getName()+"s");
					}
				}
			}
			
			
			//��ȡ��������
			String getScoreName=name.substring(0, name.length()-1);
			String getScoreHql="select score from educationTable where name='"+getScoreName+"'";
			String MaxScoreTemp=ETD.queryScore(getScoreHql);
			System.out.println("space MaxScore:"+MaxScoreTemp);
			String MaxScore=MaxScoreTemp.substring(1, MaxScoreTemp.length()-1);
			String MaxAllName=headName+"1";
			String getAllScoreHql="select AllScore from educationTable where name='"+MaxAllName+"'";
			String MaxAllScoreTemp=ETD.queryScore(getAllScoreHql);
			String MaxAllScore=MaxAllScoreTemp.substring(1, MaxAllScoreTemp.length()-1);
			//�жϷ���
			System.out.println("space content:"+content);
			System.out.println("space MaxScore:"+MaxScore);
			if(Integer.parseInt(content)>Integer.parseInt(MaxScore)){
				content=MaxScore;
			}
			
			//�ύ�·���
			String updateHql="update EduScore  set "+name+"="+content+ "where TeacherID ="+TID;
			ESD.updateEduScore(updateHql);
			
			List ScoreList=new ArrayList();
			for(int a=0;a<ScoreNameList.size();a++){
				String GetScoreHql="select "+ScoreNameList.get(a)+" from EduScore where TeacherID='"+TID+"'";
				String EveryTemp=ESD.queryScore(GetScoreHql);
				String EveryScore=EveryTemp.substring(1, EveryTemp.length()-1);
				ScoreList.add(EveryScore);
			}
			//���㲢�ύ�µ��ܷ�
			String AfterScore=content;
			for(int b=0;b<ScoreList.size();b++){
				AfterScore=String.valueOf(Integer.parseInt(AfterScore)+Integer.parseInt((String) ScoreList.get(b)));
			}
			if(Integer.parseInt(AfterScore)>Integer.parseInt(MaxAllScore)){
				AfterScore=MaxAllScore;
			}
			String ScoreUpdate="update EduScore  set "+AllName+"="+AfterScore+ "where TeacherID ="+TID;
			ESD.updateEduScore(ScoreUpdate);
			int EduAllNum=Integer.parseInt(AfterScore)+NewAllEdu;
			if(EduAllNum>100){
				EduAllNum=100;
			}
			if(EduAllNum<0){
				EduAllNum=0;
			}
			TeacherQS TQ=new TeacherQS();
			TQ=TSD.getTableByTID(TID).get(0);
			TQ.setEduScore(String.valueOf(EduAllNum));
			TSD.updateNoticeID(TQ);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	}
	
	//�о������
	public String ReaScore(){
		try{
			//��ȡteacherID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			//��ȡ��ʼ����
			List<researchTable> tempList=new ArrayList();
			tempList=RTD.getTable();
			String initialHql="select "+name+" from researchScore where TeacherID='"+TID+"'";
			String TinitialScore=RSD.queryScore(initialHql);
			String initialScore=TinitialScore.substring(1, TinitialScore.length()-1);
			String EduAll=TSD.getTableByTID(TID).get(0).getReaScore();
			//��ȡ�ܷ���
			String headName=name.substring(0, 1);
			String AllName=headName+"0";
			System.out.println("Allname:"+AllName+"teacher ID:"+TID);
			String hqlAll="select "+AllName+" from researchScore where TeacherID='"+TID+"'";
			String Alltemp=RSD.queryScore(hqlAll);
			String AllScore=Alltemp.substring(1, Alltemp.length()-1);
			int NewAllEdu=Integer.parseInt(EduAll)-Integer.parseInt(AllScore);
			System.out.println(AllScore);
			//��ȡ���з���
			List ScoreNameList=new ArrayList();
			List<researchTable> AllNameList=new ArrayList();
			AllNameList=RTD.getTable();
			for(int i=0;i<AllNameList.size();i++){
				if(AllNameList.get(i).getName().contains(headName)){
					ScoreNameList.add(AllNameList.get(i).getName()+"s");
				}
			}
			System.out.println("Search Name:"+ScoreNameList.get(0));
		
			//��ȡ��������
			String getScoreName=name.substring(0, name.length()-1);
			String getScoreHql="select score from researchTable where name='"+getScoreName+"'";
			String MaxScoreTemp=RTD.queryScore(getScoreHql);
			System.out.println("space MaxScore:"+MaxScoreTemp);
			String MaxScore=MaxScoreTemp.substring(1, MaxScoreTemp.length()-1);
			String MaxAllName=headName+"1";
			String getAllScoreHql="select AllScore from researchTable where name='"+MaxAllName+"'";
			String MaxAllScoreTemp=RTD.queryScore(getAllScoreHql);
			String MaxAllScore=MaxAllScoreTemp.substring(1, MaxAllScoreTemp.length()-1);
			//�жϷ���
			System.out.println("space content:"+content);
			System.out.println("space MaxScore:"+MaxScore);
			if(Integer.parseInt(content)>Integer.parseInt(MaxScore)){
				content=MaxScore;
			}
			
			//�ύ�·���
			String updateHql="update researchScore  set "+name+"="+content+ "where TeacherID ="+TID;
			RSD.updateEduScore(updateHql);
			
			List ScoreList=new ArrayList();
			for(int a=0;a<ScoreNameList.size();a++){
				String GetScoreHql="select "+ScoreNameList.get(a)+" from researchScore where TeacherID='"+TID+"'";
				String EveryTemp=RSD.queryScore(GetScoreHql);
				String EveryScore=EveryTemp.substring(1, EveryTemp.length()-1);
				ScoreList.add(EveryScore);
			}
			//���㲢�ύ�µ��ܷ�
			String AfterScore="0";
			for(int b=0;b<ScoreList.size();b++){
				AfterScore=String.valueOf(Integer.parseInt(AfterScore)+Integer.parseInt((String) ScoreList.get(b)));
			}
			if(Integer.parseInt(AfterScore)>Integer.parseInt(MaxAllScore)){
				AfterScore=MaxAllScore;
			}
			String ScoreUpdate="update researchScore  set "+AllName+"="+AfterScore+ "where TeacherID ="+TID;
			RSD.updateEduScore(ScoreUpdate);
			int EduAllNum=Integer.parseInt(AfterScore)+NewAllEdu;
			if(EduAllNum>100){
				EduAllNum=100;
			}
			if(EduAllNum<0){
				EduAllNum=0;
			}
			TeacherQS TQ=new TeacherQS();
			TQ=TSD.getTableByTID(TID).get(0);
			TQ.setReaScore(String.valueOf(EduAllNum));
			TSD.updateNoticeID(TQ);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	}
	
	//��������
	public String SerScore(){
		try{
			//��ȡteacherID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			//��ȡ��ʼ����
			List<serveTable> tempList=new ArrayList();
			tempList=STD.getTable();
			String initialHql="select "+name+" from serveScore where TeacherID='"+TID+"'";
			String TinitialScore=SSD.queryScore(initialHql);
			String initialScore=TinitialScore.substring(1, TinitialScore.length()-1);
			String EduAll=TSD.getTableByTID(TID).get(0).getSerScore();
			//��ȡ�ܷ���
			String headName=name.substring(0, 1);
			String AllName=headName+"0";
			System.out.println("Allname:"+AllName+"teacher ID:"+TID);
			String hqlAll="select "+AllName+" from serveScore where TeacherID='"+TID+"'";
			String Alltemp=SSD.queryScore(hqlAll);
			String AllScore=Alltemp.substring(1, Alltemp.length()-1);
			int NewAllEdu=Integer.parseInt(EduAll)-Integer.parseInt(AllScore);
			System.out.println(AllScore);
			//��ȡ���з���
			List ScoreNameList=new ArrayList();
			List<serveTable> AllNameList=new ArrayList();
			AllNameList=STD.getTable();
			for(int i=0;i<AllNameList.size();i++){
				if(AllNameList.get(i).getName().contains(headName)){
					ScoreNameList.add(AllNameList.get(i).getName()+"s");
				}
			}
			
			
			//��ȡ��������
			String getScoreName=name.substring(0, name.length()-1);
			String getScoreHql="select score from serveTable where name='"+getScoreName+"'";
			String MaxScoreTemp=STD.queryScore(getScoreHql);
			System.out.println("space MaxScore:"+MaxScoreTemp);
			String MaxScore=MaxScoreTemp.substring(1, MaxScoreTemp.length()-1);
			String MaxAllName=headName+"1";
			String getAllScoreHql="select AllScore from serveTable where name='"+MaxAllName+"'";
			String MaxAllScoreTemp=STD.queryScore(getAllScoreHql);
			String MaxAllScore=MaxAllScoreTemp.substring(1, MaxAllScoreTemp.length()-1);
			//�жϷ���
			System.out.println("space content:"+content);
			System.out.println("space MaxScore:"+MaxScore);
			if(Integer.parseInt(content)>Integer.parseInt(MaxScore)){
				content=MaxScore;
			}
			
			//�ύ�·���
			String updateHql="update serveScore  set "+name+"="+content+ "where TeacherID ="+TID;
			SSD.updateEduScore(updateHql);
			
			List ScoreList=new ArrayList();
			for(int a=0;a<ScoreNameList.size();a++){
				String GetScoreHql="select "+ScoreNameList.get(a)+" from serveScore where TeacherID='"+TID+"'";
				String EveryTemp=SSD.queryScore(GetScoreHql);
				String EveryScore=EveryTemp.substring(1, EveryTemp.length()-1);
				ScoreList.add(EveryScore);
			}
			//���㲢�ύ�µ��ܷ�
			String AfterScore="0";
			for(int b=0;b<ScoreList.size();b++){
				AfterScore=String.valueOf(Integer.parseInt(AfterScore)+Integer.parseInt((String) ScoreList.get(b)));
			}
			if(Integer.parseInt(AfterScore)>Integer.parseInt(MaxAllScore)){
				AfterScore=MaxAllScore;
			}
			String ScoreUpdate="update serveScore  set "+AllName+"="+AfterScore+ "where TeacherID ="+TID;
			SSD.updateEduScore(ScoreUpdate);
			int EduAllNum=Integer.parseInt(AfterScore)+NewAllEdu;
			if(EduAllNum>100){
				EduAllNum=100;
			}
			if(EduAllNum<0){
				EduAllNum=0;
			}
			System.out.print("AAAAAAAAAAAAAAAAAAAAAAAAAA+"+EduAllNum);
			System.out.print("AAAAAAAAAAAAAAAAAAAAAAAAAA+");
			TeacherQS TQ=new TeacherQS();
			TQ=TSD.getTableByTID(TID).get(0);
			TQ.setSerScore(String.valueOf(EduAllNum));
			TSD.updateNoticeID(TQ);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	}
	
	//�̸������
	public String AssScore(){
		try{
			//��ȡteacherID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			//��ȡ��ʼ����
			List<assistantTable> tempList=new ArrayList();
			tempList=ATD.getTable();
			String initialHql="select "+name+" from assistantScore where TeacherID='"+TID+"'";
			String TinitialScore=ASSD.queryScore(initialHql);
			String initialScore=TinitialScore.substring(1, TinitialScore.length()-1);
			String EduAll=TSD.getTableByTID(TID).get(0).getAssScore();
			//��ȡ�ܷ���
			String headName=name.substring(0, 1);
			String AllName=headName+"0";
			System.out.println("Allname:"+AllName+"teacher ID:"+TID);
			String hqlAll="select "+AllName+" from assistantScore where TeacherID='"+TID+"'";
			String Alltemp=ASSD.queryScore(hqlAll);
			String AllScore=Alltemp.substring(1, Alltemp.length()-1);
			int NewAllEdu=Integer.parseInt(EduAll)-Integer.parseInt(AllScore);
			System.out.println(AllScore);
			//��ȡ���з���
			List ScoreNameList=new ArrayList();
			List<assistantTable> AllNameList=new ArrayList();
			AllNameList=ATD.getTable();
			for(int i=0;i<AllNameList.size();i++){
				if(AllNameList.get(i).getName().contains(headName)){
					ScoreNameList.add(AllNameList.get(i).getName()+"s");
				}
			}
			System.out.println("Search Name:"+ScoreNameList.get(0));
		
			//��ȡ��������
			String getScoreName=name.substring(0, name.length()-1);
			String getScoreHql="select score from assistantTable where name='"+getScoreName+"'";
			String MaxScoreTemp=ATD.queryScore(getScoreHql);
			System.out.println("space MaxScore:"+MaxScoreTemp);
			String MaxScore=MaxScoreTemp.substring(1, MaxScoreTemp.length()-1);
			String MaxAllName=headName+"1";
			String getAllScoreHql="select AllScore from assistantTable where name='"+MaxAllName+"'";
			String MaxAllScoreTemp=ATD.queryScore(getAllScoreHql);
			String MaxAllScore=MaxAllScoreTemp.substring(1, MaxAllScoreTemp.length()-1);
			//�жϷ���
			System.out.println("space content:"+content);
			System.out.println("space MaxScore:"+MaxScore);
			if(Integer.parseInt(content)>Integer.parseInt(MaxScore)){
				content=MaxScore;
			}
			
			//�ύ�·���
			String updateHql="update assistantScore  set "+name+"="+content+ "where TeacherID ="+TID;
			ASSD.updateEduScore(updateHql);
			
			List ScoreList=new ArrayList();
			for(int a=0;a<ScoreNameList.size();a++){
				String GetScoreHql="select "+ScoreNameList.get(a)+" from assistantScore where TeacherID='"+TID+"'";
				String EveryTemp=ASSD.queryScore(GetScoreHql);
				String EveryScore=EveryTemp.substring(1, EveryTemp.length()-1);
				ScoreList.add(EveryScore);
			}
			//���㲢�ύ�µ��ܷ�
			String AfterScore="0";
			for(int b=0;b<ScoreList.size();b++){
				AfterScore=String.valueOf(Integer.parseInt(AfterScore)+Integer.parseInt((String) ScoreList.get(b)));
			}
			if(Integer.parseInt(AfterScore)>Integer.parseInt(MaxAllScore)){
				AfterScore=MaxAllScore;
			}
			String ScoreUpdate="update assistantScore  set "+AllName+"="+AfterScore+ "where TeacherID ="+TID;
			ASSD.updateEduScore(ScoreUpdate);
			int EduAllNum=Integer.parseInt(AfterScore)+NewAllEdu;
			if(EduAllNum>100){
				EduAllNum=100;
			}
			if(EduAllNum<0){
				EduAllNum=0;
			}
			TeacherQS TQ=new TeacherQS();
			TQ=TSD.getTableByTID(TID).get(0);
			TQ.setAssScore(String.valueOf(EduAllNum));
			TSD.updateNoticeID(TQ);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	}
	
	//��ѧ���˱�����
	public String EduContent(){
		try{
			//��ȡteacherID
			
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			System.out.println("teacher ID:"+TID);
			System.out.println("Name:"+name);
			System.out.println("content:"+content);
			String contentHql="update EduScore set "+name+"='"+content+ "' where TeacherID ="+TID;
			ESD.updateEduScore(contentHql);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	}
	
	public String ReaContent(){

		try{
			//��ȡteacherID
			
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			System.out.println("teacher ID:"+TID);
			System.out.println("Name:"+name);
			System.out.println("content:"+content);
			String contentHql="update researchScore set "+name+"='"+content+ "' where TeacherID ="+TID;
			RSD.updateEduScore(contentHql);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	
	}
	
	public String SerContent(){

		try{
			//��ȡteacherID
			
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			System.out.println("teacher ID:"+TID);
			System.out.println("Name:"+name);
			System.out.println("content:"+content);
			String contentHql="update serveScore set "+name+"='"+content+ "' where TeacherID ="+TID;
			SSD.updateEduScore(contentHql);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	
	}
	
	public String AssContent(){

		try{
			//��ȡteacherID
			
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			System.out.println("teacher ID:"+TID);
			System.out.println("Name:"+name);
			System.out.println("content:"+content);
			String contentHql="update assistantScore set "+name+"='"+content+ "' where TeacherID ="+TID;
			ASSD.updateEduScore(contentHql);
		}catch(Exception e){
			e.printStackTrace();
		}
		String data="success";
		JSONArray json = JSONArray.fromObject("['data']");
		result=json.toString();
		return SUCCESS;
	
	}
}
