package com.filecompare.vo;

import java.io.Serializable;

public class FileDetailsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected String fileDesc;
	
	protected String fileResp;
	
	protected String dropLoc1;
	
	protected String dropLoc2;

	protected String pickLoc1;
	
	protected String pickLoc2;
	
	
	/**
	 * @return the dropLoc1
	 */
	public String getDropLoc1() {
		return dropLoc1;
	}

	/**
	 * @param dropLoc1 the dropLoc1 to set
	 */
	public void setDropLoc1(String dropLoc1) {
		this.dropLoc1 = dropLoc1;
	}

	/**
	 * @return the dropLoc2
	 */
	public String getDropLoc2() {
		return dropLoc2;
	}

	/**
	 * @param dropLoc2 the dropLoc2 to set
	 */
	public void setDropLoc2(String dropLoc2) {
		this.dropLoc2 = dropLoc2;
	}

	/**
	 * @return the pickLoc1
	 */
	public String getPickLoc1() {
		return pickLoc1;
	}

	/**
	 * @param pickLoc1 the pickLoc1 to set
	 */
	public void setPickLoc1(String pickLoc1) {
		this.pickLoc1 = pickLoc1;
	}

	/**
	 * @return the pickLoc2
	 */
	public String getPickLoc2() {
		return pickLoc2;
	}

	/**
	 * @param pickLoc2 the pickLoc2 to set
	 */
	public void setPickLoc2(String pickLoc2) {
		this.pickLoc2 = pickLoc2;
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
