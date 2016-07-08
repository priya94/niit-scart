package Array;

import java.util.Iterator;

public class ArrayList {
	
	public static void main(String[] args) {
		
		
		java.util.ArrayList<String> al = new java.util.ArrayList<String>();
		al.add("JAVA");
		al.add("C++");
		al.add("COBOL");
		Iterator<String> itr = al.iterator();
		
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("Does this list contain java:"+al.contains("JAVA"));
		al.add(2,"C");
		System.out.println(al);
		System.out.println(al.isEmpty());
		System.out.println(al.size());
		
}
}