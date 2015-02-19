package com.sai.training;

public abstract class Vehicle
{
	String insurance;
	long cost;
	int manufacturedYear;
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public int getManufacturedYear() {
		return manufacturedYear;
	}
	public void setManufacturedYear(int manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}
	
}
