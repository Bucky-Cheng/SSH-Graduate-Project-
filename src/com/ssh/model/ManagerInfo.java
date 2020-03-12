package com.ssh.model;

public class ManagerInfo {

	private int ID;
	private String Members;
	private String Manager;
	private String Department;
	private String Remarks;
	
	public ManagerInfo(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMembers() {
		return Members;
	}

	public void setMembers(String members) {
		Members = members;
	}

	public String getManager() {
		return Manager;
	}

	public void setManager(String manager) {
		Manager = manager;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
}
