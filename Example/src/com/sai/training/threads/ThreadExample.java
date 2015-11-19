package com.sai.training.threads;

public class ThreadExample  extends Thread{
	String objName;
	public ThreadExample(String objName) {
		this.objName=objName;
	}
	
	public void sumOfHundreed(){
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

