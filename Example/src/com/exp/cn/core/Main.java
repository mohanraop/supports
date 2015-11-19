package com.exp.cn.core;
public class Main {
	public static void main(String[] args) {
		System.out.println(1/0);
		Example ex = new Example();
		ex.setEmpNo(123);
		ex.empName = "xyz";
		//int i ="kk";
		
		System.out.println(ex.getEmpNo());
		System.out.println(ex.getEmpName());
		
	}
}
