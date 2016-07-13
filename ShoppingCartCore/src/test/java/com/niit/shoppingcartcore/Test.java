package com.niit.shoppingcartcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcartcore");
	context.refresh();
	
	Producct p = (Producct) context.getBean("producct");
	p.setId("100");
	p.setName("i phone");
	p.setPrice("50000");
	System.out.println(p.getId());
	System.out.println(p.getName());
	System.out.println(p.getPrice());
	
	context.getBean("category");
	context.getBean("producct");
	System.out.println("Category is created");
	
}
}
