package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;;

public class ProductTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");
		
		
		product.setId("PRD001");
		product.setName("PRDNameABCD");
		product.setDescription("PRDDescPQRST");
		product.setPrice("50000");
	    productDAO.saveOrUpdate(product);
		
	   // productDAO.delete("abcd"); 
		
	    
	    if(productDAO.get("PRD001")== null)
		{
			System.out.println("Product does not exist");
		}
		else
		{
			System.out.println("Product exists..");
			System.out.println();
		} 
	}

}
