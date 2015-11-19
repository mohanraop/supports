package com.exp.cn.abstractcls;

public class InnovaCar extends CarDesign{
	
	/**
	 * @return the engine
	 */
	public String getEngine() {
		return "Innova "+engine;
	}
 
	public  void setPrice(int price){
		this.price=price+3000;
	}
}

class A extends InnovaCar{
	
}
class B extends A{
	
}
class c extends B{
	
}