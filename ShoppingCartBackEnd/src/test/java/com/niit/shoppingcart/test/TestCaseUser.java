package com.niit.shoppingcart.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;

import com.niit.shoppingcart.model.User;


public class TestCaseUser {

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}

	@Test

	public void userNameTest() {
		user = userDAO.get("USR001");
		String name = user.getName();
		assertEquals("User Id Test", "abcde", name);

	}
}

