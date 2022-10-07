package com.tmp.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private int bno;
	private String bdName;
	private String bdTitle;
	private String bdContent;
	private Date bdDate;
	private String bdFileName;
	private MultipartFile uploadFile;
	
	
	public String getFileName() {
		return bdFileName;
	}
	public void setFileName(String fileName) {
		this.bdFileName = fileName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBdName() {
		return bdName;
	}
	public void setBdName(String bdName) {
		this.bdName = bdName;
	}
	public String getBdTitle() {
		return bdTitle;
	}
	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}  
	public String getBdContent() {
		return bdContent;
	}
	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}
	public Date getBdDate() {
		return bdDate;
	}
	public void setBdDate(Date bdDate) {
		this.bdDate = bdDate;
	}

	
}
