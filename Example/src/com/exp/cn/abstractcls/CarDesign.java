package com.exp.cn.abstractcls;

public abstract class CarDesign {
	int cModelNum;
	int nofTyres;
	String engine;
	int price;
	/**
	 * @return the cModelNum
	 */
	public int getcModelNum() {
		return cModelNum;
	}
	/**
	 * @param cModelNum the cModelNum to set
	 */
	public void setcModelNum(int cModelNum) {
		this.cModelNum = cModelNum;
	}
	/**
	 * @return the nofTyres
	 */
	public int getNofTyres() {
		return nofTyres;
	}
	/**
	 * @param nofTyres the nofTyres to set
	 */
	public void setNofTyres(int nofTyres) {
		this.nofTyres = nofTyres;
	}
	/**
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}
	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public abstract void setPrice(int price); 
	
}
