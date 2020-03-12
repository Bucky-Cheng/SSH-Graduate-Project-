package com.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AttachmentDownload extends ActionSupport{

	private InputStream downLoad;
	private String fileName;
	private String path;
	
	public void setDownLoad(InputStream downLoad) {
		this.downLoad = downLoad;
	}
	public String getFileName() {
		return fileName;
	}
	
	public String getPath() {
		return path;
	}
	//public void setPath(String path) throws Exception{
		//this.path = new String(path.getBytes("iso-8859-1"),"UTF-8");
	//}
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getDownLoad() throws FileNotFoundException {
		//String FilePath = ServletActionContext.getServletContext().getRealPath("/NoticeUpload/"+path);
		//System.out.println("FilePath is"+FilePath);
		//System.out.println("fileName is"+fileName);
		
		System.out.println("ATTACHMENT PATH:"+path);
		downLoad=ServletActionContext.getServletContext().getResourceAsStream("NoticeUpload/"+path);
		System.out.println("ATTACHMENT:"+downLoad);
		return downLoad;
		
	}
	
	
	
	public String execute() throws UnsupportedEncodingException{
		
		//fileName=new String(path.getBytes(),"ISO8859-1");
		fileName=new String(path.getBytes("UTF-8"), "ISO_8859_1");
		return SUCCESS;
	}
}
