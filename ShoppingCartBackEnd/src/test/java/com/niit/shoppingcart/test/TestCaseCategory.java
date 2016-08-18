
package com.niit.shoppingcart.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.model.Category;


public class TestCaseCategory {

	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}

	@Test

	public void categoryNameTest() {
		category = categoryDAO.get("CTG001");
		String name = category.getName();
		assertEquals("Category Name Test", "CTGNameABCD", name);

	}
}
