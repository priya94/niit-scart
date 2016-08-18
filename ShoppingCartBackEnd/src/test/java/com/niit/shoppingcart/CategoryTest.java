package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		
		
		category.setId("CTG002");
		category.setName("CTGNameEFGH");
		category.setDescription("CTGDescUVWXYZ");
	    categoryDAO.saveOrUpdate(category);
		
	    // categoryDAO.delete("CTG001"); 
		
	    
	    if(categoryDAO.get("CTG005")== null)
		{
			System.out.println("Category does not exist");
		}
		else
		{
			System.out.println("Category exists..");
			System.out.println();
		} 
	}
}
