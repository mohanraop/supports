package com.exp.cn.threads;

public class ThreadExtend extends Thread{
	
	public ThreadExtend() {
		super();
	}

	public ThreadExtend(String refName) {
		super();
		this.refName = refName;
	}

	String refName;
	
	
	public void run(){
		System.out.println("in run");
		for(int i=0;i<1000;i++){
			System.out.println("Object "+refName+",i="+i);
		}
	}
	
	public static void main(String[] args) {
		
		ThreadExtend th1 = new ThreadExtend("t1");
		ThreadExtend th2 = new ThreadExtend("t2");
		
		th1.start();
		th2.start();
	}

}
