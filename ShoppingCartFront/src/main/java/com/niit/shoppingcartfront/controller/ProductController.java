package com.niit.shoppingcartfront.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.dao.ProductDAO;

@Controller
public class ProductController {
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String productList(Model model) 
	{
		model.addAttribute("isIsadminClickedProducts", "true");
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		return "home";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProducts(@ModelAttribute("product")Product product) {
		productDAO.saveOrUpdate(product);

		return "redirect:/products";
	}
	
	@RequestMapping("deleteProducts/{id}")
	public String deleteProducts(@PathVariable("id") String id,ModelMap model) {
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/products";
	}
	
	
	@RequestMapping(value = "editProducts/{id}")
	public String editProducts(@PathVariable("id") String id,ModelMap model) {
		product=productDAO.get(id);
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());

		return "redirect:/products";
	}

}
