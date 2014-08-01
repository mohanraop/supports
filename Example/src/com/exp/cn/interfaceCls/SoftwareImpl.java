package com.exp.cn.interfaceCls;

public class SoftwareImpl implements Software{
	
	String tec;
	String req;
	String duration;
	String license;
	String budget;
	/**
	 * @return the budget
	 */
	public String getBudget() {
		return budget;
	}
	/**
	 * @param budget the budget to set
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}
	/**
	 * @return the tec
	 */
	public String getTec() {
		return tec;
	}
	/**
	 * @param tec the tec to set
	 */
	public void setTec(String tec) {
		this.tec = tec;
	}
	/**
	 * @return the req
	 */
	public String getReq() {
		return req;
	}
	/**
	 * @param req the req to set
	 */
	public void setReq(String req) {
		this.req = req;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}
	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}

}
