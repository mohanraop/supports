package com.exp.cn.abstractcls;

public class Main {
	public static void main(String[] args) {
		
		//CarDesign cd = new CarDesign();
		
		InnovaCar ic = new InnovaCar();
		
		ic.setcModelNum(12345);
		ic.setEngine("xyz");
		ic.setPrice(300);
		
		System.out.println(ic.getPrice());
		System.out.println(ic.getEngine());

	}
}
