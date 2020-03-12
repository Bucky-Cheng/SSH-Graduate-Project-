package com.ssh.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ApproveDao;
import com.ssh.dao.AssScoreDao;
import com.ssh.dao.AutoSelectionsDao;
import com.ssh.dao.DeclineDao;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.ReaScoreDao;
import com.ssh.dao.RowcolAssDao;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.RowcolSerDao;
import com.ssh.dao.ScoreresultDao;
import com.ssh.dao.SerScoreDao;
import com.ssh.dao.TeacherFileDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.dao.TeacherQSDao;
import com.ssh.dao.assistantTableDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.Decline;
import com.ssh.model.ScoreCombination;
import com.ssh.model.Scoreresult;
import com.ssh.model.TeacherQS;
import com.ssh.model.assistantTable;
import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.rowcol;
import com.ssh.model.rowcolAss;
import com.ssh.model.rowcolRea;
import com.ssh.model.rowcolSer;
import com.ssh.model.scorecombinationAss;
import com.ssh.model.scorecombinationRea;
import com.ssh.model.scorecombinationSer;
import com.ssh.model.serveTable;
import com.ssh.model.Approve;

import net.sf.json.JSONArray;

public class ExamineAction extends ActionSupport{

	private String result;
	private String TID;
	private String TeacherID;
	private String declineContent;
	private String Type;
	private String delID;
	private List<educationTable> educationList;
	
	private educationTable ET;
	@Autowired
	private educationTableDao ETD;
	@Autowired
	private TeacherFileDao TFD;
	@Autowired
	private AutoSelectionsDao ASD;
	@Autowired
	private RowcolDao RCD;
	@Autowired
	private EduScoreDao ESD;
	@Autowired
	private TeacherMDao TMD;
	@Autowired
	private DeclineDao DCD;
	@Autowired
	private ApproveDao APD;
	
	
	
	private String including;
	private String name;
	private List AddList;
	private List saveList;
	private List<rowcol> returnList;
	private List<rowcolRea> ReareturnList;
	private List<ScoreCombination> returnListB;
	private List<scorecombinationRea> ReareturnListB;
	private List<rowcol> showList;
	private List<rowcolRea> ReashowList;
	private List<ScoreCombination> showListB;
	private List<scorecombinationRea> ReashowListB;
	
	private List<researchTable> researchList;

	private String selections;
	
	
	private List<rowcolSer> SerreturnList;

	private List<scorecombinationSer> SerreturnListB;

	private List<rowcolSer> SershowList;

	private List<scorecombinationSer> SershowListB;
	
	private List<serveTable> serveList;


	@Autowired
	private RowcolSerDao RCSD;

	@Autowired
	private serveTableDao STD;

	@Autowired
	private SerScoreDao SSD;
	
	
	private rowcolSer RCS;
	
	private scorecombinationSer SCS;

	
	private serveTable ST;
	
	@Autowired
	private RowcolReaDao RCRD;

	@Autowired
	private researchTableDao RTD;
	
	@Autowired
	private ReaScoreDao RSD;

	private rowcol RC;
	private ScoreCombination SC;
	private researchTable RT;
	private List<rowcolAss> AssreturnList;
	private List<scorecombinationAss> AssreturnListB;
	private List<rowcolAss> AssshowList;
	private List<scorecombinationAss> AssshowListB;
	private List<assistantTable> assistantList;
	private RowcolAssDao RCAD;
	@Autowired
	private assistantTableDao ATD;
	@Autowired
	private AssScoreDao ASSD;
	@Autowired
	private TeacherQSDao TQSD;
	@Autowired
	private ScoreresultDao SRSD;
	private rowcolAss RCA;
	private scorecombinationAss SCA;
	private assistantTable AT;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	public String getDeclineContent() {
		return declineContent;
	}

	public void setDeclineContent(String declineContent) {
		this.declineContent = declineContent;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public List<educationTable> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<educationTable> educationList) {
		this.educationList = educationList;
	}

	public educationTable getET() {
		return ET;
	}

	public void setET(educationTable eT) {
		ET = eT;
	}

	public educationTableDao getETD() {
		return ETD;
	}

	public void setETD(educationTableDao eTD) {
		ETD = eTD;
	}

	public TeacherFileDao getTFD() {
		return TFD;
	}

	public void setTFD(TeacherFileDao tFD) {
		TFD = tFD;
	}

	public AutoSelectionsDao getASD() {
		return ASD;
	}

	public void setASD(AutoSelectionsDao aSD) {
		ASD = aSD;
	}

	public RowcolDao getRCD() {
		return RCD;
	}

	public void setRCD(RowcolDao rCD) {
		RCD = rCD;
	}

	public EduScoreDao getESD() {
		return ESD;
	}

	public void setESD(EduScoreDao eSD) {
		ESD = eSD;
	}

	public TeacherMDao getTMD() {
		return TMD;
	}

	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}

	public DeclineDao getDCD() {
		return DCD;
	}

	public void setDCD(DeclineDao dCD) {
		DCD = dCD;
	}

	public ApproveDao getAPD() {
		return APD;
	}

	public void setAPD(ApproveDao aPD) {
		APD = aPD;
	}

	public String getIncluding() {
		return including;
	}

	public void setIncluding(String including) {
		this.including = including;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getAddList() {
		return AddList;
	}

	public void setAddList(List addList) {
		AddList = addList;
	}

	public List getSaveList() {
		return saveList;
	}

	public void setSaveList(List saveList) {
		this.saveList = saveList;
	}

	public List<rowcol> getReturnList() {
		return returnList;
	}

	public void setReturnList(List<rowcol> returnList) {
		this.returnList = returnList;
	}

	public List<rowcolRea> getReareturnList() {
		return ReareturnList;
	}

	public void setReareturnList(List<rowcolRea> reareturnList) {
		ReareturnList = reareturnList;
	}

	public List<ScoreCombination> getReturnListB() {
		return returnListB;
	}

	public void setReturnListB(List<ScoreCombination> returnListB) {
		this.returnListB = returnListB;
	}

	public List<scorecombinationRea> getReareturnListB() {
		return ReareturnListB;
	}

	public void setReareturnListB(List<scorecombinationRea> reareturnListB) {
		ReareturnListB = reareturnListB;
	}

	public List<rowcol> getShowList() {
		return showList;
	}

	public void setShowList(List<rowcol> showList) {
		this.showList = showList;
	}

	public List<rowcolRea> getReashowList() {
		return ReashowList;
	}

	public void setReashowList(List<rowcolRea> reashowList) {
		ReashowList = reashowList;
	}

	public List<ScoreCombination> getShowListB() {
		return showListB;
	}

	public void setShowListB(List<ScoreCombination> showListB) {
		this.showListB = showListB;
	}

	public List<scorecombinationRea> getReashowListB() {
		return ReashowListB;
	}

	public void setReashowListB(List<scorecombinationRea> reashowListB) {
		ReashowListB = reashowListB;
	}

	public List<researchTable> getResearchList() {
		return researchList;
	}

	public void setResearchList(List<researchTable> researchList) {
		this.researchList = researchList;
	}

	public String getSelections() {
		return selections;
	}

	public void setSelections(String selections) {
		this.selections = selections;
	}

	public List<rowcolSer> getSerreturnList() {
		return SerreturnList;
	}

	public void setSerreturnList(List<rowcolSer> serreturnList) {
		SerreturnList = serreturnList;
	}

	public List<scorecombinationSer> getSerreturnListB() {
		return SerreturnListB;
	}

	public void setSerreturnListB(List<scorecombinationSer> serreturnListB) {
		SerreturnListB = serreturnListB;
	}

	public List<rowcolSer> getSershowList() {
		return SershowList;
	}

	public void setSershowList(List<rowcolSer> sershowList) {
		SershowList = sershowList;
	}

	public List<scorecombinationSer> getSershowListB() {
		return SershowListB;
	}

	public void setSershowListB(List<scorecombinationSer> sershowListB) {
		SershowListB = sershowListB;
	}

	public List<serveTable> getServeList() {
		return serveList;
	}

	public void setServeList(List<serveTable> serveList) {
		this.serveList = serveList;
	}

	public RowcolSerDao getRCSD() {
		return RCSD;
	}

	public void setRCSD(RowcolSerDao rCSD) {
		RCSD = rCSD;
	}

	public serveTableDao getSTD() {
		return STD;
	}

	public void setSTD(serveTableDao sTD) {
		STD = sTD;
	}

	public SerScoreDao getSSD() {
		return SSD;
	}

	public void setSSD(SerScoreDao sSD) {
		SSD = sSD;
	}

	public rowcolSer getRCS() {
		return RCS;
	}

	public void setRCS(rowcolSer rCS) {
		RCS = rCS;
	}

	public scorecombinationSer getSCS() {
		return SCS;
	}

	public void setSCS(scorecombinationSer sCS) {
		SCS = sCS;
	}

	public serveTable getST() {
		return ST;
	}

	public void setST(serveTable sT) {
		ST = sT;
	}

	public RowcolReaDao getRCRD() {
		return RCRD;
	}

	public void setRCRD(RowcolReaDao rCRD) {
		RCRD = rCRD;
	}

	public researchTableDao getRTD() {
		return RTD;
	}

	public void setRTD(researchTableDao rTD) {
		RTD = rTD;
	}

	public ReaScoreDao getRSD() {
		return RSD;
	}

	public void setRSD(ReaScoreDao rSD) {
		RSD = rSD;
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

	public researchTable getRT() {
		return RT;
	}

	public void setRT(researchTable rT) {
		RT = rT;
	}

	public List<rowcolAss> getAssreturnList() {
		return AssreturnList;
	}

	public void setAssreturnList(List<rowcolAss> assreturnList) {
		AssreturnList = assreturnList;
	}

	public List<scorecombinationAss> getAssreturnListB() {
		return AssreturnListB;
	}

	public void setAssreturnListB(List<scorecombinationAss> assreturnListB) {
		AssreturnListB = assreturnListB;
	}

	public List<rowcolAss> getAssshowList() {
		return AssshowList;
	}

	public void setAssshowList(List<rowcolAss> assshowList) {
		AssshowList = assshowList;
	}

	public List<scorecombinationAss> getAssshowListB() {
		return AssshowListB;
	}

	public void setAssshowListB(List<scorecombinationAss> assshowListB) {
		AssshowListB = assshowListB;
	}

	public List<assistantTable> getAssistantList() {
		return assistantList;
	}

	public void setAssistantList(List<assistantTable> assistantList) {
		this.assistantList = assistantList;
	}

	public RowcolAssDao getRCAD() {
		return RCAD;
	}

	public void setRCAD(RowcolAssDao rCAD) {
		RCAD = rCAD;
	}

	public assistantTableDao getATD() {
		return ATD;
	}

	public void setATD(assistantTableDao aTD) {
		ATD = aTD;
	}

	public AssScoreDao getASSD() {
		return ASSD;
	}

	public void setASSD(AssScoreDao aSSD) {
		ASSD = aSSD;
	}

	public rowcolAss getRCA() {
		return RCA;
	}

	public void setRCA(rowcolAss rCA) {
		RCA = rCA;
	}

	public scorecombinationAss getSCA() {
		return SCA;
	}

	public void setSCA(scorecombinationAss sCA) {
		SCA = sCA;
	}

	public assistantTable getAT() {
		return AT;
	}

	public void setAT(assistantTable aT) {
		AT = aT;
	}
	
	
	
	public TeacherQSDao getTQSD() {
		return TQSD;
	}

	public void setTQSD(TeacherQSDao tQSD) {
		TQSD = tQSD;
	}

	public ScoreresultDao getSRSD() {
		return SRSD;
	}

	public void setSRSD(ScoreresultDao sRSD) {
		SRSD = sRSD;
	}
	
	
	
	public String getDelID() {
		return delID;
	}

	public void setDelID(String delID) {
		this.delID = delID;
	}

	//展示教学表
	public String Education(){
		try{
			System.out.println("TID:"+TID);
			int maxCol=0;
			educationList=new ArrayList();
			List<educationTable> eduList=new ArrayList();
			eduList=ETD.getTable();
			
			String tdLast="";
			List EdureturnList=new ArrayList();
			//过滤排序考核项
			for(int p=eduList.size()-1;p>=0;p--){
				ET=eduList.get(p);
			
				if(p<=eduList.size()){
					Pattern pattern = Pattern.compile("[0-9]*");
			           Matcher isNum = pattern.matcher(ET.getName());
				if(isNum.matches()){
					eduList.remove(ET);
				}else{
					
				}
				}
			}
			List<educationTable> tempList=new ArrayList();
			for(int t=0;t<eduList.size();t++){
				tempList.add(eduList.get(t));
			}
			String specialString="s1+";
			for(int q=0;q<eduList.size();q++){
				boolean specialFlag=true;
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
						specialFlag=false;
					}
				}
				if(specialFlag){
					specialString=specialString+eduList.get(q).getName()+"+";
				}
			}
			//System.out.println("=================================================");
			//System.out.println(specialString);
			for(int r=0;r<educationList.size();r++){
				
				//System.out.println("EDUTEST"+educationList.get(r).getName());
				
			}
			//System.out.println("=================================================");
			List<rowcol> RcReturn=new ArrayList();
			List<ScoreCombination> ScReturn=new ArrayList();
			
			
			
			RcReturn=RCD.getCombination();
			ScReturn=RCD.getCombinationB();
			//获取自动项目
			String AShql="select Selections from AutoSelections where Type='Education'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			//System.out.println("SelContent:"+SelContent);
			for(int i=0;i<educationList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				//获取分数
				String ScoreName=educationList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from EduScore where TeacherID='"+TID+"'";
				String scoreTemp=ESD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from EduScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=ESD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//获取通过项目
				String ContentName=educationList.get(i).getName()+"c";
				String ContentHql="select "+ContentName+" from EduScore where TeacherID='"+TID+"'";
				String contentTemp=ESD.queryScore(ContentHql);
				String ScoreContent=contentTemp.substring(1,contentTemp.length()-1);
				
				
				for(int j=0;j<RcReturn.size();j++){
					if(RcReturn.get(j).getIncluding().contains(educationList.get(i).getName())){
						RcID.add(String.valueOf(RcReturn.get(j).getID()));
						RcFlag=false;
					}else{
						
					}
				}
				for(int k=0;k<ScReturn.size();k++){
					if(ScReturn.get(k).getIncluding().contains(educationList.get(i).getName())){
						ScID.add(String.valueOf(ScReturn.get(k).getID()));
						ScFlag=false;
					}else{
						colSpan++;
					}
				}
				int AllCol=1+RcID.size()+ScID.size();
				if(AllCol>maxCol){
					maxCol=AllCol;
				}
				String td1="";
				String headName=educationList.get(i).getName().substring(0, 1);
				if(AllCol==1){
					String name=educationList.get(i).getName();
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<educationList.size();d++){
						if(name.substring(0, 1).equals(educationList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(educationList.get(i).getName())){
					td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' '>"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' ></td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(educationList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(educationList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' >"+Score+"</td>";
						}
					}
					}else{
					tdList.add(educationList.get(i).getContent());
					countList.add(0);
					int tdColSpan=0;
					if(!RcFlag){
						
						for(int b=0;b<RcID.size();b++){
							int ID=Integer.parseInt((String) RcID.get(b));
							String Including=RCD.getInculdingByIDA(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(educationList.get(i).getName().equals(FirstIncluding)){
								String content=RCD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
						
					}
					if(!ScFlag){
						for(int b=0;b<ScID.size();b++){
							int ID=Integer.parseInt((String) ScID.get(b));
							String Including=RCD.getInculdingByIDB(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(educationList.get(i).getName().equals(FirstIncluding)){
								String content=RCD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
					}
					String name=educationList.get(i).getName();
					
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<educationList.size();d++){
						if(name.substring(0, 1).equals(educationList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(educationList.get(i).getName())){
					tdLast="<td  id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(educationList.get(i).getName())){
							tdLast="<td  id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(educationList.get(i).getName())){
							tdLast="<td  id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+educationList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' >"+Score+"</td>";
						}
						}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td rowspan='"+countList.get(c)+"' style='vertical-align:middle' >"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td >"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				//System.out.println("!!!!TD1:"+td1);
				
				//System.out.println("TD1:"+td1);
				EdureturnList.add(td1);
				
				
			
			}
			String EduAll=TQSD.getTableByTID(TID).get(0).getEduScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+EduAll+"</td>";
			EdureturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(EdureturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	}
	
	//展示研究表
	public String Research(){

		try{
			int maxCol=0;
			researchList=new ArrayList();
			List<researchTable> reaList=new ArrayList();
			reaList=RTD.getTable();
			
			String tdLast="";
			List ReareturnList=new ArrayList();
			//过滤排序考核项
			for(int p=reaList.size()-1;p>=0;p--){
				RT=reaList.get(p);
			
				if(p<=reaList.size()){
					Pattern pattern = Pattern.compile("[0-9]*");
			           Matcher isNum = pattern.matcher(RT.getName());
				if(isNum.matches()){
					reaList.remove(RT);
				}else{
					
				}
				}
			}
			List<researchTable> tempList=new ArrayList();
			for(int t=0;t<reaList.size();t++){
				tempList.add(reaList.get(t));
			}
			String specialString="s1+";
			for(int q=0;q<reaList.size();q++){
				boolean specialFlag=true;
				String head=reaList.get(q).getName().substring(0,1);
				int NameNum=Integer.parseInt(reaList.get(q).getName().substring(1, 2));
				if(NameNum==1){
					//System.out.println("NULL NULL:"+reaList.get(q).getName());
					researchList.add(reaList.get(q));
				}
				for(int w=0;w<tempList.size();w++){
					String headW=tempList.get(w).getName().substring(0, 1);
					String nameW=tempList.get(w).getName();
					if(head.equals(headW)&&(!reaList.get(q).getName().equals(nameW))){
						researchList.add(tempList.get(w));
						researchTable temp=new researchTable();
						temp=tempList.get(w);
						reaList.remove(temp);
						specialFlag=false;
					}
				}
				if(specialFlag){
					specialString=specialString+reaList.get(q).getName()+"+";
				}
			}
			//System.out.println("=================================================");
			//System.out.println(specialString);
			for(int r=0;r<researchList.size();r++){
				
				//System.out.println("EDUTEST"+researchList.get(r).getName());
				
			}
			//System.out.println("=================================================");
			List<rowcolRea> RcReturn=new ArrayList();
			List<scorecombinationRea> ScReturn=new ArrayList();
			
			
			
			RcReturn=RCRD.getCombination();
			ScReturn=RCRD.getCombinationB();
			//获取自动项目
			String AShql="select Selections from AutoSelections where Type='Research'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			//System.out.println("SelContent:"+SelContent);
			for(int i=0;i<researchList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				//获取分数
				String ScoreName=researchList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from researchScore where TeacherID='"+TID+"'";
				System.out.println("TID!!!!!!!"+TID);
				String scoreTemp=RSD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				System.out.println("SCORE!!!!!!!"+Score);
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from researchScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=RSD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//获取通过项目
				String ContentName=researchList.get(i).getName()+"c";
				String ContentHql="select "+ContentName+" from researchScore where TeacherID='"+TID+"'";
				String contentTemp=RSD.queryScore(ContentHql);
				String ScoreContent=contentTemp.substring(1,contentTemp.length()-1);
				
				
				for(int j=0;j<RcReturn.size();j++){
					if(RcReturn.get(j).getIncluding().contains(researchList.get(i).getName())){
						RcID.add(String.valueOf(RcReturn.get(j).getID()));
						RcFlag=false;
					}else{
						
					}
				}
				for(int k=0;k<ScReturn.size();k++){
					if(ScReturn.get(k).getIncluding().contains(researchList.get(i).getName())){
						ScID.add(String.valueOf(ScReturn.get(k).getID()));
						ScFlag=false;
					}else{
						colSpan++;
					}
				}
				int AllCol=1+RcID.size()+ScID.size();
				if(AllCol>maxCol){
					maxCol=AllCol;
				}
				String td1="";
				String headName=researchList.get(i).getName().substring(0, 1);
				if(AllCol==1){
					String name=researchList.get(i).getName();
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<researchList.size();d++){
						if(name.substring(0, 1).equals(researchList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(researchList.get(i).getName())){
					td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' '>"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' ></td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(researchList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(researchList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' >"+Score+"</td>";
						}
					}
					}else{
					tdList.add(researchList.get(i).getContent());
					countList.add(0);
					int tdColSpan=0;
					if(!RcFlag){
						
						for(int b=0;b<RcID.size();b++){
							int ID=Integer.parseInt((String) RcID.get(b));
							String Including=RCRD.getInculdingByIDA(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(researchList.get(i).getName().equals(FirstIncluding)){
								String content=RCRD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
						
					}
					if(!ScFlag){
						for(int b=0;b<ScID.size();b++){
							int ID=Integer.parseInt((String) ScID.get(b));
							String Including=RCRD.getInculdingByIDB(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(researchList.get(i).getName().equals(FirstIncluding)){
								String content=RCRD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
					}
					String name=researchList.get(i).getName();
					
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<researchList.size();d++){
						if(name.substring(0, 1).equals(researchList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(researchList.get(i).getName())){
					tdLast="<td  id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(researchList.get(i).getName())){
							tdLast="<td  id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+researchList.get(i).getName()+"c'>"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(researchList.get(i).getName())){
							tdLast="<td  id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+researchList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s'>"+Score+"</td>";
						}
						}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td rowspan='"+countList.get(c)+"' style='vertical-align:middle' >"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td >"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				ReareturnList.add(td1);
				
				
			
			}
			String EduAll=TQSD.getTableByTID(TID).get(0).getReaScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+EduAll+"</td>";
			ReareturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(ReareturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	//展示服务表
	public String Serve(){

		try{
			int maxCol=0;
			serveList=new ArrayList();
			List<serveTable> serList=new ArrayList();
			serList=STD.getTable();
			
			String tdLast="";
			List ReareturnList=new ArrayList();
			//过滤排序考核项
			for(int p=serList.size()-1;p>=0;p--){
				ST=serList.get(p);
			
				if(p<=serList.size()){
					Pattern pattern = Pattern.compile("[0-9]*");
			           Matcher isNum = pattern.matcher(ST.getName());
				if(isNum.matches()){
					serList.remove(ST);
				}else{
					
				}
				}
			}
			List<serveTable> tempList=new ArrayList();
			for(int t=0;t<serList.size();t++){
				tempList.add(serList.get(t));
			}
			String specialString="s1+";
			for(int q=0;q<serList.size();q++){
				boolean specialFlag=true;
				String head=serList.get(q).getName().substring(0,1);
				int NameNum=Integer.parseInt(serList.get(q).getName().substring(1, 2));
				if(NameNum==1){
					//System.out.println("NULL NULL:"+reaList.get(q).getName());
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
						specialFlag=false;
					}
				}
				if(specialFlag){
					specialString=specialString+serList.get(q).getName()+"+";
				}
			}
			//System.out.println("=================================================");
			//System.out.println(specialString);
			for(int r=0;r<serveList.size();r++){
				
				//System.out.println("EDUTEST"+researchList.get(r).getName());
				
			}
			//System.out.println("=================================================");
			List<rowcolSer> RcReturn=new ArrayList();
			List<scorecombinationSer> ScReturn=new ArrayList();
			
			
			
			RcReturn=RCSD.getCombination();
			ScReturn=RCSD.getCombinationB();
			//获取自动项目
			String AShql="select Selections from AutoSelections where Type='Serve'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			//System.out.println("SelContent:"+SelContent);
			for(int i=0;i<serveList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				//获取分数
				String ScoreName=serveList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from serveScore where TeacherID='"+TID+"'";
				System.out.println("TID!!!!!!!"+TID);
				String scoreTemp=SSD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				System.out.println("SCORE!!!!!!!"+Score);
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from serveScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=SSD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//获取通过项目
				String ContentName=serveList.get(i).getName()+"c";
				String ContentHql="select "+ContentName+" from serveScore where TeacherID='"+TID+"'";
				String contentTemp=SSD.queryScore(ContentHql);
				String ScoreContent=contentTemp.substring(1,contentTemp.length()-1);
				
				
				for(int j=0;j<RcReturn.size();j++){
					if(RcReturn.get(j).getIncluding().contains(serveList.get(i).getName())){
						RcID.add(String.valueOf(RcReturn.get(j).getID()));
						RcFlag=false;
					}else{
						
					}
				}
				for(int k=0;k<ScReturn.size();k++){
					if(ScReturn.get(k).getIncluding().contains(serveList.get(i).getName())){
						ScID.add(String.valueOf(ScReturn.get(k).getID()));
						ScFlag=false;
					}else{
						colSpan++;
					}
				}
				int AllCol=1+RcID.size()+ScID.size();
				if(AllCol>maxCol){
					maxCol=AllCol;
				}
				String td1="";
				String headName=serveList.get(i).getName().substring(0, 1);
				if(AllCol==1){
					String name=serveList.get(i).getName();
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<serveList.size();d++){
						if(name.substring(0, 1).equals(serveList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(serveList.get(i).getName())){
					td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' '>"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' ></td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(serveList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(serveList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' >"+Score+"</td>";
						}
					}
					}else{
					tdList.add(serveList.get(i).getContent());
					countList.add(0);
					int tdColSpan=0;
					if(!RcFlag){
						
						for(int b=0;b<RcID.size();b++){
							int ID=Integer.parseInt((String) RcID.get(b));
							String Including=RCSD.getInculdingByIDA(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(serveList.get(i).getName().equals(FirstIncluding)){
								String content=RCSD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
						
					}
					if(!ScFlag){
						for(int b=0;b<ScID.size();b++){
							int ID=Integer.parseInt((String) ScID.get(b));
							String Including=RCSD.getInculdingByIDB(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(serveList.get(i).getName().equals(FirstIncluding)){
								String content=RCSD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
					}
					String name=serveList.get(i).getName();
					
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<serveList.size();d++){
						if(name.substring(0, 1).equals(serveList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(serveList.get(i).getName())){
					tdLast="<td  id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(serveList.get(i).getName())){
							tdLast="<td  id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+serveList.get(i).getName()+"c'>"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(serveList.get(i).getName())){
							tdLast="<td  id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+serveList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s'>"+Score+"</td>";
						}
						}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td rowspan='"+countList.get(c)+"' style='vertical-align:middle' >"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td >"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				ReareturnList.add(td1);
				
				
			
			}
			String EduAll=TQSD.getTableByTID(TID).get(0).getSerScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+EduAll+"</td>";
			ReareturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(ReareturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	//展示教辅表
	public String Assistant(){

		try{
			int maxCol=0;
			assistantList=new ArrayList();
			List<assistantTable> assList=new ArrayList();
			assList=ATD.getTable();
			
			String tdLast="";
			List AssreturnList=new ArrayList();
			//过滤排序考核项
			for(int p=assList.size()-1;p>=0;p--){
				AT=assList.get(p);
			
				if(p<=assList.size()){
					Pattern pattern = Pattern.compile("[0-9]*");
			           Matcher isNum = pattern.matcher(AT.getName());
				if(isNum.matches()){
					assList.remove(AT);
				}else{
					
				}
				}
			}
			List<assistantTable> tempList=new ArrayList();
			for(int t=0;t<assList.size();t++){
				tempList.add(assList.get(t));
			}
			String specialString="s1+";
			for(int q=0;q<assList.size();q++){
				boolean specialFlag=true;
				String head=assList.get(q).getName().substring(0,1);
				int NameNum=Integer.parseInt(assList.get(q).getName().substring(1, 2));
				if(NameNum==1){
					//System.out.println("NULL NULL:"+reaList.get(q).getName());
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
						specialFlag=false;
					}
				}
				if(specialFlag){
					specialString=specialString+assList.get(q).getName()+"+";
				}
			}
			//System.out.println("=================================================");
			//System.out.println(specialString);
			for(int r=0;r<assistantList.size();r++){
				
				//System.out.println("EDUTEST"+researchList.get(r).getName());
				
			}
			//System.out.println("=================================================");
			List<rowcolAss> RcReturn=new ArrayList();
			List<scorecombinationAss> ScReturn=new ArrayList();
			
			
			
			RcReturn=RCAD.getCombination();
			ScReturn=RCAD.getCombinationB();
			//获取自动项目
			String AShql="select Selections from AutoSelections where Type='Assistant'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			//System.out.println("SelContent:"+SelContent);
			for(int i=0;i<assistantList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				//获取分数
				String ScoreName=assistantList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from assistantScore where TeacherID='"+TID+"'";
				System.out.println("TID!!!!!!!"+TID);
				String scoreTemp=ASSD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				System.out.println("SCORE!!!!!!!"+Score);
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from assistantScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=ASSD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//获取通过项目
				String ContentName=assistantList.get(i).getName()+"c";
				String ContentHql="select "+ContentName+" from assistantScore where TeacherID='"+TID+"'";
				String contentTemp=ASSD.queryScore(ContentHql);
				String ScoreContent=contentTemp.substring(1,contentTemp.length()-1);
				
				
				for(int j=0;j<RcReturn.size();j++){
					if(RcReturn.get(j).getIncluding().contains(assistantList.get(i).getName())){
						RcID.add(String.valueOf(RcReturn.get(j).getID()));
						RcFlag=false;
					}else{
						
					}
				}
				for(int k=0;k<ScReturn.size();k++){
					if(ScReturn.get(k).getIncluding().contains(assistantList.get(i).getName())){
						ScID.add(String.valueOf(ScReturn.get(k).getID()));
						ScFlag=false;
					}else{
						colSpan++;
					}
				}
				int AllCol=1+RcID.size()+ScID.size();
				if(AllCol>maxCol){
					maxCol=AllCol;
				}
				String td1="";
				String headName=assistantList.get(i).getName().substring(0, 1);
				if(AllCol==1){
					String name=assistantList.get(i).getName();
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<assistantList.size();d++){
						if(name.substring(0, 1).equals(assistantList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(assistantList.get(i).getName())){
					td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' '>"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' ></td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(assistantList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(assistantList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' >"+Score+"</td>";
						}
					}
					}else{
					tdList.add(assistantList.get(i).getContent());
					countList.add(0);
					int tdColSpan=0;
					if(!RcFlag){
						
						for(int b=0;b<RcID.size();b++){
							int ID=Integer.parseInt((String) RcID.get(b));
							String Including=RCAD.getInculdingByIDA(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(assistantList.get(i).getName().equals(FirstIncluding)){
								String content=RCAD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
						
					}
					if(!ScFlag){
						for(int b=0;b<ScID.size();b++){
							int ID=Integer.parseInt((String) ScID.get(b));
							String Including=RCAD.getInculdingByIDB(ID).get(0).getIncluding();
							String ArrayIncluding[]=Including.split(",");
							String FirstIncluding=ArrayIncluding[0];
							int count=ArrayIncluding.length;
							if(assistantList.get(i).getName().equals(FirstIncluding)){
								String content=RCAD.getContentByID(String.valueOf(ID)).get(0).getContent();
								tdList.add(content);
								countList.add(count);
							}else{
								tdColSpan++;
							}
							
						}
					}
					String name=assistantList.get(i).getName();
					
					
					if(name.contains("1")){
					int maxRow=0;
					for(int d=0;d<assistantList.size();d++){
						if(name.substring(0, 1).equals(assistantList.get(d).getName().substring(0, 1))){
							maxRow++;
						}
					}
					if(!specialString.contains(assistantList.get(i).getName())){
					tdLast="<td  id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
					}else{
						if(SelContent.contains(assistantList.get(i).getName())){
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+assistantList.get(i).getName()+"c'>"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(assistantList.get(i).getName())){
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' >"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s'>"+Score+"</td>";
						}
						}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td rowspan='"+countList.get(c)+"' style='vertical-align:middle' >"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td >"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				AssreturnList.add(td1);
				
				
			
			}
			String EduAll=TQSD.getTableByTID(TID).get(0).getAssScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+EduAll+"</td>";
			AssreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(AssreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	//保存教学表审核结果
	public String Save(){
		//获取时间
		Calendar calendar = Calendar.getInstance();      
		int year = calendar.get(Calendar.YEAR);      
		int month = calendar.get(Calendar.MONTH);      
		int day = calendar.get(Calendar.DATE);      
		int hour = calendar.get(Calendar.HOUR_OF_DAY);      
		int minute = calendar.get(Calendar.MINUTE);      
		int second = calendar.get(Calendar.SECOND);
		String StartTime=year+"/"+month+"/"+day+"/"+hour+":"+minute+":"+second;
		//获取主管姓名
		Map session = ActionContext.getContext().getSession();
		String ManagerID=(String) session.get("t_ID");
		String ManagerName=TMD.getTableByTID(ManagerID).get(0).getTeacherName();
		Decline DC=new Decline();
		DC.setDeclineContent(declineContent);
		DC.setTeacherID(TeacherID);
		DC.setManagerID(ManagerID);
		DC.setManagerName(ManagerName);
		DC.setStartTime(StartTime);
		DC.setFlag("F");
		List<Decline> DCT=new ArrayList();
		
		DC.setDeclineName(Type);
		
		DCD.insertOne(DC);
		Approve DAP=new Approve();
if(APD.getApproveByTID(TeacherID+Type)==null){
			
		}else{
		DAP=APD.getApproveByTID(TeacherID+Type).get(0);
		APD.deleteApproveAById(DAP);
		}
		//modify at 0349 02022020
		//modify start
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TeacherID);
		SRCL.get(0).setEducation("0");
		SRCL.get(0).setAllScore("0");
		SRSD.updateNoticeID(SRCL.get(0));
		//modify end
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存研究表审核结果
	public String SaveR(){
		//获取时间
		Calendar calendar = Calendar.getInstance();      
		int year = calendar.get(Calendar.YEAR);      
		int month = calendar.get(Calendar.MONTH);      
		int day = calendar.get(Calendar.DATE);      
		int hour = calendar.get(Calendar.HOUR_OF_DAY);      
		int minute = calendar.get(Calendar.MINUTE);      
		int second = calendar.get(Calendar.SECOND);
		String StartTime=year+"/"+month+"/"+day+"/"+hour+":"+minute+":"+second;
		//获取主管姓名
		Map session = ActionContext.getContext().getSession();
		String ManagerID=(String) session.get("t_ID");
		String ManagerName=TMD.getTableByTID(ManagerID).get(0).getTeacherName();
		Decline DC=new Decline();
		DC.setDeclineContent(declineContent);
		DC.setTeacherID(TeacherID);
		DC.setManagerID(ManagerID);
		DC.setManagerName(ManagerName);
		DC.setStartTime(StartTime);
		DC.setFlag("F");
		List<Decline> DCT=new ArrayList();
	
		DC.setDeclineName(Type);
		
		DCD.insertOne(DC);
		Approve DAP=new Approve();
if(APD.getApproveByTID(TeacherID+Type)==null){
			
		}else{
		DAP=APD.getApproveByTID(TeacherID+Type).get(0);
		APD.deleteApproveAById(DAP);
		}
		//modify at 0434 02022020
		//modify start
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TeacherID);
		SRCL.get(0).setResearch("0");
		SRCL.get(0).setAllScore("0");
		SRSD.updateNoticeID(SRCL.get(0));
		//modify end
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存服务表审核结果
	public String SaveS(){
		//获取时间
		Calendar calendar = Calendar.getInstance();      
		int year = calendar.get(Calendar.YEAR);      
		int month = calendar.get(Calendar.MONTH);      
		int day = calendar.get(Calendar.DATE);      
		int hour = calendar.get(Calendar.HOUR_OF_DAY);      
		int minute = calendar.get(Calendar.MINUTE);      
		int second = calendar.get(Calendar.SECOND);
		String StartTime=year+"/"+month+"/"+day+"/"+hour+":"+minute+":"+second;
		//获取主管姓名
		Map session = ActionContext.getContext().getSession();
		String ManagerID=(String) session.get("t_ID");
		String ManagerName=TMD.getTableByTID(ManagerID).get(0).getTeacherName();
		Decline DC=new Decline();
		DC.setDeclineContent(declineContent);
		DC.setTeacherID(TeacherID);
		DC.setManagerID(ManagerID);
		DC.setManagerName(ManagerName);
		DC.setStartTime(StartTime);
		DC.setFlag("F");
		List<Decline> DCT=new ArrayList();
		
		DC.setDeclineName(Type);
		
		DCD.insertOne(DC);
		Approve DAP=new Approve();
		if(APD.getApproveByTID(TeacherID+Type)==null){
			
		}else{
		DAP=APD.getApproveByTID(TeacherID+Type).get(0);
		APD.deleteApproveAById(DAP);
		}
		//modify at 0433 02022020
		//modify start
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TeacherID);
		SRCL.get(0).setServe("0");
		SRCL.get(0).setAllScore("0");
		SRSD.updateNoticeID(SRCL.get(0));
		//modify end
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存教辅表审核结果
	public String SaveA(){
		//获取时间
		Calendar calendar = Calendar.getInstance();      
		int year = calendar.get(Calendar.YEAR);      
		int month = calendar.get(Calendar.MONTH);      
		int day = calendar.get(Calendar.DATE);      
		int hour = calendar.get(Calendar.HOUR_OF_DAY);      
		int minute = calendar.get(Calendar.MINUTE);      
		int second = calendar.get(Calendar.SECOND);
		String StartTime=year+"/"+month+"/"+day+"/"+hour+":"+minute+":"+second;
		//获取主管姓名
		Map session = ActionContext.getContext().getSession();
		String ManagerID=(String) session.get("t_ID");
		String ManagerName=TMD.getTableByTID(ManagerID).get(0).getTeacherName();
		Decline DC=new Decline();
		DC.setDeclineContent(declineContent);
		DC.setTeacherID(TeacherID);
		DC.setManagerID(ManagerID);
		DC.setManagerName(ManagerName);
		DC.setStartTime(StartTime);
		DC.setFlag("F");
		List<Decline> DCT=new ArrayList();
		
		DC.setDeclineName(Type);
		
		DCD.insertOne(DC);
		Approve DAP=new Approve();
		if(APD.getApproveByTID(TeacherID+Type)==null){
			
		}else{
		DAP=APD.getApproveByTID(TeacherID+Type).get(0);
		APD.deleteApproveAById(DAP);
		}
		//modify at 0434 02022020
		//modify start
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TeacherID);
		SRCL.get(0).setAssistant("0");
		SRCL.get(0).setAllScore("0");
		SRSD.updateNoticeID(SRCL.get(0));
		//modify end
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result = json.toString();
		return SUCCESS;
	}
	
	public String Approve(){
		System.out.println("APPROVE");
		//获取主管姓名
		Map session = ActionContext.getContext().getSession();
		String ManagerID=(String) session.get("t_ID");
		String ManagerName=TMD.getTableByTID(ManagerID).get(0).getTeacherName();
		Approve AP=new Approve();
		AP.setTeacherID(TeacherID+Type);
		AP.setManagerID(ManagerID);
		APD.insertOne(AP);
		List<TeacherQS> TQL=new ArrayList();
		TQL=TQSD.getTableByTID(TeacherID);
		List<Scoreresult> SRL=new ArrayList();
		SRL=SRSD.getTableByTID(TeacherID);
		Scoreresult SS=SRL.get(0);
		int AllS=Integer.parseInt(SS.getAllScore());
		if(Type.equals("教学表驳回")){
		int EduQuality=Integer.parseInt(TQL.get(0).getEduQuality().substring(0,TQL.get(0).getEduQuality().length()-1 ));
		System.out.println("SQ"+EduQuality);
		System.out.println("SCORE"+Integer.parseInt(TQL.get(0).getEduScore()));
		
		double Sq = new BigDecimal((float)EduQuality/100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("SQ"+Sq);
		int EduS=(int) (Integer.parseInt(TQL.get(0).getEduScore())*Sq);
		System.out.println("SCORE"+EduS);
		SS.setEducation(String.valueOf(EduS));
		SS.setAllScore(String.valueOf(AllS+EduS));
		
		}
		if(Type.equals("研究表驳回")){
			int ReaQuality=Integer.parseInt(TQL.get(0).getReaQuality().substring(0,TQL.get(0).getReaQuality().length()-1 ));
			
			double Sq = new BigDecimal((float)ReaQuality/100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			int ReaS=(int) (Integer.parseInt(TQL.get(0).getReaScore())*Sq);
			SS.setResearch(String.valueOf(ReaS));
			SS.setAllScore(String.valueOf(AllS+ReaS));
			
			}
		if(Type.equals("服务表驳回")){
			int SerQuality=Integer.parseInt(TQL.get(0).getSerQuality().substring(0,TQL.get(0).getSerQuality().length()-1 ));
			
			double Sq = new BigDecimal((float)SerQuality/100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			int SerS=(int) (Integer.parseInt(TQL.get(0).getSerScore())*Sq);
			SS.setServe(String.valueOf(SerS));
			SS.setAllScore(String.valueOf(AllS+SerS));
			
			}
		if(Type.equals("辅导表驳回")){
			int AssQuality=Integer.parseInt(TQL.get(0).getAssQuality().substring(0,TQL.get(0).getAssQuality().length()-1 ));
			
			double Sq = new BigDecimal((float)AssQuality/100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			int AssS=(int) (Integer.parseInt(TQL.get(0).getAssScore())*Sq);
			SS.setAssistant(String.valueOf(AssS));
			SS.setAllScore(String.valueOf(AllS+AssS));
			
			}
		SRSD.updateNoticeID(SS);
	
		System.out.println("TTTYPE:"+Type);
		if(DCD.getDecline(Type, TeacherID)==null){
			
		}else{
			Decline DAP=new Decline();
		DAP=DCD.getDecline(Type, TeacherID).get(0);
		
		
		DCD.deleteDeclineById(DAP.getID());
		}
		List a=new ArrayList();
		a.add("aaa");
		JSONArray json = JSONArray.fromObject(a);
		result = json.toString();
		return SUCCESS;
	}
	
	//返回同意状态
	public String returnStatusA(){
		Map session = ActionContext.getContext().getSession();
		String Manager=(String) session.get("t_ID");
		List<Approve> APL=new ArrayList();
		List returnA=new ArrayList();
		APL=APD.getApproveByMID(Manager);
		System.out.println("APL 0"+APL.get(0).getManagerID());
		for(int i=0;i<APL.size();i++){
			
				returnA.add(APL.get(i).getTeacherID());
			
		}
		JSONArray json = JSONArray.fromObject(returnA);
		result = json.toString();
		return SUCCESS;
	}
	
	//返回驳回状态
public String returnStatusD(){
		Map session = ActionContext.getContext().getSession();
		String Manager=(String) session.get("t_ID");
		List<Decline> DCL=new ArrayList();
		List returnA=new ArrayList();
		DCL=DCD.getDeclineByMID(Manager);
		for(int i=0;i<DCL.size();i++){
			String ManagerID=DCL.get(i).getManagerID().replace(" ", "");
			
				returnA.add(DCL.get(i).getTeacherID()+DCL.get(i).getDeclineName());
			
		}
		JSONArray json = JSONArray.fromObject(returnA);
		result = json.toString();
		return SUCCESS;
	}

	public String TSubmit(){
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TID);
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
	
	//提交服务审核结果
	public String submitS(){
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TID);
		SRCL.get(0).setServe("1");
		SRSD.updateNoticeID(SRCL.get(0));
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
	
	//提交研究审核结果
	public String submitR(){
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TID);
		SRCL.get(0).setResearch("1");
		SRSD.updateNoticeID(SRCL.get(0));
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
	//提交教辅审核结果
	public String submitA(){
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TID);
		SRCL.get(0).setAssistant("1");
		SRSD.updateNoticeID(SRCL.get(0));
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
	
	//提交教学审核结果
	public String submitE(){
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(TID);
		SRCL.get(0).setEducation("1");
		SRSD.updateNoticeID(SRCL.get(0));
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
	
	//获取部门所有教职工审核状态
	public String getAll(){
		List<Scoreresult> SRCL=new ArrayList();
		
		List<Scoreresult> SRCT=new ArrayList();
		SRCT=SRSD.getTable();
		for(int i=0;i<SRCT.size();i++){
			Scoreresult SRS=new Scoreresult();
			SRS=SRCT.get(i);
			if(SRS.getEducation().equals("1")||SRS.getResearch().equals("1")||SRS.getServe().equals("1")||SRS.getAssistant().equals("1")){
				System.out.println("TID"+SRS.getTeacherID());
				SRCL.add(SRS);
			}else{
				System.out.println("AAA"+SRS.getTeacherID());
				
			}
		}
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
	
	public String backT(){
		List<Scoreresult> SRCL=new ArrayList();
		SRCL=SRSD.getTableByTID(delID);
		SRCL.get(0).setEducation("0");
		SRCL.get(0).setResearch("0");
		SRCL.get(0).setServe("0");
		SRCL.get(0).setAssistant("0");
		SRCL.get(0).setAllScore("0");
		SRSD.updateNoticeID(SRCL.get(0));
		JSONArray json = JSONArray.fromObject(SRCL);
		result = json.toString();
		return SUCCESS;
	}
}
