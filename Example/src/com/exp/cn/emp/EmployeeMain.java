package com.exp.cn.emp;

/**
 * 
 */

/**
 * @author Amar
 *
 */
public class EmployeeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setfName("kkkk");
		employee.setlName("LLL");
		
		Employee employee2 = new Employee();
		employee2.getlName();
		
		System.out.println(employee.getfName());
		System.out.println(employee.getlName());
		
		Teacher teacher = new Teacher();
		teacher.setTFNamge("kkk");
		teacher.setTLName("LLLL");
		teacher.setTNo(10);
		System.out.println(teacher.getTFNamge());
		System.out.println(teacher.getTLName());
		System.out.println(teacher.getTNo());
		

	}

}
