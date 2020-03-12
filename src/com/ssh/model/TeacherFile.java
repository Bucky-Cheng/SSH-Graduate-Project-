package com.ssh.model;

public class TeacherFile {

	private int ID;
	private String TeacherID;
	private String TeacherName;
	private  String Education;
	private String Research;
	private String Serve;
	private String Assistant;
	
	public TeacherFile(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public String getResearch() {
		return Research;
	}

	public void setResearch(String research) {
		Research = research;
	}

	public String getServe() {
		return Serve;
	}

	public void setServe(String Serve) {
		this.Serve = Serve;
	}

	public String getAssistant() {
		return Assistant;
	}

	public void setAssistant(String assistant) {
		Assistant = assistant;
	}
	
}
