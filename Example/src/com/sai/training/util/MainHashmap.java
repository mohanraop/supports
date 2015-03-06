package com.sai.training.util;
import java.util.*;

public class MainHashmap {

	public static void main(String[] args) 
	{
		HashMap<Integer, String> h = new HashMap<Integer, String>();
	    h.put(1, "One");
	    h.put(2, "Two");
	    h.put(3, "Three");
	    HashMap<Integer,String > h2=new HashMap<Integer,String>();
	    h2.put(4,"Four");
	    h2.put(5,"Five");
	    h2.put(6,"six");
	    Collection c = h.values();
	    Iterator itr = c.iterator();
	    while (itr.hasNext())
	    {
	      System.out.println(itr.next());
	    }
	    Map m=Collections.synchronizedMap(h);
	    /*Even m.size() returns the same*/
	    System.out.println(h.size());
	    System.out.println(h.isEmpty());
	    System.out.println(h.get(1));
	    System.out.println(h.containsKey(1));
	    System.out.println();
	    h.putAll(h2);
	    System.out.println(h);
	    System.out.println(h.containsValue("six"));
	    System.out.println(h.values());

	}

}
