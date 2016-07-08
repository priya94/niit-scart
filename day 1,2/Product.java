package com.niit.shoppingcart;

public class Product {
 
	public String id;
	public String name;
	public double price;
	
	public Product(String id,String name){
		this.id=id;
		this.name=name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if(price<0){
			System.out.println("No negative price");
		}
		else{
		this.price = price;
		}
	}
	
}
