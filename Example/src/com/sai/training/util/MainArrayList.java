package com.sai.training.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sai.training.staticEx.StaticClass;

public class MainArrayList {
	public static void main(String[] args){
		ArrayList al = new ArrayList();
		int i;
		al.add("sai");
		al.add("ram");
		al.add("sai");
		al.add("kan");
		al.add("swe");
		System.out.println(al.size());
		//StaticClass sc = new StaticClass();
		//System.out.println(sc);
		//al.add(sc);
		
		System.out.println(al.size());
		System.out.println(al.get(1));
		System.out.println(al.get(2));
		System.out.println("0index="+al.get(0));
		System.out.println("The size of the array list is returned : "+al.size());
		System.out.println("Returns true if the list is empty: "+al.isEmpty());
		System.out.println("Returns true if it contains the input object "+al.contains("sai"));
		System.out.println("Returns an iterator over the list of elements in proper sequence: "+al.iterator());
		//System.out.println(al.toArray());
		String[] y=(String[]) al.toArray(new String[0]);
		for(i=0;i<y.length;i++)
		{
			System.out.println(y[i]);
		}
		System.out.println(al.remove("xx"));
		System.out.println(al.contains("sai"));
		//al.clear();
		//System.out.println(al.size());
		al.add(2, "jan");
		for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}
		
		al.set(2,"Feb");
		System.out.println();
		for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}
		System.out.println();
		System.out.println(al.indexOf("sai"));
		System.out.println(al.lastIndexOf("sai"));
		System.out.println(al.listIterator());
		System.out.println(al.listIterator(2));
		
		/*al.subList(2,4).clear();
		for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}*/
		List lst = (List) al.subList(1, 3);
		for(i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i));
		}
		/*al.addAll(lst);
		for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}*/
		/*al.addAll(3,lst);
		for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}*/
		//al.removeAll(lst);
		/*for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}*/
		/*al.retainAll(lst);
		for(i=0;i<al.size();i++)
		{
			System.out.print(al.get(i));
			System.out.print("  ");
		}*/
	}
}

