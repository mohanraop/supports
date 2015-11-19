package com.exp.cn.utill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class ListExample {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(20);
		list.add(30);
		//System.out.println(list);
		list.add(1, 40);
		//System.out.println(list);
		list.add(20);
		System.out.println("Before sorting="+list);
		Collections.sort(list);
		System.out.println("After Sorting="+list);
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		
		Vector v=  new Vector();
		v.add(35);
		
	}

}
