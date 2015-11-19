package com.exp.cn.threads;

public class ThreadExample implements Runnable{	
	String refName;
	
	public ThreadExample(String refName) {
		this.refName = refName;
	}
	
	public ThreadExample(){
		
	}
	

	public static void main(String[] args) {
		
		ThreadExample t1= new ThreadExample("t1");
		ThreadExample t2 = new ThreadExample("t2");
		
		//t1.printMethod();
		//t2.printMethod();
		
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		th1.start();
		th2.start();
		
	}
	
	public void printMethod(){
		for(int i=0;i<1000;i++){
			System.out.println("Object "+refName+",i="+i);
		}
	}

	@Override
	public void run() {
		printMethod();		
	}
	
	
}
