package com.sai.training.threads;

public class MainRunnable {

	public static void main(String[] args) {
		RunnableExample r1=new RunnableExample("r1");
		RunnableExample r2=new RunnableExample("r2");
		RunnableExample r3=new RunnableExample("r3");
		/*r1.sumOfHundreed();
		r2.sumOfHundreed();
		r3.sumOfHundreed();*/
		
		Thread t1 =new Thread(r1);
		Thread t2 =new Thread(r2);
		Thread t3 =new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}

}
