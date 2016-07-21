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

		user.setId("USR002");
		user.setName("USRNameABCDE");
		user.setPassword("EFGHI");
		user.setMobilenumber("9116029241");
		user.setMailid("priya@gmail.com");
		user.setAddress("KLMNOPQR");
		userDAO.saveOrUpdate(user);
		System.out.println("NO of users:"+userDAO.list().size());

		//userDAO.delete("USR002");

		if(userDAO.get("USR002")== null)
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
