/**
 * 
 */
package com.exp.cn.exc;

import org.apache.log4j.Logger;

/**
 * @author Amar
 * 
 */
public class Excep {
	static Logger log = Logger.getLogger(Excep.class.getName());

	public void m1() throws Exception {
		System.out.println("m1-begin");
		log.info("m1-begin");
		m2();
		System.out.println("m1-end");
		log.info("m1-end");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Excep excep = new Excep();

		try {
			excep.m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}

		// throw

		/*
		 * try { int i =1/0; System.out.println(i); System.out.println(12345);
		 * }catch (ArithmeticException e) {
		 * System.out.println("-----ArithmeticException"); }catch
		 * (IndexOutOfBoundsException e) {
		 * System.out.println("-----IndexOutOfBoundsException"); }catch
		 * (Exception e) { System.out.println("-----Exception"); }
		 */

		System.out.println(1);
		System.out.println(0);
		System.out.println(2);
	}

	public void m2() throws Exception {

		System.out.println("m2");
		try {
			int j = 1 / 0;
			System.out.println(j);
		} catch (ArithmeticException ae) {
			System.out.println("partial exception handling");
			//throw ae;
			throw new Exception("Please handle");
		}
	}

}
