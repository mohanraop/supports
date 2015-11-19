package com.train.ws.service;

public class Currency {

	public String getCountry(String name){
		String rtnStr="";
		if(name.equalsIgnoreCase("India")){
			rtnStr= "India currency is INR";
		}
		return rtnStr;
	}
}
