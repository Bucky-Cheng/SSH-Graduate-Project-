package com.ssh.model;

public class Decline {

	private int ID;
	private String TeacherID;
	private String DeclineID;
	private String DeclineName;
	private String DeclineContent;
	private String ManagerID;
	private String ManagerName;
	private String StartTime;
	private String Flag;
	
	public Decline(){
		
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

	public String getDeclineID() {
		return DeclineID;
	}

	public void setDeclineID(String declineID) {
		DeclineID = declineID;
	}

	public String getDeclineName() {
		return DeclineName;
	}

	public void setDeclineName(String declineName) {
		DeclineName = declineName;
	}

	public String getDeclineContent() {
		return DeclineContent;
	}

	public void setDeclineContent(String declineContent) {
		DeclineContent = declineContent;
	}

	public String getManagerID() {
		return ManagerID;
	}

	public void setManagerID(String managerID) {
		ManagerID = managerID;
	}

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}
	
	
}
