package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestUserDetailsDAO {

	@Autowired
	UserDetailsDAO userdetailsDAO;

	@Autowired
	UserDetails userDetails;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userdetailsDAO = (UserDetailsDAO) context.getBean("userdetailsDAO");

		userDetails = (UserDetails) context.getBean("userDetails");
	}

	@Test

	public void UserDetailsTestCase() {
		int size = userdetailsDAO.list().size();
		assertEquals("userdetails list test case ", 1, size);

	}

}

