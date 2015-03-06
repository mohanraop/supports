package com.sai.training.util;

import com.sai.training.staticEx.StaticClass;

public class MainArray {

	public static void main(String[] args) {
		int iVar=10;
		int i[]=new int[]{1,2,5,3,1};
		System.out.println(iVar);
		System.out.println(i.length);
		System.out.println(i[0]);
		System.out.println(i[3]);
		i[3]=50;
		System.out.println(i[3]);
		
		StaticClass sc[]=new StaticClass[10];
		sc[0]= new StaticClass();
		sc[1]=new StaticClass();

	}

}
