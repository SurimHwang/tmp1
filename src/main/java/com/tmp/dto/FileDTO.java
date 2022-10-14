package com.tmp.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	
	private int fno;
	private int bno;
	private String orgFileName;
	private String metaFileName;
	private String fileUrl;
	//private MultipartFile uploadFile;
	
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getMetaFileName() {
		return metaFileName;
	}
	public void setMetaFileName(String metaFileName) {
		this.metaFileName = metaFileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
//	public MultipartFile getUploadFile() {
//		return uploadFile;
//	}
//	public void setUploadFile(MultipartFile uploadFile) {
//		this.uploadFile = uploadFile;
//	}
	
	
}
