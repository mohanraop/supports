package com.exp.cn.core;
public class StudentMain {
	public static void main(String[] args) {
		Student student = new Student();
		student.setstudentName("Sri");
		student.setStudNo(123);
		student.setsub1(10);
		student.setsub2(20);
		student.setsub3(30);
		int empNo;
		int i=0;
		int j=i;
		System.out.println(student.sub1 + student.sub2 + student.sub3);

	}
}
