package com.niit.shoppingcartfront.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.dao.CategoryDAO;

@Controller
public class CategoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String listCategories(Model model) {
		model.addAttribute("isAdminCLickedCategory", "true");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		return "home";
	}

	@RequestMapping(value = "/to_add_category", method = RequestMethod.POST)
	public String addCategories(@ModelAttribute("category") Category category) {
		categoryDAO.saveOrUpdate(category);

		return "redirect:/categories";
	}
	
	@RequestMapping(value = "category/remove/{id}")
	public String deleteCategories(@PathVariable("id") String id,ModelMap model) {
		try {
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/categories";
	}
	
	
	@RequestMapping(value = "category/edit/{id}")
	public String editCategories(@PathVariable("id") String id,ModelMap model) {
		category=categoryDAO.get(id);
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());

		return "redirect:/categories";
	}

}