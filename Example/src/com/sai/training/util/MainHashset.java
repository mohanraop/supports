package com.sai.training.util;
import java.util.*;

public class MainHashset {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		ArrayList al = new ArrayList();
		al.add("sai");
		al.add("ram");
		al.add("sai");
		al.add("kan");
		al.add("swe");
	    set.add("Hello");
	    if (set.add("Hello")) {
	      System.out.println("addition successful");
	    } else {
	      System.out.println("addition failed");
	    }
	    set.add("Hi");
	    System.out.println(set);
	    System.out.println(set.isEmpty());
	    //set.clear();
	    System.out.println(set);
	    System.out.println(set.contains("Hello"));
	    System.out.println(set.hashCode());
	    System.out.println(set.size());
	    set.remove("Hi");
	    System.out.println(set);
	    set.addAll(al);
	    System.out.println(set);
	    System.out.println(set.containsAll(al));
	    

	}

}
