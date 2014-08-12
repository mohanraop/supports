package com.exp.cn.junit;

import junit.framework.TestCase;

public class CalculatingAreaTest extends TestCase {
	
	CalculatingArea ca ;
	
	CalculatingArea caNull;
	
	@Override
	protected void setUp() throws Exception {
		ca = new CalculatingArea();	
		super.setUp();
	}
	
	public void testForNotNullValues(){
		assertNotNull("Calculating Area is not initalized",ca);
	}
	
	public void testForNullValues(){
		assertNull("Calculating Area is  initalized",caNull);
	}
	
	public void testAreaPossitveValue(){
		
		int i=-1000;
		
		int output=ca.areaSquare(i);
		boolean bl = output > 0;
		
		assertTrue("Positive value expeted",bl);
	}
	
	
	public void testAreaOfSquareUnit2(){
		int i=2;
		int expetedVal=4;
		
		int output=ca.areaSquare(i);
		
		assertEquals("Expected value is not equal to output",expetedVal, output);
	}
	
	public void testAreaOfSquareUnit4(){
		int i=4;
		int expetedVal=16;
		
		int output=ca.areaSquare(i);
		
		assertEquals("Expected value is not equal to output",expetedVal, output);
	}
	
	
	
	@Override
	protected void tearDown() throws Exception {
		ca=null;	
		super.tearDown();
	}
	

}
