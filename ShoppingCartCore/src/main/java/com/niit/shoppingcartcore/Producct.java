package com.niit.shoppingcartcore;

import org.springframework.stereotype.Component;

@Component
public class Producct {
 private String id;
 private String name;
 private String Price;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrice() {
	return Price;
}
public void setPrice(String price) {
	Price = price;
}
 
 
}
