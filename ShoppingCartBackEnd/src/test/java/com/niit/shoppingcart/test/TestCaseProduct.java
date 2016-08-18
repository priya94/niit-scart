package com.niit.shoppingcart.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.model.Product;


public class TestCaseProduct {

	@Autowired
	static ProductDAO productDAO;

	@Autowired
	static Product product;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}

	@Test

	public void productNameTest() {
		product = productDAO.get("PRD001");
		String name = product.getName();
		assertEquals("Product Name Test", "PRDNameABCD", name);

	}
}

