package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;

public class ProductTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		Product product = (Product) context.getBean("product");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		

		product.setId("PRD001");
		product.setName("PRDNameABCD");
		product.setDescription("PRDDescPQRST");
		product.setPrice("50000");
		product.setCategory(categoryDAO.get(",CTG002"));
		product.setSupplier(supplierDAO.get(",SP002"));

		productDAO.saveOrUpdate(product);

		productDAO.delete("abcd");

		if (productDAO.get("PRD006") == null) {
			System.out.println("Product does not exist");
		} else {
			System.out.println("Product exists..");
			System.out.println();
		}
	}

}
