package com.sai.training;

public class TwoWheeler extends Vehicle
{
	String type;
	String name;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getCost() {
	return cost+100;
    }
}