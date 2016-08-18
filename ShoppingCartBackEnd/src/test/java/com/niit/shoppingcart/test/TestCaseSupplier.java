package com.niit.shoppingcart.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;

import com.niit.shoppingcart.model.Supplier;


public class TestCaseSupplier {

	@Autowired
	static SupplierDAO supplierDAO;

	@Autowired
	static Supplier supplier;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
	}

	@Test

	public void supplierNameTest() {
		supplier = supplierDAO.get("SP001");
		String name = supplier.getName();
		assertEquals("Supplier Name Test", "SPNameABCD", name);

	}
}
