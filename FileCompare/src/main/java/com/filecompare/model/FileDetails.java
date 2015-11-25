package com.filecompare.model;

import java.io.Serializable;

public class FileDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected byte[] fileInfo;
	
	protected String fileDesc;
	
	protected String fileResp;

	/**
	 * @return the fileInfo
	 */
	public byte[] getFileInfo() {
		return fileInfo;
	}

	/**
	 * @param fileInfo the fileInfo to set
	 */
	public void setFileInfo(byte[] fileInfo) {
		this.fileInfo = fileInfo;
	}

	/**
	 * @return the fileDesc
	 */
	public String getFileDesc() {
		return fileDesc;
	}

	/**
	 * @param fileDesc the fileDesc to set
	 */
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	/**
	 * @return the fileResp
	 */
	public String getFileResp() {
		return fileResp;
	}

	/**
	 * @param fileResp the fileResp to set
	 */
	public void setFileResp(String fileResp) {
		this.fileResp = fileResp;
	}
	
	

}
