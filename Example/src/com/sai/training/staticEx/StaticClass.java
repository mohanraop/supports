package com.sai.training.staticEx;

import com.sai.training.core.Person;

public class StaticClass {
 int i;
  static int j;  
  Person p1= new Person();
  static Person out= new Person();
  
  public void setI(int i,int iVar,int j){
	 this.i=i;
	 iVar= iVar;
			 this.j=j;
  }  
  
  public static void setJ(int iVar){
	  j=iVar;
	 //i=iVar;
  }
 
}
