package com.tmp.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private int bno;
	private String bdName;
	private String bdTitle;
	private String bdContent;
	private Date bdDate;
	
	private List<MultipartFile> files;
	private List<FileDTO> filedto;
	
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
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public List<FileDTO> getFiledto() {
		return filedto;
	}
	public void setFiledto(List<FileDTO> filedto) {
		this.filedto = filedto;
	}
	
	


}
