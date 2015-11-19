package com.exp.cn.array;

import java.util.Stack;

import com.exp.cn.emp.Employee;

public class ArrayExm {

	public static void main(String[] args) {
		int i=10;
		
		int arr[]=new int[50];
		
		arr[0]=30;
		arr[1]=20;
		arr[2]=10;
		arr[3]=5;
		arr[4]=2;	
		arr[35]=45;		
		arr[4]=0;
		
		
		arr=new int[20];
		
		System.out.println(arr[3]);
		System.out.println(arr.length);
		
		Employee emp = new Employee();
		
		Employee emplArr[]= new Employee[10];
		emplArr[5]= new Employee();
		
		Stack st= new Stack();
		st.add(10);
		st.add(20);
		st.add(emp);
		st.add("abc");
		st.push(20.3);
		System.out.println(st);
		System.out.println(st.pop());
		System.out.println(st);
		System.out.println(st.peek());
		System.out.println(st);
		System.out.println(st.peek());
		System.out.println(st);
		
	
		
	}
}
