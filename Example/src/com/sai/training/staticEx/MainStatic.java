package com.sai.training.staticEx;


public class MainStatic {

	public static void main(String[] args) {
		
		StaticClass  sc = new StaticClass();
		
		StaticClass  sc1 = new StaticClass();
		
		StaticClass  sc2= new StaticClass();
		
		//System.out.println(StaticClass.i);
		System.out.println("StaticClass.j="+StaticClass.j);
		
		sc.i=1;
		sc.j=1;
		System.out.println("sc.i="+sc.i);
		System.out.println("sc.j="+sc.j);
		sc1.i=sc1.i+1;
		sc1.j=sc1.j+1;
		System.out.println("sc1.i="+sc1.i);
		System.out.println("sc1.j="+sc1.j);
		sc2.i = sc2.i+1;
		sc2.j=sc2.j+1;
		System.out.println("sc2.i="+sc2.i);
		System.out.println("sc2.j="+sc2.j);
		
		System.out.println("StaticClass.j="+StaticClass.j);
		
		//sc.setI(10, 30, 40);
		//StaticClass.setI(20,30,50);
		//sc.setJ(30);
		//StaticClass.setJ(30);
		
		//StaticClass.out.age=10;
		
		//StaticClass.out.printLn();
		//StaticClass.p1
		

	}

}
