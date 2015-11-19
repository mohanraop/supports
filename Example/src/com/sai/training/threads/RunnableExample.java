package com.sai.training.threads;

public class RunnableExample implements Runnable{
	String objName;
	public RunnableExample(String objName) {
		this.objName=objName;
	}
	
	public  synchronized void sumOfHundreed(){		
		
		int j=0;
		for(int i=1;i<=100;i++){
			j=j+i;
			System.out.println(objName+"="+j);
		}
		
	}
	
	public void run(){
		sumOfHundreed();
	}
}
