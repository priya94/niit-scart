package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		UserDetailsDAO userdetailsDAO = (UserDetailsDAO) context.getBean("userdetailsDAO");
		UserDetails userDetails = (UserDetails) context.getBean("userDetails");

		userDetails.setId("USR001");
		userDetails.setName("Abcdef");
		userDetails.setPassword("123456");
		userDetails.setMobile_number("9446029241");
		userDetails.setMail_id("menon94@gmail.com");
		userDetails.setAddress("hgasdfhasgfdgfd");
		userdetailsDAO.saveOrUpdate(userDetails);
		System.out.println("NO of users:"+userdetailsDAO.list().size());

		userdetailsDAO.delete("USR00");

		if(userdetailsDAO.get("USR004")== null)
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