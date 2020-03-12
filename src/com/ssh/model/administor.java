package com.ssh.model;

public class administor {

	private int ID;
	private String administor_No;
	private String name;
	private String birthday;
	private String a_department;
	
	public administor(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAdministor_No() {
		return administor_No;
	}

	public void setAdministor_No(String administor_No) {
		this.administor_No = administor_No;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getA_department() {
		return a_department;
	}

	public void setA_department(String a_department) {
		this.a_department = a_department;
	}
	
}
