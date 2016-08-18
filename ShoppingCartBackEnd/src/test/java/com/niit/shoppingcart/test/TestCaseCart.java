/*package com.niit.shoppingcart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;


public class TestCaseCart {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		
		con.scan("com.niit.shoppingcart");
		con.refresh();
		
		CartDAO cartDAO =  (CartDAO) con.getBean("cartDAO");
		
		Cart cart= (Cart) con.getBean("cart");
		cart.setId("CART01");
		cart.setPrice(100);
		cart.setQuantity(2);
		cart.setTotal(200);
		//cart.setUserId("USR001");
		//cart.setProduct_Name("PRDCT");
		cart.setStatus("AVAILABLE");
		
		cartDAO.saveOrUpdate(cart);
		
		System.out.println("updated");
	}

}*/
