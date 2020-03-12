package com.ssh.model;

public class TeacherInfo {

	private int ID;
	private String TeacherName;
	private String TeacherID;
	private String TeacherSex;
	private String TeacherBirthday;
	private String Department;
	private String Programme;
	private String Notice;
	
	public TeacherInfo(){
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	public String getTeacherSex() {
		return TeacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		TeacherSex = teacherSex;
	}

	public String getTeacherBirthday() {
		return TeacherBirthday;
	}

	public void setTeacherBirthday(String teacherBirthday) {
		TeacherBirthday = teacherBirthday;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getProgramme() {
		return Programme;
	}

	public void setProgramme(String programme) {
		Programme = programme;
	}

	public String getNotice() {
		return Notice;
	}

	public void setNotice(String notice) {
		Notice = notice;
	}
	
}
