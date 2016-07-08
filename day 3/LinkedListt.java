package Linked;


import java.util.Collections;

import java.util.LinkedList;


public class LinkedListt {

	public static void main(String[] args) {
	LinkedList<Employee> list = new LinkedList<Employee>();
	list.add(new Employee("Tim", 3000));
	list.add(new Employee("Rim", 6000));
	Collections.sort(list, new compre());
	System.out.println("");
	for(Employee e:list)
	{
		System.out.println(e.getName());
		System.out.println(e.getSalary());
	}
	
	
}
}


class Employee
{
	private String name;
	private int salary;
	public Employee(String n,int s)
	{
		this.name = n;
		this.salary = s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString()
	{
		return "Name:"+this.name+"Salary"+this.salary;
	}
}

