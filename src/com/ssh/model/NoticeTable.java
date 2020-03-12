package com.ssh.model;

public class NoticeTable {

	private int ID;
	private int NoticeID;
	private String NoticeTheme;
	private String NoticeContent;
	private String Type;
	private String StartTime;
	private String FileLoction;
	private String Flag;
	
	public NoticeTable(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNoticeID() {
		return NoticeID;
	}

	public void setNoticeID(int noticeID) {
		NoticeID = noticeID;
	}

	public String getNoticeContent() {
		return NoticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		NoticeContent = noticeContent;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	

	

	public String getFileLoction() {
		return FileLoction;
	}

	public void setFileLoction(String fileLoction) {
		FileLoction = fileLoction;
	}

	public String getNoticeTheme() {
		return NoticeTheme;
	}

	public void setNoticeTheme(String noticeTheme) {
		NoticeTheme = noticeTheme;
	}

	public String getFlag() {
		return Flag;
	}

	public void setFlag(String flag) {
		Flag = flag;
	}
	
}
