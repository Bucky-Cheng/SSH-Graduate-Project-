package com.ssh.model;

public class AD_login {

private int ID;
	
	private String AD_ID;
	private String teacherName;
	private String password;
	
	public AD_login(){
		
	}
	public AD_login(String AD_ID,String password){
		this.AD_ID=AD_ID;
		this.password=password;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAD_ID() {
		return AD_ID;
	}
	public void setAD_ID(String aD_ID) {
		AD_ID = aD_ID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
