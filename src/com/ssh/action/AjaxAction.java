package com.ssh.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AssScoreDao;
import com.ssh.dao.AutoSelectionsDao;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.ReaScoreDao;
import com.ssh.dao.RowcolAssDao;
import com.ssh.dao.RowcolDao;
import com.ssh.dao.RowcolReaDao;
import com.ssh.dao.RowcolSerDao;
import com.ssh.dao.SerScoreDao;
import com.ssh.dao.TeacherQSDao;
import com.ssh.dao.assistantTableDao;
import com.ssh.dao.educationTableDao;
import com.ssh.dao.researchTableDao;
import com.ssh.dao.serveTableDao;
import com.ssh.model.AutoSelections;
import com.ssh.model.ScoreCombination;
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

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class AjaxAction extends ActionSupport{

	private String including;
	private String name;
	private List AddList;
	private List saveList;
	private List<rowcol> returnList;
	private List<rowcolRea> ReareturnList;
	private List<rowcolSer> SerreturnList;
	private List<rowcolAss> AssreturnList;
	private List<ScoreCombination> returnListB;
	private List<scorecombinationRea> ReareturnListB;
	private List<scorecombinationSer> SerreturnListB;
	private List<scorecombinationAss> AssreturnListB;
	private List<rowcol> showList;
	private List<rowcolRea> ReashowList;
	private List<rowcolSer> SershowList;
	private List<rowcolAss> AssshowList;
	private List<ScoreCombination> showListB;
	private List<scorecombinationRea> ReashowListB;
	private List<scorecombinationSer> SershowListB;
	private List<scorecombinationAss> AssshowListB;
	private List<educationTable> educationList;
	private List<researchTable> researchList;
	private List<serveTable> serveList;
	private List<assistantTable> assistantList;
	private String result;
	private String selections;
	
	private RowcolDao RCD;
	@Autowired
	private RowcolReaDao RCRD;
	@Autowired
	private RowcolSerDao RCSD;
	@Autowired
	private RowcolAssDao RCAD;
	@Autowired
	private educationTableDao ETD;
	@Autowired
	private researchTableDao RTD;
	@Autowired
	private serveTableDao STD;
	@Autowired
	private assistantTableDao ATD;
	@Autowired
	private EduScoreDao ESD;
	@Autowired
	private ReaScoreDao RSD;
	@Autowired
	private SerScoreDao SSD;
	@Autowired
	private AssScoreDao ASSD;
	@Autowired
	private AutoSelectionsDao ASD;
	@Autowired
	private TeacherQSDao TQSD;
	private rowcol RC;
	private rowcolSer RCS;
	private rowcolAss RCA;
	private ScoreCombination SC;
	private scorecombinationSer SCS;
	private scorecombinationAss SCA;
	private educationTable ET;
	private researchTable RT;
	private serveTable ST;
	private assistantTable AT;
	
	private AjaxAction(){
		
	}
	
	
	public TeacherQSDao getTQSD() {
		return TQSD;
	}


	public void setTQSD(TeacherQSDao tQSD) {
		TQSD = tQSD;
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


	public RowcolDao getRCD() {
		return RCD;
	}


	public void setRCD(RowcolDao rCD) {
		RCD = rCD;
	}


	public rowcol getRC() {
		return RC;
	}


	public void setRC(rowcol rC) {
		RC = rC;
	}
	

	public List getAddList() {
		return AddList;
	}


	public void setAddList(List addList) {
		AddList = addList;
	}
	

	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
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
	
	
	
	public List<rowcol> getShowList() {
		return showList;
	}


	public void setShowList(List<rowcol> showList) {
		this.showList = showList;
	}
	

	public List<ScoreCombination> getReturnListB() {
		return returnListB;
	}


	public void setReturnListB(List<ScoreCombination> returnListB) {
		this.returnListB = returnListB;
	}


	public List<ScoreCombination> getShowListB() {
		return showListB;
	}


	public void setShowListB(List<ScoreCombination> showListB) {
		this.showListB = showListB;
	}
	

	public ScoreCombination getSC() {
		return SC;
	}


	public void setSC(ScoreCombination sC) {
		SC = sC;
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
	
	

	public List<educationTable> getEducationList() {
		return educationList;
	}


	public void setEducationList(List<educationTable> educationList) {
		this.educationList = educationList;
	}
	

	public EduScoreDao getESD() {
		return ESD;
	}


	public void setESD(EduScoreDao eSD) {
		ESD = eSD;
	}

	
	
	public String getSelections() {
		return selections;
	}


	public void setSelections(String selections) {
		this.selections = selections;
	}


	public AutoSelectionsDao getASD() {
		return ASD;
	}


	public void setASD(AutoSelectionsDao aSD) {
		ASD = aSD;
	}
	

	public List<rowcolRea> getReareturnList() {
		return ReareturnList;
	}


	public void setReareturnList(List<rowcolRea> reareturnList) {
		ReareturnList = reareturnList;
	}


	public List<scorecombinationRea> getReareturnListB() {
		return ReareturnListB;
	}


	public void setReareturnListB(List<scorecombinationRea> reareturnListB) {
		ReareturnListB = reareturnListB;
	}


	public List<rowcolRea> getReashowList() {
		return ReashowList;
	}


	public void setReashowList(List<rowcolRea> reashowList) {
		ReashowList = reashowList;
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


	public researchTable getRT() {
		return RT;
	}


	public void setRT(researchTable rT) {
		RT = rT;
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
	
	//��ʾ��ѧ���Զ��������Ŀ
	public String showEduType(){
		try{
		List<AutoSelections> initialList=new ArrayList();
		AutoSelections AS=new AutoSelections();
		String AShql="select Selections from AutoSelections where Type='Education'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		
			AS.setSelections(content);
			AS.setID(1);
			AS.setType("EDU");
			System.out.println("SELECTIONS:"+content);
			initialList.add(AS);
		
		JSONArray json = JSONArray.fromObject(initialList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�о����Զ��������Ŀ
	public String showReaType(){
		try{
		List<AutoSelections> initialList=new ArrayList();
		AutoSelections AS=new AutoSelections();
		String AShql="select Selections from AutoSelections where Type='Research'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		
			AS.setSelections(content);
			AS.setID(1);
			AS.setType("REA");
			System.out.println("SELECTIONS:"+content);
			initialList.add(AS);
		
		JSONArray json = JSONArray.fromObject(initialList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	//��ʾ������Զ��������Ŀ
	public String showSerType(){
		try{
		List<AutoSelections> initialList=new ArrayList();
		AutoSelections AS=new AutoSelections();
		String AShql="select Selections from AutoSelections where Type='Serve'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		
			AS.setSelections(content);
			AS.setID(1);
			AS.setType("SER");
			System.out.println("SELECTIONS:"+content);
			initialList.add(AS);
		
		JSONArray json = JSONArray.fromObject(initialList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�̸����Զ��������Ŀ
	public String showAssType(){
		try{
		List<AutoSelections> initialList=new ArrayList();
		AutoSelections AS=new AutoSelections();
		String AShql="select Selections from AutoSelections where Type='Assistant'";
		String TempContent=ASD.queryContent(AShql);
		String content=TempContent.substring(1, TempContent.length()-1);
		
			AS.setSelections(content);
			AS.setID(1);
			AS.setType("ASS");
			System.out.println("SELECTIONS:"+content);
			initialList.add(AS);
		
		JSONArray json = JSONArray.fromObject(initialList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ��ѧ��Ҫ��ϲ���
	public String showCombinationA(){
		try{
		showList=new ArrayList();
		showList=RCD.getCombination();
		JSONArray json = JSONArray.fromObject(showList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�о���Ҫ��ϲ���
	public String showCombinationAR(){
		try{
		ReashowList=new ArrayList();
		ReashowList=RCRD.getCombination();
		JSONArray json = JSONArray.fromObject(ReashowList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�����Ҫ��ϲ���
	public String showCombinationAS(){
		try{
		SershowList=new ArrayList();
		SershowList=RCSD.getCombination();
		JSONArray json = JSONArray.fromObject(SershowList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�̸���Ҫ��ϲ���
	public String showCombinationAA(){
		try{
		AssshowList=new ArrayList();
		AssshowList=RCAD.getCombination();
		JSONArray json = JSONArray.fromObject(AssshowList);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ��ѧ��ɼ��ϲ���
	public String showCombinationB(){
		try{
		showListB=new ArrayList();
		showListB=RCD.getCombinationB();
		JSONArray json = JSONArray.fromObject(showListB);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�о���ɼ��ϲ���
	public String showCombinationBR(){
		try{
		ReashowListB=new ArrayList();
		ReashowListB=RCRD.getCombinationB();
		JSONArray json = JSONArray.fromObject(ReashowListB);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�����ɼ��ϲ���
	public String showCombinationBS(){
		try{
		SershowListB=new ArrayList();
		SershowListB=RCSD.getCombinationB();
		JSONArray json = JSONArray.fromObject(SershowListB);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��ʾ�̸���ɼ��ϲ���
	public String showCombinationBA(){
		try{
		AssshowListB=new ArrayList();
		AssshowListB=RCAD.getCombinationB();
		JSONArray json = JSONArray.fromObject(AssshowListB);
		result = json.toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�����ѧ���Զ����ֵ���Ŀ
	public String saveEduSe(){
		try{
			System.out.println("select:"+selections);
			String replace1=selections.replace("[","");
			System.out.println("select:"+replace1);
			String replaceTemp=replace1.replace("\\[","");
			System.out.println("select:"+replaceTemp);
			String replace2=replaceTemp.replace("\"","");
			String replace3=replace2.replace("\"","");
			String replace4=replace3.replace("]","");
			System.out.println("select:"+replace4);
			String updateEduSeHql="update AutoSelections  set Selections='"+replace4+ "'where Type ='Education'";
			ASD.updateEduSe(updateEduSeHql);
			List ll1=new ArrayList();
		//System.out.println("return"+returnList.size());
		JSONArray json = JSONArray.fromObject(ll1);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�����о����Զ����ֵ���Ŀ
	public String saveReaSe(){
		try{
			System.out.println("select:"+selections);
			String replace1=selections.replace("[","");
			System.out.println("select:"+replace1);
			String replaceTemp=replace1.replace("\\[","");
			System.out.println("select:"+replaceTemp);
			String replace2=replaceTemp.replace("\"","");
			String replace3=replace2.replace("\"","");
			String replace4=replace3.replace("]","");
			System.out.println("select:"+replace4);
			String updateEduSeHql="update AutoSelections  set Selections='"+replace4+ "'where Type ='Research'";
			ASD.updateEduSe(updateEduSeHql);
			List ll1=new ArrayList();
		//System.out.println("return"+returnList.size());
		JSONArray json = JSONArray.fromObject(ll1);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//���������Զ����ֵ���Ŀ
	public String saveSerSe(){
		try{
			System.out.println("select:"+selections);
			String replace1=selections.replace("[","");
			System.out.println("select:"+replace1);
			String replaceTemp=replace1.replace("\\[","");
			System.out.println("select:"+replaceTemp);
			String replace2=replaceTemp.replace("\"","");
			String replace3=replace2.replace("\"","");
			String replace4=replace3.replace("]","");
			System.out.println("select:"+replace4);
			String updateEduSeHql="update AutoSelections  set Selections='"+replace4+ "'where Type ='Serve'";
			ASD.updateEduSe(updateEduSeHql);
			List ll1=new ArrayList();
		//System.out.println("return"+returnList.size());
		JSONArray json = JSONArray.fromObject(ll1);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//����̸����Զ����ֵ���Ŀ
	public String saveAssSe(){
		try{
			System.out.println("select:"+selections);
			String replace1=selections.replace("[","");
			System.out.println("select:"+replace1);
			String replaceTemp=replace1.replace("\\[","");
			System.out.println("select:"+replaceTemp);
			String replace2=replaceTemp.replace("\"","");
			String replace3=replace2.replace("\"","");
			String replace4=replace3.replace("]","");
			System.out.println("select:"+replace4);
			String updateEduSeHql="update AutoSelections  set Selections='"+replace4+ "'where Type ='Assistant'";
			ASD.updateEduSe(updateEduSeHql);
			List ll1=new ArrayList();
		//System.out.println("return"+returnList.size());
		JSONArray json = JSONArray.fromObject(ll1);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�����ѧ��Ҫ��ϲ���
	public String saveCombinationA(){
		AddList= new ArrayList();
		returnList=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombination");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<rowcol> dataList=RCD.getCombination();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		RCD.insertOne(AddList);
		}
		if(saveList.size()>0){
		RCD.updaterowcol(saveList);
		}
		returnList=RCD.getCombination();
		List<educationTable> tableList=new ArrayList();
		List<educationTable> EduTable=new ArrayList();
		EduTable=ETD.getTable();
		for(int i=0;i<returnList.size();i++){
			boolean EduFlag=true;
			ET= new educationTable();
			ET.setName(String.valueOf(returnList.get(i).getID()));
			ET.setContent("要求通过");
			for(int f=0;f<EduTable.size();f++){
				if(ET.getName().equals(EduTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +ET.getName());
			if(EduFlag){
			tableList.add(ET);
			}
		}
		System.out.println("educationTable SIZE" +tableList.size());
		ETD.insertOneB(tableList);
		System.out.println("return"+returnList.size());
		JSONArray json = JSONArray.fromObject(returnList);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�����о���Ҫ��ϲ���
	public String saveCombinationAR(){
		AddList= new ArrayList();
		ReareturnList=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombination");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<rowcolRea> dataList=RCRD.getCombination();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		RCRD.insertOne(AddList);
		}
		if(saveList.size()>0){
		RCRD.updaterowcol(saveList);
		}
		ReareturnList=RCRD.getCombination();
		List<researchTable> tableList=new ArrayList();
		List<researchTable> ReaTable=new ArrayList();
		ReaTable=RTD.getTable();
		for(int i=0;i<ReareturnList.size();i++){
			boolean EduFlag=true;
			RT= new researchTable();
			RT.setName(String.valueOf(ReareturnList.get(i).getID()));
			RT.setContent("要求通过");
			for(int f=0;f<ReaTable.size();f++){
				if(RT.getName().equals(ReaTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +RT.getName());
			if(EduFlag){
			tableList.add(RT);
			}
		}
		System.out.println("educationTable SIZE" +tableList.size());
		RTD.insertOneB(tableList);
		System.out.println("return"+ReareturnList.size());
		JSONArray json = JSONArray.fromObject(ReareturnList);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��������Ҫ��ϲ���
	public String saveCombinationAS(){
		AddList= new ArrayList();
		SerreturnList=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombination");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<rowcolSer> dataList=RCSD.getCombination();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		RCSD.insertOne(AddList);
		}
		if(saveList.size()>0){
		RCSD.updaterowcol(saveList);
		}
		SerreturnList=RCSD.getCombination();
		List<serveTable> tableList=new ArrayList();
		List<serveTable> ReaTable=new ArrayList();
		ReaTable=STD.getTable();
		for(int i=0;i<SerreturnList.size();i++){
			boolean EduFlag=true;
			ST= new serveTable();
			ST.setName(String.valueOf(SerreturnList.get(i).getID()));
			ST.setContent("要求通过");
			for(int f=0;f<ReaTable.size();f++){
				if(ST.getName().equals(ReaTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +ST.getName());
			if(EduFlag){
			tableList.add(ST);
			}
		}
		System.out.println("educationTable SIZE" +tableList.size());
		STD.insertOneB(tableList);
		System.out.println("return"+SerreturnList.size());
		JSONArray json = JSONArray.fromObject(SerreturnList);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//����̸���Ҫ��ϲ���
	public String saveCombinationAA(){
		AddList= new ArrayList();
		AssreturnList=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombination");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<rowcolAss> dataList=RCAD.getCombination();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		RCAD.insertOne(AddList);
		}
		if(saveList.size()>0){
		RCAD.updaterowcol(saveList);
		}
		AssreturnList=RCAD.getCombination();
		List<assistantTable> tableList=new ArrayList();
		List<assistantTable> ReaTable=new ArrayList();
		ReaTable=ATD.getTable();
		for(int i=0;i<AssreturnList.size();i++){
			boolean EduFlag=true;
			AT= new assistantTable();
			AT.setName(String.valueOf(AssreturnList.get(i).getID()));
			AT.setContent("要求通过");
			for(int f=0;f<ReaTable.size();f++){
				if(AT.getName().equals(ReaTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +AT.getName());
			if(EduFlag){
			tableList.add(AT);
			}
		}
		System.out.println("educationTable SIZE" +tableList.size());
		ATD.insertOneB(tableList);
		System.out.println("return"+AssreturnList.size());
		JSONArray json = JSONArray.fromObject(AssreturnList);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�����ѧ��ɼ��ϲ���
	public String saveCombinationB(){
		AddList= new ArrayList();
		returnListB=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombinationB");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<ScoreCombination> dataList=RCD.getCombinationB();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		
		RCD.insertOneB(AddList);
		}
		if(saveList.size()>0){
		RCD.updaterowcolB(saveList);
		}
		returnListB=RCD.getCombinationB();
		List<educationTable> tableList=new ArrayList();
		List<educationTable> EduTable=new ArrayList();
		EduTable=ETD.getTable();
		for(int i=0;i<returnListB.size();i++){
			boolean EduFlag=true;
			ET= new educationTable();
			ET.setName(String.valueOf(returnListB.get(i).getID()));
			ET.setContent("通过得X分，不通过得X分");
			for(int f=0;f<EduTable.size();f++){
				if(ET.getName().equals(EduTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +ET.getName());
			if(EduFlag){
			tableList.add(ET);
			}
			
		}
		ETD.insertOneB(tableList);
		
		System.out.println("return"+returnListB.size());
		JSONArray json = JSONArray.fromObject(returnListB);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�����о���ɼ��ϲ���
	public String saveCombinationBR(){
		

		AddList= new ArrayList();
		ReareturnListB=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombinationB");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<scorecombinationRea> dataList=RCRD.getCombinationB();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		
		RCRD.insertOneB(AddList);
		}
		if(saveList.size()>0){
		RCRD.updaterowcolB(saveList);
		}
		ReareturnListB=RCRD.getCombinationB();
		List<researchTable> tableList=new ArrayList();
		List<researchTable> ReaTable=new ArrayList();
		ReaTable=RTD.getTable();
		for(int i=0;i<ReareturnListB.size();i++){
			boolean EduFlag=true;
			RT= new researchTable();
			RT.setName(String.valueOf(ReareturnListB.get(i).getID()));
			RT.setContent("通过得X分，不通过得X分");
			for(int f=0;f<ReaTable.size();f++){
				if(RT.getName().equals(ReaTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +RT.getName());
			if(EduFlag){
			tableList.add(RT);
			}
			
		}
		RTD.insertOneB(tableList);
		
		System.out.println("return"+ReareturnListB.size());
		JSONArray json = JSONArray.fromObject(ReareturnListB);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	
	}
	
	//��������ɼ��ϲ���
public String saveCombinationBS(){
		

		AddList= new ArrayList();
		SerreturnListB=new ArrayList();
		saveList=new ArrayList();
		boolean flag=true; 
		try {
		System.out.println("saveCombinationB");
		
		String replace1=including.replaceFirst("\\[","");
		String replace2=replace1.replace("\"","");
		String replace3=replace2.replace("\"","");
		String replace4=replace3.replace("]","");
		String replace5=replace4+",";
		System.out.println(replace5);
		String []reslut=replace5.split("\\[");
		Map AddMap=new HashMap();
		List<scorecombinationSer> dataList=RCSD.getCombinationB();
		
		for(int i=1;i<reslut.length;i=i+2){
			flag=true;
			System.out.println("action"+reslut[i]);
			String name=reslut[i].substring(0, reslut[i].length()-1);
			System.out.println("action"+name);
			String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
			for(int j=0;j<dataList.size();j++){
			
			if(String.valueOf(dataList.get(j).getID()).equals(name)){
				flag=false;
				
				}
			
			}
			System.out.println(flag);
			if(flag==true){
			AddList.add(name);
			AddList.add(value);
			}else{
			saveList.add(name);
			saveList.add(value);
			}
		}
		if(AddList.size()>0){
		
		RCSD.insertOneB(AddList);
		}
		if(saveList.size()>0){
		RCSD.updaterowcolB(saveList);
		}
		SerreturnListB=RCSD.getCombinationB();
		List<serveTable> tableList=new ArrayList();
		List<serveTable> ReaTable=new ArrayList();
		ReaTable=STD.getTable();
		for(int i=0;i<SerreturnListB.size();i++){
			boolean EduFlag=true;
			ST= new serveTable();
			ST.setName(String.valueOf(SerreturnListB.get(i).getID()));
			ST.setContent("通过得X分，不通过得X分");
			for(int f=0;f<ReaTable.size();f++){
				if(ST.getName().equals(ReaTable.get(f).getName())){
					EduFlag=false;
				}
			}
			System.out.println("ET NAME" +ST.getName());
			if(EduFlag){
			tableList.add(ST);
			}
			
		}
		STD.insertOneB(tableList);
		
		System.out.println("return"+SerreturnListB.size());
		JSONArray json = JSONArray.fromObject(SerreturnListB);
		result = json.toString();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	
	}
	
//����̸���ɼ��ϲ���
public String saveCombinationBA(){
	

	AddList= new ArrayList();
	AssreturnListB=new ArrayList();
	saveList=new ArrayList();
	boolean flag=true; 
	try {
	System.out.println("saveCombinationB");
	
	String replace1=including.replaceFirst("\\[","");
	String replace2=replace1.replace("\"","");
	String replace3=replace2.replace("\"","");
	String replace4=replace3.replace("]","");
	String replace5=replace4+",";
	System.out.println(replace5);
	String []reslut=replace5.split("\\[");
	Map AddMap=new HashMap();
	List<scorecombinationAss> dataList=RCAD.getCombinationB();
	
	for(int i=1;i<reslut.length;i=i+2){
		flag=true;
		System.out.println("action"+reslut[i]);
		String name=reslut[i].substring(0, reslut[i].length()-1);
		System.out.println("action"+name);
		String value=reslut[i+1].substring(0, reslut[i+1].length()-1);
		for(int j=0;j<dataList.size();j++){
		
		if(String.valueOf(dataList.get(j).getID()).equals(name)){
			flag=false;
			
			}
		
		}
		System.out.println(flag);
		if(flag==true){
		AddList.add(name);
		AddList.add(value);
		}else{
		saveList.add(name);
		saveList.add(value);
		}
	}
	if(AddList.size()>0){
	
	RCAD.insertOneB(AddList);
	}
	if(saveList.size()>0){
	RCAD.updaterowcolB(saveList);
	}
	AssreturnListB=RCAD.getCombinationB();
	List<assistantTable> tableList=new ArrayList();
	List<assistantTable> ReaTable=new ArrayList();
	ReaTable=ATD.getTable();
	for(int i=0;i<AssreturnListB.size();i++){
		boolean EduFlag=true;
		AT= new assistantTable();
		AT.setName(String.valueOf(AssreturnListB.get(i).getID()));
		AT.setContent("通过得X分，不通过得X分");
		for(int f=0;f<ReaTable.size();f++){
			if(AT.getName().equals(ReaTable.get(f).getName())){
				EduFlag=false;
			}
		}
		System.out.println("ET NAME" +AT.getName());
		if(EduFlag){
		tableList.add(AT);
		}
		
	}
	ATD.insertOneB(tableList);
	
	System.out.println("return"+AssreturnListB.size());
	JSONArray json = JSONArray.fromObject(AssreturnListB);
	result = json.toString();
	
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	return SUCCESS;

}
	//ɾ����ѧ���Զ����ֵ���Ŀ
	public String delEduSe(){
		try {
		String delName=name;
		System.out.println(delName);
		String updateEduSeHql="update AutoSelections  set Selections=''where Type ='Education'";
		ASD.updateEduSe(updateEduSeHql);
		
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ���о����Զ����ֵ���Ŀ
	public String delReaSe(){
		try {
		String delName=name;
		System.out.println(delName);
		String updateEduSeHql="update AutoSelections  set Selections=''where Type ='Research'";
		ASD.updateEduSe(updateEduSeHql);
		
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ��������Զ����ֵ���Ŀ
	public String delSerSe(){
		try {
		String delName=name;
		System.out.println(delName);
		String updateEduSeHql="update AutoSelections  set Selections=''where Type ='Serve'";
		ASD.updateEduSe(updateEduSeHql);
		
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ���̸����Զ����ֵ���Ŀ
	public String delAssSe(){
		try {
		String delName=name;
		System.out.println(delName);
		String updateEduSeHql="update AutoSelections  set Selections=''where Type ='Assistant'";
		ASD.updateEduSe(updateEduSeHql);
		
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ����ѧ��Ҫ��ϲ���
	public String delCombinationA(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCD.deleteCombinationById(ID);
		List<educationTable> ETT=new ArrayList();
		ETT=ETD.getTableByName(String.valueOf(ID));
		ETD.deleteCombinationAById(ETT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ���о���Ҫ��ϲ���
	public String delCombinationAR(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCRD.deleteCombinationById(ID);
		List<researchTable> RTT=new ArrayList();
		RTT=RTD.getTableByName(String.valueOf(ID));
		RTD.deleteCombinationAById(RTT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ�������Ҫ��ϲ���
	public String delCombinationAS(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCSD.deleteCombinationById(ID);
		List<serveTable> RTT=new ArrayList();
		RTT=STD.getTableByName(String.valueOf(ID));
		STD.deleteCombinationAById(RTT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ���̸���Ҫ��ϲ���
	public String delCombinationAA(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCAD.deleteCombinationById(ID);
		List<assistantTable> ATT=new ArrayList();
		ATT=ATD.getTableByName(String.valueOf(ID));
		ATD.deleteCombinationAById(ATT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ����ѧ��ɼ��ϲ���
	public String delCombinationB(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCD.deleteCombinationAById(ID);
		List<educationTable> ETT=new ArrayList();
		ETT=ETD.getTableByName(String.valueOf(ID));
		ETD.deleteCombinationAById(ETT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ���о���Ҫ��ϲ���
	public String delCombinationBR(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCRD.deleteCombinationAById(ID);
		List<researchTable> RTT=new ArrayList();
		RTT=RTD.getTableByName(String.valueOf(ID));
		RTD.deleteCombinationAById(RTT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ�������Ҫ��ϲ���
	public String delCombinationBS(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCSD.deleteCombinationAById(ID);
		List<serveTable> RTT=new ArrayList();
		RTT=STD.getTableByName(String.valueOf(ID));
		STD.deleteCombinationAById(RTT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//ɾ���̸���Ҫ��ϲ���
	public String delCombinationBA(){
		try {
		String delName=name;
		System.out.println(delName);
		int ID =  Integer.parseInt(delName);
		RCAD.deleteCombinationAById(ID);
		List<assistantTable> RTT=new ArrayList();
		RTT=ATD.getTableByName(String.valueOf(ID));
		ATD.deleteCombinationAById(RTT.get(0).getID());
		result=null;
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	//��ȡ��ʦ�˽�ѧ��
	public String getEduTable(){
		try{
			int maxCol=0;
			educationList=new ArrayList();
			List<educationTable> eduList=new ArrayList();
			eduList=ETD.getTable();
			
			String tdLast="";
			List EdureturnList=new ArrayList();
			//�������򿼺���
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
			
			List<rowcol> RcReturn=new ArrayList();
			List<ScoreCombination> ScReturn=new ArrayList();
			//��ȡ teacher ID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			RcReturn=RCD.getCombination();
			ScReturn=RCD.getCombinationB();
			//��ȡ�Զ���Ŀ
			String AShql="select Selections from AutoSelections where Type='Education'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			System.out.println("SelContent:"+SelContent);
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
				//��ȡ����
				String ScoreName=educationList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from EduScore where TeacherID='"+TID+"'";
				String scoreTemp=ESD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from EduScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=ESD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//��ȡͨ����Ŀ
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
							td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' bgcolor='#cccccc'>"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' bgcolor='#cccccc'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(educationList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' bgcolor='#cccccc'>"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' bgcolor='#cccccc'>"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td id='"+educationList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+educationList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
							tdLast="<td  id='"+educationList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+educationList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(educationList.get(i).getName())){
							tdLast="<td  id='"+educationList.get(i).getName()+"c' bgcolor='#cccccc'>"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+educationList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+educationList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
				
				EdureturnList.add(td1);
				
				
			
			}
			String EduAll=TQSD.getTableByTID(TID).get(0).getEduScore();
			int LastMax=maxCol+2;
			
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+EduAll+"</td>";
			EdureturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(EdureturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	}
	
	////��ȡ����Ա�˽�ѧ��
	public String AdGetEduTable(){

		try{
			int maxCol=0;
			educationList=new ArrayList();
			List<educationTable> eduList=new ArrayList();
			eduList=ETD.getTable();
			
			String tdLast="";
			List EdureturnList=new ArrayList();
			
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
			for(int r=0;r<educationList.size();r++){
				System.out.println("EDUTEST"+educationList.get(r).getName());
			}
			
			List<rowcol> RcReturn=new ArrayList();
			List<ScoreCombination> ScReturn=new ArrayList();
			
			RcReturn=RCD.getCombination();
			ScReturn=RCD.getCombinationB();
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
					td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+educationList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td>通过项目</td><td>"+educationList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+educationList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td colspan='"+maxCol+"'>"+educationList.get(i).getContent()+"</td><td>通过项目</td><td>"+educationList.get(i).getScore()+"</td>";
						
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
					tdLast="<td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+educationList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td>"+educationList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+educationList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td>"+educationList.get(i).getScore()+"</td>";
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
				EdureturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>100</td>";
			EdureturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(EdureturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	//��ȡ���޸ĵĽ�ѧ��
	public String getEduTableM(){
		try{
			int maxCol=0;
			educationList=new ArrayList();
			List<educationTable> eduList=new ArrayList();
			eduList=ETD.getTable();
			
			String tdLast="";
			List EdureturnList=new ArrayList();
			
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
				boolean specialflag=true;
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
						specialflag=false;
					}
				}
				if(specialflag){
					specialString=specialString+eduList.get(q).getName()+"+";
				}
			}
			for(int r=0;r<educationList.size();r++){
				System.out.println("EDUTEST"+educationList.get(r).getName());
			}
			
			List<rowcol> RcReturn=new ArrayList();
			List<ScoreCombination> ScReturn=new ArrayList();
			
			RcReturn=RCD.getCombination();
			ScReturn=RCD.getCombinationB();
			for(int i=0;i<educationList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				List IDList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				
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
					td1="<td name='EduM' colspan='"+maxCol+"' id='"+educationList.get(i).getName()+"' onclick='change(this)'>"+educationList.get(i).getContent()+"</td><td></td><td name='EduM' id='"+educationList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+educationList.get(i).getName()+"+AllScore' onclick='change(this)'>"+educationList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+educationList.get(i).getName()+"' onclick='change(this)'>"+educationList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+educationList.get(i).getName()+"+Score' onclick='change(this)'>"+educationList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+educationList.get(i).getName()+"+AllScore' onclick='change(this)'>"+educationList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+educationList.get(i).getName()+"' onclick='change(this)'>"+educationList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+educationList.get(i).getName()+"+Score' onclick='change(this)'>"+educationList.get(i).getScore()+"</td>";
						
					}
					}else{
					tdList.add(educationList.get(i).getContent());
					countList.add(0);
					IDList.add("0");
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
								IDList.add(ID);
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
								IDList.add(ID);
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
					tdLast="<td ></td><td name='EduM' id='"+educationList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+educationList.get(i).getName()+"+AllScore' onclick='change(this)'>"+educationList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+educationList.get(i).getName()+"+Score' onclick='change(this)'>"+educationList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+educationList.get(i).getName()+"+AllScore' onclick='change(this)'>"+educationList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+educationList.get(i).getName()+"+Score' onclick='change(this)'>"+educationList.get(i).getScore()+"</td>";
					}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td name='EduM' rowspan='"+countList.get(c)+"' style='vertical-align:middle' id='"+IDList.get(c)+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td name='EduM' id='"+educationList.get(i).getName()+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				EdureturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td></td>";
			EdureturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(EdureturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	}
	
	
	
	//��ȡ��ʦ���о���
	public String getReaTable(){

		try{
			int maxCol=0;
			researchList=new ArrayList();
			List<researchTable> reaList=new ArrayList();
			reaList=RTD.getTable();
			
			String tdLast="";
			List ReareturnList=new ArrayList();
			//�������򿼺���
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
					System.out.println("NULL NULL:"+reaList.get(q).getName());
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
			System.out.println("=================================================");
			System.out.println(specialString);
			for(int r=0;r<researchList.size();r++){
				
				System.out.println("EDUTEST"+researchList.get(r).getName());
				
			}
			System.out.println("=================================================");
			List<rowcolRea> RcReturn=new ArrayList();
			List<scorecombinationRea> ScReturn=new ArrayList();
			//��ȡ teacher ID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			RcReturn=RCRD.getCombination();
			ScReturn=RCRD.getCombinationB();
			//��ȡ�Զ���Ŀ
			String AShql="select Selections from AutoSelections where Type='Research'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			System.out.println("SelContent:"+SelContent);
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
				//��ȡ����
				String ScoreName=researchList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from researchScore where TeacherID='"+TID+"'";
				String scoreTemp=RSD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from researchScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=RSD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//��ȡͨ����Ŀ
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
							td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(researchList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td id='"+researchList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+researchList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
							tdLast="<td  id='"+researchList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+researchList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(researchList.get(i).getName())){
							tdLast="<td  id='"+researchList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+researchList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+researchList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
			String ReaAll=TQSD.getTableByTID(TID).get(0).getReaScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+ReaAll+"</td>";
			ReareturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(ReareturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	//��ȡ����Ա���о���
	public String AdGetReaTable(){

		try{
			int maxCol=0;
			researchList=new ArrayList();
			List<researchTable> reaList=new ArrayList();
			reaList=RTD.getTable();
			
			String tdLast="";
			List EdureturnList=new ArrayList();
			
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
			for(int r=0;r<researchList.size();r++){
				System.out.println("REATEST"+researchList.get(r).getName());
			}
			
			List<rowcolRea> RcReturn=new ArrayList();
			List<scorecombinationRea> ScReturn=new ArrayList();
			
			RcReturn=RCRD.getCombination();
			ScReturn=RCRD.getCombinationB();
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
					td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+researchList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td>通过项目</td><td>"+researchList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+researchList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td colspan='"+maxCol+"'>"+researchList.get(i).getContent()+"</td><td>通过项目</td><td>"+researchList.get(i).getScore()+"</td>";
						
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
					tdLast="<td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+researchList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td>"+researchList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+researchList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td>"+researchList.get(i).getScore()+"</td>";
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
				EdureturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>100</td>";
			EdureturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(EdureturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	
	}
	//��ȡ���޸ĵ��о���
	public String getReaTableM(){

		try{
			int maxCol=0;
			researchList=new ArrayList();
			List<researchTable> reaList=new ArrayList();
			reaList=RTD.getTable();
			
			String tdLast="";
			List EdureturnList=new ArrayList();
			
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
				boolean specialflag=true;
				String head=reaList.get(q).getName().substring(0,1);
				int NameNum=Integer.parseInt(reaList.get(q).getName().substring(1, 2));
				if(NameNum==1){
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
						specialflag=false;
					}
				}
				if(specialflag){
					specialString=specialString+reaList.get(q).getName()+"+";
				}
			}
			for(int r=0;r<researchList.size();r++){
				System.out.println("REATEST"+researchList.get(r).getName());
			}
			
			List<rowcolRea> RcReturn=new ArrayList();
			List<scorecombinationRea> ScReturn=new ArrayList();
			
			RcReturn=RCRD.getCombination();
			ScReturn=RCRD.getCombinationB();
			for(int i=0;i<researchList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				List IDList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				
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
					td1="<td name='EduM' colspan='"+maxCol+"' id='"+researchList.get(i).getName()+"' onclick='change(this)'>"+researchList.get(i).getContent()+"</td><td></td><td name='EduM' id='"+researchList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+researchList.get(i).getName()+"+AllScore' onclick='change(this)'>"+researchList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+researchList.get(i).getName()+"' onclick='change(this)'>"+researchList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+researchList.get(i).getName()+"+Score' onclick='change(this)'>"+researchList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+researchList.get(i).getName()+"+AllScore' onclick='change(this)'>"+researchList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+researchList.get(i).getName()+"' onclick='change(this)'>"+researchList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+researchList.get(i).getName()+"+Score' onclick='change(this)'>"+researchList.get(i).getScore()+"</td>";
						
					}
					}else{
					tdList.add(researchList.get(i).getContent());
					countList.add(0);
					IDList.add("0");
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
								IDList.add(ID);
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
								IDList.add(ID);
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
					tdLast="<td ></td><td name='EduM' id='"+researchList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+researchList.get(i).getName()+"+AllScore' onclick='change(this)'>"+researchList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+researchList.get(i).getName()+"+Score' onclick='change(this)'>"+researchList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+researchList.get(i).getName()+"+AllScore' onclick='change(this)'>"+researchList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+researchList.get(i).getName()+"+Score' onclick='change(this)'>"+researchList.get(i).getScore()+"</td>";
					}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td name='EduM' rowspan='"+countList.get(c)+"' style='vertical-align:middle' id='"+IDList.get(c)+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td name='EduM' id='"+researchList.get(i).getName()+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				EdureturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td></td>";
			EdureturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(EdureturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	////��ȡ��ʦ�˷����
	public String getSerTable(){

		try{
			int maxCol=0;
			serveList=new ArrayList();
			List<serveTable> serList=new ArrayList();
			serList=STD.getTable();
			
			String tdLast="";
			List SerreturnList=new ArrayList();
			//�������򿼺���
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
					System.out.println("NULL NULL:"+serList.get(q).getName());
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
			System.out.println("=================================================");
			System.out.println(specialString);
			for(int r=0;r<serveList.size();r++){
				
				System.out.println("EDUTEST"+serveList.get(r).getName());
				
			}
			System.out.println("=================================================");
			List<rowcolSer> RcReturn=new ArrayList();
			List<scorecombinationSer> ScReturn=new ArrayList();
			//��ȡ teacher ID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			RcReturn=RCSD.getCombination();
			ScReturn=RCSD.getCombinationB();
			//��ȡ�Զ���Ŀ
			String AShql="select Selections from AutoSelections where Type='Serve'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			System.out.println("SelContent:"+SelContent);
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
				//��ȡ����
				String ScoreName=serveList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from serveScore where TeacherID='"+TID+"'";
				String scoreTemp=SSD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from serveScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=SSD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//��ȡͨ����Ŀ
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
							td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(serveList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td id='"+serveList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+serveList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
							tdLast="<td  id='"+serveList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+serveList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(serveList.get(i).getName())){
							tdLast="<td  id='"+serveList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+serveList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+serveList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
				SerreturnList.add(td1);
				
				
			
			}
			String SerAll=TQSD.getTableByTID(TID).get(0).getSerScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+SerAll+"</td>";
			SerreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(SerreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	//��ȡ����Ա���о���
	public String AdGetSerTable(){

		try{
			int maxCol=0;
			serveList=new ArrayList();
			List<serveTable> serList=new ArrayList();
			serList=STD.getTable();
			
			String tdLast="";
			List SerreturnList=new ArrayList();
			
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
			for(int r=0;r<serveList.size();r++){
				System.out.println("REATEST"+serveList.get(r).getName());
			}
			
			List<rowcolSer> RcReturn=new ArrayList();
			List<scorecombinationSer> ScReturn=new ArrayList();
			
			RcReturn=RCSD.getCombination();
			ScReturn=RCSD.getCombinationB();
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
					td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+serveList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td>通过项目</td><td>"+serveList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+serveList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td colspan='"+maxCol+"'>"+serveList.get(i).getContent()+"</td><td>通过项目</td><td>"+serveList.get(i).getScore()+"</td>";
						
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
					tdLast="<td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+serveList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td>"+serveList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+serveList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td>"+serveList.get(i).getScore()+"</td>";
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
				SerreturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>100</td>";
			SerreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(SerreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	
	}
	
	//��ȡ���޸ĵķ����
	public String getSerTableM(){

		try{
			int maxCol=0;
			serveList=new ArrayList();
			List<serveTable> serList=new ArrayList();
			serList=STD.getTable();
			
			String tdLast="";
			List SerreturnList=new ArrayList();
			
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
				boolean specialflag=true;
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
						specialflag=false;
					}
				}
				if(specialflag){
					specialString=specialString+serList.get(q).getName()+"+";
				}
			}
			for(int r=0;r<serveList.size();r++){
				System.out.println("REATEST"+serveList.get(r).getName());
			}
			
			List<rowcolSer> RcReturn=new ArrayList();
			List<scorecombinationSer> ScReturn=new ArrayList();
			
			RcReturn=RCSD.getCombination();
			ScReturn=RCSD.getCombinationB();
			for(int i=0;i<serveList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				List IDList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				
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
					td1="<td name='EduM' colspan='"+maxCol+"' id='"+serveList.get(i).getName()+"' onclick='change(this)'>"+serveList.get(i).getContent()+"</td><td></td><td name='EduM' id='"+serveList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+serveList.get(i).getName()+"+AllScore' onclick='change(this)'>"+serveList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+serveList.get(i).getName()+"' onclick='change(this)'>"+serveList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+serveList.get(i).getName()+"+Score' onclick='change(this)'>"+serveList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+serveList.get(i).getName()+"+AllScore' onclick='change(this)'>"+serveList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+serveList.get(i).getName()+"' onclick='change(this)'>"+serveList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+serveList.get(i).getName()+"+Score' onclick='change(this)'>"+serveList.get(i).getScore()+"</td>";
						
					}
					}else{
					tdList.add(serveList.get(i).getContent());
					countList.add(0);
					IDList.add("0");
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
								IDList.add(ID);
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
								IDList.add(ID);
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
					tdLast="<td ></td><td name='EduM' id='"+serveList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+serveList.get(i).getName()+"+AllScore' onclick='change(this)'>"+serveList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+serveList.get(i).getName()+"+Score' onclick='change(this)'>"+serveList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+serveList.get(i).getName()+"+AllScore' onclick='change(this)'>"+serveList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+serveList.get(i).getName()+"+Score' onclick='change(this)'>"+serveList.get(i).getScore()+"</td>";
					}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td name='EduM' rowspan='"+countList.get(c)+"' style='vertical-align:middle' id='"+IDList.get(c)+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td name='EduM' id='"+serveList.get(i).getName()+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				SerreturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td></td>";
			SerreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(SerreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	////��ȡ��ʦ�˽̸���
	public String getAssTable(){

		try{
			int maxCol=0;
			assistantList=new ArrayList();
			List<assistantTable> assList=new ArrayList();
			assList=ATD.getTable();
			
			String tdLast="";
			List AssreturnList=new ArrayList();
			//�������򿼺���
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
					System.out.println("NULL NULL:"+assList.get(q).getName());
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
			System.out.println("=================================================");
			System.out.println(specialString);
			for(int r=0;r<assistantList.size();r++){
				
				System.out.println("EDUTEST"+assistantList.get(r).getName());
				
			}
			System.out.println("=================================================");
			List<rowcolAss> RcReturn=new ArrayList();
			List<scorecombinationAss> ScReturn=new ArrayList();
			//��ȡ teacher ID
			Map session = ActionContext.getContext().getSession();
			String TID=(String) session.get("t_ID");
			
			RcReturn=RCAD.getCombination();
			ScReturn=RCAD.getCombinationB();
			//��ȡ�Զ���Ŀ
			String AShql="select Selections from AutoSelections where Type='Assistant'";
			String TempContent=ASD.queryContent(AShql);
			String SelContent=TempContent.substring(1, TempContent.length()-1);
			System.out.println("SelContent:"+SelContent);
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
				//��ȡ����
				String ScoreName=assistantList.get(i).getName()+"s";
				String ScoreHql="select "+ScoreName+" from assistantScore where TeacherID='"+TID+"'";
				String scoreTemp=ASSD.queryScore(ScoreHql);
				String Score=scoreTemp.substring(1,scoreTemp.length()-1 );
				String AllScoreName=ScoreName.substring(0, 1)+"0";
				String hqlAll="select "+AllScoreName+" from assistantScore where TeacherID='"+TID+"'";
				String ScoreAllTemp=ASSD.queryScore(hqlAll);
				String ScoreAll=ScoreAllTemp.substring(1, ScoreAllTemp.length()-1);
				//��ȡͨ����Ŀ
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
							td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}else{
							td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle' id='"+headName+"0'>"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(assistantList.get(i).getName())){
							td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
						td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td id='"+assistantList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td id='"+assistantList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
							
						}else{
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'  id='"+headName+"0' >"+ScoreAll+"</td>";
						}
					}
					}else{
						if(SelContent.contains(assistantList.get(i).getName())){
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' bgcolor='#cccccc' >"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' bgcolor='#cccccc' >"+Score+"</td>";
							
						}else{
							tdLast="<td  id='"+assistantList.get(i).getName()+"c' onclick='ContentChange(this)'>"+ScoreContent+"</td><td  id='"+assistantList.get(i).getName()+"s' onclick='change(this)'>"+Score+"</td>";
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
			String AssAll=TQSD.getTableByTID(TID).get(0).getAssScore();
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>"+AssAll+"</td>";
			AssreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(AssreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	//��ȡ����Ա�˽̸���
	public String AdGetAssTable(){

		try{
			int maxCol=0;
			assistantList=new ArrayList();
			List<assistantTable> assList=new ArrayList();
			assList=ATD.getTable();
			
			String tdLast="";
			List AssreturnList=new ArrayList();
			
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
			for(int r=0;r<assistantList.size();r++){
				System.out.println("REATEST"+assistantList.get(r).getName());
			}
			
			List<rowcolAss> RcReturn=new ArrayList();
			List<scorecombinationAss> ScReturn=new ArrayList();
			
			RcReturn=RCAD.getCombination();
			ScReturn=RCAD.getCombinationB();
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
					td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+assistantList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td>通过项目</td><td>"+assistantList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+assistantList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td colspan='"+maxCol+"'>"+assistantList.get(i).getContent()+"</td><td>通过项目</td><td>"+assistantList.get(i).getScore()+"</td>";
						
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
					tdLast="<td></td><td></td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+assistantList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td>"+assistantList.get(i).getScore()+"</td><td rowspan='"+maxRow+"' style='vertical-align:middle'>"+assistantList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td>"+assistantList.get(i).getScore()+"</td>";
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
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td>100</td>";
			AssreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(AssreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	
	}
	
	//��ȡ���޸ĵĽ̸���
	public String getAssTableM(){

		try{
			int maxCol=0;
			assistantList=new ArrayList();
			List<assistantTable> assList=new ArrayList();
			assList=ATD.getTable();
			
			String tdLast="";
			List AssreturnList=new ArrayList();
			
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
				boolean specialflag=true;
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
						specialflag=false;
					}
				}
				if(specialflag){
					specialString=specialString+assList.get(q).getName()+"+";
				}
			}
			for(int r=0;r<assistantList.size();r++){
				System.out.println("REATEST"+assistantList.get(r).getName());
			}
			
			List<rowcolAss> RcReturn=new ArrayList();
			List<scorecombinationAss> ScReturn=new ArrayList();
			
			RcReturn=RCAD.getCombination();
			ScReturn=RCAD.getCombinationB();
			for(int i=0;i<assistantList.size();i++){
				List RcID=new ArrayList();
				List RcIncluding=new ArrayList();
				List ScID=new ArrayList();
				List ScIncluding=new ArrayList();
				List tdList=new ArrayList();
				List countList=new ArrayList();
				List IDList=new ArrayList();
				boolean RcFlag=true;
				boolean ScFlag=true;
				int RcCol=0;
				int ScCol=0;
				int rowSpanA=0;
				int rowSpanB=0;
				int colSpan=0;
				
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
					td1="<td name='EduM' colspan='"+maxCol+"' id='"+assistantList.get(i).getName()+"' onclick='change(this)'>"+assistantList.get(i).getContent()+"</td><td></td><td name='EduM' id='"+assistantList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+assistantList.get(i).getName()+"+AllScore' onclick='change(this)'>"+assistantList.get(i).getAllScore()+"</td>";
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+assistantList.get(i).getName()+"' onclick='change(this)'>"+assistantList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+assistantList.get(i).getName()+"+Score' onclick='change(this)'>"+assistantList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+assistantList.get(i).getName()+"+AllScore' onclick='change(this)'>"+assistantList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						td1="<td name='EduM' colspan='"+maxCol+"' id='"+assistantList.get(i).getName()+"' onclick='change(this)'>"+assistantList.get(i).getContent()+"</td><td>通过项目</td><td name='EduM' id='"+assistantList.get(i).getName()+"+Score' onclick='change(this)'>"+assistantList.get(i).getScore()+"</td>";
						
					}
					}else{
					tdList.add(assistantList.get(i).getContent());
					countList.add(0);
					IDList.add("0");
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
								IDList.add(ID);
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
								IDList.add(ID);
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
					tdLast="<td ></td><td name='EduM' id='"+assistantList.get(i).getName()+"+Score' ></td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+assistantList.get(i).getName()+"+AllScore' onclick='change(this)'>"+assistantList.get(i).getAllScore()+"</td>";
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+assistantList.get(i).getName()+"+Score' onclick='change(this)'>"+assistantList.get(i).getScore()+"</td><td name='EduM' rowspan='"+maxRow+"' style='vertical-align:middle' id='"+assistantList.get(i).getName()+"+AllScore' onclick='change(this)'>"+assistantList.get(i).getAllScore()+"</td>";
						
					}
					}else{
						tdLast="<td>通过项目</td><td name='EduM' id='"+assistantList.get(i).getName()+"+Score' onclick='change(this)'>"+assistantList.get(i).getScore()+"</td>";
					}
					int AcolSpan=maxCol-tdList.size();
					for(int c=0;c<tdList.size();c++){
						
					if(c!=0){
						td1=td1+"<td name='EduM' rowspan='"+countList.get(c)+"' style='vertical-align:middle' id='"+IDList.get(c)+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}else{
						System.out.println("!!!!jingru0:");
						td1=td1+"<td name='EduM' id='"+assistantList.get(i).getName()+"' onclick='change(this)'>"+tdList.get(c)+"</td>";
					}
					}
					
			
					td1=td1+tdLast;
				
			}
				System.out.println("!!!!TD1:"+td1);
				
				System.out.println("TD1:"+td1);
				AssreturnList.add(td1);
				
				
			
			}
			int LastMax=maxCol+2;
			System.out.println("maxCol="+maxCol);
			String LastTr="<td id='HJ' colspan='"+LastMax+"' style='text-align: center'>合计</td><td></td>";
			AssreturnList.add(LastTr);
			JSONArray json = JSONArray.fromObject(AssreturnList);
			result = json.toString();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	
	}
	
	
	
	
	
}
