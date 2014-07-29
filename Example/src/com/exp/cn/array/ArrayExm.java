package com.exp.cn.array;

import com.exp.cn.emp.Employee;

public class ArrayExm {

	public static void main(String[] args) {
		int i=10;
		
		int arr[]=new int[5];
		
		arr[0]=30;
		arr[1]=20;
		arr[2]=10;
		arr[3]=5;
		arr[4]=2;	
		
		System.out.println(arr[3]);
		
		Employee emp = new Employee();
		
		Employee emplArr[]= new Employee[10];
		emplArr[5]= new Employee();
		
	}
}
