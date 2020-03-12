package com.ssh.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AssScoreDao;
import com.ssh.dao.EduScoreDao;
import com.ssh.dao.SerScoreDao;
import com.ssh.dao.TeacherFileDao;
import com.ssh.dao.TeacherMDao;
import com.ssh.model.TeacherFile;

import net.sf.json.JSONArray;

public class FileUpload extends ActionSupport{

	private File upload;// 要上传的文件
	private String uploadFileName;// 上传文件的名字
	private String path;// 路径
	private String result;
	private TeacherFile TF;
	@Autowired
	private EduScoreDao ESD;
	@Autowired
	private SerScoreDao SSD;
	@Autowired
	private AssScoreDao ASD;
	@Autowired
	private TeacherFileDao TFD;
	@Autowired
	private TeacherMDao TMD;
	
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
 
	public String getPath() {
		return path;
	}
 
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

	public EduScoreDao getESD() {
		return ESD;
	}

	public void setESD(EduScoreDao eSD) {
		ESD = eSD;
	}

	public TeacherFileDao getTFD() {
		return TFD;
	}

	public void setTFD(TeacherFileDao tFD) {
		TFD = tFD;
	}
	
	public TeacherFile getTF() {
		return TF;
	}

	public void setTF(TeacherFile tF) {
		TF = tF;
	}
	
	public TeacherMDao getTMD() {
		return TMD;
	}

	public void setTMD(TeacherMDao tMD) {
		TMD = tMD;
	}
	

	public SerScoreDao getSSD() {
		return SSD;
	}

	public void setSSD(SerScoreDao sSD) {
		SSD = sSD;
	}
	

	public AssScoreDao getASD() {
		return ASD;
	}

	public void setASD(AssScoreDao aSD) {
		ASD = aSD;
	}

	/**
	 * ajaxfileupload.js实现异步上传图片
	 */
	
	public String Edu() {
		//获取teacherID
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		try {
			//教师姓名
			String SearchNameHql="select TeacherName from TeacherInfo where TeacherID ='"+TID+"'";
			String SearchTemp=TMD.queryID(SearchNameHql);
			String SearchName=SearchTemp.substring(1, SearchTemp.length()-1);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			// 设置文件保存的路径
			path = ServletActionContext.getServletContext().getRealPath("/upload/"+TID+"_"+SearchName+"/");
			File file = new File(path);
			if (!file.exists()) {//如果文件夹不存在则自动创建
				file.mkdir();
			}
			// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
			
			String[] upFile=uploadFileName.split("\\.");
			String upLast=upFile[upFile.length-1];
			uploadFileName=TID+"_"+SearchName+"教学资料"+"."+upLast;
			FileUtils.copyFile(upload, new File(file, uploadFileName));
			String file2 = new File(file, uploadFileName).toString();// 文件保存的全路径名，包含文件名
			String[] FileArray= file2.split("\\\\");
			String FileLoc=FileArray[FileArray.length-1];
			System.out.println("FILE LOCATION:"+FileLoc);
			String FileLocation=TID+"_"+SearchName+"/"+FileLoc;
			String SaveHql="update TeacherFile  set Education='"+FileLocation+ "' where TeacherID ="+TID;
			TFD.updateEduScore(SaveHql);
			TF=new TeacherFile();
			TF.setTeacherID(TID);
			TF.setEducation(FileLoc);
			//TFD.updateEdu(TF);
			ret="ok";
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(ret);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE FILE FILE");
			e.printStackTrace();
		}
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		List returnL=new ArrayList();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}

	public String Rea() {
		//获取teacherID
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		try {
			//教师姓名
			String SearchNameHql="select TeacherName from TeacherInfo where TeacherID ='"+TID+"'";
			String SearchTemp=TMD.queryID(SearchNameHql);
			String SearchName=SearchTemp.substring(1, SearchTemp.length()-1);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			// 设置文件保存的路径
			path = ServletActionContext.getServletContext().getRealPath("/upload/"+TID+"_"+SearchName+"/");
			File file = new File(path);
			if (!file.exists()) {//如果文件夹不存在则自动创建
				file.mkdir();
			}
			// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
			
			String[] upFile=uploadFileName.split("\\.");
			String upLast=upFile[upFile.length-1];
			uploadFileName=TID+"_"+SearchName+"研究资料"+"."+upLast;
			FileUtils.copyFile(upload, new File(file, uploadFileName));
			String file2 = new File(file, uploadFileName).toString();// 文件保存的全路径名，包含文件名
			String[] FileArray= file2.split("\\\\");
			String FileLoc=FileArray[FileArray.length-1];
			System.out.println("FILE LOCATION:"+FileLoc);
			String FileLocation=TID+"_"+SearchName+"/"+FileLoc;
			String SaveHql="update TeacherFile  set Research='"+FileLocation+ "' where TeacherID ="+TID;
			TFD.updateEduScore(SaveHql);
			TF=new TeacherFile();
			TF.setTeacherID(TID);
			TF.setEducation(FileLoc);
			//TFD.updateEdu(TF);
			ret="ok";
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(ret);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE FILE FILE");
			e.printStackTrace();
		}
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		List returnL=new ArrayList();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	public String Ser() {
		//获取teacherID
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		try {
			//教师姓名
			String SearchNameHql="select TeacherName from TeacherInfo where TeacherID ='"+TID+"'";
			String SearchTemp=TMD.queryID(SearchNameHql);
			String SearchName=SearchTemp.substring(1, SearchTemp.length()-1);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			// 设置文件保存的路径
			path = ServletActionContext.getServletContext().getRealPath("/upload/"+TID+"_"+SearchName+"/");
			File file = new File(path);
			if (!file.exists()) {//如果文件夹不存在则自动创建
				file.mkdir();
			}
			// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
			
			String[] upFile=uploadFileName.split("\\.");
			String upLast=upFile[upFile.length-1];
			uploadFileName=TID+"_"+SearchName+"服务资料"+"."+upLast;
			FileUtils.copyFile(upload, new File(file, uploadFileName));
			String file2 = new File(file, uploadFileName).toString();// 文件保存的全路径名，包含文件名
			String[] FileArray= file2.split("\\\\");
			String FileLoc=FileArray[FileArray.length-1];
			System.out.println("FILE LOCATION:"+FileLoc);
			String FileLocation=TID+"_"+SearchName+"/"+FileLoc;
			String SaveHql="update TeacherFile  set Serve='"+FileLocation+ "' where TeacherID ="+TID;
			TFD.updateEduScore(SaveHql);
			TF=new TeacherFile();
			TF.setTeacherID(TID);
			TF.setEducation(FileLoc);
			//TFD.updateEdu(TF);
			ret="ok";
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(ret);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE FILE FILE");
			e.printStackTrace();
		}
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		List returnL=new ArrayList();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
	
	public String Ass() {
		//获取teacherID
		Map session = ActionContext.getContext().getSession();
		String TID=(String) session.get("t_ID");
		
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/json; charset=UTF-8");
		String ret = "";
		try {
			//教师姓名
			String SearchNameHql="select TeacherName from TeacherInfo where TeacherID ='"+TID+"'";
			String SearchTemp=TMD.queryID(SearchNameHql);
			String SearchName=SearchTemp.substring(1, SearchTemp.length()-1);
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			// 设置文件保存的路径
			path = ServletActionContext.getServletContext().getRealPath("/upload/"+TID+"_"+SearchName+"/");
			File file = new File(path);
			if (!file.exists()) {//如果文件夹不存在则自动创建
				file.mkdir();
			}
			// 将页面传过来的数据通过FileUtils 拷贝到我们刚刚定义的路径
			
			String[] upFile=uploadFileName.split("\\.");
			String upLast=upFile[upFile.length-1];
			uploadFileName=TID+"_"+SearchName+"辅导资料 "+"."+upLast;
			FileUtils.copyFile(upload, new File(file, uploadFileName));
			String file2 = new File(file, uploadFileName).toString();// 文件保存的全路径名，包含文件名
			String[] FileArray= file2.split("\\\\");
			String FileLoc=FileArray[FileArray.length-1];
			System.out.println("FILE LOCATION:"+FileLoc);
			String FileLocation=TID+"_"+SearchName+"/"+FileLoc;
			String SaveHql="update TeacherFile  set Assistant='"+FileLocation+ "' where TeacherID ="+TID;
			TFD.updateEduScore(SaveHql);
			TF=new TeacherFile();
			TF.setTeacherID(TID);
			TF.setEducation(FileLoc);
			//TFD.updateEdu(TF);
			ret="ok";
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.write(ret);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE FILE FILE");
			e.printStackTrace();
		}
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		List returnL=new ArrayList();
		returnL.add("aaa");
		JSONArray json = JSONArray.fromObject(returnL);
		result=json.toString();
		return SUCCESS;
	}
}
