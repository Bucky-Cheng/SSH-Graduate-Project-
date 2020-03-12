package com.ssh.action;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.DeclineDao;
import com.ssh.dao.NoticeTableDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.model.Decline;
import com.ssh.model.NoticeTable;
import com.ssh.model.TeacherInfo;

import net.sf.json.JSONArray;


public class NoticeAction extends ActionSupport{
	
	private String Type;
	private String Theme;
	private String Content;
	private String result;
	private String NoticeID;
	private String TID;
	private File upload;
	private String uploadFileName;
	private String delID;
	private String FileName;
	private String path;
	private InputStream NoticeFile;
	private InputStream downLoad;
	private String fileNameD;
	private String pathD;
	@Autowired
	private NoticeTableDao NTD;
	@Autowired
	private TeacherMDao TMD;
	@Autowired
	private DeclineDao DLD;
	
	
	
	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public NoticeTableDao getNTD() {
		return NTD;
	}



	public void setNTD(NoticeTableDao nTD) {
		NTD = nTD;
	}
	


	public String getType() {
		return Type;
	}



	public void setType(String type) {
		Type = type;
	}



	public String getTheme() {
		return Theme;
	}



	public void setTheme(String theme) {
		Theme = theme;
	}



	public String getContent() {
		return Content;
	}



	public void setContent(String content) {
		Content = content;
	}
	


	public File getUpload() {
		return upload;
	}



	public void setUpload(File upload) {
		this.upload = upload;
	}



	public String getUploadFileName() {
		return uploadFileName;
	}



	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}



	public String getFileName() {
		return FileName;
	}



	public void setFileName(String fileName) {
		FileName = fileName;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public InputStream getNoticeFile() {
		return NoticeFile;
	}



	public void setNoticeFile(InputStream noticeFile) {
		NoticeFile = noticeFile;
	}
	


	public String getDelID() {
		return delID;
	}



	public void setDelID(String delID) {
		this.delID = delID;
	}
	


	public String getNoticeID() {
		return NoticeID;
	}



	public void setNoticeID(String noticeID) {
		NoticeID = noticeID;
	}
	


	public String getTID() {
		return TID;
	}



	public void setTID(String tID) {
		TID = tID;
	}
	


	public TeacherMDao getTMD() {
		return TMD;
	}



	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}
	


	public InputStream getDownLoad() {
		return downLoad;
	}



	public void setDownLoad(InputStream downLoad) {
		this.downLoad = downLoad;
	}



	public String getPathD() {
		return pathD;
	}



	public void setPathD(String pathD) {
		this.pathD = pathD;
	}
	


	public String getFileNameD() {
		return fileNameD;
	}



	public void setFileNameD(String fileNameD) {
		this.fileNameD = fileNameD;
	}



	//获取通知列表
	public String getTable(){
		List<NoticeTable> NT=new ArrayList();
		NT=NTD.getNotice();
		for(int i=0;i<NT.size();i++){
			if(NT.get(i).getNoticeContent().length()>5){
				String Content=NT.get(i).getNoticeContent().substring(0, 4)+"...";
				NT.get(i).setNoticeContent(Content);
			}
		}
		JSONArray json = JSONArray.fromObject(NT);
		result = json.toString();
		return SUCCESS;
	}
	
	//教职工端根据类别获取通知
	public String getTableByType(){
		//获取教职工类别
			Map session = ActionContext.getContext().getSession();
			String TeacherID=(String) session.get("t_ID");
			String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
			//查询
			List<NoticeTable> NT=new ArrayList();
			NT=NTD.getTeacherNotice(Type);
			JSONArray json = JSONArray.fromObject(NT);
			result = json.toString();
			return SUCCESS;
	}
	
	//获取驳回列表
	public String AttentionSystem(){
		//获取教职工
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		//查询
		List<TeacherInfo> TIL=new ArrayList();
		TIL=TMD.getTableByTID(TeacherID);
		String Department=TIL.get(0).getDepartment();
		List<NoticeTable> NTL=new ArrayList();
		NTL=NTD.getTeacherNotice(Department);
		String NumTemp=TIL.get(0).getNotice().replace(" ", "");
		String[] Num=NumTemp.split(",");
		List returnList=new ArrayList();
		for(int i=0;i<Num.length;i++){
			System.out.println("READED NUM"+Num[i]);
				returnList.add(Num[i]);
			
		}
		if(returnList.size()>=NTL.size()){
			returnList.add("SystemNotice");
		}
		JSONArray json = JSONArray.fromObject(returnList);
		result = json.toString();
		return SUCCESS;
	}
	
	//获取该教职工的通知
	public String TeacherShow(){
		List<NoticeTable> NT=new ArrayList();
		
		
		NT=NTD.getTeacherNoticeByID(Integer.parseInt(NoticeID));
		JSONArray json = JSONArray.fromObject(NT);
		result = json.toString();
		return SUCCESS;
	}
	
	//获取该教职工被驳回的通知
	public String TeacherShowD(){
		List<Decline> DCT=new ArrayList();
		
		
		DCT=DLD.getDeclineByID(Integer.parseInt(NoticeID));
		DCT.get(0).setFlag("T");
		DLD.updateDecline(DCT.get(0));
		
		JSONArray json = JSONArray.fromObject(DCT);
		result = json.toString();
		return SUCCESS;
	}
	
	
	public String Num(){
		//获取教职工工号
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		List<TeacherInfo> TIL=new ArrayList();
		System.out.println("TID"+TID);
		
		TIL=TMD.getTableByTID(TeacherID);
		TIL.get(0).setNotice(TIL.get(0).getNotice()+TID+",");
		TMD.updateNoticeID(TIL.get(0));
		List returnL=new ArrayList();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	//保存附件
	public String FileSave() throws Exception{
		Map session = ActionContext.getContext().getSession();
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		path = ServletActionContext.getServletContext().getRealPath("/NoticeUpload/");
		File file = new File(path);
		if (!file.exists()) {//如果文件夹不存在则自动创建
			file.mkdir();
		}
		// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
		System.out.println("INITIAL NOTICEFILE LOC:"+uploadFileName);
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		String file2 = new File(file, uploadFileName).toString();
		System.out.println("NOTICEFILE LOC:"+uploadFileName);
		//文件地址存入session
		session.put("FileLoc",uploadFileName);
		String[] a=uploadFileName.split("\\.");
		String FileFlag=a[1];
		System.out.println("FILE Flag:"+uploadFileName);
		
		List returnL=new ArrayList();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	//删除通知
	public String DelID(){
		//改变通知编号
		List<NoticeTable> INT=new ArrayList();
		INT=NTD.getNotice();
		for(int i=0;i<INT.size();i++){
			if(INT.get(i).getID()>Integer.parseInt(delID)){
				INT.get(i).setNoticeID(INT.get(i).getNoticeID()-1);
				NTD.updateNoticeID(INT.get(i));
			}
		}
		//删除通知
		NTD.deleteNoticeById(Integer.parseInt(delID));
		//重新获取通知
		List<NoticeTable> NT=new ArrayList();
		NT=NTD.getNotice();
		
		JSONArray json = JSONArray.fromObject(NT);
		result = json.toString();
		return SUCCESS;
	}
	
	//保存通知
	public String Save(){
		Map session = ActionContext.getContext().getSession();
		//获取发布时间
		Calendar calendar = Calendar.getInstance();      
		int year = calendar.get(Calendar.YEAR);      
		int month = calendar.get(Calendar.MONTH);      
		int day = calendar.get(Calendar.DATE);      
		int hour = calendar.get(Calendar.HOUR_OF_DAY);      
		int minute = calendar.get(Calendar.MINUTE);      
		int second = calendar.get(Calendar.SECOND);
		
		List<NoticeTable> NT=new ArrayList();
		NT=NTD.getNotice();
		int NoticeID=NT.get(NT.size()-1).getNoticeID();
		int NewID=NoticeID+1;
		NoticeTable NTC=new NoticeTable();
		NTC.setNoticeID(NewID);
		NTC.setNoticeTheme(Theme);
		NTC.setNoticeContent(Content);
		NTC.setType(Type);
		String StartTime=year+"/"+month+"/"+day+"/"+hour+":"+minute+":"+second;
		NTC.setStartTime(StartTime);
		//获取文件地址
		String FileLoc=(String) session.get("FileLoc");
		if(FileLoc==null||FileLoc.length()<=0){
			FileLoc="无";
		}
		NTC.setFileLoction(FileLoc);
		NTC.setFlag("0");
		NTD.insertOne(NTC);
		session.remove("FileLoc");
		//重新获取通知表
		NT=new ArrayList();
		NT=NTD.getNotice();
		
		JSONArray json = JSONArray.fromObject(NT);
		result = json.toString();
		return SUCCESS;
	}
	
	//驳回列表
	public String DeclineShow(){
		//获取当前教师ID
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		//查询结果
		List<Decline> DCL=new ArrayList();
		DCL=DLD.getDeclineByTID(TeacherID);
		JSONArray json = JSONArray.fromObject(DCL);
		result = json.toString();
		return SUCCESS;
	}
	
	//驳回提醒
	public String AttentionDecline(){
		//获取教职工
				Map session = ActionContext.getContext().getSession();
				String TeacherID=(String) session.get("t_ID");
				//查询
				
				List<Decline> DCL=new ArrayList();
				DCL=DLD.getDeclineByTID(TeacherID);
				List returnList=new ArrayList();
				if(DCL==null){
					returnList.add("DeclineNotice");
				}
				else{
				for(int i=0;i<DCL.size();i++){
					if(DCL.get(i).getFlag().equals("T")){
						returnList.add(DCL.get(i).getID());
					}
				}
				
				
				
				if(returnList.size()==DCL.size()){
					returnList.add("DeclineNotice");
				}
				}
				JSONArray json = JSONArray.fromObject(returnList);
				result = json.toString();
				return SUCCESS;
	}
	
	//系统通知列表显示
	public String SystemShow(){
		Map session = ActionContext.getContext().getSession();
		String TeacherID=(String) session.get("t_ID");
		String Type=TMD.getTableByTID(TeacherID).get(0).getDepartment();
		List<NoticeTable> TNT=new ArrayList();
		TNT=NTD.getTeacherNotice(Type);
		System.out.println("New NOTICE THEME:"+TNT.get(0).getNoticeTheme());
		JSONArray json = JSONArray.fromObject(TNT);
		result = json.toString();
		return SUCCESS;
		
	}
	
	//所有通知提醒
	 public String AllAttention(){
		//获取教职工工号
		 String Flag="T";
		 Map session = ActionContext.getContext().getSession();
			String TeacherID=(String) session.get("t_ID");
			//通知表
			List<TeacherInfo> TIL=new ArrayList();
			TIL=TMD.getTableByTID(TeacherID);
			String Department=TIL.get(0).getDepartment();
			List<NoticeTable> NTL=new ArrayList();
			NTL=NTD.getTeacherNotice(Department);
			String NumTemp=TIL.get(0).getNotice().replace(" ", "");
			String[] Num=NumTemp.split(",");
			List returnList=new ArrayList();
			for(int i=0;i<Num.length;i++){
				System.out.println("READED NUM"+Num[i]);
					returnList.add(Num[i]);
				
			}
			if(returnList.size()<NTL.size()){
				Flag="F";
			}
			//驳回表
			List<Decline> DCL=new ArrayList();
			DCL=DLD.getDeclineByTID(TeacherID);
			List returnListD=new ArrayList();
			if(DCL==null){
				
			}else{
			
			for(int i=0;i<DCL.size();i++){
				if(DCL.get(i).getFlag().equals("T")){
					returnListD.add(DCL.get(i).getID());
				}
			}

			if(returnListD.size()!=DCL.size()){
				Flag="F";
			}
			}
			List resultL=new ArrayList();
			resultL.add(Flag);
			
			JSONArray json = JSONArray.fromObject(resultL);
			result = json.toString();
		return SUCCESS;
	}
}
