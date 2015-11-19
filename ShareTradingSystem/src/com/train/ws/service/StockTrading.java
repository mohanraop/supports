package com.train.ws.service;

public class StockTrading {
	
	public String getQuote(String shareName){
		if(shareName.equalsIgnoreCase("Infosys")){
			return "Infosys share Price is "+2000;
		}
		else if(shareName.equalsIgnoreCase("CTS")){
			return "CTS share Price is "+400;
		}
		else if(shareName.equalsIgnoreCase("Wipro")){
			return "Wipro share Price is "+200;
		}
		else if(shareName.equalsIgnoreCase("Satyam")){
			return "Satyam share Price is "+70;
		}
		else if(shareName.equalsIgnoreCase("TCS")){
			return "TCS share Price is "+3000;
		}else{
			return "wrong input";
		}
	}

}
