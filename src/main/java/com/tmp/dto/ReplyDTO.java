package com.tmp.dto;

import java.sql.Date;

public class ReplyDTO {
	private String rpWriter;
	private String rpContent;
	private Date rpDate;
	public String getRpWriter() {
		return rpWriter;
	}
	public void setRpWriter(String rpWriter) {
		this.rpWriter = rpWriter;
	}
	public String getRpContent() {
		return rpContent;
	}
	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}
	public Date getRpDate() {
		return rpDate;
	}
	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}
	
	
}
