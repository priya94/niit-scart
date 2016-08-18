package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");

		user.setId("USR005");
		user.setPassword("niit");
		user.setName("niit");
		user.setMobile_number("9875478035");
		user.setMail_id("peyeno94@gmail.com");
		user.setAddress("lkiughfoijv");
		user.setIsadmin(false);
		userDAO.saveOrUpdate(user);
		System.out.println("NO of users:"+userDAO.list().size());

		//userDAO.delete("USR002");

		if(userDAO.get("USR001")== null)
		{
			System.out.println("User does not exist");
		}
		else
		{
			System.out.println("User exists..");
			System.out.println();
		} 
		
	}
}