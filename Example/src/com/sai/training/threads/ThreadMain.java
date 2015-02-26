package com.sai.training.threads;

public class ThreadMain {

	public static void main(String[] args) {
		ThreadExample t1=new ThreadExample("t1");
		ThreadExample t2=new ThreadExample("t2");
		ThreadExample t3=new ThreadExample("t3");
		
		/*t1.sumOfHundreed();
		t2.sumOfHundreed();
		t3.sumOfHundreed();*/
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
