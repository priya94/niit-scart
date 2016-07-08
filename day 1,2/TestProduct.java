package com.niit.shoppingcart;

public class TestProduct {

	public static void main(String[] args) {
		Product product = new Product("PRD001","GOOGLE GLASS");
		product.setPrice(21000);
		
		System.out.println(product.id);
		System.out.println(product.name);
		System.out.println(product.getPrice());
	}
}
